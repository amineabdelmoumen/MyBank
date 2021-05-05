package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class compteCourant extends compte {
    private double decouvert;

    public compteCourant(String numCompte, Double solde, Date dateCreation, client client, double decouvert) {
        super(numCompte, solde, dateCreation, client);
        this.decouvert = decouvert;
    }

    public compteCourant() {

    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
