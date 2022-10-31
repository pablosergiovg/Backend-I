package daos;

import entidades.Avion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvionDAOH2 implements IDAO<Avion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Avion registrar(Avion avion) {

        //declarar connection y pStatement nulos.
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {

            //levantar el Driver y conectarons.
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear una sentencia.
            pStatement = connection.prepareStatement("INSERT INTO avion VALUES(?,?,?,?,?)");
            pStatement.setLong(1, avion.getId());
            pStatement.setString(2, avion.getMarca());
            pStatement.setString(3, avion.getModelo());
            pStatement.setString(4, avion.getMatricula());
            pStatement.setString(5, avion.getFechaEntradaServicio());

            //ejecutar la sentencia
            pStatement.executeUpdate();
            pStatement.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return avion;
    }

    @Override
    public Avion buscar(Long id) {

        //declarar connection y pStatement nulos.
        Connection connection = null;
        PreparedStatement pStatement = null;
        Avion avion = null;

        try {

            //levantar el Driver y conectarons.
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear la Query.
            pStatement = connection.prepareStatement("SELECT * FROM avion WHERE id=?");
            pStatement.setLong(1, id);

            //ejecutar la Query
            ResultSet result = pStatement.executeQuery();

            //recorremos la tabla
            while (result.next()){

                Long idAvion = result.getLong("id");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String matricula = result.getString("matricula");
                String fechaEntradaServicio = result.getString("fechaEntradaServicio");

                avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marca);
                avion.setModelo(modelo);
                avion.setMatricula(matricula);
                avion.setFechaEntradaServicio(fechaEntradaServicio);

            }

            pStatement.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return avion;

    }

    @Override
    public void eliminar(Long id) {

        //declarar connection y pStatement nulos.
        Connection connection = null;
        PreparedStatement pStatement = null;

        try {

            //levantar el Driver y conectarons.
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear una sentencia.
            pStatement = connection.prepareStatement("DELETE FROM avion WHERE id=?");
            pStatement.setLong(1, id);

            //ejecutar la sentencia
            pStatement.executeUpdate();
            pStatement.close();

        }catch(Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Avion> buscarTodos() {

        //declarar connection y pStatement nulos.
        Connection connection = null;
        PreparedStatement pStatement = null;
        List<Avion> flotaAviones = new ArrayList<>();

        try {

            //levantar el Driver y conectarons.
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Crear la Query.
            pStatement = connection.prepareStatement("SELECT * FROM avion");

            //ejecutar la Query
            ResultSet result = pStatement.executeQuery();

            //recorremos la tabla
            while (result.next()){

                Long idAvion = result.getLong("id");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");
                String matricula = result.getString("matricula");
                String fechaEntradaServicio = result.getString("fechaEntradaServicio");

                Avion avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marca);
                avion.setModelo(modelo);
                avion.setMatricula(matricula);
                avion.setFechaEntradaServicio(fechaEntradaServicio);

                flotaAviones.add(avion);
            }

            pStatement.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return flotaAviones;

    }
}
