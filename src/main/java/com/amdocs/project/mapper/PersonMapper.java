package com.amdocs.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.amdocs.project.dto.request.PersonDTO;
import com.amdocs.project.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);
}	
