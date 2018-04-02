/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Logger;

/**
 *
 * @author nicat
 */
public class ExpenseCategory {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public ExpenseCategory() {
    }

    public ExpenseCategory(int id) {
        this.id = id;
    }

    public ExpenseCategory(String name) {
        this.name = name;
    }

    public ExpenseCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
