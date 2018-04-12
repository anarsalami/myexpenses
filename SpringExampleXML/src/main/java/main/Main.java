package main;

import beans.Student;
import dao.UserDAOInter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
                
                System.out.println(context.getBean("student"));
                //DI, IoC, TomEE
	}
}
