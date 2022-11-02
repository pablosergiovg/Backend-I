package dao;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final String SQL_DROP_CREATE_IMPRESORAS = "DROP TABLE IF EXISTS IMPRESORAS;"
            + "CREATE TABLE IMPRESORAS (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "NOMBRE VARCHAR(100) NOT NULL,"
            + "MARCA VARCHAR(100) NOT NULL,"
            + "COLOR VARCHAR(100) NOT NULL"
            + ")";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/impresoras", "imp", "imp");
    }

    public static void crearTabla(){

        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_IMPRESORAS);

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
