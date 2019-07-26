package com.ym.feign;

import com.ym.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)
//value用于指定已经在注册中心注册的服务
public interface FeignProviderClient {
    @GetMapping("/person/findAll")
    public Collection<Person> findAll();

    @GetMapping("/person/index")
    public String index();
}
