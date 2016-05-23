package com.demo.controller;

import java.util.List;

import com.demo.model.Student;
import com.demo.validator.StudentValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.ehcache.CacheName;

public class StudentController extends Controller {
	// private final Class<T> classT;
	 @Before(StudentValidator.class)
	public void index() {
		List<Student> list = Student.dao.find("select * from student ");
		setAttr("studentList", list).render("/WEB-INF/index.html");
	}

	public void add() {
		render("/WEB-INF/add.html");
	}

	public void delete() {
		// 获取表单域名为studentID的值
		// Student.dao.deleteById(getPara("studentID"));
		// 获取url请求中第一个值
		Student.dao.deleteById(getParaToInt());
		forwardAction("/nihao");
	}

	public void update() {
		Student student = getModel(Student.class);
		student.update();
		forwardAction("/nihao");
	}

	public void get() {
		Student student = Student.dao.findById(getParaToInt());
		setAttr("student", student).render("/WEB-INF/index2.html");
	}

	@Before(StudentValidator.class)
	public void save() {
		Student student = getModel(Student.class);
		// String name=getPara("student.name");
		// renderText(name);
		String name = getPara("name");
		String age = getPara("age");
		String sex = getPara("sex");
		student.set("name", name).set("age", age).set("sex", sex).save();
		forwardAction("/nihao");
	}

}