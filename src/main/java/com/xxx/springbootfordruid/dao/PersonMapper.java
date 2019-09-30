package com.xxx.springbootfordruid.dao;

import java.util.List;

import com.xxx.springbootfordruid.model.Person;

public interface PersonMapper {
	int insertPerson(Person person);
	
	Person selectPersonByName(String name);
	
	List<Person> selectAllPerson();
	
	int updatePerson(Integer id);
}
