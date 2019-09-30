package com.xxx.springbootfordruid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.springbootfordruid.dao.PersonMapper;
import com.xxx.springbootfordruid.model.Person;

@Service
public class PersonServiceImpl{
	
	@Autowired
	private PersonMapper personMapper; 
	
	@Transactional(rollbackFor = Exception.class)
	public void insertPerson(Person person) {
//		System.out.println("啦啦" + (PersonServiceImpl) AopContext.currentProxy());
//
//		((PersonServiceImpl) AopContext.currentProxy()).ins(person);
		this.personMapper.insertPerson(person);
		try {
			Thread.currentThread().sleep(20000);
			this.personMapper.insertPerson(person);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void ins(Person person){
		this.personMapper.insertPerson(person);
		//throw new RuntimeException("我手动制造的异常。");
	}

	public Person selectPersonByName(String name) {
		Person person = this.personMapper.selectPersonByName(name);
		return person;
	}
	
	@Transactional
	public List<Person> selectAllPerson() {
		List<Person> selectAllPerson = this.personMapper.selectAllPerson();
		try {
			Thread.currentThread().sleep(20000);
			selectAllPerson = this.personMapper.selectAllPerson();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectAllPerson;
	}
	
	public void updatePerson(Integer id) {
		this.personMapper.updatePerson(id);
	}

}
