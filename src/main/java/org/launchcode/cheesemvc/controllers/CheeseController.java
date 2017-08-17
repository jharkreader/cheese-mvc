package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("cheese")
public class CheeseController {


    // Request path is now /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");

        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {

        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {

        CheeseData.add(newCheese);

        //Sample code demos model binding, keeping old code because it had input validation
        /*
        if (cheeseName.equals("") || !cheeseName.matches("[a-zA-Z ]+")) {

            model.addAttribute("error", "Must have a valid cheese");
            return "cheese/add";
        }
        Cheese cheese = new Cheese(cheeseName, cheeseDescription);
        CheeseData.add(cheese);
                              */
        //Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        return "redirect:";
    }


    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        Cheese editingCheese = CheeseData.getById(cheeseId);
        model.addAttribute("cheese", editingCheese);


        return "cheese/edit";

    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String cheeseName, String cheeseDescription) {

        Cheese editedCheese = CheeseData.getById(cheeseId);
        editedCheese.setCheeseName(cheeseName);
        editedCheese.setCheeseDescription(cheeseDescription);

        return "redirect:";
    }

}
