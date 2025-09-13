/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Convocatorias;

import BackEnd.DB.Convocatoria.Convocatoria;
import BackEnd.DB.Convocatoria.ConvocatoriaDB;
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
public class IrListadoConvocatorias extends HttpServlet {

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
        ConvocatoriaDB convocatoriaDB = new ConvocatoriaDB();
        List<Convocatoria> convocatorias = convocatoriaDB.listarConvocatoria();
        for (Convocatoria c : convocatorias) {
            System.out.println("ID: " + c.getIdConvocatoria());
            System.out.println("Titulo: " + c.getTitulo());
            System.out.println("Fecha inicio: " + c.getFechaInicio());
        }
        request.setAttribute("convocatorias", convocatorias);
        
        request.getRequestDispatcher("/Convocatorias-pages/ListaConvocatorias.jsp").forward(request, response);
    }
}
