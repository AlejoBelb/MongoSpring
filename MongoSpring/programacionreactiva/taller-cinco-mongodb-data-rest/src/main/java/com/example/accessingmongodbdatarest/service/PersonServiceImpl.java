package com.example.accessingmongodbdatarest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingmongodbdatarest.dao.PersonRepository;
import com.example.accessingmongodbdatarest.document.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository dao;	
	
	@Override
	public Person updateCellNumber(Person person) {
		Optional<Person> objPerson = dao.findById(person.getId());
		Person personBd = new Person();
		
		if(objPerson.isPresent()) {
			
			personBd = objPerson.get();
			personBd.setCellNumber(person.getCellNumber());
			dao.delete(personBd);
			dao.save(personBd);
			
		}
		return personBd ;
	}
	
	@Override
	public Person save(Person person) {
			return dao.save(person);
	}

	@Override
	public List<Person> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Person> findAllConNombreUpperCase() {
		// TODO Auto-generated method stub
		List<Person> persons = dao.findAll();
		List<Person> allPersonName = persons.stream()
				.map(person -> {person.setFirstName(
						person.getFirstName()
						.toUpperCase());
				return person;})
				.collect(Collectors.toList());
		
		return allPersonName;
	}

	@Override
	public List<Person> findAllConNombreUpperCaseRepeat() {
	    List<Person> persons = dao.findAll();
	    List<Person> transformedPersons = persons.stream()
	        .map(person -> {
	            String upperCaseRepeatName = person.getFirstName()
	                .toUpperCase()
	                .chars()
	                .mapToObj(c -> String.valueOf((char) c).repeat(2))
	                .collect(Collectors.joining());
	            person.setFirstName(upperCaseRepeatName);
	            return person;
	        })
	        .collect(Collectors.toList());
	    return transformedPersons;
	}


	@Override
	public Person findById(String id) {
		Optional<Person> person = dao.findById(id);
		if(person.isPresent()){
			Person per = person.get();
			return per;
		}else {
			throw new RuntimeException("La persona no encontrada con el id: " + id);
		}
	};

	

	@Override
	public boolean delete(Person person) {
		try {
			dao.delete(person);
			return true;
		} catch (Exception e) {
				return false;
		}		
	}

	
	
	@Override
	public Person updateAddress(Person person) {
		Optional<Person> objPerson = dao.findById(person.getId());
		Person personBd = new Person();
		if(objPerson.isPresent()) {
			
			personBd = objPerson.get();
			personBd.setAddress(person.getAddress());
			dao.delete(personBd);
			dao.save(personBd);
			
		}
		return personBd ;
	}

	@Override
	public Person updateEmailAddress(Person person) {
		Optional<Person> objPerson = dao.findById(person.getId());
		Person personBd = new Person();
		if(objPerson.isPresent()) {
			
			personBd = objPerson.get();
			personBd.setEmailAddress(person.getEmailAddress());
			dao.delete(personBd);
			dao.save(personBd);
			
		}
		return personBd ;
	}

	
}
