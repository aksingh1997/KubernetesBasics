package com.abhi.Kubernetes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeSet;

@RestController
public class Controller {

    

    @Autowired
    Service service;

    @GetMapping("/get-all-books")
    public String getAllBooks() {
        return service.getAllBooks();
    }

}
