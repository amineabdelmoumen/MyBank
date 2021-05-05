package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class compte implements Serializable {
    @Id
    private String numCompte;
    private Double solde;
    private Date dateCreation;
    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private client client;
    @OneToMany(mappedBy = "compte")
    private Collection<operation> operations;

    public compte(String numCompte, Double solde, Date dateCreation, org.sid.entities.client client) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }

    public compte() {
    }

    public Collection<operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<operation> operations) {
        this.operations = operations;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
}
