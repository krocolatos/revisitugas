    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.dao;

import com.apptravel.connect.Koneksi;
import com.apptravel.view.RegisterView;
import com.apptravel.model.ModRegister;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author galih
 */
public class DaoRegister implements ImplementReg{
  Connection connection;
  final String insertreg = "INSERT INTO tabelogin (username, password, nama, nohp) VALUES (?,?,?,?)";
  
  public DaoRegister() throws SQLException {
        connection = Koneksi.connection();
  }
        
  @Override
  public void insertreg(ModRegister mr){
      PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(insertreg,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, mr.getUserdaf());
            pst.setString(2, mr.getPassdaf());
            pst.setString(3, mr.getNama());
            pst.setString(4, mr.getNohp());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
           
        }catch (SQLException ex){
           ex.printStackTrace();
        }finally{
            try{
                pst.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
}
