package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
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

    @RequestMapping(value="/add")
    public String add(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddUser(@ModelAttribute @Valid User user, Errors errors, Model model) {

       if(errors.hasErrors()) {
           model.addAttribute("title", "Add User");
           model.addAttribute("user", user);
           return "user/add";
       }
       UserData.addUser(user);
       return "redirect:";
        }

    @RequestMapping(value = "")
    public static String index(Model model) {
        List<User> users = UserData.getUsers();
        model.addAttribute("users", users);
        return "user/index";
    }
    }



