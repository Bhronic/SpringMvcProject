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
public class SubTopicController {

	@Autowired
	UserDao dao;

	@RequestMapping("/ProjectDemo/addtopic/add_sub_topic/{id}")
	public String showform(@PathVariable int id,Model m,Model n) {
		Topics topic = dao.getTopicById(id);
		m.addAttribute("topic", topic);
		m.addAttribute("command",new SubTopic());
		List<SubTopic> subtopic= dao.getAllSubTopic(id);
		m.addAttribute("subtopic", subtopic);
		return "subtopicform";
	}
	
	@RequestMapping(value="/ProjectDemo/addtopic/add_sub_topic/save_sub_topic", method=RequestMethod.POST)
	public String saveSubTopic(@ModelAttribute("subtopic") SubTopic st,Model m) {
		dao.saveSubTopic(st);
		return "redirect:/ProjectDemo/addtopic/add_sub_topic/"+st.getTopic_id();
	}
	
	@RequestMapping("/ProjectDemo/addtopic/add_sub_topic/edit_sub_topic/{id}") 
    public String editSubTopic(@PathVariable int id, Model m){
        SubTopic st = dao.getSubTopicById(id);
        m.addAttribute("st",st);
        return "editsubtopicform";
    }
	
	@RequestMapping(value="/ProjectDemo/addtopic/add_sub_topic/edit_sub_topic/save_edit_sub_topic",method = RequestMethod.POST)    
    public String saveEditSubTopic(@ModelAttribute("subtopic") SubTopic st){
        dao.updateSubTopic(st);
        return "redirect:/ProjectDemo/addtopic/add_sub_topic/"+st.getTopic_id();
	}
	
	@RequestMapping(value="/ProjectDemo/addtopic/add_sub_topic/delete_sub_topic/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){
		SubTopic st = dao.getSubTopicById(id);
		int a=st.getTopic_id();
        dao.deleteSubTopic(id);
        return "redirect:/ProjectDemo/addtopic/add_sub_topic/"+a;
    }
}
