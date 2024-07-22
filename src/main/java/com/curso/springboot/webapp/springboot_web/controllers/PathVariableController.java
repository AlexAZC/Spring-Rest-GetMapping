package com.curso.springboot.webapp.springboot_web.controllers;


import com.curso.springboot.webapp.springboot_web.models.User;
import com.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    @Value("${config.number}")
    private Integer number;
    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Autowired
    private Environment environment;



    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable(required = false) String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }


    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<>();
        json.put("product",product);
        json.put("id",id);

        return json;

    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        user.setName(user.getName().toUpperCase());
        return user;
    }


    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}") String message){
        Map<String,Object> json = new HashMap<>();

        json.put("username",username);
        json.put("number",number);
        json.put("message", message);
        json.put("valuesMap", valuesMap);
        json.put("username2",environment.getProperty("config.username"));
        json.put("number2",environment.getProperty("config.number", Integer.class));

        return json;
    }



}
