/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;

import com.apptravel.dao.DaoLogin;
import com.apptravel.view.LoginView;
import com.apptravel.dao.ImplementLogin;
import com.apptravel.model.ModLogin;
import com.apptravel.view.HomeView;
import com.mysql.cj.Messages;
import java.beans.Statement;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author galih
 */
public class ControllerLogin {
    LoginView frame;
    ImplementLogin Implogin;
    ModLogin modlog;
    //list<ModLogin> lmb;

    /**
     *
     * @param frame
     * @throws java.sql.SQLException
     */
    public ControllerLogin(LoginView frame) throws SQLException {
        this.frame = frame;
        Implogin = new DaoLogin();
    }
    
    // public void dispose() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}
   // !frame.getTxtUser().equals(ml.getUser()) & frame.getTxtPw().equals(ml.getPass())
    
    public void select(ModLogin ml){
        if(frame.getTxtUser().equals(ml.getUser()) & frame.getTxtPw().equals(ml.getPass())){
            JOptionPane.showMessageDialog(null, "berhasil");    
        
    } else{
                JOptionPane.showMessageDialog(null, "gagal","pesan", JOptionPane.ERROR_MESSAGE);
                }

        
        
    
}

} 
    //private void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

   




