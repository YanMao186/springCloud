package com.ym.repository;

import com.ym.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonServiceImpl implements PersonService {
    private static Map<Long,Person> personMap;
    static {
        personMap  = new HashMap<>();
        personMap.put(1L,new Person(1L,"张三",20));
        personMap.put(2L,new Person(2L,"李四",21));
        personMap.put(3L,new Person(3L,"王五",22));
        personMap.put(4L,new Person(4L,"赵六",23));
    }

    @Override
    public Collection<Person> findAll() {
        return personMap.values();
    }

    @Override
    public Person findById(Long id) {
        return personMap.get(id);
    }

    @Override
    public void deleteById(Long id) {
        personMap.remove(id);
    }

    @Override
    public void save(Person person) {
        personMap.put(person.getId(),person);
    }
}
