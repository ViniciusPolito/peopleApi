package com.amdocs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amdocs.project.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
