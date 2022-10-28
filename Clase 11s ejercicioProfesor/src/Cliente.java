import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {
    public static void main(String[] args) {

        //quiero conectarme a la base de datos.
        //necesito información sobre la misma.
        Connection connection;
        //como tiran excepciones, coloco try catch.
        try{
            connection = getConnection();
            //preparar nuestro mensaje a la base de datos
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, TIPO VARCHAR(100) NOT NULL)");

            statement.execute("INSERT INTO ANIMALES VALUES(1, 'Coco', 'gato'), (2, 'Minerva', 'perro'), (3, 'Margarita', 'tortuga'), (4, 'Jona', 'hamster'), (5, 'Duke', 'perro')");
            ResultSet rs = statement.executeQuery("SELECT * FROM ANIMALES");
            //rs.next() hace 2 cosas:
            //1) mueve el puntero interno del Resultset.
            //2) me indica si tengi un elemento, es decir me arroja un boolean.
            while(rs.next()){
                System.out.println("Nombre: " + rs.getString(2) + " - " + "Tipo: " + rs.getString(3));
            }

        }catch (Exception e){
            //aqui podria ir un logger de tipo error.
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11", "sa", "sa");
    }

}