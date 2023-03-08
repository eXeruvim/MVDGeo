package org.geomvd.mvdgeo.controllers.profile;

import org.geomvd.mvdgeo.models.User;
import org.geomvd.mvdgeo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping()
    public String getProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("role", "Роль: " +  String.valueOf(auth.getAuthorities()).replaceAll("\\[", "").replaceAll("]", ""));
        model.addAttribute("user", user);
        return "profile/profile";
    }

}
