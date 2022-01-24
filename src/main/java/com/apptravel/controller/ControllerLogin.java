/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;

import com.apptravel.dao.DaoLogin;
import com.apptravel.view.LoginView;
import com.apptravel.dao.ImplementLogin;
import com.apptravel.model.ModLogin;
import com.mysql.cj.Messages;
import java.beans.Statement;

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
     */
    public ControllerLogin(LoginView frame) {
        this.frame = frame;
        //Implogin = new DaoLogin();
    }
    
    
    public void select(){
       modlog  = new ModLogin();
       modlog.getUser(frame.getTxtUser().getText());
       modlog.getPass(frame.getTxtPw().getText());
       
        
        
    }
    
}
