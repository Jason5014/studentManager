package com.jason.dao.impl;

import java.sql.ResultSet;

import com.jason.dao.BaseDao;
import com.jason.entity.Student;

public class StudentDao implements StudentDaoImpl{
	
	private BaseDao base = new BaseDao();

	@Override
	public ResultSet allStudentInfo() {
		String sql = "select * from student";
		return base.executeQuery(sql);
	}

	@Override
	public int addStudent(Student stu) {
		String sql = "INSERT Student(name,password,age,description,sex) values(?,?,?,?,?)";
		int result = base.executeUpdate(sql, stu.getName(),stu.getPassword(),stu.getAge(),stu.getDescription(),stu.getSex());
		return result;
	}

	@Override
	public int delStudent(int id) {
		String sql = "DELETE FROM Student WHERE id = ?";
		return base.executeUpdate(sql, id);
	}

	@Override
	public int updateStudent(int id, String name) {
		String sql = "UPDATE Student SET name = ? WHERE id = ?";
		return base.executeUpdate(sql, name,id);
	}
	
}
