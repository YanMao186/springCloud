package com.ym.feign;

import com.ym.entity.Person;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient{
    @Override
    public Collection<Person> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器错误。。。。";
    }
}
