package org.sid.web;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import org.sid.buziness.bankBuziness;
import org.sid.dao.compteRepository;
import org.sid.entities.compte;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String mycompte(Model model, @RequestParam(name = "codeCompte", defaultValue = "c1") String codeCompte) {
        try {
            compte cmp = bankImp.consultation(codeCompte);
            model.addAttribute("compte", cmp);
        } catch (Exception e) {
            model.addAttribute("exception", e);
        }
        return "comptes";

    }
}
