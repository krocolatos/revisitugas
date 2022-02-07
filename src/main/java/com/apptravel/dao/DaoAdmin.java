/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apptravel.dao;

import com.apptravel.model.ModAdmin;
import com.apptravel.connect.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author galih
 */
public class DaoAdmin implements ImplementAdmin{
    Connection connection;
    final String insert = "INSERT INTO datatiket (travel, asal, tujuan, jam, harga) VALUES (?,?,?,?,?);";
    final String delete = "DELETE FROM datatiket WHERE id_tiket=?";
    final String update = "UPDATE datatiket SET travel=?, asal=?, tujuan=?, jam=?, harga=? WHERE id_tiket=?;";
    final String select = "SELECT * FROM datatiket;";

    public DaoAdmin() throws SQLException {
        connection = Koneksi.connection();
    }
    
    
    @Override
    public void insert(ModAdmin ma) {
        
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(insert);
            pst.setString(1, ma.getTravel());
            pst.setString(2, ma.getAsal());
            pst.setString(3, ma.getTujuan());
            pst.setString(4, ma.getJam());
            pst.setDouble(5, ma.getHarga());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            while (rs.next()){
                ma.setNoID(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
        }finally{
            try{
                pst.close();
            } catch(SQLException ex){
            }
        }
    }

    

    @Override
    public void update(ModAdmin ma) {
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(update);
            pst.setString(1, ma.getTravel());
            pst.setString(2, ma.getAsal());
            pst.setString(3, ma.getTujuan());
            pst.setString(4, ma.getJam());
            pst.setDouble(5, ma.getHarga());
            pst.setInt(6, ma.getNoID());
            pst.executeUpdate();
           // ResultSet rs = pst.getGeneratedKeys();
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                pst.close();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(int no) {
       PreparedStatement pst = null;
       
        try {
            pst = connection.prepareStatement(delete);
            
            pst.setInt(1, no);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                pst.close();
            } catch(SQLException ex){
                ex.printStackTrace(); 
            }
        }
       
    }
    
    @Override
    public java.util.List<ModAdmin> getAll() {
        List<ModAdmin> lma = null;
            
       try {
            lma = new ArrayList<ModAdmin>();
            
            Statement st = connection.createStatement();
          
            ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            ModAdmin ma = new ModAdmin();
            ma.setNoID(rs.getInt("id_tiket"));
            ma.setTravel(rs.getString("travel"));
            ma.setAsal(rs.getString("asal"));
            ma.setTujuan(rs.getString("tujuan"));   
            ma.setJam(rs.getString("jam"));
            ma.setHarga(rs.getDouble("harga"));
            lma.add(ma);
                    
        }
        }catch (SQLException ex) {
           //Logger.getLogger(DaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lma;
    }

    
    
}
