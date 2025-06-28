package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ToDoDao;
import com.entities.ToDo;

@Controller
public class Homectrl {
	
	@Autowired
	ServletContext context;
	
	@Autowired
	ToDoDao todoDao;
	
	
	@RequestMapping("/home")
	public String Home(Model m) {
		String  str = "home";
		List<ToDo> list = this.todoDao.getAll();
		m.addAttribute("list",list);
		m.addAttribute("page",str);
		return "home";
	}
	
	
	@RequestMapping("/add")
	public String addToDo(Model m) {		
		ToDo todo = new ToDo();
		m.addAttribute("page", "add");
		m.addAttribute("todo", todo);
		return "home";
	}
	
	@RequestMapping(value = "/saveToDo", method=RequestMethod.POST)
	public String saveToDo(@ModelAttribute("todo") ToDo t, Model m) {
		System.out.println(t);
		t.setDate(new Date());
		
		this.todoDao.Save(t);
		
		m.addAttribute("msg","Successfully Added");
		return "home";
	}
	
	
}
