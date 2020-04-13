/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Mustafa Khaled
 */
public class DBConnection {

    // setup connection variables
    private static String user = "springstudent";
    private static String pass = "springstudent";
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/task?useSSL=false&serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection conn = null;

    public static Connection getCon() throws Exception {
        if (conn != null) {
            return conn;
        }
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Yeah ! Connection Done!");
        } catch (Exception ex){
            System.err.println("Error in DB");
            throw new Exception("Error in My connection");
        }
        return conn;
    }
    
}
