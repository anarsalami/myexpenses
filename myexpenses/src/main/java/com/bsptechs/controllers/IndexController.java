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
@RequestMapping("/index")
public class IndexController {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
 

}
