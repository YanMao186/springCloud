package com.ym.controller;

import com.ym.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerHandler {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findAll")
    public Collection<Person> findAll() {
        return  restTemplate.getForEntity("http://localhost:9001/person/findAll",Collection.class).getBody();
    }
    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable("id")Long id) {
        return restTemplate.getForEntity("http://localhost:9001/person/findById/{id}",Person.class,id).getBody();
    }
    @PostMapping("/save")
    public void save(@RequestBody Person person){
        restTemplate.postForEntity("http://localhost:9001/person/save",person,null).getBody();
    }
    @DeleteMapping("del/{id}")
    public void del(@PathVariable("id")Long id) {
        restTemplate.delete("http://localhost:9001/person/del/{id}",id);
    }
}
