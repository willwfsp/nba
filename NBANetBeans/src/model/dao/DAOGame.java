/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.Data;
import model.Game;
import model.Person;

/**
 *
 * @author will
 */
public class DAOGame {
    public List<Game> getList (){
        return Data.listGame;
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
