package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final String SQL_DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; "
            + "CREATE TABLE PACIENTE (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "APELLIDO VARCHAR(100) NOT NULL, "
            + "NOMBRE VARCHAR(100) NOT NULL,"
            + "DNI VARCHAR(255) NOT NULL,"
            + "FECHA_INGRESO DATE NOT NULL,"
            + "DOMICILIO_ID INT NOT NULL"
            + ")";

    private static final String SQL_DROP_CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIOS; "
            + "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "CALLE VARCHAR(100) NOT NULL, "
            + "NUMERO INT NOT NULL, "
            + "LOCALIDAD VARCHAR(255) NOT NULL, "
            + "PROVINCIA VARCHAR(255) NOT NULL, "
            + ")";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/pabloviera", "pv", "pv");
    }

    public static void crearTablas(){

        Connection connection = null;
        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIO);
            statement.execute(SQL_DROP_CREATE_PACIENTES);

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

}
