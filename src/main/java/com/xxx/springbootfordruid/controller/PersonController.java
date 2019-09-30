package com.xxx.springbootfordruid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.springbootfordruid.model.Person;
import com.xxx.springbootfordruid.service.impl.PersonServiceImpl;

@RestController
public class PersonController {
	@Autowired
	private PersonServiceImpl personService;
	
	@GetMapping("/test")
	public String test(Person person) {
		this.personService.insertPerson(person);
		return "person";
	}
	
	@GetMapping("/get")
	public Person get(String name) {
		return this.personService.selectPersonByName(name);
	}
	
	@GetMapping("/test2")
	public List<Person> get() {
		List<Person> persons = this.personService.selectAllPerson();
		return persons;
	}
	
	@GetMapping("/update")
	public void update(Integer id) {
		this.personService.updatePerson(id);
	}
}
