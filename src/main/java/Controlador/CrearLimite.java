/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorCrearUsuarioDB;
import BaseDatos.GestorReporteGerente;
import Objetos.Limite;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "CrearLimite", urlPatterns = {"/CrearLimite"})
public class CrearLimite extends HttpServlet {
GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
GestorCrearUsuarioDB gestorBD2 = new GestorCrearUsuarioDB();
GestorReporteGerente gestor2 = new GestorReporteGerente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        Double minimo = Double.parseDouble(request.getParameter("minimo"));
        Double maximo = Double.parseDouble(request.getParameter("maximo"));
        
        String USER = request.getParameter("USER");
        java.time.LocalDate today = java.time.LocalDate.now();
             
                if (gestorBD.Actualizar_Limite(USER, minimo, maximo) ) {
                    
                    //agrega al cajero
                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "AGREGADO");
                    Limite limit;
                    limit = gestor2.consultarLimite(USER);       
                    Double limiteSuperior=null;
                    limiteSuperior=limit.getLimite2();
                    request.setAttribute("LIMITE", limiteSuperior);
                    request.getRequestDispatcher("/PagesGerente/Limites.jsp").forward(request, response);
                    
                
                } else {
                    
                    request.setAttribute("ESTADO", "AGREGADO");
                    gestorBD2.Registrar_Limite( USER,  minimo,  maximo);
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/Limites.jsp").forward(request, response);
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
