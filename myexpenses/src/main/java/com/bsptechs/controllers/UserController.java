/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IUserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/alma")
    public String welcome(Map<String, Object> model) {
        List<User> alma = userService.selectAll();
        model.put("users", alma);
        
        return "users";
    }

}
