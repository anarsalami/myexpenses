/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.UserForm;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IUserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String userPage(Map<String, Object> model, @ModelAttribute("userForm") UserForm userForm) {
        List<User> users = userService.selectAll();
        model.put("users", users);

        System.out.println("users size= " + users.size());
        return "usersPage";
    }

    @RequestMapping(path = "crud", method = RequestMethod.POST)
    public String userCrud(
            @ModelAttribute("userForm") UserForm userForm,
            @RequestParam String action) {
        User user = new User();
        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
//        user.setRoleId(new UserRole().getRoleId());
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                userService.insert(user);
            } else if (action.equalsIgnoreCase("delete")) {
                userService.delete(userForm.getId());
            } else if (action.equalsIgnoreCase("update")) {
                user.setId(userForm.getId());
                userService.update(user);
            }
        }
        System.out.println("id=" + userForm.getId());
        System.out.println("userform=" + userForm);

        return "redirect: /myexpenses/users";
    }

}
