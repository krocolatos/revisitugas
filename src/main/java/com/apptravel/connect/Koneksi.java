/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author galih
 */
public class Koneksi {
    static Connection con;
    
    public static Connection connection() throws SQLException{
        if(con == null){
            //try{
             String url = new String();
             String user = new String();
             String password = new String();
             url = "jdbc:mysql://localhost:3307/logintry";
             user = "root";
             password = "";
             DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
             try{
                  con = DriverManager.getConnection(url, user, password);
             
             
             
             
        }catch(SQLException ex){
          //System.out.println("error");
        }
    }
              //System.out.println("hello world");
              
   
        return con;
}
        
    }
        
    
    
    
