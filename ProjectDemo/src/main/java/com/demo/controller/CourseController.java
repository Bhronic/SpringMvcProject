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
public class CourseController {
	@Autowired
	UserDao dao;
	
	@RequestMapping(value="/ProjectDemo/viewallcourse")
	public String viewallCourse(Model m) {
		List<Course> c= dao.getallcourses();
		m.addAttribute("course", c);
		return "viewallcourse";
	}
	
	@RequestMapping("/ProjectDemo/addcourse")
	public String showform1(Model m) {
		m.addAttribute("command",new Course());
		List<Course> a= dao.getallcourses();
		m.addAttribute("course", a);
		return "add_courses";
	}
	
	@RequestMapping(value="/ProjectDemo/save_course", method=RequestMethod.POST)
	public String save_course(@ModelAttribute("course") Course c,Model m) {
		dao.savecourse(c);
		return "redirect:/ProjectDemo/addcourse";
	}
	
	
	@RequestMapping("/ProjectDemo/editcourse/{id}") 
    public String edit(@PathVariable int id, Model m){
        Course course=dao.getCourseById(id);    
        m.addAttribute("course",course);
        return "editcourseform";
    }
	
	@RequestMapping(value="/ProjectDemo/saveeditcourse",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("course") Course course){
        dao.updateCourse(course);
        return "redirect:/ProjectDemo/viewallusers";
	}
	
	
	@RequestMapping(value="/ProjectDemo/deletecourse/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){
        dao.deleteCourse(id);
        return "redirect:/ProjectDemo/addcourse";
    }
}
