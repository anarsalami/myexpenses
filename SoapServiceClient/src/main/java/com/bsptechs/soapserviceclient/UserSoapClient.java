/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.soapserviceclient;

import com.bsptechs.soapservices.users.User;
import com.bsptechs.soapservices.users.Users;
import com.bsptechs.soapservices.users.Users_Service;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public class UserSoapClient {

    public static List<User> getUsers(String name, String surname) {
        Users_Service service = new Users_Service();
        Users port = service.getUsersPort();
        List<User> result = port.getUsers(name, surname);
        return result;
    }
}
