package com.demo.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Student extends Model<Student> {
	public static final Student dao = new Student();

	/*
	 * public Classes getClasses() { return
	 * Classes.dao.findById(get("classesid")); }
	 */

}