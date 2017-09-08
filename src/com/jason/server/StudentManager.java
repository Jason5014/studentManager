package com.jason.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jason.dao.impl.StudentDao;
import com.jason.entity.Student;

public class StudentManager {

	public static void main(String[] args) {
		StudentServer ss = new StudentServer();
		System.out.println("-----***学生管理系统***-----");
		boolean flag = true;
		while(flag){
			switch(menu()){
			case 1:
				ss.getAllStudentInfo();
				break;
			case 2:
				ss.addStudent();
				break;
			case 3:
				ss.delStudent();
				break;
			case 4:
				ss.updateStudent();
				break;
			case 5:
				flag = false;
				System.out.println("退出系统!");
				break;
			default:
				break;
		}
		}
		
	}
	
	@SuppressWarnings("resource")
	public static int menu(){
		System.out.println("1.查询所有学生信息");
		System.out.println("2.添加学员");
		System.out.println("3.删除学员");
		System.out.println("4.修改学员信息");
		System.out.println("5.退出系统");
		System.out.print("请选择相应的操作：");
		Scanner input = new Scanner(System.in);
		int choise = input.nextInt();
		return choise;
	}
	
	
}
