/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.SignForm;
import com.bsptechs.beans.UserForm;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sign")
public class SignController {

    @Autowired
    IUserService userService;

   @RequestMapping(method = RequestMethod.POST)
    public String sign(
            @ModelAttribute("signForm") SignForm signForm,
            @RequestParam String action) {
        User user = new User();
        user.setName(signForm.getName());
        user.setSurname(signForm.getSurname());
        user.setUsername(signForm.getUsername());
        user.setPassword(signForm.getPassword());
        user.setEnabled(true);
        if (action != null) {
            if (action.equalsIgnoreCase("LogIn")) {
                userService.insert(user);
            }
        }
        System.out.println("id=" + signForm.getId());
        System.out.println("userform=" + signForm);

        return "redirect: /myexpenses/users";
    }
 

}