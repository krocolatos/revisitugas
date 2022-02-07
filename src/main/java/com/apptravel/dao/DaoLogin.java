/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.dao;

import com.apptravel.connect.Koneksi;
import com.apptravel.model.ModLogin;
import com.apptravel.view.HomeView;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author galih
 */
public class DaoLogin implements ImplementLogin{
    Connection connection;

    final String select = "SELECT * FROM tabelogin where username=? and password=?";
                          //"SELECT * FROM tabelogin where username=? and password=?
    public DaoLogin() throws SQLException {
        connection = Koneksi.connection();
            
    }


        
    @Override
    public void selectLogin(ModLogin ml){
        //PreparedStatement pst = 
        try{    
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ml.setUser(rs.getString("username"));
                ml.setPass(rs.getString("password"));
            }
     
           }catch (SQLException ex){
              
           }
          
        
        }  
             
}
