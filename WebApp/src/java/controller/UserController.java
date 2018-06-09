/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author pierredebuisson
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String pseudo = request.getParameter("pseudo");
            String password = request.getParameter("password");
            if (pseudo.equals("") && password.equals("")) {
                redirectToLoginPage(request, response);
            } else {
                UserDAOImpl userDAO = new UserDAOImpl();
                User user = userDAO.getByUsername(pseudo);

                if (user != null && user.getPseudo().equals(pseudo)) {
                    if (password.equals(user.getPassword())) {
              
                        request.setAttribute("pseudo", user.getPseudo());
                        getServletConfig().getServletContext().getRequestDispatcher(
                                "/vue/accueil.jsp").forward(request, response);
                    }

                } else {
                    redirectToLoginPage(request, response);
                }
            }
        }
    
    public void redirectToLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.setAttribute("pseudo", "");
                        getServletConfig().getServletContext().getRequestDispatcher(
                                "/vue/connexion.jsp").forward(request, response);
    }
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
