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
import model.AssetPlayer;
import model.BoxScore;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOAssetPlayer {
    public List<AssetPlayer> getListFromGame (int gameId){
        
        
        String sql = "select * from AssetPlayer";
        List<AssetPlayer> list = new ArrayList<>();
        DAOFranchise daoF = new DAOFranchise();
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AssetPlayer ap = new AssetPlayer();
                
                ap.setIdContract(rs.getInt("idContract"));
                ap.setEndC(rs.getDate("endC"));
                ap.setStartC(rs.getDate("startC"));
                ap.setSalary(rs.getDouble("salary"));
                
                list.add(ap);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar AssetPlayers.\nDetalhes: "+ex.getMessage());
        }
        
        return list;
    }
}
