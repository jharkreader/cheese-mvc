package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<Cheese> cheeses = new ArrayList<>();


    // Request path is now /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription, Model
     model) {

        if (cheeseName.equals("") || !cheeseName.matches("[a-zA-Z ]+")) {

            model.addAttribute("error", "Must have a valid cheese");
            return "cheese/add";
        }
        Cheese cheese = new Cheese(cheeseName, cheeseDescription);
        cheeses.add(cheese);

        //Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheeseName) {

        int index = 0;
        for (Cheese cheese : cheeses) {
            if (cheeseName.equals(cheese.getCheeseName())) {
                index = cheeses.indexOf(cheese);
            }
        }
        cheeses.remove(index);

        // Redirect to /cheese
        return "redirect:";
    }
}
