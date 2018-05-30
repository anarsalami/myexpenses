/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.ResponseDTO;
import com.bsptechs.beans.UserDTO;
import com.bsptechs.beans.UserForm;
import com.bsptechs.entities.User;
import com.bsptechs.service.inter.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bsptechs.service.inter.IRoleService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseDTO users() {//data transfer object dto
        List<User> users = userService.selectAll();
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            userDTOs.add(new UserDTO(user.getId(),user.getName(),user.getSurname(), user.getUsername()));
        }
        return ResponseDTO.successResp(userDTOs);
    }
    
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseDTO user(@PathVariable(value = "id") Integer id) {//data transfer object dto
        User user = userService.find(id);
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getSurname(), user.getUsername());
        
        return ResponseDTO.successResp(userDTO);
    }

    @RequestMapping(path = "crud", method = RequestMethod.POST)
    public ResponseDTO userCrud(
            @RequestBody UserForm userForm,
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

        return ResponseDTO.successResp();
    }

}
