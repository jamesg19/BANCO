/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDatos.GestorLoginDB;
import Objetos.Usuario;
import ReporteClass.Horario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{

        } catch(Exception e){
            System.out.println(e);
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
        //request.getRequestDispatcher("/PagesGerente/InicioGerente.jsp").forward(request, response);

        Usuario usuario;
        Horario horario;
        Horario tiempo;
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        

        GestorLoginDB gestorBD = new GestorLoginDB();
        GestorLoginDB gestorBD2 = new GestorLoginDB();
        GestorLoginDB gestorBD3 = new GestorLoginDB();
        GestorLoginDB gestorBD4 = new GestorLoginDB();
        usuario = gestorBD.consultar(username, password);
        
        if (usuario != null) {
            horario=gestorBD2.consultarJornada(username, usuario.getTipo().toLowerCase().trim());
            request.setAttribute("codigo", usuario.getCodigo());
            request.setAttribute("USER", username);
            request.setAttribute("tipo", usuario.getTipo());
            //request.setAttribute("horario",horario.getHorario());
            String tipo =usuario.getTipo();
            
            LocalDateTime locaDate = LocalDateTime.now();
            String hora = locaDate.getHour() + ":" + locaDate.getMinute()+ ":00";
            switch (tipo) {
            case "GERENTE": 
                
                if(gestorBD4.Disponible(horario.getHorario(), hora)){
                    
                    request.getRequestDispatcher("/PagesGerente/CrearGerente.jsp").forward(request, response); 
                } else{
                    request.getRequestDispatcher("/PagesGerente/SINTURNO.jsp").forward(request, response); 
                }
                
                break; 
            case "CLIENTE": 
                request.getRequestDispatcher("/PagesCliente/InicioCliente.jsp").forward(request, response); 
                
                break; 
            case "CAJERO": 
                if(gestorBD4.Disponible(horario.getHorario(), hora)){
                 request.getRequestDispatcher("/PagesCajero/InicioCajero.jsp").forward(request, response); 
                } else{
                    request.getRequestDispatcher("/PagesCajero/SINTURNO.jsp").forward(request, response); 
                }
                 break; 
            default: 
                System.out.println("no match"); 
        }
        } else {
            request.setAttribute("ERROR", "error");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
 
    }

}
