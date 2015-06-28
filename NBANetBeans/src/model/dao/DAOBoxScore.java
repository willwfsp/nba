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
import model.BoxScore;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOBoxScore {
    public List<BoxScore> getListFromGame (Integer gameId){
        
        
        String sql = "select * from boxscore where numGame = "+ gameId;
        List<BoxScore> list = new ArrayList<>();
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                BoxScore bs = new BoxScore();
                bs.setNumGame(rs.getInt("numgame"));
                bs.setIdContract(rs.getInt("idcontract"));
                bs.setIdFranchise(rs.getInt("idfranchise"));
                bs.setIdPlayer(rs.getInt("idplayer"));
                bs.setStarter(rs.getBoolean("starter"));
                bs.setSegs(rs.getInt("segs"));
                bs.setFg(rs.getInt("fg"));
                bs.setFga(rs.getInt("fga"));
                bs.setPt2(rs.getInt("twopt"));
                bs.setPt3(rs.getInt("threept"));
                bs.setAssist(rs.getInt("assist"));
                bs.setBlock(rs.getInt("bock"));
                bs.setFt(rs.getInt("ft"));
                bs.setSteal(rs.getInt("steal"));
                bs.setTurnOver(rs.getInt("turnover"));
                bs.setdReb(rs.getInt("d_reb"));
                bs.setoReb(rs.getInt("o_reb"));
                
                list.add(bs);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar BoxScore.\nDetalhes: "+ex.getMessage());
        }
        
        return list;
    }
}
