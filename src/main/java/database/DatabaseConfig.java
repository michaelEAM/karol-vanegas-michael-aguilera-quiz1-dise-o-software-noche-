/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Probook
 */
public class DatabaseConfig {
    
        
 private static final String URL ="jdbc:mysql://localhost:3306/motocicleta-proyect";
 private static final String USER = "root";
 private static final String PASSWORD = "123";
 
 public static Connection getConnection() throws SQLException {
 return DriverManager.getConnection(URL, USER, PASSWORD);
 }
    
}
