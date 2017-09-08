package com.jason.server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jason.dao.impl.StudentDao;
import com.jason.entity.Student;

public class StudentManager {

	public static void main(String[] args) {
		StudentServer ss = new StudentServer();
		System.out.println("-----***ѧ������ϵͳ***-----");
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
				System.out.println("�˳�ϵͳ!");
				break;
			default:
				break;
		}
		}
		
	}
	
	@SuppressWarnings("resource")
	public static int menu(){
		System.out.println("1.��ѯ����ѧ����Ϣ");
		System.out.println("2.���ѧԱ");
		System.out.println("3.ɾ��ѧԱ");
		System.out.println("4.�޸�ѧԱ��Ϣ");
		System.out.println("5.�˳�ϵͳ");
		System.out.print("��ѡ����Ӧ�Ĳ�����");
		Scanner input = new Scanner(System.in);
		int choise = input.nextInt();
		return choise;
	}
	
	
}
