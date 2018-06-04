/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.controllers;

import com.bsptechs.beans.ExpenseCategoryForm;

import com.bsptechs.entities.ExpenseCategory;

import com.bsptechs.service.inter.IExpenseCategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    IExpenseCategoryService categoryService;

 

    @RequestMapping(method = RequestMethod.GET)
    public String categoryPage(Map<String, Object> model, @ModelAttribute("categoryForm") ExpenseCategoryForm categoryForm) {
        List<ExpenseCategory> category = categoryService.selectAll();
        model.put("category", category);
        
        System.out.println("test2 ");
        return "categoryPage";
    }

    @RequestMapping(path = "crud", method = RequestMethod.POST)
    public String categoryCrud(
            @ModelAttribute("categoryForm") ExpenseCategoryForm categoryForm,
            @RequestParam String action) {
       ExpenseCategory category = new ExpenseCategory();
        category.setId(categoryForm.getId());
        category.setName(categoryForm.getName());
        
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                categoryService.insert(category);
            } else if (action.equalsIgnoreCase("delete")) {
                categoryService.delete(categoryForm.getId());
            } else if (action.equalsIgnoreCase("update")){
                category.setId(categoryForm.getId());
                categoryService.update(category);
            }
        }
        System.out.println("id="+categoryForm.getId());
        System.out.println("userform="+categoryForm);

        return "redirect: /myexpenses/categories";
    }

}
