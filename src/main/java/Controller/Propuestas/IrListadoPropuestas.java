/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Propuestas;

import BackEnd.DB.Propuesta.Propuesta;
import BackEnd.DB.Propuesta.PropuestaDB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author jgarcia07
 */
public class IrListadoPropuestas extends HttpServlet {

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
        
        int idConvocatoria = Integer.parseInt(request.getParameter("idConvocatoria"));
        PropuestaDB propuestasDB = new PropuestaDB();
        List<Propuesta> propuestas = propuestasDB.listarPropuesta(idConvocatoria);
        
        request.setAttribute("propuestas", propuestas);
        
        request.getRequestDispatcher("/Propuestas-pages/ListaPropuestas.jsp").forward(request, response);
    }


}
