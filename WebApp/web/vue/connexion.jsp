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
        <title>Connexion Utilisateur</title>
    </head>
    <body>
        <div>
            <form id="formConnexion" method="POST" action="/WebApp/UserController">
                <label>Username :</label>
                <input name="pseudo" type="text">
                <br>
                <label>Password :</label>
                <input name="password" type="password">
                <br>
                <input name="connectionButton" type="submit" value="Se connecter">
            </form>
            <form id="formRegister" method="POST" action="/WebApp/vue/inscription.jsp">
                <input name="connectionButton" type="submit" value="Inscription">
            </form>
        </div>
    </body>
</html>
