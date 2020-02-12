package com.spring.mysql.docker.example.repositories;

import com.spring.mysql.docker.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
