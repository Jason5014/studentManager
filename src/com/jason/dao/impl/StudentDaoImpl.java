package com.jason.dao.impl;

import java.sql.ResultSet;

import com.jason.entity.Student;

public interface StudentDaoImpl {
	public ResultSet allStudentInfo();
	public int addStudent(Student stu);
	public int delStudent(int id);
	public int updateStudent(int id,String name);
}
