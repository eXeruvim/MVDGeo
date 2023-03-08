package org.geomvd.mvdgeo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String getHome(){

        return "index";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
}
