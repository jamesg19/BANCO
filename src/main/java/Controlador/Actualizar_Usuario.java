/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.*;
import Objetos.Gerente;
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
@WebServlet(name = "Actualizar_Usuario", urlPatterns = {"/Actualizar_Usuario"})
public class Actualizar_Usuario extends HttpServlet {
Gerente gerente;

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
            
            //recibe los parametros
            String usuario = request.getParameter("usuario");
            String nombre = request.getParameter("nombre");
            String turno = request.getParameter("turno");
            String dpi = request.getParameter("dpi");
            String direccion = request.getParameter("direccion");
            String sexo = request.getParameter("sexo");
            String password = request.getParameter("password");

            String tipo = request.getParameter("tipo");
            String USER = request.getParameter("USER");

            if (tipo.equals("GERENTE")) {
                
                GestorActualizarUsuario gestorBD = new GestorActualizarUsuario();
                java.time.LocalDate today = java.time.LocalDate.now();
                if (gestorBD.Actualizar_Gerente(USER, nombre, turno, dpi, direccion, sexo, password)) {
                    gestorBD.Actualizar_Usuario(USER, password);
                    gestorBD.agregarHistorial(usuario, nombre, turno, "", dpi, direccion, sexo, today.toString(),USER);

                    request.setAttribute("ESTADO", "AGREGADO");
                    request.setAttribute("USER", USER);

                    //carga la informacion actualizada
                    gerente = gestorBD.InfoPersonalGerente(USER);

                    request.setAttribute("Direccion", gerente.getDireccion());
                    request.setAttribute("Dpi", gerente.getDpi());
                    request.setAttribute("Nombre", gerente.getNombre());
                    request.setAttribute("Password", gerente.getPassword());
                    request.setAttribute("Sexo", gerente.getSexo());
                    request.setAttribute("Turno", gerente.getTurno());

                    request.getRequestDispatcher("/PagesGerente/EditMyInfo.jsp").forward(request, response);
                } else {
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/EditMyInfo.jsp").forward(request, response);
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
