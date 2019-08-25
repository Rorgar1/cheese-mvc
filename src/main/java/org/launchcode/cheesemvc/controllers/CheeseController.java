package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // static HashMap<String, String> cheeses = new HashMap<>();

    // request path: cheese/
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    //request path cheese/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {

        Cheese cheese = new Cheese(cheeseName, description);
        cheeses.add(cheese);
        //cheeses.put(cheeseName, description);

        //redirect to /cheese
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String processRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", this.cheeses);
        return "cheese/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int cheeseIndex) {
        this.cheeses.remove(cheeseIndex);

        return "redirect:";
    }
}



    /*public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheeses) {
        for (String cheese : cheeses) {
            for (Cheese cheeze : this.cheeses) {
                if (cheese.equals(cheeze.getName())) {
                    this.cheeses.remove(cheeze); */


