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
import model.domain.Arena;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOArena {
    
    private static final List<Arena> list = new ArrayList<>();
    
    public List<Arena> getList (){
        
        if(list.isEmpty()){
        
            String sql = "select name, arena.idArena, arena.idFranchise, arena.idSponsor, arena.address from arena, sponsor where sponsor.idsponsor = arena.idsponsor";
            

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
        }
        
        return list;
    }
    
    public Arena getArenaById (Integer idArena){
        if(list.isEmpty()){
            getList();
        }
        
        for(Arena arena : list){
            if(arena.getIdArena() == idArena){
                return arena;
            }
        }
        
        return null;
        
    }
    
}
