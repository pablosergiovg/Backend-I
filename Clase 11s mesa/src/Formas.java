import java.sql.*;

public class Formas {

    public static void main(String[] args) {
        Connection con;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS FIGURAS; \n " +
                    "CREATE TABLE FIGURAS (id INT PRIMARY KEY, figura VARCHAR(50), color VARCHAR(50)); \n" +
                    "INSERT INTO FIGURAS VALUES(1, 'circulo', 'rojo'); \n" +
                    "INSERT INTO FIGURAS VALUES(2, 'circulo', 'azul'); \n" +
                    "INSERT INTO FIGURAS VALUES(3, 'cuadrado', 'naranja'); \n" +
                    "INSERT INTO FIGURAS VALUES(4, 'cuadrado', 'amarillo');\n" +
                    "INSERT INTO FIGURAS VALUES(5, 'cuadrado', 'violeta');"
            );
            ResultSet rd = stmt.executeQuery(
                    "SELECT * FROM FIGURAS \n" +
                            "WHERE color = 'rojo' AND figura = 'circulo' "
            );
            while (rd.next()){
                System.out.println(rd.getString(2) + " " + rd.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11m", "sa", "sa");
    }

}