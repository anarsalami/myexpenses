/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boraji.tutorial.spring.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author sarkhanrasullu
 */
public class Main {

    public static void main(String[] args) {
        BCryptPasswordEncoder en = new BCryptPasswordEncoder();
         
        System.out.println(en.encode("12345"));
        System.out.println(en.encode("12345"));
        System.out.println(en.encode("12345"));

//        $2a$10$Vq9ffYtYF/8RBFtEXuQSSOjZlRS/9h6O2j7Lpf2TiYLNnpyMjdJm2
//                $2a$10$IY8Zqy/HLmz0nz39fLQcF.JaT.F3mx6aibjOa59PcdiUUR1A7jud.
    }
}
