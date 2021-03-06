package org.sid.web;

import java.lang.ProcessBuilder.Redirect;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import org.sid.buziness.bankBuziness;
import org.sid.dao.compteRepository;
import org.sid.entities.compte;
import org.sid.entities.operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlleur {
    @Autowired
    private bankBuziness bankImp;
    @Autowired
    private compteRepository compterepo;

    @RequestMapping("/comptes")
    public String index() {
        return "comptes";
    }

    @RequestMapping("/save")
    public String mycompte(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "size", defaultValue = "5") int s,
            @RequestParam(name = "codeCompte", defaultValue = "c1") String codeCompte) {
        try {
            compte cmp = bankImp.consultation(codeCompte);
            Page<operation> operations = bankImp.listoperation(codeCompte, p, s);
            model.addAttribute("operationlist", operations.getContent());

            int NbrPages[] = new int[operations.getTotalPages()];

            model.addAttribute("codeCompte", codeCompte);
            model.addAttribute("pages", NbrPages);
            model.addAttribute("compte", cmp);
            model.addAttribute("currentPage", p);
        } catch (Exception e) {
            model.addAttribute("exception", e);
        }
        return "comptes";

    }

    @RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
    public String saveOperation(Model model, String codeCompte, String typeOperation, double montant,
            String codeCompte2) {
        // model.addAttribute("typeOperation", typeOperation);
        try {
            if (typeOperation.equals("VERS"))
                bankImp.verser(codeCompte, montant);
            if (typeOperation.equals("RETR"))
                bankImp.retirer(codeCompte, montant);
            if (typeOperation.equals("VIRM"))
                bankImp.virement(codeCompte, codeCompte2, montant);
        } catch (Exception e) {
            model.addAttribute("error", e);
            return "redirect:/save?codeCompte=" + codeCompte + "&error=" + e.getMessage();
        }
        return "redirect:/save?codeCompte=" + codeCompte;
    }
}
