/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorCrearUsuarioDB;
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
@WebServlet(name = "EditaInfo", urlPatterns = {"/EditaInfo"})
public class EditaInfo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
//            java.time.LocalDate today = java.time.LocalDate.now();
//            //recibe los parametros
//            String usuario = request.getParameter("usuario");
//            String nombre = request.getParameter("nombre");
//            String turno = request.getParameter("turno");
//            String dpi = request.getParameter("dpi");
//            String direccion = request.getParameter("direccion");
//            String sexo = request.getParameter("sexo");
//            String password = request.getParameter("password");
//            String tipo = request.getParameter("tipo");
//            String USER = request.getParameter("USER");
//
//            if (tipo.equals("GERENTE")) {
//
//                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
//                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)) {
//                    //agrega al gerente
//                    gestorBD.Registrar_Gerente(usuario, password, tipo, nombre, turno, dpi, direccion, sexo);
//
//                    request.setAttribute("ESTADO", "AGREGADO");
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("ESTADO", "ERROR");
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response);
//                }
//            } else if (tipo.equals("CAJERO")) {
//
//                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
//                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)) {
//                    //agrega al cajero
//                    gestorBD.Registrar_Cajero(usuario, password, tipo, nombre, turno, dpi, direccion, sexo);
//                    request.setAttribute("USER", USER);
//                    request.setAttribute("ESTADO", "AGREGADO");
//                    request.getRequestDispatcher("/PagesGerente/CrearCajero.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("ESTADO", "ERROR");
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/CrearCajero.jsp").forward(request, response);
//                }
//            } else if (tipo.equals("CLIENTE")) {
//                String cumple = request.getParameter("cumple");
//                String pdf = request.getParameter("pdf");
//                Double credito = Double.parseDouble(request.getParameter("credito"));
//
//                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
//                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)
//                        && gestorBD.Registrar_Cliente(usuario, password, tipo, nombre, dpi, direccion, sexo, cumple, pdf)) {
//
//                    //agrega la cuenta
//                    gestorBD.Registrar_Cuenta(usuario, today.toString(), credito);
//
//                    request.setAttribute("ESTADO", "AGREGADO");
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/CrearCliente.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("ESTADO", "ERROR");
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/CrearCliente.jsp").forward(request, response);
//                }
//            }
//
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
    
