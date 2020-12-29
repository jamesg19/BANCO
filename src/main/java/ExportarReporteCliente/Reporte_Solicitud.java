/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportarReporteCliente;

import BaseDatos.GestorAsociar;
import BaseDatos.GestorReporteCliente;
import ExportarReporte.*;
import BaseDatos.GestorReporteGerente;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import Objetos.Solicitud;
import Objetos.Transaccion;
import ReporteClass.Reporte1Cliente;
import ReporteClass.Reporte2Gerente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Reporte_Solicitud", urlPatterns = {"/Reporte_Solicitud"})
public class Reporte_Solicitud extends HttpServlet {

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
            
            String USER = request.getParameter("USERR");
            request.setAttribute("USER", USER);        



                ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
                
                GestorAsociar gestor = new GestorAsociar();
                
                solicitud = gestor.verSolicitudesRecibidas(USER);
                
                if ((solicitud != null)) {
                    request.setAttribute("Reporte1", solicitud);

                    request.getRequestDispatcher("/PagesClienteReporte/SolicitudRecibida.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/PagesClienteReporte/Reporte1.jsp").forward(request, response);
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






