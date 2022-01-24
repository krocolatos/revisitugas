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
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author galih
 */
public class DaoRegister implements ImplementReg{
    PreparedStatement pst = null;
    Resultset rs = null;
    Connection connection = Koneksi.getCon();
    RegisterView framef;

    @Override
    public void insert(ModRegister mr) {
        connection = Koneksi.getCon();
        
        String insert = "INSERT INTO tabelogin (username, password, nama, nohp) VALUES (?,?,?,?)";
        try{
            pst = connection.prepareStatement(insert);
            pst.setString(1, framef.getRgsUser().getText());
            pst.setString(2, framef.getRgsPw().getText());
            pst.setString(3, framef.getRgsNama().getText());
            pst.setString(3, framef.getRgsNohp().getText());
            pst.executeUpdate();
            rs = (Resultset) pst.getGeneratedKeys();
            while(rs.next()){
                
            }
        }catch (SQLException ex){
           ex.printStackTrace();
        }finally{
            try{
                pst.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
