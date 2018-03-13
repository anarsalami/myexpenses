/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarkhanrasullu.servlets;

import beans.User;
import dao.impl.UserDAOImpl;
import dao.inter.UserDAOInter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarkhanrasullu Java Enterprise Endition
 * 
 * @ - annotation
 */
@WebServlet(name = "IndexController", urlPatterns = {"/index"})
public class IndexController extends HttpServlet {

    UserDAOInter userDao = new UserDAOImpl();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String suranme = request.getParameter("surname");

        List<User> list = userDao.selectAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Users</title>");
            out.println("</head>");
            out.println("<body>");

            for (int i = 0; i < list.size(); i++) {
                User u = list.get(i);
                out.println(u.getName() + " " + u.getSurname() + "<br/>");
            }
            out.println("<form method='POST'>");
            out.println("<input type='text' name='name'/>");
            out.println("<input type='text' name='surname'/>");
            out.println("<input type='text' name='username'/>");
            out.println("<input type='password' name='password'/>");
            out.println("<input type='submit' value='ok'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * post-add put-update delete-delete get-select
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter("actionName");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userDao.insert(new User(name, surname, username, password));
 
         response.sendRedirect("index");
    }
    
     @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userDao.update(id,new User(name, surname, username, password));
 
         response.sendRedirect("index");
    }
    
      @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        

        userDao.delete(id);
 
         response.sendRedirect("index");
    }

}
