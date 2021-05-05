package org.sid.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("retrait")
public class retrait extends operation {
    public retrait(Date dateOperation, double montant, org.sid.entities.compte compte) {
        super(dateOperation, montant, compte);
    }

    public retrait() {

    }
}
