/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.controller;


import com.apptravel.dao.DaoAdmin;
import com.apptravel.dao.ImplementAdmin;
import com.apptravel.model.ModAdmin;
import com.apptravel.model.ModTabAdmin;
import com.apptravel.view.HomeView;
import com.apptravel.view.AdminTable;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author galih
 */
public class ControllerHome {
    HomeView framehome;
    ImplementAdmin ImplHome;
    java.util.List<ModAdmin> lmh;

    public ControllerHome(HomeView framehome) throws SQLException {
        this.framehome = framehome;
        ImplHome = new DaoAdmin();
        lmh = ImplHome.getAll();
        
    }
    
    
     public void isiTable(){
        lmh = ImplHome.getAll();
        ModTabAdmin mth = new ModTabAdmin(lmh);
        framehome.getjTable3().setModel(mth);
        
       

    
    
}


}
