package com.example.ItemLists.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainViewController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String itemLists(Model model) {
        model.addAttribute("appName", "Itemlists");
        return "itemLists";
    }


}