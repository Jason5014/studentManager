package com.jason.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jason.dao.impl.StudentDao;
import com.jason.entity.Student;

public class StudentServer {
	private StudentDao student = new StudentDao();
	public void getAllStudentInfo(){
		ResultSet rs = student.allStudentInfo();
		System.out.println("编号\t姓名\t性别\t评价\t");
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String description = rs.getString("description");
				System.out.println(id+"\t"+name+"\t"+sex+"\t"+description+"\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addStudent(){
		Scanner input = new Scanner(System.in);
		System.out.print("请输入学员姓名：");
		String name = input.next();
		System.out.print("请输入密码：");
		String pwd = input.next();
		System.out.print("请输入学员年龄：");
		int age = input.nextInt();
		System.out.print("请输入评价：");
		String description = input.next();
		System.out.print("请输入学员性别：");
		String sex = input.next();
		int result = student.addStudent(new Student(0,name,pwd,age,description,sex));
		if(result>0){
			System.out.println("增加成功！！");
		}else{
			System.out.println("增加失败！！");
		}
	}
	
	public void delStudent(){
		System.out.println("当前操作：根据ID删除学员");
		System.out.print("请输入您要删除学员的ID：");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		int result = student.delStudent(id);
		if(result>0){
			System.out.println("删除成功！！");
		}else{
			System.out.println("删除失败！！");
		}
	}
	
	public void updateStudent(){
		System.out.println("当前操作：根据ID更新学员姓名");
		System.out.print("请输入您要更改学员的ID：");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		System.out.print("请输入修改后的学员姓名：");
		String name = input.next();
		int result = student.updateStudent(id,name);
		if(result>0){
			System.out.println("修改成功！！");
		}else{
			System.out.println("修改失败！！");
		}
	}
}
