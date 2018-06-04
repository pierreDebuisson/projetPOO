<%-- 
    Document   : login
    Created on : 4 juin 2018, 08:26:57
    Author     : Nous1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        <div>
            <form id="formConnexion" method="POST" action="/WebApp/UserController">
                <input id="pseudo" type="text">
                <input id="password" type="text">
                <input id="connectionButton" type="submit" value="Se connecter">
            </form>
        </div>
    </body>
</html>
