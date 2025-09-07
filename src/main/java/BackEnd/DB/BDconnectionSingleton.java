 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jgarcia07
 */
public class BDconnectionSingleton {
    
    private static final String IP = "localhost";
    private static final int PUERTO = 3306;
    private static final String SCHEMA = "CongresCodeNBugs";
    private static final String USER_NAME = "adminDBA";
    private static final String PASSWORD = "admin@123";
    private static final String URL = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + SCHEMA;
    
    private static BDconnectionSingleton instance;
    
    private Connection connection;

    private BDconnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("CONEXION EXITOSA A LA BASE DE DATOS");
        } catch (SQLException e) {
            System.out.println("Error al conectarse");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    
     public static BDconnectionSingleton getInstance() {
        if (instance == null) {
            instance = new BDconnectionSingleton();
        }
        return instance;
    }
}
