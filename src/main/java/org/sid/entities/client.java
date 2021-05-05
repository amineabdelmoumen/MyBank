package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class client implements Serializable {
    @Id
    @GeneratedValue
    private Long code;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<compte> comptes;

    public client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public client() {
    }

    public Collection<compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<compte> comptes) {
        this.comptes = comptes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" + " code='" + getCode() + "'" + ", nom='" + getNom() + "'" + ", email='" + getEmail() + "'"
                + ", comptes='" + getComptes() + "'" + "}";
    }

}