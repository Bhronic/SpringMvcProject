package com.demo.beans;

import java.sql.Date;;


public class Attendence {
	private int atd_id,student_id;
	private Date date;
	private int student[];
	
	

	public int[] getStudent() {
		return student;
	}
	public void setStudent(int[] student) {
		this.student = student;
	}
	public int getAtd_id() {
		return atd_id;
	}
	public void setAtd_id(int atd_id) {
		this.atd_id = atd_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
