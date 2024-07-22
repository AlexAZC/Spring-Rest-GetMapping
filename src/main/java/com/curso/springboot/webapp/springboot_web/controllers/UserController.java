package com.curso.springboot.webapp.springboot_web.controllers;


import com.curso.springboot.webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Alexander","Zea");
        user.setEmail("alex.e@gmail.com");
        model.addAttribute("title","Hola Mundo Spring Boot");
        model.addAttribute("user",user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap){

        //modelMap.addAttribute("users",users);
        modelMap.addAttribute("title","Listado de usuarios!");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){

        User user = new User("Andres","Nuñes");
        User user2 = new User("Jose","Zegarra","alonsoz@gmail.com");
        User user3 = new User("Juan","Ramos");
        User user4 = new User("Paul","Arevalo","paula@gmail.com");

        List<User> users = Arrays.asList(user,user2,user3,user4);

        return users;

    }

}
