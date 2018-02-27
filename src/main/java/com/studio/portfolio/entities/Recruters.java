/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studio.portfolio.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;

/**
 *
 * Class to define recruters basic info.
 */
@RequestScoped
public class Recruters implements Serializable {

    private String name;
    private String company;

    public Recruters() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    @Override
    public int hashCode() {
        int hash = 70;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.company);
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
        final Recruters other = (Recruters) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recruters{" + "name=" + name + ", company=" + company + '}';
    }
    
    
}
