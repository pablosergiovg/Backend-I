package com.example.sIntegradorV1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    private static final String SQL_DROP_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; "
            + "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "MATRICULA INT NOT NULL,"
            + "NOMBRE VARCHAR(100) NOT NULL,"
            + "APELLIDO VARCHAR(100) NOT NULL"
            + ")";

    private static final String SQL_DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; "
            + "CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "APELLIDO VARCHAR(100) NOT NULL, "
            + "NOMBRE VARCHAR(100) NOT NULL,"
            + "DNI VARCHAR(255) NOT NULL,"
            + "FECHA_INGRESO DATE NOT NULL,"
            + "EMAIL VARCHAR(100) NOT NULL,"
            + "DOMICILIO_ID INT NOT NULL"
            + ")";

    private static final String SQL_DROP_CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIOS; "
            + "CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY,"
            + "CALLE VARCHAR(100) NOT NULL, "
            + "NUMERO INT NOT NULL, "
            + "LOCALIDAD VARCHAR(255) NOT NULL, "
            + "PROVINCIA VARCHAR(255) NOT NULL "
            + ")";

    private static final String SQL_INSERT_INPUT_TRYHARD = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA)" +
            " VALUES ('Calle a',58,'Salta capital','Salta'); INSERT INTO PACIENTES (NOMBRE, APELLIDO," +
            "DNI, FECHA_INGRESO, EMAIL, DOMICILIO_ID) VALUES ('Rodolfo','Baspineiro','684','2022-11-10'," +
            "'prueba@gmail.com',1); ";

    private static final String SQL_INSERT_INPUT_TRYHARD2 = "INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES (21, 'Pablo', 'Viera')";

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/proyectoIntegrador2", "pv", "pv");
    }

    public static void crearTablas(){

        Connection connection = null;
        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_DOMICILIO);
            statement.execute(SQL_DROP_CREATE_PACIENTES);
            statement.execute(SQL_DROP_CREATE_ODONTOLOGOS);
            statement.execute(SQL_INSERT_INPUT_TRYHARD);
            statement.execute(SQL_INSERT_INPUT_TRYHARD2);

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
