package com.amdocs.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amdocs.project.dto.MessageResponseDTO;
import com.amdocs.project.entity.Person;
import com.amdocs.project.repository.PersonRepository;

@Service
public class PersonService {	
	
		//@Autowired
		PersonRepository personRepository;
		
		@Autowired
		public PersonService(PersonRepository personRepository) {
			this.personRepository = personRepository;
		}
		
		@PostMapping
		public MessageResponseDTO createPerson(@RequestBody Person person) {
			Person savedPerson = personRepository.save(person);
			return MessageResponseDTO.builder().message("Create person with ID " + savedPerson.getId()).build();
		}
}
