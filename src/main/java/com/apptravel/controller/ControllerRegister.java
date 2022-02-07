/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;

import com.apptravel.dao.DaoRegister;
import com.apptravel.dao.ImplementReg;
import com.apptravel.model.ModRegister;
import com.apptravel.view.RegisterView;
import java.awt.Component;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author galih
 */
public class ControllerRegister {
    RegisterView framef;
    ImplementReg implreg;
    ModRegister modreg;

    public ControllerRegister(RegisterView framef) throws SQLException {
        this.framef = framef;
        implreg = new DaoRegister();
    }
    
    public void insert(){
        if(!framef.getRgsUser().getText().trim().isEmpty() & !framef.getRgsPw().getText().trim().isEmpty() & !framef.getRgsNama().getText().trim().isEmpty() & !framef.getRgsNohp().getText().trim().isEmpty()){
        ModRegister mr = new ModRegister();    
        
        mr.setUserdaf(framef.getRgsUser().getText());
        mr.setPassdaf(framef.getRgsPw().getText());
        mr.setNama(framef.getRgsNama().getText());
        mr.setNohp(framef.getRgsNohp().getText());
        
        implreg.insertreg(mr);
        JOptionPane.showMessageDialog(null, "berhasil");
       }else{
            JOptionPane.showMessageDialog(null, "data gagal");
        }
    }

    
}
