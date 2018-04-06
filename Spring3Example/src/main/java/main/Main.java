package main;

import beans.User;
import dao.UserDAOInter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
                
                UserDAOInter obj = (UserDAOInter) context.getBean("userDao");
                 obj = (UserDAOInter) context.getBean("userDao");
                //DI, IoC, TomEE
	}
}
