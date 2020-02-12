package com.spring.mysql.docker.example.services;

import com.spring.mysql.docker.example.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAll();
}
