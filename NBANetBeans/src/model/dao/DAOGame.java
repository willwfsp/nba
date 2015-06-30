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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Arena;
import model.Game;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOGame {
    public List<Game> getList (){
        
        
        String sql =    "select distinct g.numgame, g.dateg, g.hourg, g.idArena, g.idSeason, s.name, a.address, a.idFranchise, a.idSponsor " +
                        "from game g, arena a, sponsor s, boxscore b " +
                        "where a.idSponsor = s.idSponsor AND " +
                        "a.idArena = g.idArena AND b.numGame = g.numGame " +
                        "order by g.numGame";
        List<Game> list = new ArrayList<>();
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){

                Game game = new Game();
                game.setNumGame(rs.getInt("numgame"));
                Arena arena = new Arena();
                
                arena.setAddress(rs.getString("address"));
                arena.setIdFranchise(rs.getInt("idFranchise"));
                arena.setIdSponsor(rs.getInt("idSponsor"));
                arena.setIdArena(rs.getInt("idArena"));
                arena.setName(rs.getString("name"));
                
                game.setArena(arena);
                game.setSeason(rs.getInt("idseason"));
                game.setDate(rs.getDate("dateg"));
                
                Calendar c = Calendar.getInstance();
                java.sql.Time t = rs.getTime("hourg");
                c.setTime(t);
                
                game.setHour(c);
                
                list.add(game);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Games.\nDetalhes: "+ ex.getMessage());
        }
        
        return list;
    }

}
