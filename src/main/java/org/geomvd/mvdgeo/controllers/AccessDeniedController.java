package org.geomvd.mvdgeo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/access_denied")
    public String getAccessDenied(){
        return "access_denied";
    }
}
