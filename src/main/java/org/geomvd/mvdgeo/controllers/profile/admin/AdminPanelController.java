package org.geomvd.mvdgeo.controllers.profile.admin;

import org.geomvd.mvdgeo.models.User;
import org.geomvd.mvdgeo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public String getAdmin(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "/profile/admin/admin";
    }

//    @GetMapping()
//    public String getUsers(Model model){
//        model.addAttribute("users", userService.findAllUsers());
//        return "/profile/admin/admin";
//    }
//
//    @GetMapping("{user}")
//    public String editUser(@PathVariable User user, Model model){
//        model.addAttribute("user", user);
//        return "/profile/admin/editUser";
//    }
}
