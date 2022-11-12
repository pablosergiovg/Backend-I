package com.example.sIntegradorV1.dao;

import com.example.sIntegradorV1.model.Domicilio;
import com.example.sIntegradorV1.model.Odontologo;
import com.example.sIntegradorV1.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo>{

    //SQLs
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE ID = ?";
    private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_BY_MATRICULA = "SELECT * FROM ODONTOLOGOS WHERE MATRICULA=?";
    private static final String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ID = ?";

    //Logger
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        Connection connection = null;

        try {

            LOGGER.info("Se ha iniciado el registro de un Odontologo");
            connection = BD.getConnection();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }

        }catch (Exception e){
            LOGGER.error("Error: " + e);
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {

        Connection connection = null;
        Odontologo odontologo = null;
        LOGGER.info("Iniciando la busqueda del Odontologo con id: " + id);

        try {

            connection = BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1,id);
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
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

        return odontologo;
    }

    @Override
    public void actualizar(Odontologo odontologo) {

        LOGGER.info("Iniciando la actualización de un Odontologo");
        Connection connection = null;

        try {

            connection = BD.getConnection();
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setInt(1, odontologo.getMatricula());
            psUpdate.setString(2, odontologo.getNombre());
            psUpdate.setString(3, odontologo.getApellido());
            psUpdate.setInt(4, odontologo.getId());
            psUpdate.execute();

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
    public void eliminar(Integer id) {

        Connection connection = null;
        LOGGER.info("Inicianfo eliminacion del Odontologo con id: " + id);

        try {

            connection = BD.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();
            LOGGER.error("Se ha borrado el id: " +id);


        }catch (Exception e){
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
    public List<Odontologo> buscarTodo() {

        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;

        try {

            LOGGER.info("Se ha iniciado la busqueda de todos los Odontologos");
            connection = BD.getConnection();

            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();

            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4));
                odontologos.add(odontologo);
            }

        }catch (Exception e){
            LOGGER.error("Error: " + e);
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return odontologos;
    }

    @Override
    public Odontologo buscarXString(String valor) {
        return null;
    }
}
