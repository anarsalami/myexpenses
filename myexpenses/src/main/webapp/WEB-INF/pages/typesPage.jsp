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
        <link rel="stylesheet" type="text/css" href="assets/css/mainTable.css">
        <link rel="stylesheet" type="text/css" href="assets/css/mainForm.css">
        <link rel="stylesheet" type="text/css" href="assets/css/navigation.css">
        <link rel="stylesheet" type="text/css" href="assets/css/util.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Expense types</title>


    </head>
    <body>


        <div class="wrapper">
            <!-- Sidebar Holder -->
            <%@include file="header.jsp" %>

            <!-- Page Content Holder -->
            <div id="content">

                <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                                <i class="glyphicon glyphicon-align-left"></i>                                
                            </button>
                        </div>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <div class="wrap-table100">
                            <form:form    modelAttribute="typeForm" 
                                          action="types/crud" 
                                          method="POST"
                                          cssClass="contact100-form"
                                          >

                                <div class="wrap-form-control rs1-wrap-form-control" >
                                    <form:input path="name" class="form-control"  placeholder="Enter role name"/>
                                    <span class="focus-form-control"></span>
                                </div>

                                <div class="container-contact100-form-btn">
                                    <button class="contact100-form-btn" name="action" value="add">
                                        <input type="hidden" name="id" id="idElement"/>
                                        <span>
                                            Add
                                            <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                        </span>
                                    </button>
                                    <button class="contact100-form-btn" name="action" value="delete">
                                        <input type="hidden" name="id" id="idElement"/>
                                        <span>
                                            Delete
                                            <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                        </span>
                                    </button>
                                    <button class="contact100-form-btn" name="action" value="update">
                                        <input type="hidden" name="id" id="idElement"/>
                                        <span>
                                            Update
                                            <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                        </span>
                                    </button>
                                </div>
                            </form:form>



                            <div class="table100 ver1 m-b-110">
                                <table data-vertable="ver3">
                                    <thead>
                                        <tr class="row100 head">
                                            <th class="column100" data-column="column1">ID</th>
                                            <th class="column100" data-column="column2"> Role Name</th>

                                        </tr>
                                    </thead>
                                    <tbody> <c:forEach var="type" items="${types}">
                                            <tr class="row100" onclick="setId(<c:out value="${type.id}"/>)">
                                                <td class="column100 " data-column="column1"><c:out value="${type.id}"/></td>
                                                <td class="column100" data-column="column2"><c:out value="${type.name}"/></td>
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div> 
            </div>


        </nav>


    </div>



    <script src="assets/js/main.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <!-- Bootstrap Js CDN -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
                                                $(document).ready(function () {
                                                    $('#sidebarCollapse').on('click', function () {
                                                        $('#sidebar').toggleClass('active');
                                                    });
                                                });
    </script>
    <script>
        function setId(id) {
            document.getElementById("idElement").value = id;
        }
    </script>
</body>
</html>
