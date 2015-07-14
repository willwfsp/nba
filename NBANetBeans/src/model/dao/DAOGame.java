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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.AssetPlayer;
import model.Game;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOGame {
    
    List<Game> list = new ArrayList<>();
    
    public List<Game> getList (){
        
        
        String sql =    "select distinct g.numgame, g.dateg, g.hourg, g.idArena, g.idSeason, s.name " +
                        "from game g, arena a, sponsor s, boxscore b " +
                        "where a.idSponsor = s.idSponsor AND " +
                        "a.idArena = g.idArena AND b.numGame = g.numGame " +
                        "order by g.numGame";
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DAOArena dao = new DAOArena();
                Game game = new Game();
                game.setNumGame(rs.getInt("numgame"));
                game.setArena(dao.getArenaById(rs.getInt("idArena")));
                game.setSeason(rs.getInt("idseason"));
                game.setDate(rs.getDate("dateg"));
                game.setHour(rs.getDate("hourg"));                
                list.add(game);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Games.\nDetalhes: "+ ex.getMessage());
        }
        
        return list;
    }
    
    public Boolean insert(Game game){
        
        if(list.isEmpty()){
            getList();
        }
        game.setNumGame(list.get(list.size()-1).getNumGame()+100);
        String sql = "INSERT INTO Game (numGame, dateg, hourg, idArena, idSeason) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            pst.setInt(1, game.getNumGame());
            pst.setDate(2, (Date) game.getDate());
            pst.setDate(3, (Date) game.getHour());
            pst.setInt(4, game.getArena().getIdArena());
            pst.setInt(5, game.getSeason());
            pst.executeUpdate();
            
            return true;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao inserir Games.\nDetalhes: "+ex.getMessage());
            return false;
        }
    }

}
