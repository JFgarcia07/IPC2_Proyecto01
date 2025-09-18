/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Congreso;

import BackEnd.DB.Congreso.Congreso;
import Model.Congreso.ListadorCongresos;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
@WebServlet("/IrGestorCongresos")
public class IrGestorCongresos extends HttpServlet {

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
        String idPersonal = request.getParameter("idPersonal");
        
        ListadorCongresos listador = new ListadorCongresos();
        List<Congreso> congresos = listador.listaGestorCongresos(idPersonal);
        
        request.setAttribute("congresos", congresos);
        request.getRequestDispatcher("/Congresos-pages/GestorCongresos.jsp").forward(request, response);
    }
}
