package com.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.support.ObjectNameManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.beans.*;
import com.demo.dao.*;

@Controller
public class AdminController {
	@Autowired
	UserDao dao;
	
	@RequestMapping(value="/ProjectDemo/getDetails",method=RequestMethod.GET)
	public @ResponseBody
	Map<String,Object> getDetails(HttpServletRequest request){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<User> list=dao.getallusers();
		modelMap.put("data", list);
		//JSONObject obj=new JSONObject();
		//obj.put("data", list.get(1));
		//System.out.println(obj);
		return modelMap;
	}
	
	
	
	@RequestMapping(value="/ProjectDemo/facultyandstudents/submitattendence", method=RequestMethod.POST)
	public String submitAttendence(@ModelAttribute("attendence")Attendence a ,Model m) {
		int[] b=a.getStudent();
		for (int i : b) {
			a.setStudent_id(i);
			dao.saveAttendence(a);
		}
		List<Attendence> x = dao.getAllAttendence();
 		m.addAttribute("attendence", x);
		return "viewattendence";
	}
	
	@RequestMapping("/ProjectDemo/facultyandstudents/{id}")    
    public String viewFacultyAndStudents(@PathVariable int id,Model m,Model n){
		User b = dao.getUserById(id);
		m.addAttribute("faculty",b);
		List<AssignFaculty> af = dao.getStudents(id);
		ArrayList<Integer> alist=new ArrayList<Integer>();
		for (AssignFaculty x : af) {
			alist.add(x.getStudent_id());
		}
		List<User> u = new ArrayList<User>();
		for (Integer y : alist) {
			u.add(dao.getUserById(y));
		}
		n.addAttribute("students", u);
        return "Facultyandstudent";
    }
	
	
	@RequestMapping(value="/ProjectDemo/assignfaculty/saveassignfaculty", method=RequestMethod.POST)
	public String savesetfaculty(@ModelAttribute("assign") AssignFaculty a,Model m) {
		dao.saveassignfaculty(a);
		return "success1";
	}
	
	@RequestMapping(value="/ProjectDemo/viewassignfaculty")
	public String viewassignfaculty(Model m) {
		List<AssignFaculty> af = dao.getAssignDetails();
		m.addAttribute("faculty", af);
		return "viewrelation";
	}
	
	
	@RequestMapping(value="/ProjectDemo/viewallstudents")
	public String viewallStudents(Model m) {
		List<User> user=dao.getallstudents();
		m.addAttribute("user", user);
		return "viewallstudents";
		
	}
	
	@RequestMapping("/ProjectDemo/assignfaculty/{id}")
	public String assignform(@PathVariable int id,Model m,Model n,Model q) {
		m.addAttribute("command", new AssignFaculty());
		User user=dao.getUserById(id);
		m.addAttribute("user",user);
		List<User> faculty=dao.getallfaculty();
		n.addAttribute("faculty",faculty);
		List<Course> course=dao.getallcourses();
		q.addAttribute("course",course);
		return "assignfacultyform";
	}
	
	@RequestMapping(value="/ProjectDemo/viewallfaculty")
	public String viewallFaculty(Model m) {
		List<User> user=dao.getallfaculty();
		m.addAttribute("user", user);
		return "viewallfaculty";
		
	}
	
	@RequestMapping("/ProjectDemo/viewallusers")
	public String viewalluser(Model m) {
		List<User> user=dao.getallusers();
		m.addAttribute("user", user);
		return "viewallusers";	
	}
	
	@RequestMapping("/ProjectDemo/regform")
	public String showform(Model m) {
		m.addAttribute("command", new User());
		return "regform";
	}
	
	@RequestMapping(value="/ProjectDemo/saveuser", method=RequestMethod.POST)
	public String saveuser(@ModelAttribute("User")User user,Model m) {
		dao.save(user);
		return "savesuccessfull";
		
	}
	
	@RequestMapping("/ProjectDemo/edituser/{id}")    
    public String edit(@PathVariable int id, Model m){
        User user=dao.getUserById(id);    
        m.addAttribute("u",user);
        return "edituserform";
    }
	
	@RequestMapping(value="/ProjectDemo/edituser/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("user") User user){
        dao.updateUser(user);
        return "redirect:/ProjectDemo/viewallusers";
	}
	
	@RequestMapping(value="/ProjectDemo/deleteuser/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){
        dao.deleteUser(id);
        return "redirect:/ProjectDemo/viewallusers";
    }
}
