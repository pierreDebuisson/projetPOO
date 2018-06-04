<%-- 
    Document   : accueil
    Created on : 4 juin 2018, 08:27:26
    Author     : Nous1
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UserDAOImpl"%>
<%@page import="DAO.GameDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="model.Game"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
    </head>
    <body>    
          
        <%! int id=0; %>
        <%! String pseudo="15"; %>
        <% 
            if( request.getParameter("pseudo")!=null){ pseudo=request.getParameter("pseudo");}
            UserDAOImpl userDAO = new UserDAOImpl();
            List<User> users = userDAO.findAll();
            GameDAOImpl gameDAO = new GameDAOImpl();
            List<Game> games = gameDAO.findAll();
        %>
       
        <h1> Bienvenue <%= pseudo%></h1>
        
        <h2> Parametres compte :</h2>
        
        <div>Vous avez réalisé <%=games.size()%></div>
        
        
        
        
        <h2> Parametres partie :</h2>
        <div>
            <label> Choisissez le nombre de manches : </label><br>
            <input type=radio id="choix1" name=choix value="Choix 1" checked=checked> 3 Manches </input><br>
            <input type=radio id="choix2" name=choix value="Choix 2"> 4 Manches </input><br>
            <input type=radio id="choix3" name=choix value="Choix 3" > 5 Manches </input><br>
            <input type=radio id="choix4" name=choix value="Choix 4" > 6 Manches </input><br>
            <input type=radio id="choix5" name=choix value="Choix 5" > 7 Manches </input><br>
            <input type=radio id="choix6" name=choix value="Choix 6" > 8 Manches </input><br>
            <input type=radio id="choix7" name=choix value="Choix 7" > 9 Manches </input><br>
            <input type=radio id="choix8" name=choix value="Choix 8" > 10 Manches </input><br>
        </div></br>
        
        
        <div>
            <label> Liste des utilisateurs : </label><br>
            <% for(User u: users){ %>
            <div><%=u.getPseudo()%></div><br>
            <input type=radio id="<%=u.getId()%>" name=choixAdversaire value="Choix<%=u.getId()%>"><%=u.getPseudo()%> </input><br>
            <% } %>
        </div>
        
        <!-- Envoyer deux parametres à Elsa NbManches et l'IdUser -->
        
    </body>
</html>
