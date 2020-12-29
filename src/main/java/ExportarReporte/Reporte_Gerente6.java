/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExportarReporte;

import Controlador.*;
import BaseDatos.GestorActualizarUsuario;
import BaseDatos.GestorCrearUsuarioDB;
import BaseDatos.GestorEditaInfo;
import BaseDatos.GestorReporteGerente;
import Objetos.Cajero;
import Objetos.Cliente;
import Objetos.Transaccion;
import ReporteClass.Reporte2Gerente;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
@WebServlet(name = "Reporte_Gerente6", urlPatterns = {"/Reporte_Gerente6"})
public class Reporte_Gerente6 extends HttpServlet {

    ArrayList<Reporte2Gerente> clienteList = new ArrayList<Reporte2Gerente>();
    GestorReporteGerente gestor1 = new GestorReporteGerente();
    String USERG = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            
            String busqueda = request.getParameter("busqueda");
            String tipo = request.getParameter("tipo");
            String USER = request.getParameter("USER");
            USERG = USER;
            request.setAttribute("USER", USER);
            java.time.LocalDate today = java.time.LocalDate.now();

            if (tipo.equalsIgnoreCase("BUSCAR")) {

                

                    
                    clienteList = gestor1.reporte6(busqueda);
                    request.setAttribute("USER", USER);
                    if (clienteList != null) {
                        
                        request.setAttribute("USER", USER);
                        request.setAttribute("USERRR", USER);
                        request.setAttribute("BUSQUEDA", busqueda);
                        request.setAttribute("Cajero", clienteList);
                        request.getRequestDispatcher("/PagesGerenteReporte/Reporte6.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ESTADO", "ERROR");
                        request.getRequestDispatcher("/PagesGerenteReporte/Reporte6.jsp").forward(request, response);
                    }

                
                    
                

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

        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String dpi = request.getParameter("dpi");
        String direccion = request.getParameter("direccion");
        String sexo = request.getParameter("sexo");
        String password = request.getParameter("password");
        String tipoI = request.getParameter("tipoI");
        Cajero cajero;

        if (tipoI.equalsIgnoreCase("CAJERO")) {

            String turno = request.getParameter("turno");

            GestorActualizarUsuario gestorBD = new GestorActualizarUsuario();
            java.time.LocalDate today = java.time.LocalDate.now();
            if (gestorBD.Actualizar_Cajero(usuario, nombre, turno, dpi, direccion, sexo, password)) {
                gestorBD.Actualizar_Usuario(usuario, password);
                gestorBD.agregarHistorial(usuario, nombre, turno, "", dpi, direccion, sexo, today.toString(), USERG);
                request.setAttribute("AGREGADO", "SE HA ACTUALIZADO CORRECTAMENTE");
            } else {
                request.setAttribute("ERROR", "NO SE PUDO ACTUALIZAR LA INFORMACION");
            }
        } else if (tipoI.equalsIgnoreCase("CLIENTE")) {
            String cumple = request.getParameter("cumple");
            InputStream inputStream = null;

            GestorActualizarUsuario gestorBD = new GestorActualizarUsuario();
            java.time.LocalDate today = java.time.LocalDate.now();
            if (gestorBD.Actualizar_Cliente(usuario, nombre, cumple, dpi, direccion, sexo, password, inputStream)) {
                gestorBD.Actualizar_Usuario(usuario, password);
                gestorBD.agregarHistorial(usuario, nombre, "", cumple, dpi, direccion, sexo, today.toString(), USERG);

            } else {
                request.setAttribute("ERROR", "NO SE PUDO ACTUALIZAR LA INFORMACION");
            }
        }

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
