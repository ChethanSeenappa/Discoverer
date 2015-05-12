/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ChethanSeenappa
 */
@Controller
public class StudentController {

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value="/new", method =RequestMethod.GET)
    public String create(ModelMap model){
        model.addAttribute("student", new Student());
        return "new";
    }
    
    @RequestMapping(value="/show", method = RequestMethod.POST)
    public String show(@ModelAttribute Student student, ModelMap model){
        System.out.println("Name value"+student.getName());
        System.out.println("Age value"+student.getAge());
        model.addAttribute("name", student.getName());
        model.addAttribute("age", student.getAge());
        return "show";
    }
}
