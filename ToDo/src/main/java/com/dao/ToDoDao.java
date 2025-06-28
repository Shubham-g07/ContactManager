package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.ToDo;

@Component
public class ToDoDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int Save(ToDo t) {
		Integer res = (Integer) this.hibernateTemplate.save(t);
		return res;
	}
	
	
	public List<ToDo> getAll(){
		List<ToDo> todos = this.hibernateTemplate.loadAll(ToDo.class);
		return todos;
	}
}
