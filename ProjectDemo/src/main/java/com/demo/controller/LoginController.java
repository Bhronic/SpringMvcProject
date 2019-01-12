package com.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.beans.*;
import com.demo.dao.UserDao;

@Controller
public class LoginController {
	@Autowired
	UserDao dao;
	
	@RequestMapping(value = "/ProjectDemo/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("User") User u, Model m) {
		
		String email = u.getEmail();
		String password = u.getPassword();
		List<User> user = dao.validate(email, password);
		m.addAttribute("user", user);
		int z=0;
		
		for (User x : user) {
			z=x.getRoles_id();
		}
		
		if(z==1) {
			return "adminview";
		}
		else if (z==2) {
			return "facultyview";
		}
		else if (z==3) {
			return "studentview";
		}
		else if (z==4) {
			return "userview";
		}
		else {
			return "error";
		}
	}
	
}
