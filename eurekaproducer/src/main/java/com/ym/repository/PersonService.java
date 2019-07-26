package com.ym.repository;

import com.ym.entity.Person;

import java.util.Collection;
import java.util.List;

public interface PersonService {

    Collection<Person> findAll();
    Person findById(Long id);
    void deleteById(Long id);
    void save(Person person);
}
