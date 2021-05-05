package org.sid.buziness;

import org.sid.entities.compte;
import org.sid.entities.operation;
import org.springframework.data.domain.Page;

public interface bankBuziness {
    public compte consultation(String codecmpt);

    public void verser(String codecmpt, double amout);

    public void retirer(String codecmpt, double amount);

    public void virement(String codecmpt1, String codecmpt2, double amount);

    public Page<operation> listoperation(String codecmpt, int page, int size);

}
