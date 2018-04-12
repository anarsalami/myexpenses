<%-- 
    Document   : users
    Created on : Mar 16, 2018, 9:53:49 PM
    Author     : sarkhanrasullu
--%>

<%@page import="jsputils.UsersJspUtil"%>
<%@page import="beans.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.UserDAOImpl"%>
<%@page import="dao.inter.UserDAOInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Users</title>
        <meta charset="UTF-8">
    </head>
    <body style="background-color: green">
        <div>
            <fieldset>
                <legend>Fill fields:</legend>
                <form action="" method="GET">
                    <table>
                        <tbody>
                            <tr>
                                <td>
                                    <label for="name" >
                                        Name:
                                    </label>
                                </td>
                                <td>
                                    <input type="text" name="name"/>
                                </td>
                                <td>
                                    <span id="namePreview"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="surname">
                                        Surname:
                                    </label>
                                </td>
                                <td>
                                    <input type="text" name="surname"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="username">
                                        Username:
                                    </label>
                                </td>
                                <td>
                                    <input type="text" name="username" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="password">
                                        Password:
                                    </label>
                                </td>
                                <td>
                                    <input type="password" name="password" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="roleid">
                                        Role:
                                    </label>
                                </td>
                                <td>
                                    <select name="roleid" 
                                            id="roleField"
                                            onchange="makePreview('rolePreview', 'roleField')">
                                        <option value="2">User</option>
                                        <option value="1">Admin</option>
                                    </select>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <br/>
                    <input type="hidden" name="userId" id="userField"/>
                    <input type="submit" name="action" value="Search"/>
                    <input type="submit" name="action" value="Insert"/>
                    <input type="submit" name="action" value="Update"/>
                    <input type="submit" name="action" value="Delete"/>
                </form>
            </fieldset>
        </div>
        <hr/>

        <%
            List<User> userList = UsersJspUtil.checkOperation(request);
        %>

        <div id="content">
            <table border="1">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>name</th>
                        <th>surname</th>
                        <th>username</th>
                        <th>role</th>
                    </tr>
                </thead>
                <tbody>
                    <%  for (int i = 0; i < userList.size(); i++) {
                            User user = userList.get(i);
                    %>
                    <tr onclick="getIdAndSet('<%=user.getId()%>')">
                        <td>
                            <%=i + 1%></td>
                        <td><%=user.getName()%></td>
                        <td><%=user.getSurname()%></td>
                        <td><%=user.getUsername()%></td>
                        <td><%=user.getRoleName()%></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>

        </div>


        <script>
            function getIdAndSet(id) {
                var userField = document.getElementById("userField");
                userField.value = id;
            }
        </script>
    </body>
</html>
