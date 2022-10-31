package presencial.dao;

import org.apache.log4j.Logger;
import presencial.model.Medicamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicamentoDaoH2 implements IDao<Medicamento>{
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS " +
            "VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM MEDICAMENTOS WHERE ID=?";
    private static final Logger LOGGER= Logger.getLogger(MedicamentoDaoH2.class);
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        LOGGER.info("Se inició un pedido de incorporación de medicamento");
        //va el código que realizabamos con anteriodad
        //ahora la información está en medicamento como parametro
        Connection connection=null;
        try{
            //conectarme a la base
            connection=BD.getConnection();
            //insertar
            PreparedStatement psInsert= connection.prepareStatement(
                    SQL_INSERT);
            psInsert.setInt(1,medicamento.getId());
            psInsert.setString(2,medicamento.getNombre());
            psInsert.setString(3, medicamento.getLaboratorio());
            psInsert.setInt(4,medicamento.getCantidad());
            psInsert.setDouble(5,medicamento.getPrecio());
            psInsert.setInt(6,medicamento.getCodigo());
            psInsert.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar(Integer id) {
        LOGGER.info("Se inició una busqueda de Medicamento");

        Connection connection = null;
        Medicamento medicamento = null;

        try {

            connection=BD.getConnection();
            PreparedStatement psSelect = connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1, id);

            ResultSet resultSet = psSelect.executeQuery();

            while (resultSet.next()){

                medicamento = new Medicamento(resultSet.getInt("id"
                ), resultSet.getString("nombre"),
                        resultSet.getString("laboratorio"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDouble("precio"),
                        resultSet.getInt("codigo"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicamento;


    }
}
