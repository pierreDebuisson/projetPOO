<%-- 
    Document   : jeu
    Created on : 4 juin 2018, 08:27:08
    Author     : Nous1
--%>

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
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT="+nbRoundT+"&score="+score+"&tour=ordi&choix=1'> <img src='../image/pierre.jpg' width='70px' height='70px'> </a> ");
                out.println("<img src='../image/feuille.jpg'width='70px' height='70px'> ");
                out.println("<img src='../image/ciseau.jpg' width='70px' height='70px'>");
            }
            else {
                if(nbRoundT>nbRound){
                    out.println("<h1>Votre partie est fini , votre score est de : "+score+"</h1>");
                }
                else{
                    
                }
            }
           
            if(tour.equals("ordi")){
                
                out.println("<h2> Votre choix </h2>");
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
            
                
                nbRoundT++;
                score++;
                
                out.println("<a href='http://localhost:8080/WebApp/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound+"&nbRoundT"+nbRoundT+"&score="+score+"&tour=user'><button type='button'> Suivant </button> <a>");
                
            }
           


            
            
            
           %>
            
        </center>

    </body>
</html>
