/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author will
 */
public class Franchise implements Serializable{
    private Integer idFranchise;
    private String city;
    private String name;
    private String symbol;
    private Integer idDivision;

    public Franchise() {
    }

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idFranchise);
        hash = 53 * hash + Objects.hashCode(this.idDivision);
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
        final Franchise other = (Franchise) obj;
        if (!Objects.equals(this.idFranchise, other.idFranchise)) {
            return false;
        }
        if (!Objects.equals(this.idDivision, other.idDivision)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
