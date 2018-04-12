package com.bsptechs.beans;

import com.bsptechs.jdbc.annotations.NColumn;
import com.bsptechs.jdbc.annotations.NEntity;

@NEntity
public class User {
 
    @NColumn(name="id")
    private int id;//0
    
    @NColumn(name="name")
    private String name;
    
    @NColumn(name="surname")
    private String surname;
    
    
    @NColumn(name="username")
    private String username;
    
    @NColumn(name="password")
    private String password;
    
    @NColumn(name="role_id")
    private int roleId;
    
    private String roleName;


    public User() {
    }

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public User(String name, String surname, String username, String password, int roleId) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
    

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
