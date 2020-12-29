/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import WDir.*;
import BaseDatos.GestorTransaccion;
import BaseDatos.GestorVerInfo;
import Objetos.Cuenta;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Transferenciaa", urlPatterns = {"/Transferenciaa"})
public class TransferirR extends HttpServlet {

    Cuenta cuenta1;
    Cuenta cuenta2;
    String er = null;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String USER = request.getParameter("USERR");
            String CtaOrigen = request.getParameter("origen");
            String CtaDestino = request.getParameter("destino");
            double cantidad = Double.parseDouble(request.getParameter("cantidad"));
            request.setAttribute("USER", USER);
            

            ArrayList<Cuenta> solicitud = new ArrayList<Cuenta>();
            ArrayList<Cuenta> solicitud1 = new ArrayList<Cuenta>();
            GestorVerInfo gestor = new GestorVerInfo();
            GestorVerInfo gestor1 = new GestorVerInfo();
            solicitud = gestor.verCuenta(USER);
            solicitud1 = gestor1.verAsoCuenta(USER);

            //cuando selecciona el mismo codigo de la cuenta
            if (CtaOrigen.equalsIgnoreCase(CtaDestino.trim())) {
                request.setAttribute("Cuenta", solicitud);
                request.setAttribute("Cuenta1", solicitud1);
                String USERa = request.getParameter("USERR");
                request.setAttribute("USER", USERa);
                er = "ERROR";
                request.setAttribute("ESTADO", er);

                request.getRequestDispatcher("/PagesCliente/Transferencia.jsp").forward(request, response);

            } else {

                GestorTransaccion gestorT = new GestorTransaccion();
                GestorTransaccion debitar = new GestorTransaccion();
                GestorTransaccion acreditar = new GestorTransaccion();
                GestorTransaccion transaccionDebito = new GestorTransaccion();
                GestorTransaccion transaccionCredito = new GestorTransaccion();

                cuenta1 = gestorT.consultaSaldo(CtaOrigen);
                cuenta2 = gestorT.consultaSaldo(CtaDestino);
                //verifica si tiene fondos suficientes en la cuenta    
                if (cantidad <= cuenta1.getCredito()) {
                    double total = cuenta1.getCredito() - cantidad;
                    double totAcreditar = cuenta2.getCredito() + cantidad;

                    LocalDateTime locaDate = LocalDateTime.now();
            
                    String hora=locaDate.getHour()+":"+locaDate.getMinute()+":"+locaDate.getSecond();
                    java.time.LocalDate today = java.time.LocalDate.now();
                    
                    debitar.actualizarSaldoCuenta(CtaOrigen, total);
                    acreditar.actualizarSaldoCuenta(CtaDestino, totAcreditar);
                    transaccionDebito.registraTransaccion(CtaOrigen, today.toString(), hora, "DEBITO", cantidad, "101");
                    transaccionCredito.registraTransaccion(CtaDestino, today.toString(), hora, "CREDITO", cantidad, "101");

                    solicitud = gestor.verCuenta(USER);
                    solicitud1 = gestor1.verAsoCuenta(USER);
                    request.setAttribute("Cuenta", solicitud);
                    request.setAttribute("Cuenta1", solicitud1);
                    String USERa = request.getParameter("USERR");
                    request.setAttribute("USER", USERa);
                    request.setAttribute("ESTADO", "AGREGADO");
                    request.getRequestDispatcher("/PagesCliente/Transferencia.jsp").forward(request, response);
                
                } else {
                    solicitud = gestor.verCuenta(USER);
                    solicitud1 = gestor1.verAsoCuenta(USER);
                    request.setAttribute("Cuenta", solicitud);
                    request.setAttribute("Cuenta1", solicitud1);
                    String USERa = request.getParameter("USERR");
                    request.setAttribute("USER", USERa);
                    request.setAttribute("ESTADO", "SINDINERO");
                    request.getRequestDispatcher("/PagesCliente/Transferencia.jsp").forward(request, response);
                    
                    

                }

            }

        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
