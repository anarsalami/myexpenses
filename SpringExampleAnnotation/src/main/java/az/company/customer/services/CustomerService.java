package az.company.customer.services;

import az.company.beans.User;
import az.company.customer.dao.inter.ICustomerDAO;
import az.company.customer.services.inter.ICustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    @Qualifier(value = "dao2")
    ICustomerDAO customerDAO;

    @Override
    public List<User> getUsers() {
        List<User> list = customerDAO.getUsers();
        for (User u : list) {
            System.out.println(u);
        }
        return list;
    }

    
}
