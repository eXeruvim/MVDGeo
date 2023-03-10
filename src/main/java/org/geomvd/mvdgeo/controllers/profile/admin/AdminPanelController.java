package org.geomvd.mvdgeo.controllers.profile.admin;

import org.geomvd.mvdgeo.models.User;
import org.geomvd.mvdgeo.repositories.RoleRepository;
import org.geomvd.mvdgeo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/profile/admin/users";
    }

    @GetMapping()
    public String getAdminPage(){
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
