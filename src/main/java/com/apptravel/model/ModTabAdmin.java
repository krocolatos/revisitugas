/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author galih
 */
public class ModTabAdmin extends AbstractTableModel{
    
    java.util.List<ModAdmin> lma;

    public ModTabAdmin(List<ModAdmin> lma) {
        this.lma = lma;
    }
    
    
        
    @Override
    public int getRowCount() {
        return lma.size();
       }

    @Override
    public int getColumnCount() {
        return 6;
      }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID Tiket";
            case 1:
                return "Travel";
            case 2:
                return "Asal";
            case 3:
                return "Tujuan";    
            case 4:
                return "Jam";
            case 5:
                return "Harga";
            default:
                return null;
        }
        
    }
    
    @Override
    public Object getValueAt(int row, int column) {
       switch (column) {
           case 0:
                return lma.get(row).getNoID();
           case 1:
                return lma.get(row).getTravel();
           case 2:
                return lma.get(row).getAsal();
           case 3:
                return lma.get(row).getTujuan();
           case 4:
                return lma.get(row).getJam();
           case 5:
                return lma.get(row).getHarga();    
           default:
               return null;
       }
    }

        
}
