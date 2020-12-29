/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorCrearUsuarioDB;
import BaseDatos.GestorVerificar;
import ReporteClass.Libreta;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState.Final;

/**
 *
 * @author james
 */
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
@MultipartConfig(maxFileSize = 991772151)    // upload file's size up to 16MB
public class CrearUsuario extends HttpServlet {
GestorVerificar verifica1 = new GestorVerificar();
GestorVerificar verifica2 = new GestorVerificar();
GestorVerificar verifica3 = new GestorVerificar();
GestorVerificar verificaLibreta= new GestorVerificar();
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
            java.time.LocalDate today = java.time.LocalDate.now();
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

            if (verifica1.verificarDPICaj(dpi) || verifica2.verificarDPIGe(dpi) || verifica3.verificarDPIClie(dpi)) {
            request.setAttribute("ESTADO", "ERROR");
            request.setAttribute("USER", USER);
            request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response);
            
            }else{
            if (tipo.equals("GERENTE")) {

                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
                GestorCrearUsuarioDB limite = new GestorCrearUsuarioDB();

                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)) {
                    //agrega al gerente
                    gestorBD.Registrar_Gerente(usuario, password, tipo, nombre, turno, dpi, direccion, sexo);
                    limite.Registrar_Limite(usuario, 0, 1000);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response);
                } else {
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response);
                }
            } else if (tipo.equals("CAJERO")) {

                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)) {
                    //agrega al gerente
                    gestorBD.Registrar_Cajero(usuario, password, tipo, nombre, turno, dpi, direccion, sexo);

                    request.setAttribute("ESTADO", "AGREGADO");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearCajero.jsp").forward(request, response);
                } else {
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearCajero.jsp").forward(request, response);
                }
            } else if (tipo.equals("CLIENTE")) {

                String cumple = request.getParameter("cumple");
                //recibe el archivo
                InputStream inputStream = null;
                Part filePart = request.getPart("pdf");
                inputStream = filePart.getInputStream();
                
                
                //recibe el credito a depositar
                Double credito = Double.parseDouble(request.getParameter("credito"));

                GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
                if (gestorBD.Registrar_Usuario(usuario, password, tipo, nombre, turno, dpi, direccion, sexo)) {
                    
                    if(gestorBD.Registrar_Cliente(usuario, password, tipo, nombre, dpi, direccion, sexo, cumple, inputStream)
                            && gestorBD.Registrar_Cuenta(usuario, today.toString(), credito) ){  
                      //agrega la cuenta
                    //gestorBD.Registrar_Cuenta(usuario, today.toString(), credito);
                    libreta=verificaLibreta.libreta(usuario, today.toString(), credito);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.setAttribute("CUENTA", libreta);
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearCliente.jsp").forward(request, response);  
 
                    }
                    
                } else {
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesGerente/CrearCliente.jsp").forward(request, response);
                }
                
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
