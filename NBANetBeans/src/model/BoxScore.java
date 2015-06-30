/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author will
 */
public class BoxScore implements Serializable{
    private Boolean starter;
    private Integer segs;
    private Integer fg;
    private Integer fga;
    private Integer pt2;
    private Integer pt3;
    private Integer oReb;
    private Integer dReb;
    private Integer assist;
    private Integer ft;
    private Integer block;
    private Integer steal;
    private Integer turnOver;
    private Integer idContract;
    private Integer idPlayer;
    private Franchise franchise;
    private Integer numGame;

    public BoxScore() {
    }

    public Boolean getStarter() {
        return starter;
    }

    public void setStarter(Boolean starter) {
        this.starter = starter;
    }

    public Integer getSegs() {
        return segs;
    }

    public void setSegs(Integer segs) {
        this.segs = segs;
    }

    public Integer getFg() {
        return fg;
    }

    public void setFg(Integer fg) {
        this.fg = fg;
    }

    public Integer getFga() {
        return fga;
    }

    public void setFga(Integer fga) {
        this.fga = fga;
    }

    public Integer getPt2() {
        return pt2;
    }

    public void setPt2(Integer pt2) {
        this.pt2 = pt2;
    }

    public Integer getPt3() {
        return pt3;
    }

    public void setPt3(Integer pt3) {
        this.pt3 = pt3;
    }

    public Integer getoReb() {
        return oReb;
    }

    public void setoReb(Integer oReb) {
        this.oReb = oReb;
    }

    public Integer getdReb() {
        return dReb;
    }

    public void setdReb(Integer dReb) {
        this.dReb = dReb;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public Integer getFt() {
        return ft;
    }

    public void setFt(Integer ft) {
        this.ft = ft;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getSteal() {
        return steal;
    }

    public void setSteal(Integer steal) {
        this.steal = steal;
    }

    public Integer getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(Integer turnOver) {
        this.turnOver = turnOver;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    public Integer getNumGame() {
        return numGame;
    }

    public void setNumGame(Integer numGame) {
        this.numGame = numGame;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idContract);
        hash = 23 * hash + Objects.hashCode(this.idPlayer);
        hash = 23 * hash + Objects.hashCode(this.franchise);
        hash = 23 * hash + Objects.hashCode(this.numGame);
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
        final BoxScore other = (BoxScore) obj;
        if (!Objects.equals(this.idContract, other.idContract)) {
            return false;
        }
        if (!Objects.equals(this.idPlayer, other.idPlayer)) {
            return false;
        }
        if (!Objects.equals(this.franchise, other.franchise)) {
            return false;
        }
        if (!Objects.equals(this.numGame, other.numGame)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
