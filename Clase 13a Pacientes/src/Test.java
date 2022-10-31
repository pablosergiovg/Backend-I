import java.sql.*;

public class Test {

    //***************************************
    //SQLs CREATE, INSERT, UPDATE.
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE"
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL,"
            + " APELLIDO varchar(100) NOT NULL,"
            + " DOMICILIO varchar(100) NOT NULL,"
            + " DNI varchar(100) NOT NULL,"
            + " FECHADEALTA varchar(100) NOT NULL,"
            + " USUARIO varchar(100) NOT NULL,"
            + " PASSWORD varchar(100) NOT NULL"
            + ")";
    private static final String SQL_INSERT_TABLE = "INSERT INTO PACIENTE(ID, NOMBRE, APELLIDO, DOMICILIO, DNI, FECHADEALTA, USUARIO, PASSWORD) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_TABLE = "UPDATE PACIENTE SET PASSWORD=? WHERE USUARIO=?";



    public static void main(String[] args) throws Exception {

        //Se crea el usuario para guardarlo en la Base de Datos.
        Paciente paciente1 = new Paciente("Fredegundo", "Marciel", "Wachinton Dici", "12344567890","18-2-1999", "Frede", "1234");

        //Se crea la conexión
        Connection connection = null;

        //Se utiliza el try catch para crear, insertar y modificar la tabla, con la exception Exception.
        try {

            //igualamos connection al getConnection() que está debajo, el que se conecta a la base.
            connection = getConnection();

            //creamos el statement para crear la tabla.
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            //*****

            //para hacer el insert se utiliza PreparedStatement(utilizando el insert, insertaremos los datos mas adelante).
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_TABLE);

            //preparando los datos a insertar del paciente1.
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, paciente1.getNombre());
            preparedStatement.setString(3, paciente1.getApellido());
            preparedStatement.setString(4, paciente1.getDomicilio());
            preparedStatement.setString(5, paciente1.getDNI());
            preparedStatement.setString(6, paciente1.getFechaDeAlta());
            preparedStatement.setString(7, paciente1.getUsuario());
            preparedStatement.setString(8, paciente1.getPassword());

            //ejecutamos el preparedStatement con .execute().
            preparedStatement.execute();

            //*****

            //Antes del update, se debe comenzar la transaccion en false, si no le ponemos nada será true,
            //y se commitearia toodo automaticamente.
            connection.setAutoCommit(false);

            //*****

            //al igual que con el insert, se utiliza preparedStatement, para mas adelante insertar los datos.
            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE_TABLE);

            //preparando los datos del update de paciente1.
            psUpdate.setString(1, paciente1.setPassword("asdf"));
            psUpdate.setString(2, paciente1.getUsuario());

            //ejecutamos el preparedStatement con .execute().
            psUpdate.execute();

            //****************
            //Creando un error para probar si la contraseña permanecio 1234
            //int a = 4/0;
            //****************


            //debido a que colocamos false en setAutoCommit, aquñi hacemos el commit.
            connection.commit();

            //es una buena practica poner el setAutoCommit en true luego del .commit()
            connection.setAutoCommit(true);

            //ahora corremos la la query(consulta a la base de datos) para ver si cambió la clave.
            String sql = "SELECT * FROM PACIENTE";
            Statement stmt = connection.createStatement();
            ResultSet rd = stmt.executeQuery(sql);

            //ahora iteramos el objeto ResultSet "rd".
            while (rd.next()){
                System.out.println(rd.getInt(1) + " " +
                        rd.getString(2) + " " +
                        rd.getString(3) + " " +
                        rd.getString(4) + " " +
                        rd.getString(5) + " " +
                        rd.getString(6) + " " +
                        rd.getString(7) + " " +
                        rd.getString(8));
            }


        }catch (Exception e){
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }finally {
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //*************
        //COLOCANDO UN ERROR SE SINTAXIS VAMOS A VER CON LA SIGUIENTE CONSULTA A LA BASE DE DATOS DE QUE NO SE MODIFICO LA CLAVE.
        Connection connectionPrueba = getConnection();
        String sql = "SELECT * FROM PACIENTE";
        Statement statementPrueba = connectionPrueba.createStatement();
        ResultSet rdPrueba = statementPrueba.executeQuery(sql);
        while (rdPrueba.next() && rdPrueba.getString(8).equals("1234")){
            System.out.println("La contrasenia sigue siendo: " + rdPrueba.getString(8));
        }
        //*************

    }


    //***************************************
    //Datos de conexión a la base
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase13a", "sa", "sa");
    }

}