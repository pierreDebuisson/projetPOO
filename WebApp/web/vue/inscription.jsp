<%-- 
    Document   : inscription
    Created on : Jun 9, 2018, 4:13:31 PM
    Author     : pierredebuisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription Utilisateur</title>
    </head>
    <body>
        <div>
            <form id="formRegister" method="POST" action="/WebApp/SignUpController">
                <label>Username :</label>
                <input name="pseudo" type="text">
                <br>
                <label>Password :</label>
                <input name="password" type="password">
                <br>
                <label>Confirm Password :</label>
                <input name="confirmPassword" type="password">
                <br>
                <input name="connectionButton" type="submit" value="Inscription">
            </form>
        </div>
    </body>
</html>
