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
public class TopicController {
	
	@Autowired
	UserDao dao;
	
	@RequestMapping("/ProjectDemo/addtopic/{id}")
	public String showform(@PathVariable int id,Model m,Model n) {
		Course course = dao.getCourseById(id);
		m.addAttribute("course", course);
		m.addAttribute("command",new Topics());
		List<Topics> topics= dao.getAllTopics(id);
		m.addAttribute("topics", topics);
		return "topicform";
	}
	
	@RequestMapping(value="/ProjectDemo/addtopic/save_topic", method=RequestMethod.POST)
	public String saveTopic(@ModelAttribute("topic") Topics t,Model m) {
		dao.saveTopic(t);
		return "redirect:/ProjectDemo/addtopic/"+t.getCourse_id();
	}
	
	@RequestMapping("/ProjectDemo/addtopic/edit_topic/{id}") 
    public String editTopic(@PathVariable int id, Model m){
        Topics topic=dao.getTopicById(id);
        m.addAttribute("topic",topic);
        return "edittopicform";
    }
	
	@RequestMapping(value="/ProjectDemo/addtopic/edit_topic/save_edit_topic",method = RequestMethod.POST)    
    public String saveEditTopic(@ModelAttribute("topic") Topics t){
        dao.updateTopic(t);
        return "redirect:/ProjectDemo/addtopic/"+t.getCourse_id();
	}
	
	@RequestMapping(value="/ProjectDemo/addtopic/delete_topic/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){
		Topics t=dao.getTopicById(id);
		int a=t.getCourse_id();
        dao.deleteTopic(id);
        return "redirect:/ProjectDemo/addtopic/"+a;
    }
	
}
