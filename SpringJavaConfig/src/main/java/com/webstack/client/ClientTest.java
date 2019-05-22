package com.webstack.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webstack.bean.HelloBean;
import com.webstack.bean.MessageBean;
import com.webstack.bean.Student;
import com.webstack.configuration.AppConfig;
import com.webstack.repository.StudentDAO;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		
		MessageBean messageBean = applicationContext.getBean("messageBean",MessageBean.class);
		
		//messageBean.setMessage("Hello...");
		messageBean.setMessage("Hi....");
		System.out.println(messageBean.getMessage());
		
		
		MessageBean messageBean1 = applicationContext.getBean("messageBean",MessageBean.class);
		
		System.out.println(messageBean1.getMessage());
		
		HelloBean helloBean = applicationContext.getBean("helloBean",HelloBean.class);
		
		System.out.println(helloBean.getMessage());
		
		//JDBC Testing
		
		StudentDAO studentDAO = applicationContext.getBean("studentDAO",StudentDAO.class);
		
		List<Student> studentList = studentDAO.list(); 
		
		studentList.stream().forEach(s->System.out.println(s.getName()+" "+s.getId() +" " + s.getCity()+" "+s.getMobileNo()));
		
		Student newStudent = new Student();
		newStudent.setName("Darsh");
		newStudent.setCity("Navsari");
		newStudent.setMobileNo("9898012143");
		
		int result = studentDAO.save(newStudent);
		
		if(result > 0) {
			System.out.println("student information saved successfully...");
		}
		
		System.out.println("======================After New Student==============");
		
		studentList = studentDAO.list(); 
		
		studentList.stream().forEach(s->System.out.println(s.getName()+" "+s.getId() +" " + s.getCity()+" "+s.getMobileNo()));
		applicationContext.close();
		
	}

}
