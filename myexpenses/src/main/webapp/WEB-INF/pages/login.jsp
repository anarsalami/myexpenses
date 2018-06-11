<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/login.css">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Login</title>
    </head>
    <body>


        <div class="wrapper fadeInDown">
            <div id="formContent">
                


                <h2 ><a href="/login" >Log in</a> </h2>
                <h2 ><a href="/sign" >Sign up</a></h2>

            
                <div class="fadeIn first">
                    <img src="assets/images/background/logo.png" id="icon" alt="User Icon" />
                </div>

                <form:form action='<spring:url value="/login"/>' method="post">
                    <form:input type="text" class="fadeIn second" path="username" placeholder="Username"/>
                    <input:password  class="fadeIn third" path="password" placeholder="Password"/>
                    <input type="submit" class="fadeIn fourth" value="Log In">
                </form:form>

             
                <div id="formFooter">
                    <a class="underlineHover" href="#">Forgot Password?</a>
                </div>

            </div>
        </div>
    </body>
</html>
