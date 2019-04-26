package com.webstack.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webstack.bean.Message;
import com.webstack.object.PersonDTO;
import com.webstack.service.impl.ExamServiceImpl;

public class ClientTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		Message message = (Message) applicationContext.getBean("messageBean");
		message.setMessage("Hi");
		System.out.println(message.getMessage());
		
		Message message1 = (Message) applicationContext.getBean("messageBean");
		System.out.println(message1.getMessage());
		
		ExamServiceImpl examServiceImpl = applicationContext.getBean("examService",ExamServiceImpl.class);
		examServiceImpl.startExam();
		
		ExamServiceImpl examServiceImpl1 = applicationContext.getBean("examService1",ExamServiceImpl.class);
		examServiceImpl1.startExam();
		
		//
		
		PersonDTO personDTO = applicationContext.getBean("personDTO",PersonDTO.class);
		
		System.out.println("Perosn Details...: "+personDTO.getPid()+" "+personDTO.getName()+" "+personDTO.getAge()+" "+personDTO.getGender());
		System.out.println("Person Contact Details...: "+personDTO.getContactDTO().getMobileNo()+" "+personDTO.getContactDTO().getEmail());
	}

}
