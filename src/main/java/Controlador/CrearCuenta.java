/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorCrearUsuarioDB;
import BaseDatos.GestorVerificar;
import ReporteClass.Libreta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "CrearCuenta", urlPatterns = {"/CrearCuenta"})
public class CrearCuenta extends HttpServlet {
GestorVerificar gestor= new GestorVerificar();
List<Libreta> libreta;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String usuario = request.getParameter("usuario");
        Double credito = Double.parseDouble(request.getParameter("credito"));
        String USER = request.getParameter("USER");
        java.time.LocalDate today = java.time.LocalDate.now();
        
                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
                if (gestorBD.Registrar_Cuenta( usuario,  today.toString(),  credito)) {
                    //agrega al cajero

                    libreta=gestor.libreta(usuario, today.toString(), credito);
                    
                    
                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.setAttribute("CUENTA", libreta);
                    request.getRequestDispatcher("/PagesGerente/CrearCuenta.jsp").forward(request, response);
                } else {
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearCuenta.jsp").forward(request, response);
                }
            
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
