import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestLog {

    public static void main(String[] args) throws Exception {


        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
        Statement stmt = connection.createStatement();

        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255))";
        stmt.execute(createTable);

        String insertarFila = "INSERT INTO TEST VALUES(1, 'HOLA')";
        String insertarFila2 = "INSERT INTO TEST VALUES(2, 'CHAU')";

        stmt.execute(insertarFila);
        stmt.execute(insertarFila2);

        String sql = "SELECT * FROM TEST";
        ResultSet rd = stmt.executeQuery(sql);

        while(rd.next()){
            System.out.println(rd.getInt(1) + rd.getString(2));
        }

        /*Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "myPassword");
        Statement stmt = con.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la
        //vuelve a crear
        String createSql = "DROP TABLE IF EXISTS TEST;\n" +
                "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));\n" +
                "INSERT INTO TEST VALUES(1, 'Hello');\n" +
                "INSERT INTO TEST VALUES(2, 'World');\n";
        stmt.execute(createSql);

        //Codigo para consultar todos los registros de la tabla TEST
        String sql = "select * from TEST";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2));
        }*/
    }

}
