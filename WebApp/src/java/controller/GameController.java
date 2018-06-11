package controller;

import DAO.GameDAOImpl;
import DAO.UserDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import static javassist.CtMethod.ConstParameter.string;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;
import model.User;

 /*@author ursul*/
         
@WebServlet(name = "GameController", urlPatterns = {"/GameController"})
public class GameController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDAOImpl userDAO = new UserDAOImpl();
        int idUser = Integer.parseInt(request.getParameter("choixutilisateur"));
        int nbRound = Integer.parseInt(request.getParameter("choix"));
        User user = userDAO.findById(idUser,new User());
        
                Game gameForm = new Game(nbRound, user);
                GameDAOImpl gameDAO = new GameDAOImpl();
                Game game = gameDAO.create(gameForm);
                
                getServletConfig().getServletContext().getRequestDispatcher(
                        "/vue/jeu.jsp?idUser="+idUser+"&nbRound="+nbRound).forward(request, response);
            }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
