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
import java.util.Objects;
import javax.swing.JOptionPane;
import model.domain.Arena;
import model.domain.Franchise;
import model.OracleJDBC;

/**
 *
 * @author will
 */
public class DAOFranchise {

    private static final List<Franchise> list = new ArrayList<>();

    public List<Franchise> getList() {

        if (list.isEmpty()) {
            String sql = "select * from franchise";

            try {
                PreparedStatement pst = OracleJDBC.getPreparedStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Franchise franc = new Franchise();
                    franc.setIdFranchise(rs.getInt("idfranchise"));
                    franc.setIdDivision(rs.getInt("iddivision"));
                    franc.setCity(rs.getString("city"));
                    franc.setName(rs.getString("name"));
                    franc.setSymbol(rs.getString("symbol"));

                    list.add(franc);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao listar Franchises.\nDetalhes: " + ex.getMessage());
            }
        }

        return list;
    }

    public Franchise getFranchiseById(Integer idFranchise) {

        if (list.isEmpty()) {
            getList();
        }
        
        for (Franchise franc : list) {
            if (Objects.equals(franc.getIdFranchise(), idFranchise)) {
                return franc;
            }
        }

        return null;

    }
}
