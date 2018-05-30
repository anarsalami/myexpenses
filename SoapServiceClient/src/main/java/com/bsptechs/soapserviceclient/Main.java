/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.soapserviceclient;

import com.bsptechs.soapservices.users.User;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public class Main {

    public static void main(String[] args) {
        List<User> list=  UserSoapClient.getUsers("Sarkhan", "Rasullu");
        for(User u:list){
            System.out.println(u.getName());
            System.out.println(u.getSurname());
        }
    }
    
}
