/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetPlayer;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOAssetPlayer {
    
    
    List<AssetPlayer> list = new ArrayList<>();
    
    /**
     * Retorna todos os AssetPlayers
     * @return lista de AssetPlayers
     */
    public List<AssetPlayer> getList(){
        
        
        String sql = "select * from AssetPlayer a, Player p where p.idPerson = a.idPlayer order by idContract";
        
        DAOFranchise daoF = new DAOFranchise();
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            
            DAOFranchise daoFranchise = new DAOFranchise();
            DAOPlayer daoPlayer = new DAOPlayer();
            daoPlayer.getList();
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                AssetPlayer ap = new AssetPlayer();
                
                ap.setFranchise(daoFranchise.getFranchiseById(rs.getInt("idFranchise")));
                ap.setPlayer(daoPlayer.getPlayerById(rs.getInt("idPlayer")));
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
    
    /**
     * Insere um novo AssetPlayer no banco
     * @param assetPlayer novo assetPlayer
     * @return Boolean sucesso ou falha
     */
    public Boolean insert(AssetPlayer assetPlayer){
        if(list.isEmpty()){
            getList();
        }
        assetPlayer.setIdContract(list.size()+100);
        list.add(assetPlayer);
        
        String sql = "INSERT INTO AseetPlayer (idContract, idPlayer, idFranchise, startC, endC, salary) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            pst.setInt(1, assetPlayer.getIdContract());
            pst.setInt(2, assetPlayer.getPlayer().getIdPerson());
            pst.setInt(3, assetPlayer.getFranchise().getIdFranchise());
            pst.setDate(4, (Date) assetPlayer.getStartC());
            pst.setDate(5, (Date) assetPlayer.getEndC());
            pst.setDouble(6, assetPlayer.getSalary());
            
            pst.executeUpdate();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir AssetPlayer.\nDetalhes: "+ex.getMessage());
        }
        
	
        return true;
    }
}
