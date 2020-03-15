package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * LandingPageController
 */

 @RestController
public class LandingPageController {

@GetMapping("/")
public ModelAndView showInit(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name){

    ModelAndView mav = new ModelAndView("hello");  //Retrieves hello.html from templates
    model.addAttribute("username", "Sri");
    return mav ;
}

    
}