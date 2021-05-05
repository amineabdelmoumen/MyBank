package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class compteEpargne extends compte {
    private double taux;

    public compteEpargne() {

    }

    public compteEpargne(String numCompte, Double solde, Date dateCreation, client client, double taux) {
        super(numCompte, solde, dateCreation, client);
        this.taux = taux;
    }

    public compteEpargne(double taux) {
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

}
