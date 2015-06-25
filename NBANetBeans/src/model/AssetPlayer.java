/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author will
 */
public class AssetPlayer implements Serializable {
    private Integer idPlayer;
    private Integer idContract;
    private Integer idFranchise; // Necessário criar um model para Franchise
    private Double salary;
    private Calendar endC;
    private Calendar startC;

    public AssetPlayer() {
    }

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Calendar getEndC() {
        return endC;
    }

    public void setEndC(Calendar endC) {
        this.endC = endC;
    }

    public Calendar getStartC() {
        return startC;
    }

    public void setStartC(Calendar startC) {
        this.startC = startC;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idPlayer);
        hash = 97 * hash + Objects.hashCode(this.idContract);
        hash = 97 * hash + Objects.hashCode(this.idFranchise);
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
        if (!Objects.equals(this.idPlayer, other.idPlayer)) {
            return false;
        }
        if (!Objects.equals(this.idContract, other.idContract)) {
            return false;
        }
        if (!Objects.equals(this.idFranchise, other.idFranchise)) {
            return false;
        }
        return true;
    }
    
}
