package org.sid.buziness;

import java.util.Date;
import java.util.Optional;

import org.sid.dao.clientRepository;
import org.sid.dao.compteRepository;
import org.sid.dao.operationRepository;
import org.sid.entities.compte;
import org.sid.entities.operation;
import org.sid.entities.versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class bankImp implements bankBuziness {
    @Autowired
    private clientRepository clientrepo;
    @Autowired
    private compteRepository compterepo;
    @Autowired
    private operationRepository operationrepo;

    @Override
    public compte consultation(String codecmpt) {
        compte cmp = compterepo.findOne(codecmpt);
        System.out.println(cmp.toString());
        return cmp;
    }

    @Override
    public void verser(String codecmpt, double amount) {
        compte cmp = consultation(codecmpt);
        operation op = new versement(new Date(), 3000, cmp);
        operationrepo.save(op);
        cmp.setSolde(cmp.getSolde() + amount);
        compterepo.save(cmp);

    }

    @Override
    public void retirer(String codecmpt, double amout) {
        // TODO Auto-generated method stub

    }

    @Override
    public void virement(String codecmpt1, String codecmpt2, double amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public Page<operation> listoperation(String codecmpt, int page, int size) {
        // TODO Auto-generated method stub
        return null;
    }

}