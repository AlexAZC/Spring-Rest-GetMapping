package com.curso.springboot.webapp.springboot_web.controllers;



import com.curso.springboot.webapp.springboot_web.models.User;
import com.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RestUserController {

    @GetMapping("/details")
    public UserDto details(){

        User user = new User("Alexander","Zea");

        UserDto userDto = new UserDto();
        userDto.setTitle("Hola mundo Spring Boot");
        userDto.setUser(user);


//        Map<String,Object> body = new HashMap<>();
//        body.put("title","Hola Mundo Spring Boot");
//        body.put("user", user);

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Andres","Nuñes");
        User user2 = new User("Jose","Zegarra");
        User user3 = new User("Juan","Ramos");
        User user4 = new User("Paul","Arevalo");

        List<User> users = Arrays.asList(user,user2,user3,user4);
//        users.add(user);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);

        return users;
    }

}
