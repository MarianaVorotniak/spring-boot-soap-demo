package com.soap.demo.springbootdemoexample.service;

import com.github.marianavorotniak.spring_boot_soap_demo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {
        User mariana = new User();
        mariana.setName("Mariana");
        mariana.setEmpId(1);
        mariana.setSalary(300);

        User irina = new User();
        mariana.setName("Irina");
        mariana.setEmpId(2);
        mariana.setSalary(200);

        users.put(mariana.getName(), mariana);
        users.put(irina.getName(), irina);
    }

    public User getUsers(String name) {
        return  users.get(name);
    }
}
