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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author galih
 */
public class DaoLogin implements ImplementLogin{
    PreparedStatement pst = null;
    Resultset rs = null;
    Connection connection = Koneksi.getCon();
    final String select = "SELECT * FROM tabelogin where username =? and password=?";
    
  //  final String select = "SELECT * FROM tabelogin where username =? and password=?";

    

    public void select(ModLogin ml) {
        //PreparedStatement pst;
       connection = Koneksi.getCon();
       //String select = "SELECT * FROM tabelogin where username =? and password=?";
        try{
        pst = connection.prepareStatement(select);
        pst.setString(1, ml.getUser());
        pst.setString(2, ml.getPass());
        rs = (Resultset) pst.executeQuery();       
        if(rs.next()){
            JOptionPane.showMessageDialog(null, "login berhasil");
        }else{
            JOptionPane.showMessageDialog(null, "username atau password salah","",JOptionPane.ERROR_MESSAGE);
            HomeView start = new HomeView();
            start.setVisible(true);
            this.dispose();
            
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }   catch (UnsupportedOperationException | SQLException e) {
        JOptionPane.showMessageDialog(null, e);
           Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, e);
           }
    
}

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void selectLogin(ModLogin ml) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
