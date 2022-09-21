package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", new ArrayList<String>());
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(@RequestParam String searchTerm, String searchType, Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        return "search";
    }

}
