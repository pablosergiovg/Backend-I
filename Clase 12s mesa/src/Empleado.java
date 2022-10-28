import org.apache.log4j.Logger;
import java.sql.*;


public class Empleado {
    public static void main(String[] args) {


    Connection connection = null;

    try {
        connection = getConnection();
        Statement stmt = connection.createStatement();
        stmt.execute(SQL_DROP_CREATE);
        stmt.execute(SQL_INSERT);
        stmt.execute(SQL_UPDATE);
        ResultSet rs = stmt.executeQuery(SQL_SELECT);


        while (rs.next()){
            System.out.println("ID: " + rs.getInt(1) +
                    "- Nombre: " + rs.getString(2) +
                    "- Apellido: " + rs.getString(3) +
                    "- Nacionalidad: " + rs.getString(4) +
                    "- cantidadHijos: " + rs.getInt(5));
        }
        System.out.println("*******************************");



    }catch(Exception e){
        LOGGER.error("Hay un id que se repite.");
        e.printStackTrace();
    }
    finally {
        try {
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    }
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(
                "jdbc:h2:~/c3clase12",
                "sa","sa");
    }

    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS EMPLEADO; " +
            "CREATE TABLE EMPLEADO (ID INT PRIMARY KEY, " +
            "NOMBRE VARCHAR(50) NOT NULL," +
            "APELLIDO VARCHAR(50) NOT NULL," +
            "NACIONALIDAD VARCHAR(50) NOT NULL," +
            "CANTIDAD_HIJOS INT NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO EMPLEADO VALUES"+
            "(1, 'Pablo', 'Viera', 'Venezolano', 0), (2, 'Pablo', 'Alvarez', 'Argentina', 0)," +
            "(3, 'Ignacio', 'Lopez', 'Argentina', 0)";

    private static final String SQL_DELETE = "DELETE FROM EMPLEADO WHERE ID=1";

    private static final String SQL_SELECT = "SELECT * FROM EMPLEADO";

    private static final Logger LOGGER= Logger.getLogger(Empleado.class);

    private static final String SQL_UPDATE = "UPDATE EMPLEADO SET APELLIDO = 'LOPEZZ' WHERE APELLIDO = 'Lopez'";


}