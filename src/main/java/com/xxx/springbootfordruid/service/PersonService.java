package com.xxx.springbootfordruid.service;

import com.xxx.springbootfordruid.model.Person;

public interface PersonService {
	void insertPerson(Person person);
	
	Person selectPersonByName(String name);
}
