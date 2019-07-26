package com.ym.collection;

import com.ym.entity.Person;
import com.ym.repository.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class PersonCollection {

    @Autowired
    private PersonService personService;
    @Value("${server.port}")
    private String port;
    @GetMapping("/findAll")
    public Collection<Person> findAll() {
      return   personService.findAll();
    }
    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable("id")Long id) {
        return personService.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }
    @PutMapping("/del/{id}")
    public void del(@PathVariable Long id) {
        personService.deleteById(id);
    }
    @GetMapping("/index")
    public String getPort() {
        return "当前端口为"+this.port;
    }
}
