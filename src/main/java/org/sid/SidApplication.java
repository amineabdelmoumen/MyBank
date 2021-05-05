package org.sid;

import java.util.Date;

import org.sid.dao.clientRepository;
import org.sid.dao.compteRepository;
import org.sid.dao.operationRepository;
import org.sid.entities.client;
import org.sid.entities.compte;
import org.sid.entities.compteCourant;
import org.sid.entities.compteEpargne;
import org.sid.entities.operation;
import org.sid.entities.retrait;
import org.sid.entities.versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SidApplication implements CommandLineRunner {
	@Autowired
	private clientRepository clientrepo;
	@Autowired
	private compteRepository compterepo;
	@Autowired
	private operationRepository operationrepo;

	public static void main(String[] args) {
		SpringApplication.run(SidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		client c1 = clientrepo.save(new client("abdelmoumlen amine", "abdelmoumen33330@gmail.com"));
		client c2 = clientrepo.save(new client("abderrzak frethi", "fethi330@gmail.com"));
		client c3 = clientrepo.save(new client("mohammed amine", "mohammed2220@gmail.com"));
		client c4 = clientrepo.save(new client("ahmed ali", "ahmed11110@gmail.com"));
		client c5 = clientrepo.save(new client("omar", "sonof@gmail.com"));

		compte cmp1 = compterepo.save(new compteCourant("c1", 90000.00, new Date(), c1, 60000));
		compte cmp2 = compterepo.save(new compteCourant("c2", 120000.00, new Date(), c2, 50000));
		compte cmp3 = compterepo.save(new compteEpargne("c3", 180000.00, new Date(), c3, 660000));
		compte cmp4 = compterepo.save(new compteEpargne("c4", 86000.00, new Date(), c4, 10000));
		compte cmp5 = compterepo.save(new compteCourant("c5", 70000.00, new Date(), c5, 23000));

		operation op1 = operationrepo.save(new versement(new Date(), 6000, cmp1));
		operation op4 = operationrepo.save(new versement(new Date(), 6000, cmp2));
		operation op2 = operationrepo.save(new versement(new Date(), 6000, cmp1));
		operation op3 = operationrepo.save(new retrait(new Date(), 6000, cmp2));
	}

}
