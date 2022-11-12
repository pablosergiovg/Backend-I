package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;


public class PacienteDAOH2 implements IDao<Paciente>{

    private DomicilioDAOH2 domicilioDAOH2;

    private static final String SQL_INSERT = "INSERT INTO PACIENTES VALUES (DEFAULT,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM PACIENTES WHERE ID = ?";
    private static final Logger LOGGER = Logger.getLogger(PacienteDAOH2.class);

    public PacienteDAOH2() {
        this.domicilioDAOH2 = new DomicilioDAOH2();
    }

    @Override
    public Paciente guardar(Paciente paciente) {

        Connection connection = null;

        try {

            LOGGER.info("Se ha iniciado el guardado de un paciente");
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getApellido());
            psInsert.setString(2, paciente.getNombre());
            psInsert.setString(3, paciente.getDni());
            psInsert.setObject(4, paciente.getFechaIngreso());
            domicilioDAOH2.guardar(paciente.getDomicilio());
            psInsert.setInt(5, paciente.getDomicilio().getId());
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
            ResultSet rs = psSelect.executeQuery();
            //Recordar que || Tabla Paciente -> 1, Pablo, Viera, 5323, 2-11-2022, 15(FK)
            DomicilioDAOH2 daoAux = new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio = daoAux.buscar(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio);
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

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodo() {
        return null;
    }

}
