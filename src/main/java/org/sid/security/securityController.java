package org.sid.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class securityController {

    @RequestMapping(value = "/login")
    private String login() {
        return "login";

    }

    @RequestMapping(value = "/")
    private String Home() {
        return "redirect:/comptes";
    }

}
