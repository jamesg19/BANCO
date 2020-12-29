/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorActualizarUsuario;
import BaseDatos.GestorAsociar;
import BaseDatos.GestorReporteCajero;
import BaseDatos.GestorTransaccion;
import BaseDatos.GestorVerificar;
import Objetos.Cliente;
import Objetos.Cuenta;
import Objetos.Gerente;
import Objetos.Historial_Cambios;
import Objetos.Solicitud;
import Objetos.Transaccion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "VerificarCuenta", urlPatterns = {"/VerificarCuenta"})
public class Asociar extends HttpServlet {

    GestorAsociar gestor = new GestorAsociar();
    GestorAsociar existe = new GestorAsociar();
    GestorAsociar registra = new GestorAsociar();
    GestorTransaccion dep = new GestorTransaccion();
    GestorVerificar verifica1 = new GestorVerificar();

    GestorAsociar gestor2 = new GestorAsociar();
    GestorAsociar gestor3 = new GestorAsociar();
    Cliente cliente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String tipo = request.getParameter("tipo");
            String USER = request.getParameter("USER");
            request.setAttribute("USER", USER);
            int cuenta = Integer.parseInt(request.getParameter("cuenta"));

            if (tipo.equals("BUSCAR")) {

                //verificar que esta cuenta no sea de su propiedad
                if (gestor.verificarPropiedadCuenta(cuenta, USER) == true) {

                    request.setAttribute("ESTADO", "ERROR");
                    request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                } else {

                    //verificar si existe
                    if (existe.verificarExisteCuenta(cuenta)) {

                        //verifica si ya esta asociada
                        if (verifica1.existeAsociacion(cuenta, USER)==1) {
                            request.setAttribute("ESTADO", "ASOCIADA");
                            request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                        } //SINO esta asociada entonces verifica cantidad de 
                        //solicitudes enviadas
                        else {
                            //verifica si esta pendiente
                            if (verifica1.pendienteAsociacion(cuenta, USER)==1) {

                                request.setAttribute("ESTADO", "PENDIENTE");
                                request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                            } else {

                                //verifica cuantas solicitudes enviadas hay
                                if (verifica1.cantidadEnviada(cuenta, USER) < 3) {
                                    
                                    //MOSTRAR INFO DE LA CUENTA y cliente QUE SE VA ASOCIAR
                                    cliente = gestor2.consultaInfoCuenta(cuenta);
                                    request.setAttribute("CLIENTE", cliente);
                                    request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                                } else {

                                    request.setAttribute("USER", USER);
                                    request.setAttribute("ESTADO", "MAXIMO");
                                    request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);
                                }

                            }

//                        //MOSTRAR INFO DE LA CUENTA y cliente QUE SE VA ASOCIAR
//                        cliente = gestor2.consultaInfoCuenta(cuenta);
//                        request.setAttribute("CLIENTE", cliente);
//
//                        request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);
                        }

                    } else {
                        request.setAttribute("USER", USER);
                        request.setAttribute("ESTADO", "NO");
                        request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                    }

                }

            } else if (tipo.equals("ASOCIA")) {
                String clienteRe = request.getParameter("clienteRe");
                //registra la solicitud en la DB
                if (gestor3.registraSolicitud(cuenta, USER, clienteRe)) {
                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);

                } else {
                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "ERROR");
                    request.getRequestDispatcher("/PagesCliente/Asociar.jsp").forward(request, response);
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
