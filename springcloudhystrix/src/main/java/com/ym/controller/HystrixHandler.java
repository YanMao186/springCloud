package com.ym.controller;

import com.ym.entity.Person;
import com.ym.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Collection<Person> findAll() {
        return feignProviderClient.findAll();
    }
    @GetMapping("/index")
    public String index() {
        return feignProviderClient.index();
    }
}
