///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bsptechs.controllers;
//
//import com.bsptechs.beans.RoleForm;
//import com.bsptechs.entities.Role;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.bsptechs.service.inter.IRoleService;
//
//@Controller
//@RequestMapping("roles")
//public class RoleController {
//
//    @Autowired
//    IRoleService roleService;
//
// 
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String rolePage(Map<String, Object> model, @ModelAttribute("roleForm") RoleForm roleForm) {
//        List<Role> roles = roleService.selectAll();
//        model.put("roles", roles);
//        
//        System.out.println("test2 ");
//        return "rolesPage";
//    }
//
//    @RequestMapping(path = "crud", method = RequestMethod.POST)
//    public String roleCrud(
//            @ModelAttribute("roleForm") RoleForm roleForm,
//            @RequestParam String action) {
//       Role role = new Role();
//        role.setId(roleForm.getId());
//        role.setName(roleForm.getName());
//        
//        if (action != null) {
//            if (action.equalsIgnoreCase("add")) {
//                roleService.insert(role);
//            } else if (action.equalsIgnoreCase("delete")) {
//                roleService.delete(roleForm.getId());
//            } else if (action.equalsIgnoreCase("update")){
//                role.setId(roleForm.getId());
//                roleService.update(role);
//            }
//        }
//        System.out.println("id="+roleForm.getId());
//        System.out.println("userform="+roleForm);
//
//        return "redirect: /myexpenses/roles";
//    }
//
//}
