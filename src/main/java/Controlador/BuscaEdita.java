/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorActualizarUsuario;
import BaseDatos.GestorCrearUsuarioDB;
import BaseDatos.GestorEditaInfo;
import Objetos.Cajero;
import Objetos.Cliente;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@WebServlet(name = "BuscaInfo", urlPatterns = {"/BuscaInfo"})
@MultipartConfig(maxFileSize = 991772151)    // upload file's size up to 16MB
public class BuscaEdita extends HttpServlet {

    GestorCrearUsuarioDB gestorBD = new GestorCrearUsuarioDB();
    GestorCrearUsuarioDB gestorBD2 = new GestorCrearUsuarioDB();
    String USERG = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String identidad = request.getParameter("identidad");
            String parametro = request.getParameter("parametro");
            String busqueda = request.getParameter("busqueda");
            String tipo = request.getParameter("tipo");
            String USER = request.getParameter("USER");
            USERG = USER;
            request.setAttribute("USER", USER);
            java.time.LocalDate today = java.time.LocalDate.now();

            if (tipo.equalsIgnoreCase("BUSCAR")) {

                if (identidad.equalsIgnoreCase("cliente")) {

                    ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
                    GestorEditaInfo gestor1 = new GestorEditaInfo();
                    clienteList = gestor1.BuscaClienteP(identidad, busqueda, parametro);
                    request.setAttribute("USER", USER);
                    if (clienteList != null) {
                        String b = "Buscaste: '" + busqueda + "' por " + parametro;
                        request.setAttribute("USER", USER);
                        request.setAttribute("USERr", USER);
                        request.setAttribute("Cliente", clienteList);
                        request.setAttribute("Cliente1", clienteList);
                        request.setAttribute("Busqueda", b);
                        request.getRequestDispatcher("/PagesGerente/BuscaEdita.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ESTADO", "NOHAY");
                        request.getRequestDispatcher("/PagesGerente/BuscaEdita.jsp").forward(request, response);
                    }

                } else if (identidad.equalsIgnoreCase("cajero")) {
                    String b = "Buscaste: '" + busqueda + "' por " + parametro;
                    ArrayList<Cajero> cajeroList = new ArrayList<Cajero>();
                    GestorEditaInfo gestor1 = new GestorEditaInfo();
                    cajeroList = gestor1.BuscaCajeroP(identidad, busqueda, parametro);
                    request.setAttribute("USER", USER);
                    if (cajeroList != null) {
                        request.setAttribute("USER", USER);
                        request.setAttribute("USERr", USER);

                        request.setAttribute("Cajero", cajeroList);
                        request.setAttribute("Cajero1", cajeroList);
                        request.setAttribute("Busqueda", b);
                        request.getRequestDispatcher("/PagesGerente/BuscaEdita.jsp").forward(request, response);
                    } else {
                        request.setAttribute("ESTADO", "NOHAY");
                        request.getRequestDispatcher("/PagesGerente/BuscaEdita.jsp").forward(request, response);

                    }
                }

            }

//                if (gestorBD.Actualizar_Limite(USER, minimo, maximo) ) {
//                    
//                    //agrega al cajero
//                    request.setAttribute("USER", USER);
//                    request.setAttribute("ESTADO", "AGREGADO");
//                    request.getRequestDispatcher("/PagesGerente/Limites.jsp").forward(request, response);
//                    
//                } else {
//                    
//                    request.setAttribute("ESTADO", "AGREGADO");
//                    gestorBD2.Registrar_Limite( USER,  minimo,  maximo);
//                    request.setAttribute("USER", USER);
//                    request.getRequestDispatcher("/PagesGerente/Limites.jsp").forward(request, response);
//                }
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
        String num = request.getParameter("num");
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
            String a = request.getParameter("aaa");
            InputStream inputStream = null;
            if (a.equalsIgnoreCase("si")) {
                Part filePart;
                try {

                    filePart = request.getPart("pdf" + num);
                    inputStream = filePart.getInputStream();
                } catch (Exception e) {

                }
            }

            String cumple = request.getParameter("cumple");

            GestorActualizarUsuario gestorBD = new GestorActualizarUsuario();
            GestorActualizarUsuario gestorBD2 = new GestorActualizarUsuario();
            java.time.LocalDate today = java.time.LocalDate.now();
            
            if(a.equalsIgnoreCase("si")){
                
                if (gestorBD.Actualizar_ClienteC(usuario, nombre, cumple, dpi, direccion, sexo, password, inputStream)) {
                gestorBD.Actualizar_Usuario(usuario, password);
                gestorBD2.agregarHistorial(usuario, nombre, "", cumple, dpi, direccion, sexo, today.toString(), USERG);
                request.setAttribute("ESTADO", "AGREGADO");
            } else {
                request.setAttribute("ESTADO", "ERROR");
            }
                
                
            } else if (a.equalsIgnoreCase("no")){
                
            
            
            if (gestorBD.Actualizar_Cliente(usuario, nombre, cumple, dpi, direccion, sexo, password, inputStream)) {
                gestorBD.Actualizar_Usuario(usuario, password);
                gestorBD2.agregarHistorial(usuario, nombre, "", cumple, dpi, direccion, sexo, today.toString(), USERG);
                request.setAttribute("ESTADO", "AGREGADO");
            } else {
                request.setAttribute("ESTADO", "ERROR");
            }
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
