package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("versement")
public class versement extends operation {

    public versement(Date dateOperation, double montant, org.sid.entities.compte compte) {
        super(dateOperation, montant, compte);
    }

    public versement() {
    }

}
