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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Data;
import model.Game;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOGame {
    public List<Game> getList (){
        
        
        String sql = "select * from game";
        List<Game> list = new ArrayList<>();
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Game game = new Game();
                game.setNumGame(rs.getInt("numgame"));
                game.setArena(rs.getInt("idarena"));
                game.setSeason(rs.getInt("idseason"));
                java.sql.Date dt = rs.getDate("dateg");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                game.setDate(c);
                
                java.sql.Time t = rs.getTime("hourg");
                c.setTime(t);
                game.setHour(c);
                list.add(game);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Games.\nDetalhes: ");
        }
        
        return list;
    }
    
    public boolean insert (Game obj){
        if(obj == null) {
            return false;
        }
        
        if(obj.getNumGame()== null){
            Integer id = getList().size() +1;
            obj.setNumGame(id);
            Data.listGame.add(obj);
        }else{
            Data.listGame.add(obj);
        }
        return true;
    }
    
    public boolean remove (Game obj){
        Data.listGame.remove(obj);
        return true;
    }
}
