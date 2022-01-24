/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;

import com.apptravel.dao.ImplementReg;
import com.apptravel.model.ModRegister;
import com.apptravel.view.RegisterView;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author galih
 */
public class ControllerRegister {
    RegisterView framef;
    ImplementReg implreg;
    ModRegister modreg;

    public ControllerRegister(RegisterView framef) {
        this.framef = framef;
    }
    
    public void insert(){
        if(!framef.getRgsUser().getText().trim().isEmpty() & !framef.getRgsPw().getText().trim().isEmpty() & !framef.getRgsNama().getText().trim().isEmpty() & !framef.getRgsNohp().getText().trim().isEmpty()){
            
        
        modreg = new ModRegister();
        modreg.setUserdaf(framef.getRgsUser().getText());
        modreg.setPassdaf(framef.getRgsPw().getText());
        modreg.setNama(framef.getRgsNama().getText());
        modreg.setNohp(framef.getRgsNohp().getText());
        implreg.insert(modreg);
        JOptionPane.showMessageDialog((Component) implreg, "berhasil");
       }else{
            JOptionPane.showMessageDialog(null, "data gagal");
        }
    }

    public ControllerRegister(ModRegister modreg) {
        this.modreg = modreg;
    }
    
}
