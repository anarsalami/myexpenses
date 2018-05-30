/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.beans;

import lombok.Data;

/**
 *
 * @author Anar Salami
 */
@Data
public class ExpenseForm {

    private Integer id;
    private String title;
    private String description;
    private Double cost;
    private int type_id;
    private int category_id;

}
