package org.geomvd.mvdgeo.controllers.auth;

import org.geomvd.mvdgeo.config.WebSecurityConfig;
import org.geomvd.mvdgeo.models.User;
import org.geomvd.mvdgeo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;
    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String registration(Model model){
        if (!WebSecurityConfig.isAuthenticated()) {
            model.addAttribute("user", new User());
            return "auth/registration";
        }
        else return "redirect:/";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @RequestBody User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        System.out.println(user);
        return "redirect:/registration?success";
//        User exUser = userService.findUserByLogin(user.getLogin());
//        if (exUser != null && exUser.getLogin() != null && !exUser.getLogin().isEmpty()){
//            bindingResult.rejectValue("login", String.valueOf(400), "Пользователь зарегистрирован");
//        }
//        if (bindingResult.hasErrors()){
//            model.addAttribute("user", user);
//            return "auth/registration?error";
//        }
//        userService.save(user);
//        System.out.println("Я отработал бро");
//        return "redirect:/auth/registration?success";
    }

}
