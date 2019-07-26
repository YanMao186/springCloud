package com.ym.controller;

import com.ym.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Person> findAll() {
        return restTemplate.getForObject("http://provider/person/findAll",Collection.class);
    }
    @GetMapping("/index")
    public String getIndex() {
        return restTemplate.getForObject("http://provider/person/index",String.class);
    }
}
