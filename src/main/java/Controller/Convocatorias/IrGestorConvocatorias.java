/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Convocatorias;

import BackEnd.DB.SesionGlobal;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author jgarcia07
 */

public class IrGestorConvocatorias extends HttpServlet {

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
        String idRole = SesionGlobal.idRol;
        
        if(idRole.equals("00002") || idRole.equals("00001")){
            request.getSession().setAttribute("idPersonal", SesionGlobal.idPersonal);
            System.out.println(SesionGlobal.idPersonal);
            request.getRequestDispatcher("/Convocatorias-pages/CrearConvocatoria.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/SinAcceso.jsp").forward(request, response);
        }
    }

}
