package com.example.firstProject.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoResource {
@GetMapping(path = "/getName/{name}")
    public String geName(@PathVariable(value="name") String name){
    System.out.println(name);
        return name;
    }

    @GetMapping(path = "/getSurname")
    public String geSurname(@RequestParam("name") String name){
        System.out.println(name);
        return name;
    }



}
