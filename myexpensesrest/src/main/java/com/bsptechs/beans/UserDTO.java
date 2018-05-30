/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptechs.beans;

import lombok.Data;

/**
 *
 * @author sarkhanrasullu
 */
@Data
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String username;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }
    
    
    
}
