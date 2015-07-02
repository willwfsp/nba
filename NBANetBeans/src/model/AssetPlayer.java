/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.domain.Player;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import model.domain.Franchise;

/**
 *
 * @author will
 */
public class AssetPlayer implements Serializable {
    private Player player;
    private Integer idContract;
    private Franchise franchise; 
    private Double salary;
    private Date endC;
    private Date startC;

    public AssetPlayer() {
    }


    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEndC() {
        return endC;
    }

    public void setEndC(Date endC) {
        this.endC = endC;
    }

    public Date getStartC() {
        return startC;
    }

    public void setStartC(Date startC) {
        this.startC = startC;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(Franchise franchise) {
        this.franchise = franchise;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.player);
        hash = 37 * hash + Objects.hashCode(this.idContract);
        hash = 37 * hash + Objects.hashCode(this.franchise);
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
        final AssetPlayer other = (AssetPlayer) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.idContract, other.idContract)) {
            return false;
        }
        if (!Objects.equals(this.franchise, other.franchise)) {
            return false;
        }
        return true;
    }


}
