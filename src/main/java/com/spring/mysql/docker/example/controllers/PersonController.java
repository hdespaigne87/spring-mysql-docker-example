package com.spring.mysql.docker.example.controllers;

import com.spring.mysql.docker.example.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }
}
