/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditarInfo;

import BaseDatos.GestorActualizarUsuario;
import Objetos.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
@WebServlet(name = "Editar_Mi_InfoCaj", urlPatterns = {"/Editar_Mi_InfoCaj"})
public class Editar_Mi_InfoCaj extends HttpServlet {

    GestorActualizarUsuario gestorBD = new GestorActualizarUsuario();
    Cajero cajero;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);
            
                cajero = gestorBD.InfoPersonalCajero(USER);
                
                request.setAttribute("Direccion", cajero.getDireccion());
                request.setAttribute("Dpi", cajero.getDpi());
                request.setAttribute("Nombre", cajero.getNombre());
                request.setAttribute("Password", cajero.getPassword());
                request.setAttribute("Sexo", cajero.getSexo());
                request.setAttribute("Turno", cajero.getTurno());
                
                request.getRequestDispatcher("/PagesCajero/EditMyInfoCaj.jsp").forward(request, response);
            
            }
            
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
