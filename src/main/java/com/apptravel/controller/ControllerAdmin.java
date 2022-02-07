/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;

import com.apptravel.dao.DaoAdmin;
import com.apptravel.dao.ImplementAdmin;
import com.apptravel.model.ModAdmin;
import com.apptravel.model.ModTabAdmin;
import com.apptravel.view.AdminTable;
import static java.lang.String.valueOf;
import java.sql.SQLException;
//import static java.lang.String.valueOf;
import javax.swing.JOptionPane;

/**
 *
 * @author galih
 */
public class ControllerAdmin {
    AdminTable framead;
    ImplementAdmin implAdmin;
    java.util.List<ModAdmin> lma;

    public ControllerAdmin(AdminTable framead) throws SQLException {
        this.framead = framead;
        implAdmin = new DaoAdmin();
        lma = implAdmin.getAll();
    }

    
    public void reset(){
        framead.getTfID().setText("");
        framead.getTfTravel().setText("");
        framead.getTfAsal().setText("");
        framead.getTfTujuan().setText("");
        framead.getTfJam().setText("");
        framead.getTfHarga().setText("");
    }
    
    //tampil database mysql ke tabel 
    public void isiTable(){
        lma = implAdmin.getAll();
        ModTabAdmin mta = new ModTabAdmin(lma);
        framead.getTabAdmin().setModel(mta);
    }
    //tampil data tabel ke form
    public void isiField(int row){
        framead.getTfID().setText(String.valueOf(lma.get(row).getNoID()));
        framead.getTfTravel().setText(valueOf(lma.get(row).getTravel()));
        framead.getTfAsal().setText(valueOf(lma.get(row).getAsal()));
        framead.getTfTujuan().setText(valueOf(lma.get(row).getTujuan()));
        framead.getTfJam().setText(valueOf(lma.get(row).getJam()));
        framead.getTfHarga().setText(String.valueOf(lma.get(row).getHarga()));
    }
    
    public void insert(){
        if(!framead.getTfTravel().getText().trim().isEmpty() & !framead.getTfAsal().getText().trim().isEmpty()){
           ModAdmin ma = new ModAdmin();
           
           ma.setTravel(framead.getTfTravel().getText());
           ma.setAsal(framead.getTfAsal().getText());
           ma.setTujuan(framead.getTfTujuan().getText());
           ma.setJam(framead.getTfJam().getText());
           ma.setHarga(Double.valueOf(framead.getTfHarga().getText()));
           
           implAdmin.insert(ma);
            JOptionPane.showMessageDialog(null, "data disimpan");
           
        } else{
            JOptionPane.showMessageDialog(null, "gagal");
        }
    }
    
    public void delete(){
        if (!framead.getTfID().getText().trim().isEmpty()) {
            int no = Integer.parseInt(framead.getTfID().getText());
            implAdmin.delete(no);
            JOptionPane.showMessageDialog(null, "data dihapus");
           
        } else{
            JOptionPane.showMessageDialog(null, "gagal");
        }
    }
    
    public void update(){
        if (!framead.getTfID().getText().trim().isEmpty()) {
            
            ModAdmin ma = new ModAdmin();
           
           ma.setTravel(framead.getTfTravel().getText());
           ma.setAsal(framead.getTfAsal().getText());
           ma.setTujuan(framead.getTfTujuan().getText());
           ma.setJam(framead.getTfJam().getText());
           ma.setHarga(Double.valueOf(framead.getTfHarga().getText()));
           ma.setNoID(Integer.valueOf(framead.getTfID().getText()));
           
            implAdmin.update(ma);
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
           
        } else{
            JOptionPane.showMessageDialog(null, "gagal","pesan", JOptionPane.ERROR_MESSAGE);
        }
    }
  

}
