/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorActualizarUsuario;
import BaseDatos.GestorTransaccion;
import Objetos.Cliente;
import Objetos.Cuenta;
import Objetos.Gerente;
import Objetos.Historial_Cambios;
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
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
@WebServlet(name = "Deposit", urlPatterns = {"/Deposit"})
public class Deposit extends HttpServlet {

    GestorTransaccion gestor = new GestorTransaccion();
    GestorTransaccion dep = new GestorTransaccion();
    GestorTransaccion dep2 = new GestorTransaccion();
    GestorTransaccion dep3 = new GestorTransaccion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String tipo = request.getParameter("tipo");
            String USER = request.getParameter("USER");
            request.setAttribute("USER", USER);
            String cuenta = request.getParameter("cuenta");
            
            if(tipo.equals("BUSCAR")){
            
            ArrayList<Cliente> cambios = new ArrayList<Cliente>();
            
            cambios=gestor.validarCuenta(cuenta);
        
                if (cambios != null ) {

                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "");
                    request.setAttribute("CLIENTE", cambios);
                    request.getRequestDispatcher("/PagesCajero/Depositar.jsp").forward(request, response);
                    
                } else {
                    
                    request.setAttribute("ESTADO", " ");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesCajero/Depositar.jsp").forward(request, response);
                }
                
            }
            
            else if(tipo.equals("DEPOSITO")){
            Double monto=null;
            monto =Double.parseDouble(request.getParameter("monto"));
            
            Cuenta account = new Cuenta();
            account=dep.consultaSaldo(cuenta);
            
            Double creditoActual=account.getCredito();
            //es deposito se suma
            Double Total=creditoActual+monto;
            
            LocalDateTime locaDate = LocalDateTime.now();
            
            String hora=locaDate.getHour()+":"+locaDate.getMinute();
            java.time.LocalDate today = java.time.LocalDate.now();
            
            
                if (account != null ) {
                    dep2.actualizarSaldoCuenta(cuenta, Total);
                    dep3.registraTransaccion(cuenta, today.toString(), hora, "CREDITO", monto, USER);
                    
                    
                    request.setAttribute("USER", USER);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.getRequestDispatcher("/PagesCajero/Depositar.jsp").forward(request, response);
                    
                } else {
                    
                    request.setAttribute("ESTADO", "ERROR");
                    request.setAttribute("USER", USER);
                    request.getRequestDispatcher("/PagesCajero/Depositar.jsp").forward(request, response);
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
