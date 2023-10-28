package com.Alanjro_jr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * 
 * Connect to the database (MySQL) Database: facial_recognition
 *
 */
public class Connect {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;
    
    private final String driver = "org.mysql.Driver";
    private final String path = "jdbc:mysql://127.0.0.1/facial_recognition";
    private final String user = "root";
    private final String pass = "";

     
    public void conexao() {
        try {
            System.setProperty("jdbc.Driver", driver);
            conn = DriverManager.getConnection(path, user, pass);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
             System.out.println("Please Provideconnection");
           
        }
    }

   
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void executaSQL(String SQL) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
