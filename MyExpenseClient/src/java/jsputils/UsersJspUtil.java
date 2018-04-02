/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsputils;

import beans.User;
import dao.impl.UserDAOImpl;
import dao.inter.jdbc.UserDAOInter;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarkhanrasullu
 */
public class UsersJspUtil {

    private static UserDAOInter userDao = new UserDAOImpl();

    public static List<User> checkOperation(HttpServletRequest request) throws Exception {
 
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String roleIdStr = request.getParameter("roleid");
        int roleId = 0;
        if (roleIdStr != null && !roleIdStr.isEmpty()) {
            roleId = Integer.parseInt(roleIdStr);
        }

        String idStr = request.getParameter("userId");
        int id = 0;
        if (idStr != null && !idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
        }

        List<User> userList = null;
        if (action != null) {
            if (action.equals("Search")) {
                userList = actionSearch(name, surname);
                return userList;
            } else if (action.equals("Insert")) {
                actionInsert(name, surname, username, password, roleId);
            } else if (action.equals("Update")) {
                actionUpdate(id, name, surname, username, password, roleId);
            } else if (action.equals("Delete")) {
                actionDelete(id);
            }
        }
        userList = userDao.selectAll();

        return userList;
    }

    public static List<User> actionSearch(String name, String surname) {
        List<User> userList = null;
        if (name != null && !name.isEmpty() && surname != null && !surname.isEmpty()) {
            userList = userDao.findAll(name, surname);
        } else {
            userList = userDao.selectAll();
        }

        return userList;

    }

    public static void actionInsert(String name, String surname, String username, String password, int roleId) throws Exception {
        User user = new User(name, surname, username, password, roleId);
        int result = userDao.insert(user);
        if (result <= 0) {
            throw new Exception("xet bash verdi");
        }
    }

    public static void actionUpdate(int id, String name, String surname, String username, String password, int roleId) throws Exception {
        User user = new User(name, surname, username, password, roleId);
        boolean result = userDao.update(id, user);
        if (!result) {
            throw new Exception("xet bash verdi");
        }
    }

    public static void actionDelete(int id) throws Exception {
        userDao.delete(id);
    }

}
