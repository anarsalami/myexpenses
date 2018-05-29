<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/sign.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Sign up</title>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <h2 ><a href="login.jsp">Log in</a> </h2>
                <h2 ><a href="sign.jsp" >Sign up</a></h2>

                <!-- Icon -->
                <div class="fadeIn first">
                    <img src="assets/images/background/logo.png" id="icon" alt="User Icon" />
                </div>

                <!-- Login Form -->
                <form>
                    <input type="text" id="login" class="fadeIn second" name="name" placeholder="Name">
                    <input type="text" id="password" class="fadeIn third" name="surname" placeholder="Surname">
                    <input type="text" id="password" class="fadeIn fourth" name="username" placeholder="Username">
                    <input type="text" id="password" class="fadeIn fifth" name="password" placeholder="Password">
                    <input type="submit" class="fadeIn sixth" value="Log In">
                </form>

                <!-- Remind Passowrd -->
               

            </div>
        </div>
    </body>
</html>
