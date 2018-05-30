/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.List;
import beans.User;
import java.util.ArrayList;
/**
 *
 * @author sarkhanrasullu
 */
@WebService(serviceName = "Users")
public class Users {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getUsers")
    public List<User> getUsers(@WebParam(name = "user") String name,@WebParam(name = "surname") String surname) {
        List<User> list = new ArrayList<User>();//1001001
        list.add(new User(1,"Sarkhan","Rasullu"));
        list.add(new User(2,"Kanan","Rahimli"));
        
        return list;
    }
}
