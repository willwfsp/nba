/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 * Classe model para Player no padrão JavaBeans
 *
 * @author will
 */
public class Player implements Serializable {

    private Integer idPerson;
    private String hSchool;
    private String position;
    private String college;
    private String name;
    private String surname;
    private Calendar bDate;
    private String country;

    public Player() {
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String gethSchool() {
        return hSchool;
    }

    public void sethSchool(String hSchool) {
        this.hSchool = hSchool;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.idPerson);
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.idPerson, other.idPerson)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getbDate() {
        return bDate;
    }

    public void setbDate(Calendar bDate) {
        this.bDate = bDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
