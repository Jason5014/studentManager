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
		System.out.println("���\t����\t�Ա�\t����\t");
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
		System.out.print("������ѧԱ������");
		String name = input.next();
		System.out.print("���������룺");
		String pwd = input.next();
		System.out.print("������ѧԱ���䣺");
		int age = input.nextInt();
		System.out.print("���������ۣ�");
		String description = input.next();
		System.out.print("������ѧԱ�Ա�");
		String sex = input.next();
		int result = student.addStudent(new Student(0,name,pwd,age,description,sex));
		if(result>0){
			System.out.println("���ӳɹ�����");
		}else{
			System.out.println("����ʧ�ܣ���");
		}
	}
	
	public void delStudent(){
		System.out.println("��ǰ����������IDɾ��ѧԱ");
		System.out.print("��������Ҫɾ��ѧԱ��ID��");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		int result = student.delStudent(id);
		if(result>0){
			System.out.println("ɾ���ɹ�����");
		}else{
			System.out.println("ɾ��ʧ�ܣ���");
		}
	}
	
	public void updateStudent(){
		System.out.println("��ǰ����������ID����ѧԱ����");
		System.out.print("��������Ҫ����ѧԱ��ID��");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		System.out.print("�������޸ĺ��ѧԱ������");
		String name = input.next();
		int result = student.updateStudent(id,name);
		if(result>0){
			System.out.println("�޸ĳɹ�����");
		}else{
			System.out.println("�޸�ʧ�ܣ���");
		}
	}
}
