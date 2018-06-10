<%-- 
    Document   : jeu
    Created on : 4 juin 2018, 08:27:08
    Author     : Nous1
--%>

<%@page import="model.User"%>
<%@page import="DAO.UserDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jouer</title>
    </head>
    <body>
         <center>
             <%

             int idUser=0;
             int nbRound=0;
             int nbRoundT=1;
             int score=0;
             String tour="user";
             int choix=0;
            if(request.getParameter("idUser") != null) {
               
                idUser=Integer.parseInt(request.getParameter("idUser"));
             }
            else {
                out.println("null");
            }
            if(request.getParameter("nbRound") != null) {
                nbRound=Integer.parseInt(request.getParameter("nbRound"));
             }
            else {
                out.println("null");
            }
            
            if(request.getParameter("nbRoundT") != null) {
                nbRoundT=Integer.parseInt(request.getParameter("nbRoundT"));
             }
            
            
            if(request.getParameter("score") != null) {
                score=Integer.parseInt(request.getParameter("score"));
             }
            
            if(request.getParameter("tour") != null) {
                tour=(String)request.getParameter("tour");
             }
             if(request.getParameter("choix") != null) {
                choix=Integer.parseInt(request.getParameter("choix"));
             }
             
             
           
            if(tour.equals("user") && nbRoundT<=nbRound){
                out.println("<h3> Cliquez sur votre choix </h3>");
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT="+nbRoundT+"&score="+score+"&tour=ordi&choix=1'> <img src='../image/pierre.jpg' width='70px' height='70px'> </a> ");
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT="+nbRoundT+"&score="+score+"&tour=ordi&choix=2'><img src='../image/feuille.jpg'width='70px' height='70px'></a> ");
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT="+nbRoundT+"&score="+score+"&tour=ordi&choix=3'><img src='../image/ciseau.jpg' width='70px' height='70px'></a>");
            }
            else {
                if(nbRoundT>nbRound){
                   
                    out.println("<h1>Votre partie est fini , votre score est de : "+score+"</h1>");
                    if(score>0){
                    UserDAOImpl userDAO;
                    userDAO =new UserDAOImpl();
                    User user=new User();
                    user=userDAO.findById(idUser, user);
                    int scoreUser=user.getScore();
                    user.setScore(scoreUser+score);
                    userDAO.update(user);
                    
                    
                    }
                    
                   out.println("<a href='http://localhost:8080/WebApp/vue/accueil.jsp'><button type='button'> Revenir à l'accueil </button> <a>");
                }
                
            }
           
            if(tour.equals("ordi")){
                
                out.println("<p> Votre choix </p>");
                if(choix==1){
                    out.println("<img src='../image/pierre.jpg' width='70px' height='70px'>");
                }
                else {
                    if(choix==2){
                        out.println("<img src='../image/feuille.jpg'width='70px' height='70px'>");
                        
                    }
                    else {
                        out.println("<img src='../image/ciseau.jpg' width='70px' height='70px'>");
                        
                    }
                }
                out.println("</br>");
                out.println("</br>");
                out.println("</br>");
                
                out.println("<p> Le choix de l'ordinateur</h2> </p>");
                
                int nombreAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
                
                if(nombreAleatoire==1){
                    out.println("<img src='../image/pierre.jpg' width='70px' height='70px'>");
                }
                else {
                    if(nombreAleatoire==2){
                        out.println("<img src='../image/feuille.jpg'width='70px' height='70px'>");
                        
                    }
                    else {
                        out.println("<img src='../image/ciseau.jpg' width='70px' height='70px'>");
                        
                    }
                }
                
                switch(choix){
                    case 1:
                        if(nombreAleatoire==1){
                            out.println("<h3> Egalité </h3>");
                        }
                        else{
                            if(nombreAleatoire ==2){
                                out.println("<h3> L'ordinateur gagne la manche </h3>");
                                score=score-75;
                            }
                            else{
                                if(nombreAleatoire==3){
                                    out.println("<h3> Vous gagnez la manche </h3>");
                                    score=score+50;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(nombreAleatoire==1){
                            out.println("<h3> Vous gagnez la manche </h3>");
                            score=score+50;
                        }
                        else{
                            if(nombreAleatoire ==2){
                                out.println("<h3> Egalité </h3>");
                            }
                            else{
                                if(nombreAleatoire==3){
                                    out.println("<h3> L'ordinateur gagne la manche </h3>");
                                    score=score-75;
                                }
                            }
                        }
                        break;
                    case 3:
                        if(nombreAleatoire==1){
                           out.println("<h3> L'ordinateur gagne la manche </h3>");
                            score=score-75;
                        }
                        else{
                            if(nombreAleatoire ==2){
                                out.println("<h3> Vous gagnez la manche </h3>");
                                score=score+50;
                            }
                            else{
                                if(nombreAleatoire==3){
                                    out.println("<h3> Egalité </h3>");
                                }
                            }
                        }
                    
                        break;
                }
                
                
                
                nbRoundT++;
               
                
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT="+nbRoundT+"&score="+score+"&tour=user'><button type='button'> Suivant </button> <a>");
                
            }
           


            
            
            
           %>
            
        </center>

    </body>
</html>
