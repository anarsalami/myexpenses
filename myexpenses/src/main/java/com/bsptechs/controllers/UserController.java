/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.UserForm;
import com.bsptechs.entities.User;
import com.bsptechs.entities.Role;
import com.bsptechs.service.inter.IUserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bsptechs.service.inter.IRoleService;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public String userPage(Map<String, Object> model, @ModelAttribute("userForm") UserForm userForm) {
        List<User> users = userService.selectAll();
        model.put("users", users);
        List<Role> userRoles = userRoleService.selectAll();
        model.put("userRoles", userRoles);
        System.out.println("userroles size="+userRoles.size());
        System.out.println("users size= "+users.size());
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
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                userService.insert(user);
            } else if (action.equalsIgnoreCase("delete")) {
                userService.delete(userForm.getId());
            } else if (action.equalsIgnoreCase("update")){
                user.setId(userForm.getId());
                userService.update(user);
            }
        }
        System.out.println("id="+userForm.getId());
        System.out.println("userform="+userForm);

        return "redirect: /myexpenses/users";
    }

}
