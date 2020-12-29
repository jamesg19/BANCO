/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportarReporteCajero;

import BaseDatos.GestorReporteCajero;
import ExportarReporte.*;
import BaseDatos.GestorReporteGerente;
import Objetos.Cliente;
import Objetos.Historial_Cambios;
import ReporteClass.Reporte2CajeroO;
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
 * @author James
 */
@WebServlet(name = "Reporte_Cajero2", urlPatterns = {"/Reporte_Cajero2"})
public class Reporte_Cajero2 extends HttpServlet {

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
            String fecha1 = request.getParameter("fecha1");
            String fecha2 = request.getParameter("fecha2");
            request.setAttribute("t", fecha1);
            request.setAttribute("s", fecha2);
            
                ArrayList<Reporte2CajeroO> cambios = new ArrayList<Reporte2CajeroO>();
                
                GestorReporteCajero gestor = new GestorReporteCajero();
                
                cambios = gestor.Reporte2(USER,fecha1, fecha2);

                if ((cambios != null)) {
                    request.setAttribute("Cliente", cambios);

                    request.getRequestDispatcher("/PagesCajeroReporte/Reporte2.jsp").forward(request, response);
                } else {
                    request.setAttribute("Cliente", cambios);
                    request.getRequestDispatcher("/PagesCajeroReporte/Reporte2.jsp").forward(request, response);
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






