package dao;

import model.Impresora;
import org.apache.log4j.Logger;

import java.sql.*;

public class ImpresoraDAOH2 implements IDao<Impresora> {

    //SQLs
    private static final String SQL_INSERT = "INSERT INTO IMPRESORAS (NOMBRE, MARCA, COLOR) VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM IMPRESORAS WHERE ID = ?";
    private static final String SQL_SELECT = "SELECT * FROM IMPRESORAS WHERE ID = ?";
    //LOGGER
    private static final Logger LOGGER = Logger.getLogger(ImpresoraDAOH2.class);

    @Override
    public Impresora registrar(Impresora impresora) {

        Connection connection = null;

        try {

            LOGGER.info("Se ha iniciado el registro de una impresora");
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1,impresora.getNombre());
            psInsert.setString(2,impresora.getMarca());
            psInsert.setString(3,impresora.getColor());
            psInsert.execute();

            ResultSet rs = psInsert.getGeneratedKeys();
            while (rs.next()){
                impresora.setId(rs.getInt(1));
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
        return impresora;

    }

    @Override
    public void eliminar(Integer id) {

        Connection connection = null;

        try {

            LOGGER.info("Se ha iniciado la eliminación de la impresora con id: " + id);
            connection = BD.getConnection();
            PreparedStatement psDelete = connection.prepareStatement(SQL_DELETE);
            psDelete.setInt(1, id);
            psDelete.execute();
            LOGGER.error("Se ha borrado el id: " +id);

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

    }

    @Override
    public Impresora buscar(Integer id) {

        Connection connection = null;
        Impresora impresora = null;

        try {

            LOGGER.info("Se ha iniciado la busqueda de la impresora con id: " + id);
            connection = BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1,id);
            ResultSet rs = psSelect.executeQuery();

            while (rs.next()){
                impresora = new Impresora(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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

        return impresora;
    }
}
