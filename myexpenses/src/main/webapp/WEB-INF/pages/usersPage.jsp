<%-- 
    Document   : welcome
    Created on : Apr 13, 2018, 8:09:45 PM
    Author     : sarkhanrasullu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Users</title>
    </head>
    <body>

        <div>
            <form:form    modelAttribute="userForm" 
                          action="users/crud" 
                          method="POST"
                          class="contact1-form validate-form">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 validate-input" data-validate = "Name is required">
                            <form:input path="name" class="form-control"  placeholder="Name"/>
                            <span class="shadow-input1"></span>
                        </div>
                        <div class="col-md-4 validate-input" data-validate = "Surname is required">
                            <form:input path="surname" class="form-control" placeholder="Surname"/>
                            <span class="shadow-input1"></span>
                        </div>
                        <div class="col-md-4 validate-input" data-validate = "Username is required">
                            <form:input path="username" class="form-control"  placeholder="Username"/>
                            <span class="shadow-input1"></span>
                        </div>

                        <div class="col-md-4 validate-input" data-validate = "Password is required">
                            <form:input path="password" class="form-control" type="password"  placeholder="Password"/>
                            <span class="shadow-input1"></span>
                        </div>
                        <div class="col-md-4 validate-input">
                            <form:select path="roleId" class="form-control">
                                <c:forEach var="userRole" items="${userRoles}">
                                    <form:option value="${userRole.id}" class="wrap-input1">${userRole.name}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                            <span class="shadow-input1"></span>
                        </div>
                    </div>
                </div>

                <div class="container-contact1-form-btn">
                    <button type="submit" class="btn btn-danger" name="action" value="add">
                        <span>
                            Add
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>
                <div class="container-contact1-form-btn">
                    <input type="hidden" name="id" id="idElement"/>
                    <button type="submit" name="action" value="delete" class="contact1-form-btn">
                        <span>
                            Delete
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>
                <div class="container-contact1-form-btn">
                    <button class="contact1-form-btn" name="action" value="update">
                        <span>
                            Update
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>

            </form:form>
            <div class="wrap-table100">
                <div class="table100 ver1 m-b-110">
                    <table data-vertable="ver1">
                        <thead>
                            <tr class="row100 head">
                                <th class="column100 " data-column="column1">ID</th>
                                <th class="column100 " data-column="column2">Name</th>
                                <th class="column100 " data-column="column3">Surname</th>
                                <th class="column100 " data-column="column4">Username</th>
                                <th class="column100 " data-column="column6">Role</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="user" items="${users}">
                                <tr class="row100" onclick="setId(<c:out value="${user.id}"/>)">
                                    <td class="column100 " data-column="column1"><c:out value="${user.id}"/></td>
                                    <td class="column100" data-column="column2"><c:out value="${user.name}"/></td>
                                    <td class="column100" data-column="column3"><c:out value="${user.surname}"/></td>
                                    <td class="column100 " data-column="column4"><c:out value="${user.username}"/></td>
                                    <td class="column100" data-column="column5">
                                        <c:forEach var="userRole" items="${user.userRoleList}">
                                            <c:out value="${userRole.roleId.name}"/><br/>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <script src="assets/js/main.js"></script>
        <script>
                                    function setId(id) {
                                        document.getElementById("idElement").value = id;
                                    }
        </script>
    </body>
</html>