package az.company.customer.dao;

import az.company.beans.User;
import az.company.customer.dao.inter.ICustomerDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository(value="dao3")
public class CustomerDAO3 implements ICustomerDAO{
 
    @Override
    public List<User> getUsers() {
        System.out.println("dao 3 started");
        List<User> list = new ArrayList<User>();
        list.add(new User("Kanan"));
        return list;
    }
}
