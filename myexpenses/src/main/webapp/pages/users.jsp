<%-- 
    Document   : welcome
    Created on : Apr 13, 2018, 8:09:45 PM
    Author     : sarkhanrasullu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" type="text/css" href="assets/css/main.css">
        <title>Users</title>
    </head>
    <body>
        <c:forEach var="user" items="${users}">
            Name: <c:out value="${user.name}"/>
            Surname: <c:out value="${user.surname}"/>
        </c:forEach>
        <div class="container-table100">

            <form class="contact1-form validate-form">


                <div class="wrap-input1 validate-input" data-validate = "Name is required">
                    <input class="input1" type="text" name="name" placeholder="Name">
                    <span class="shadow-input1"></span>
                </div>
                <div class="wrap-input1 validate-input" data-validate = "Surname is required">
                    <input class="input1" type="text" name="surname" placeholder="Surname">
                    <span class="shadow-input1"></span>
                </div>
                <div class="wrap-input1 validate-input" data-validate = "Username is required">
                    <input class="input1" type="text" name="name" placeholder="Username">
                    <span class="shadow-input1"></span>
                </div>
                <div class="wrap-input1 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input1" type="text" name="email" placeholder="Email">
                    <span class="shadow-input1"></span>
                </div>

                <div class="wrap-input1 validate-input">
                    <select class="input1"  name="role">
                        <option value="1" class="wrap-input1">ADMIN</option>
                        <option value="2" class="wrap-input1">USER</option>
                    </select>
                    <span class="shadow-input1"></span>
                </div>


                <div class="container-contact1-form-btn">
                    <button class="contact1-form-btn">
                        <span>
                            Add
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>
                <div class="container-contact1-form-btn">
                    <button class="contact1-form-btn">
                        <span>
                            Delete
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>
                <div class="container-contact1-form-btn">
                    <button class="contact1-form-btn">
                        <span>
                            Update
                            <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                        </span>
                    </button>
                </div>

            </form>
            <div class="wrap-table100">
                <div class="table100 ver1 m-b-110">
                    <table data-vertable="ver1">
                        <thead>
                            <tr class="row100 head">
                                <th class="column100 " data-column="column1">ID</th>
                                <th class="column100 " data-column="column2">Name</th>
                                <th class="column100 " data-column="column3">Surname</th>
                                <th class="column100 " data-column="column4">Username</th>
                                <th class="column100 " data-column="column5">Password</th>
                                <th class="column100 " data-column="column6">Role</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr class="row100">
                                <td class="column100 " data-column="column1">1</td>
                                <td class="column100" data-column="column2">Anar</td>
                                <td class="column100" data-column="column3">Salami</td>
                                <td class="column100 " data-column="column4">anarsalami</td>
                                <td class="column100" data-column="column5">Salami92</td>
                                <td class="column100 " data-column="column6">Admin</td>
                            </tr>
                            <tr class="row100">
                                <td class="column100 " data-column="column1">2</td>
                                <td class="column100" data-column="column2">Sarkhan</td>
                                <td class="column100" data-column="column3">Rasullu</td>
                                <td class="column100 " data-column="column4">SarkhanRasullu</td>
                                <td class="column100" data-column="column5">123456</td>
                                <td class="column100 " data-column="column6">Admin</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <script src="../assets/js/main.js"></script>
    </body>
</html>
