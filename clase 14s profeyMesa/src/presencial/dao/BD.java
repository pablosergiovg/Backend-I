package presencial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(
                "jdbc:h2:~/c3clase14","sa"
        ,"sa");
    }
    public static void crearTablas(){
        Connection connection=null;
        try{
            //drop create
            connection=getConnection();
            Statement statement= connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS MEDICAMENTOS;" +
                    "CREATE TABLE MEDICAMENTOS (" +
                    "ID INT PRIMARY KEY," +
                    "NOMBRE VARCHAR(100) NOT NULL," +
                    "LABORATORIO VARCHAR(100) NOT NULL," +
                    "CANTIDAD INT NOT NULL," +
                    "PRECIO NUMERIC(10,2) NOT NULL," +
                    "CODIGO INT NOT NULL" +
                    ")");
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
    }
}
