/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apptravel.dao;

import com.apptravel.model.ModAdmin;
import java.util.List;

/**
 *
 * @author galih
 */
public interface ImplementAdmin {
    
    public void insert(ModAdmin ma);
    public void update (ModAdmin ma);
    public void delete(int no);
    public java.util.List<ModAdmin> getAll();
    
    
}
