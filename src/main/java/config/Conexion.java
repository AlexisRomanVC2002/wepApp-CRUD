package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Conexion {

    private static Connection conn = null;
    private final static String URL = "jdbc:mysql://localhost:3306/almacen";
    private final static String USERNAME = ResourceBundle.getBundle("DB").getString("USERNAME");
    private final static String PASSWORD = ResourceBundle.getBundle("DB").getString("PASSWORD");

    private Conexion(){}

    public static Connection getConexion(){
        if(conn == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Conexion establecida");
            } catch (SQLException | ClassNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return conn;
    }
    
}
