/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import BackEnd.DB.Usuario.SesionGlobal;
import BackEnd.DB.Usuario.Usuario;
import BackEnd.DB.UsuariosDB;
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
@WebServlet("/IrGestorUsuarios")
public class IrGestorUsuarios extends HttpServlet {

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
        
        if(idRole.equals("00001")){
            UsuariosDB usuariosDB = new UsuariosDB();
            List<Usuario> usuariosList = usuariosDB.listaUsuarios();
            request.setAttribute("usuarios", usuariosList);
            
            request.getRequestDispatcher("/Usuarios-pages/GestorUsuarios.jsp").forward(request, response);
            
        } else {
            request.getRequestDispatcher("/SinAcceso.jsp").forward(request, response);
        }
    }


}
