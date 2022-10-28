import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Empleado {

    public static void main(String[] args) throws Exception{

        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
        Statement stmt = connection.createStatement();

        String createTable = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NOMBRE VARCHAR(255), EDAD INT, EMPRESA VARCHAR(255), FECHALLEGADA VARCHAR(255))";
        stmt.execute(createTable);

        String insertarFila1 = "INSERT INTO EMPLEADO VALUES(1, 'Pablo', 32, 'Digital', '10-5-2021')";
        String insertarFila2 = "INSERT INTO EMPLEADO VALUES(2, 'Sergio', 32, 'Google', '19-07-2017')";
        String insertarFila3 = "INSERT INTO EMPLEADO VALUES(3, 'Viera', 32, 'FaceBook', '01-01-2023')";

        stmt.execute(insertarFila1);
        stmt.execute(insertarFila2);
        stmt.execute(insertarFila3);

        String sql = "SELECT * FROM EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        while (rd.next()){
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getInt(3) + " " + rd.getString(4) + " " + rd.getString(5));
        }

    }





}
