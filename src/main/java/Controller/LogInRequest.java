/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.SesionGlobal;
import Exception.UserDataInvalidException;
import Model.ValidarLogIn;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author jgarcia07
 */
@WebServlet(name = "logInRequest", urlPatterns = {"/logInRequest"})
public class LogInRequest extends HttpServlet {
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
        try {
            ValidarLogIn logIn = new ValidarLogIn();
            if (logIn.validarCredenciales(request)) {
                HttpSession session = request.getSession();
                session.setAttribute("idRole", SesionGlobal.idRol);
                request.getRequestDispatcher("/MenuPrincipal.jsp").forward(request, response);
            }
             else {
                request.setAttribute("error", "Credenciales inválidas, intenta de nuevo.");
                request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
            }
        } catch (UserDataInvalidException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
        }
    }
}
