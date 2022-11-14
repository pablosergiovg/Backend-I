package com.example.sIntegradorV1.dao;

import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Paciente;
import org.apache.log4j.Logger;


import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PacienteDAOH2 implements IDao<Paciente>{

    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_INGRESO, EMAIL, DOMICILIO_ID) VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM PACIENTES WHERE ID = ?";
    private static final String SQL_SELECT_BY_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_UPDATE = "UPDATE PACIENTE SET APELLIDO = ?, NOMBRE = ?, DNI = ?, FECHA_INGRESO = ?, EMAIL = ?, DOMICILIO_ID = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID = ?";
    //logger
    private static final Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);

    public PacienteDAOH2() {
    }

    @Override
    public Paciente guardar(Paciente paciente) {

        Connection connection = null;

        try {

            LOGGER.info("Se ha iniciado el guardado de un paciente");
            connection = BD.getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getApellido());
            psInsert.setString(2, paciente.getNombre());
            psInsert.setString(3, paciente.getDni());
            psInsert.setObject(4, paciente.getFechaIngreso());
            psInsert.setString(5,paciente.getEmail());
            domicilioDAOH2.guardar(paciente.getDomicilio());
            psInsert.setInt(6, paciente.getDomicilio().getId());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {

        Connection connection = null;
        Paciente paciente = null;
        LOGGER.info("Iniciando busqueda del paciente con id: " + id);

        try {

            connection = BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1,id);
            psSelect.execute();

            ResultSet rs = psSelect.getResultSet();
            //Recordar que || Tabla Paciente -> 1, Pablo, Viera, 5323, 2-11-2022, 15(FK)
            DomicilioDAOH2 daoAux = new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio = daoAux.buscar(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        domicilio);
            }


        }catch (Exception e){
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return paciente;

    }

    @Override
    public void actualizar(Paciente paciente) {

        LOGGER.info("Iniciando la actualización de un Paciente");
        Connection connection = null;
        DomicilioDAOH2 domicilioDAOH2 = null;

        try{
            connection=BD.getConnection();
            PreparedStatement psSelect= connection.prepareStatement(SQL_UPDATE);
            psSelect.setString(1, paciente.getApellido());
            psSelect.setString(2, paciente.getNombre());
            psSelect.setString(3, paciente.getDni());
            psSelect.setObject(4, paciente.getFechaIngreso());
            psSelect.setString(5, paciente.getEmail());
            domicilioDAOH2.actualizar(paciente.getDomicilio());
            psSelect.setInt(6, paciente.getDomicilio().getId());
            psSelect.setInt(7, paciente.getId());
            psSelect.execute();

        }
        catch (Exception e){
            LOGGER.error("Error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                LOGGER.error(ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void eliminar(Integer id) {

        Connection connection = null;
        LOGGER.info("Inicianfo eliminacion del Paciente con id: " + id);

        try {

            connection = BD.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();
            LOGGER.error("Se ha borrado el id: " +id);


        }catch (Exception e){
            LOGGER.info("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Paciente> buscarTodo() {

        Connection connection = null;
        LOGGER.info("Iniciando la busqueda de todos los Pacientes");
        List<Paciente> pacientes = new ArrayList<>();
        DomicilioDAOH2 domicilioDAOH2 = null;
        Paciente paciente = null;
        try {

            domicilioDAOH2 = new DomicilioDAOH2();
            connection = BD.getConnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();

            while (rs.next()){
                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        domicilioDAOH2.buscar(rs.getInt(7)));
                pacientes.add(paciente);
            }

        }catch (Exception e){
            LOGGER.error("Error e: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return pacientes;
    }

    @Override
    public Paciente buscarXString(String valor) {

        Connection connection = null;
        Paciente paciente = null;

        try {

            connection = BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            psSelect.setString(1,valor);
            ResultSet rs = psSelect.executeQuery();
            //Recordar que || Tabla Paciente -> 1, Pablo, Viera, 5323, 2-11-2022, email, 15(FK)
            DomicilioDAOH2 daoAux = new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio = daoAux.buscar(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        domicilio);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return paciente;
    }

}
