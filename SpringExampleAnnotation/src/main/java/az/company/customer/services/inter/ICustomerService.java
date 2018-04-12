/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.company.customer.services.inter;

import az.company.beans.User;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface ICustomerService {
    
    public List<User> getUsers();
}
