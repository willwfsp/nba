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
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOArena {
    public List<Arena> getList (){
        
        
        String sql = "select name, arena.idArena, arena.idFranchise, arena.idSponsor, arena.address from arena, sponsor where sponsor.idsponsor = arena.idsponsor;";
        List<Arena> list = new ArrayList<>();
            
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Arena arena = new Arena();
                arena.setIdArena(rs.getInt("idarena"));
                arena.setIdFranchise(rs.getInt("idfranchise"));
                arena.setIdSponsor(rs.getInt("idsponsor"));
                arena.setAddress(rs.getString("address"));
                
                arena.setName(rs.getString("name"));
                list.add(arena);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Arenas.\nDetalhes: "+ ex.getMessage());
        }
        
        return list;
    }
    
    public Arena getArenaById (Integer idArena){
        String sql = "select name, arena.idArena, arena.idFranchise, arena.idSponsor, arena.address from arena, sponsor where sponsor.idsponsor = arena.idsponsor and arena.idarena = " + idArena;
        Arena arena = new Arena();
        try {  
            PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                arena.setIdArena(rs.getInt("idarena"));
                arena.setIdFranchise(rs.getInt("idfranchise"));
                arena.setIdSponsor(rs.getInt("idsponsor"));
                arena.setAddress(rs.getString("address"));
                arena.setName(rs.getString("name"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Arena não encontrada.\nDetalhes: "+ex.getMessage());
        }
        
        return arena;
        
    }
    
}
