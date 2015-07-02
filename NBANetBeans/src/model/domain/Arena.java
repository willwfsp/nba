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
public class Arena implements Serializable{

    private Integer idSponsor;
    private Integer idArena;
    private Integer idFranchise;
    private String  adress;
    private String  name;
      
    
    public Arena() {
    }

    public Integer getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(Integer idSponsor) {
        this.idSponsor = idSponsor;
    }

    public Integer getIdArena() {
        return idArena;
    }

    public void setIdArena(Integer idArena) {
        this.idArena = idArena;
    }

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }

    public String getAdress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idArena);
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
        final Arena other = (Arena) obj;
        if (!Objects.equals(this.idArena, other.idArena)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
