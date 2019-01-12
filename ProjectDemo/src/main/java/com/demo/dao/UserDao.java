package com.demo.dao;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;
import com.demo.beans.*;

public class UserDao {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {
	    this.template = template;
	}  
	
	public int saveAttendence(Attendence a) {
		String sql="insert into student_attendence values('"+a.getAtd_id()+"','"+a.getStudent_id()+"',CURDATE())";
		return template.update(sql);	
	}
	
	public int saveassignfaculty(AssignFaculty a) {
		String sql="insert into relation_table values('"+a.getSr_no()+"','"+a.getStudent_id()+"','"+a.getFaculty_id()+"','"+a.getCourse_id()+"')";
		return template.update(sql);
	}

	public int savecourse(Course c) {
		String sql="insert into course values('"+c.getCourse_id()+"','"+c.getCourse_name()+"')";
		return template.update(sql);
	}
	
	public int saveTopic(Topics t) {
		String sql="insert into topics values('"+t.getTopic_id()+"','"+t.getTopic_name()+"','"+t.getCourse_id()+"')";
		return template.update(sql);
	}
	
	public int saveSubTopic(SubTopic st) {
		String sql="insert into sub_topics values('"+st.getSub_topic_id()+"','"+st.getSub_topic_name()+"','"+st.getTopic_id()+"')";
		return template.update(sql);
	}
	
	public int save(User u) {
		String sql="insert into users values('"+u.getUser_id()+"','"+u.getName()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getDob()+"','"+u.getGender()+"','"+u.getContact_no()+"','"+u.getRoles_id()+"')";
		return template.update(sql);
	}
		
	public User getUserById(int id) {
		String sql="select * from users where user_id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class));
	}
	
	public Course getCourseById(int id) {
		String sql="select * from course where course_id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Course>(Course.class));
	}
	
	public Topics getTopicById(int id) {
		String sql="select * from topics where topic_id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Topics>(Topics.class));
	}
	
	public SubTopic getSubTopicById(int id) {
		String sql="select * from sub_topics where sub_topic_id=?";
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SubTopic>(SubTopic.class));
	}
	
	public int updateUser(User u){    
	    String sql="update users set name='"+u.getName()+"', email='"+u.getEmail()+"',password='"+u.getPassword()+"',dob='"+u.getDob()+"',gender='"+u.getGender()+"',contact_no='"+u.getContact_no()+"',roles_id='"+u.getRoles_id()+"' where user_id='"+u.getUser_id()+"'";    
	    return template.update(sql);    
	}    
	
	public int updateCourse(Course c){
	    String sql="update course set course_name='"+c.getCourse_name()+"' where user_id='"+c.getCourse_id()+"'";    
	    return template.update(sql);    
	}
	public int updateTopic(Topics t){
	    String sql="update topics set topic_name='"+t.getTopic_name()+"' where topic_id='"+t.getTopic_id()+"'";    
	    return template.update(sql); 
	}
	
	public int updateSubTopic(SubTopic st){
	    String sql="update sub_topics set sub_topic_name='"+st.getSub_topic_name()+"' where sub_topic_id='"+st.getSub_topic_id()+"'";    
	    return template.update(sql); 
	}
	public int deleteUser(int id){  
	    String sql="delete from users where user_id='"+id+"'";
	    return template.update(sql);
	}
	
	public int deleteCourse(int id){    
	    String sql="delete from course where course_id='"+id+"'";
	    return template.update(sql);
	}
	
	public int deleteTopic(int id){    
	    String sql="delete from topics where topic_id='"+id+"'";
	    return template.update(sql);
	}
	
	public int deleteSubTopic(int id){    
	    String sql="delete from sub_topics where sub_topic_id='"+id+"'";
	    return template.update(sql);
	}
	
	public List<User> getallusers(){
	 	String sql="select * from users";
		return template.query(sql,new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User u = new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setDob(rs.getString(5));
				u.setGender(rs.getString(6));
				u.setContact_no(rs.getString(7));
				u.setRoles_id(rs.getInt(8));
				return u;
			}
		});
	}
	
	public List<User> validate(String email,String password) {
		String sql="select * from users where email='"+email+"' and password='"+password+"' ";
		return template.query(sql,new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
	            User user = new User();
	            user.setUser_id(rs.getInt(1));
	            user.setName(rs.getString(2));
	            user.setEmail(rs.getString(3));
	            user.setPassword(rs.getString(4));
	            user.setDob(rs.getString(5));
	            user.setGender(rs.getString(6));
	            user.setContact_no(rs.getString(7));
	            user.setRoles_id(rs.getInt(8));
	            return user;
	        }
		});
	}
	
	public List<User> getallstudents(){
	 	String sql="select * from users where roles_id = '3'";
		return template.query(sql,new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User u = new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setDob(rs.getString(5));
				u.setGender(rs.getString(6));
				u.setContact_no(rs.getString(7));
				u.setRoles_id(rs.getInt(8));
				return u;
			}
		});
	}
	
	public List<User> getallfaculty(){
	 	String sql="select * from users where roles_id = '2'";
		return template.query(sql,new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User u = new User();
				u.setUser_id(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setDob(rs.getString(5));
				u.setGender(rs.getString(6));
				u.setContact_no(rs.getString(7));
				u.setRoles_id(rs.getInt(8));
				return u;
			}
		});
	}
	
	
	public List<Course> getallcourses(){
	 	String sql="select * from course";
		return template.query(sql,new RowMapper<Course>() {
			public Course mapRow(ResultSet rs, int row) throws SQLException {
				Course c = new Course();
				c.setCourse_id(rs.getInt(1));
				c.setCourse_name(rs.getString(2));				
				return c;
			}
		});
	}
	
	
	
	public List<Topics> getAllTopics(int i){
	 	String sql="select * from topics where course_id='"+i+"'";
		return template.query(sql,new RowMapper<Topics>() {
			public Topics mapRow(ResultSet rs, int row) throws SQLException {
				Topics t = new Topics();
				t.setTopic_id(rs.getInt(1));
				t.setTopic_name(rs.getString(2));
				t.setCourse_id(rs.getInt(3));				
				return t;
			}
		});
	}
	
	public List<SubTopic> getAllSubTopic(int i){
	 	String sql="select * from sub_topics where topic_id='"+i+"'";
		return template.query(sql,new RowMapper<SubTopic>() {
			public SubTopic mapRow(ResultSet rs, int row) throws SQLException {
				SubTopic s = new SubTopic();
				s.setSub_topic_id(rs.getInt(1));
				s.setSub_topic_name(rs.getString(2));
				s.setTopic_id(rs.getInt(3));				
				return s;
			}
		});
	}
	
	public List<AssignFaculty> getAssignDetails(){
	 	String sql="select * from relation_table";
		return template.query(sql,new RowMapper<AssignFaculty>() {
			public AssignFaculty mapRow(ResultSet rs, int row) throws SQLException {
				AssignFaculty af = new AssignFaculty();
				af.setSr_no(rs.getInt(1));
				af.setStudent_id(rs.getInt(2));
				af.setFaculty_id(rs.getInt(3));
				af.setCourse_id(rs.getInt(4));		
				return af;
			}
		});
	}
	
	public List<AssignFaculty> getStudents(int i){
	 	String sql="select * from relation_table where faculty_id='"+i+"'";
		return template.query(sql,new RowMapper<AssignFaculty>() {
			public AssignFaculty mapRow(ResultSet rs, int row) throws SQLException {
				AssignFaculty af = new AssignFaculty();
				af.setSr_no(rs.getInt(1));
				af.setStudent_id(rs.getInt(2));
				af.setFaculty_id(rs.getInt(3));
				af.setCourse_id(rs.getInt(4));		
				return af;
			}
		});
	}
	
	public List<Attendence> getAllAttendence(){
	 	String sql="select * from student_attendence";
		return template.query(sql,new RowMapper<Attendence>() {
			public Attendence mapRow(ResultSet rs, int row) throws SQLException {
				Attendence a = new Attendence();
				a.setAtd_id(rs.getInt(1));
				a.setStudent_id(rs.getInt(2));
				a.setDate(rs.getDate(3));
				return a;
			}
		});
	}
}
