package main;

import az.company.customer.dao.inter.ICustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import az.company.customer.services.inter.ICustomerService;

public class App {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"Spring-AutoScan.xml"});

//        ICustomerService cust = (ICustomerService) context.getBean("customerService");
        ICustomerDAO cust = (ICustomerDAO) context.getBean("customerDao");
        
        System.out.println(cust.getUsers());
//

    }
}
