package com.example.SpringJDBCPractice;

import com.example.SpringJDBCPractice.model.Student;
import com.example.SpringJDBCPractice.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringJdbcPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcPracticeApplication.class, args);
		Student s=context.getBean(Student.class);
		Scanner sc=new Scanner(System.in);
		System.out.println("To add a student details Enter 1 \n To delete a student details Enter 2:");
		int option=sc.nextInt();
		while(option!=3) {
			if (option == 1) {
				System.out.println("Enter your roll name and marks");
				int r = sc.nextInt();
				String n = sc.next();
				int m = sc.nextInt();
				s.setMarks(m);
				s.setName(n);
				s.setRoll(r);
				StudentService service = context.getBean(StudentService.class);
				service.addStudent(s);
				List<Student> students = service.getStudents();
				System.out.println(students);

			} else if (option == 2) {
				System.out.println("Enter the student's roll no which you want to delete");
				int r = sc.nextInt();
				s.setRoll(r);
				StudentService service = context.getBean(StudentService.class);
				service.deleteStudent(s);
				List<Student> students = service.getStudents();
				System.out.println(students);

			}
			System.out.println("To add a student details Enter 1\nTo delete a student details Enter 2:\nTo Exit enter any other key");
			option=sc.nextInt();
		}
//		System.out.println("Enter your roll name and marks");
//		int r= sc.nextInt();
//		String n=sc.next();
//		int m= sc.nextInt();
//		s.setMarks(m);
//		s.setName(n);
//		s.setRoll(r);
//		StudentService service=context.getBean(StudentService.class);
//		service.addStudent(s);
//		List<Student> students=service.getStudents();
//		System.out.println(students);
	}

}
