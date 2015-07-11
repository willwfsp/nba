/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.domain.Arena;
import java.beans.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author will
 */
public class Game implements Serializable {
    private Integer numGame;
    private Date date;
    private Date hour;
    //private Integer arena;
    private Arena arena;
    private Integer Season;

    public Game() {
    }

    public Integer getNumGame() {
        return numGame;
    }

    public void setNumGame(Integer numGame) {
        this.numGame = numGame;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    

    public Integer getSeason() {
        return Season;
    }

    public void setSeason(Integer Season) {
        this.Season = Season;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.numGame);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.numGame, other.numGame)) {
            return false;
        }
        return true;
    }
    
    @Transient
    public String getFormattedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date.getTime());
    }
    
    @Transient
    public String getFormattedHour(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(hour.getTime());
    }
}
