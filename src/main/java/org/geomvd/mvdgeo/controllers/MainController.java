package org.geomvd.mvdgeo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {

    @RequestMapping("/")
    public String getHome(){
        return "index";
    }
}
