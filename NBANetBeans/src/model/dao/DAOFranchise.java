/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Arena;
import model.Franchise;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOFranchise {
    public List<Franchise> getList (){
        
        String sql = "select * from franchise";
        List<Franchise> list = new ArrayList<>();
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Franchise franc = new Franchise();
                franc.setIdFranchise(rs.getInt("idfranchise"));
                franc.setIdDivision(rs.getInt("iddivision"));
                franc.setCity(rs.getString("city"));
                franc.setName(rs.getString("name"));
                franc.setSymbol(rs.getString("symbol"));
                
                list.add(franc);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Franchises.\nDetalhes: "+ ex.getMessage());
        }
        
        return list;
    }
    
    public Franchise getFranchiseById (Integer idFranchise){
        String sql = "select * from franchise where idFranchise = "+idFranchise;
        Franchise franc = new Franchise();
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                franc.setIdFranchise(rs.getInt("idfranchise"));
                franc.setIdDivision(rs.getInt("iddivision"));
                franc.setCity(rs.getString("city"));
                franc.setName(rs.getString("name"));
                franc.setSymbol(rs.getString("symbol"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Franchise não encontrado.\nDetalhes: "+ex.getMessage());
        }
        
        return franc;
        
    }
}
