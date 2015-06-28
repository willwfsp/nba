/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author will
 */
public class OracleJDBC {
    private static final String db = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl";
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String user = "w8066190";
    private static final String password = "w8066190";
    private static Connection connection = null;
    
    public OracleJDBC(){
        
    }
    
    public static Connection getConnection (){
        if (connection == null){
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(db,user,password);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver: "+ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Erro na conexão: "+ex.getMessage());
            }
        }
        
        return connection;
    }
    
    
    public static PreparedStatement getPreparedStatement(String sql){
        
        if(connection == null){
            connection = getConnection();
        }
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: "+ex.getMessage());
        }
               
        return  null;
    }
    
    
}
