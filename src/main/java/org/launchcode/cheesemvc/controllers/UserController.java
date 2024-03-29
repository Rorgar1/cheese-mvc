package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute("user", new User());
        return "user/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify_password) {
        model.addAttribute("user", user);

        if (errors.hasErrors()) {
            return "user/add";
        }

        if (user.getPassword().equals(verify_password)) {
            return "user/index";
        }

        user.setPassword("");
        model.addAttribute("error_message", "Passwords don't match. Please try again.");
        return "user/add";

    }
    }



