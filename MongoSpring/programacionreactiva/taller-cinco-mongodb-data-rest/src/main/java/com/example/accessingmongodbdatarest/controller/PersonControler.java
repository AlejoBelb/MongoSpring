package com.example.accessingmongodbdatarest.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingmongodbdatarest.document.Person;
import com.example.accessingmongodbdatarest.service.PersonService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/api/person")
public class PersonControler {

	@Autowired
	PersonService service;
	
	@PostMapping
	public ResponseEntity<Person> crear(@RequestBody Person person){
		
		if(person.getCreateAt()==null) {
			person.setCreateAt(new Date());
		}
		Person personBd = service.save(person);
		
		
		return ResponseEntity.ok(personBd);
		
	}
	
	@PutMapping("/FirstName")
	public ResponseEntity<Person> updateFirstName(@RequestBody Person person) {
	    return ResponseEntity.ok(service.updateFirstName(person));
	}

	@PutMapping("/LastName")
	public ResponseEntity<Person> updateLastName(@RequestBody Person person) {
	    return ResponseEntity.ok(service.updateLastName(person));
	}

	@PutMapping("/Age")
	public ResponseEntity<Person> updateAge(@RequestBody Person person) {
	    return ResponseEntity.ok(service.updateAge(person));
	}

	@PutMapping
	public ResponseEntity<Person> updateCellNumber(@RequestBody Person person){
		return ResponseEntity.ok(service.updateCellNumber(person));	
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> person = service.findAll();
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	
	//Buscar por múltiples filtros 
	@GetMapping("/search")
	public ResponseEntity<List<Person>> searchByMultipleFields(
	        @RequestParam(required = false) String firstName,
	        @RequestParam(required = false) String lastName) {
	    return ResponseEntity.ok(service.findByMultipleFields(firstName, lastName));
	}
	
	//Cuántas personas tienen más de cierta edad
	@GetMapping("/countByAge/{age}")
	public ResponseEntity<Long> countByAge(@PathVariable String age) {
	    return ResponseEntity.ok(service.countByAgeGreaterThan(age));
	}

	//Actualizar varios campos a la vez
	@PatchMapping("/{id}")
	public ResponseEntity<Person> partialUpdate(@PathVariable String id, @RequestBody Map<String, Object> updates) {
	    return ResponseEntity.ok(service.partialUpdate(id, updates));
	}
	
	//Paginar y ordenar
	@GetMapping("/paginated")
	public ResponseEntity<Page<Person>> findAllPaginated(
	        @RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
	    return ResponseEntity.ok(service.findAllPaginated(page, size, sortBy));
	}


	
	@GetMapping("/AllUpperCase")
	public ResponseEntity<List<Person>> findAllConNombreUpperCase(){
		List<Person> person = service.findAllConNombreUpperCase();
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	@GetMapping("/AllUpperCaseRepeat")
	public ResponseEntity<List<Person>> findAllConNombreUpperCaseRepeat(){
		List<Person> person = service.findAllConNombreUpperCase();
		return new ResponseEntity<>(person,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person>findById(@RequestParam String param) {
		Person person = service.findById(param);
		if (person != null) {
			return new ResponseEntity<>(person,HttpStatus.ACCEPTED);			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<Person> delete(@RequestBody Person person){
		boolean per = service.delete(person);
		if (per == true){
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/Address")
	public ResponseEntity<Person> updateAddress(@RequestBody Person person){
		return ResponseEntity.ok(service.updateAddress(person));	
	}
	
	@PutMapping("/Email")
	public ResponseEntity<Person> updateEmailAddress(@RequestBody Person person){
		return ResponseEntity.ok(service.updateEmailAddress(person));	
	}
	
}
