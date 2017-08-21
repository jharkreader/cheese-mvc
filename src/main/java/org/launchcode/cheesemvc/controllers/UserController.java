package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        return "/user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {

        if (verify.equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "/user/index";
        }
        else {
            String errorMessage = "Please check that your passwords match.";
            model.addAttribute("error", errorMessage);
            return "/user/add";
        }


    }

}
