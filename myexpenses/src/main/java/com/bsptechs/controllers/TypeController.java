/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.ExpenseTypeForm;
import com.bsptechs.entities.ExpenseType;
import com.bsptechs.service.inter.IExpenseTypeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("types")
public class TypeController {

    @Autowired
    IExpenseTypeService typeServices;

 

    @RequestMapping(method = RequestMethod.GET)
    public String typesPage(Map<String, Object> model, @ModelAttribute("typesForm") ExpenseTypeForm typeForm) {
        List<ExpenseType> types = typeServices.selectAll();
        model.put("types", types);
        
        System.out.println("test2 ");
        return "typesPage";
    }

    @RequestMapping(path = "crud", method = RequestMethod.POST)
    public String typesCrud(
            @ModelAttribute("typesForm") ExpenseTypeForm typeForm,
            @RequestParam String action) {
       ExpenseType type = new ExpenseType();
        type.setId(typeForm.getId());
        type.setName(typeForm.getName());
        
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                typeServices.insert(type);
            } else if (action.equalsIgnoreCase("delete")) {
                typeServices.delete(typeForm.getId());
            } else if (action.equalsIgnoreCase("update")){
                type.setId(typeForm.getId());
                typeServices.update(type);
            }
        }
      
        return "redirect: /myexpenses/types";
    }

}
