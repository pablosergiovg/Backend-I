import java.sql.*;

public class Odontologo {

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO;"
            + " CREATE TABLE ODONTOLOGO"
            + "("
            + "ID INT PRIMARY KEY, "
            + "APELLIDO VARCHAR(255),"
            + "NOMBRE VARCHAR(255),"
            + "MATRICULA VARCHAR(255)"
            + ")";

    private static final String SQL_INSERT_TABLE = "INSERT INTO ODONTOLOGO VALUES(?,?,?,?)";
    private static final String SQL_UPDATE_TABLE = "UPDATE ODONTOLOGO SET MATRICULA = ? WHERE ID = ?";


    public static void main(String[] args) {

        Connection connection = null;
        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_TABLE);

            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Gaucho");
            preparedStatement.setString(3, "Ronaldinho");
            preparedStatement.setString(4, "asdf");

            preparedStatement.execute();

            String sql = "SELECT * FROM ODONTOLOGO";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(
                        "id: " + rs.getInt(1) + "\n"
                                + "Apellido: " + rs.getString(2) + "\n"
                                + "Nombre: "  + rs.getString(3) + "\n"
                                + "Matricula: " + rs.getString(4));
            }

            //UPDATE **********************

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE_TABLE);

            psUpdate.setString(1, "golazo");
            psUpdate.setInt(2,1);

            psUpdate.execute();

            String sql2 = "SELECT * FROM ODONTOLOGO";
            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2);

            while (rs2.next()){
                System.out.println(
                        "id: " + rs2.getInt(1) + "\n"
                                + "Apellido: " + rs2.getString(2) + "\n"
                                + "Nombre: "  + rs2.getString(3) + "\n"
                                + "Matricula: " + rs2.getString(4));
            }

            //UPDATE **********************


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/ClaseOdontologo", "sa", "sa");
    }


}