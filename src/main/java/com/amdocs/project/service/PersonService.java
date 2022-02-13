package com.amdocs.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amdocs.project.dto.request.PersonDTO;
import com.amdocs.project.dto.response.MessageResponseDTO;
import com.amdocs.project.entity.Person;
import com.amdocs.project.mapper.PersonMapper;
import com.amdocs.project.repository.PersonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {	
	
	 	private final PersonRepository personRepository;

	    private final PersonMapper personMapper;
		
		@PostMapping
		public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
			
			Person personToSave = personMapper.toModel(personDTO);
			Person savedPerson = personRepository.save(personToSave);
			
			return MessageResponseDTO.builder().message("Create person with ID " + savedPerson.getId()).build();
		}

		public List<PersonDTO> listAll() {
	        List<Person> people = personRepository.findAll();
	        return people.stream()
	                .map(personMapper::toDTO)
	                .collect(Collectors.toList());
	    }
}
