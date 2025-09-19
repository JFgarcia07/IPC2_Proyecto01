/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Instalacion;

import BackEnd.DB.Instalacion.Instalacion;
import Model.Instalacion.ListadorInstalaciones;
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
public class IrListadoInstalaciones extends HttpServlet {
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
        
        ListadorInstalaciones listador = new ListadorInstalaciones();
        List<Instalacion> instalaciones = listador.listadorInstalaciones();
        
        System.out.println(instalaciones.size());
        
        request.setAttribute("instalaciones", instalaciones);
        request.getRequestDispatcher("/Instalaciones-pages/ListaInstalaciones.jsp").forward(request, response);
    }

}
