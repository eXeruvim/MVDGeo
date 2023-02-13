package org.geomvd.mvdgeo.controllers.auth;

import org.geomvd.mvdgeo.config.WebSecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(){
        if (!WebSecurityConfig.isAuthenticated())
            return "auth/login";
        else return "redirect:/";
    }
}
