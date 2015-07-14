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
import java.util.Objects;
import javax.swing.JOptionPane;
import model.OracleJDBC;
import model.domain.Player;
import model.domain.Arena;
import model.domain.Franchise;

/**
 *
 * @author will
 */
public class DAOPlayer {
    private static final List<Player> list = new ArrayList<>();
    
    public List<Player> getList (){
        
        if(list.isEmpty()){
        
            String sql = "select e.idperson, college, hschool, position, name, surname, b_date, country  from Player p, Person e, AssetPlayer a " +
                          "where p.idPerson = e.idPerson AND " +
                          "p.idPerson = a.idPlayer order by name";
            

            try {  
                PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    Player player  = new Player();

                    player.setIdPerson(rs.getInt("idPerson"));
                    player.sethSchool(rs.getString("hSchool"));
                    player.setPosition(rs.getString("position"));
                    player.setCollege(rs.getString("college"));
                    player.setName(rs.getString("name"));
                    player.setSurname(rs.getString("surname"));
                    player.setCountry(rs.getString("country"));
                    
                    Calendar c = Calendar.getInstance();
                    java.sql.Time t = rs.getTime("b_Date");
                    c.setTime(t);
                    
                    player.setbDate(c);
                    
                    list.add(player);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar Players.\nDetalhes: "+ ex.getMessage());
            }
        }
        
        return list;
    }
    
    public Player getPlayerById (Integer idPerson){
        if(list.isEmpty()){
            getList();
        }
        
        for(Player player : list){
            if(Objects.equals(player.getIdPerson(), idPerson)){
                return player;
            }
        }
        
        return null;
        
    }
    
    public List<Player> getPlayersByFranchise(Franchise franchise){
        
        String sql = "select e.idperson, college, hschool, position, name, surname, b_date, country  from Player p, Person e, AssetPlayer a " +
                          "where p.idPerson = e.idPerson AND " +
                          "p.idPerson = a.idPlayer AND " +
                          "a.idFranchise = " + franchise.getIdFranchise() + " order by name";
        List<Player> playerList = new ArrayList<>();
        try {  
                PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    Player player  = new Player();

                    player.setIdPerson(rs.getInt("idPerson"));
                    player.sethSchool(rs.getString("hSchool"));
                    player.setPosition(rs.getString("position"));
                    player.setCollege(rs.getString("college"));
                    player.setName(rs.getString("name"));
                    player.setSurname(rs.getString("surname"));
                    player.setCountry(rs.getString("country"));
                    
                    Calendar c = Calendar.getInstance();
                    java.sql.Time t = rs.getTime("b_Date");
                    c.setTime(t);
                    
                    player.setbDate(c);
                    
                    playerList.add(player);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar Players.\nDetalhes: "+ ex.getMessage());
            }
        
        
        
        
        return playerList;
    }
}
