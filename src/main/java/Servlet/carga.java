/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Base.CajeroDAO;
import Base.ClienteDAO;
import Base.*;
import Base.CuentaDAO;
import Base.GerenteDAO;
import Base.TransaccionDAO;
import Base.UsuarioDAO;
import BaseDatos.ConectaBD;
import DTO.CajeroDTO;
import DTO.ClienteDTO;
import DTO.CuentaDTO;
import DTO.GerenteDTO;
import DTO.TransaccionDTO;
import DTO.UsuarioDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



/**
 *
 * @author james
 */
public class carga extends HttpServlet {

     ConectaBD cn = new ConectaBD("encender");


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        if (request.getParameter("tipo") != null) {
            String tipo = request.getParameter("tipo");
            String s = request.getParameter("test");
            Gson gson = new Gson();
            JsonArray elements = gson.fromJson(s, JsonArray.class);
            String ingresados = "";
            
            
            
            if (tipo.equalsIgnoreCase("1")) {
                for (JsonElement obj : elements) {
                    // Object of array
                    JsonObject gsonObj = obj.getAsJsonObject();
                    // Primitives elements of object
                    String codigo = gsonObj.get("codigo").getAsString();
                    String nombre = encoding(gsonObj.get("nombre").getAsString());
                    String dpi = gsonObj.get("dpi").getAsString();
                    String turno = gsonObj.get("turno").getAsString().toUpperCase();
                    String sexo = gsonObj.get("sexo").getAsString().toUpperCase();
                    String password = gsonObj.get("password").getAsString();
                    String direccion = encoding(gsonObj.get("direccion").getAsString());

                    
                    GerenteDAO gerencia2 = new GerenteDAO();
                    GerenteDTO gerente = new GerenteDTO();
                    
                    
                    
                    
                    gerente.setCodigo(Integer.parseInt(gsonObj.get("codigo").getAsString()));
                    gerente.setNombre(encoding(gsonObj.get("nombre").getAsString()));
                    gerente.setDpi(gsonObj.get("dpi").getAsString());
                    gerente.setTurno(gsonObj.get("turno").getAsString());
                    gerente.setSexo(gsonObj.get("sexo").getAsString().toUpperCase());
                    gerente.setDireccion(gsonObj.get("direccion").getAsString());
                    gerente.setPassword(gsonObj.get("password").getAsString());

                    
/////////////////////
                    
                    if (gerencia2.ingresarGerente(gerente)) {
                        UsuarioDTO usuario = new UsuarioDTO( codigo, password, "GERENTE");
                        UsuarioDAO user = new UsuarioDAO();
                        if (user.ingresarUsuario(usuario)) {
                            ingresados += "Gerente " + codigo + "codigo " + codigo + " \n";
                        } else {
                            ingresados += "Gerente " + codigo + " -No pudo crearse el usuario\n";
                        }
                    } else {
                        ingresados += "Gerente " + codigo + " -No se ingreso a la base de datos\n";
                    }
                }
            } 
            
            
            
            else if (tipo.equalsIgnoreCase("2")) {
                for (JsonElement obj : elements) {
                    // Object of array
                    JsonObject gsonObj = obj.getAsJsonObject();
                    // Primitives elements of object
                    String codigo = gsonObj.get("codigo").getAsString().trim();
                    String nombre = encoding(gsonObj.get("nombre").getAsString());
                    String dpi = gsonObj.get("dpi").getAsString();
                    String turno = gsonObj.get("turno").getAsString();
                    String sexo = gsonObj.get("sexo").getAsString();
                    String password = gsonObj.get("password").getAsString();
                    String direccion = encoding(gsonObj.get("direccion").getAsString());
                    CajeroDAO cajeros = new CajeroDAO();
                    CajeroDTO cajero = new CajeroDTO();

                    cajero.setCodigo(Integer.parseInt(gsonObj.get("codigo").getAsString().trim()));
                    cajero.setNombre(encoding(gsonObj.get("nombre").getAsString().trim()));
                    cajero.setDpi(dpi.trim());
                    cajero.setTurno(turno.toUpperCase());
                    cajero.setSexo(sexo);
                    cajero.setDireccion(direccion);
                    cajero.setPassword(password);
                    //JOptionPane.showMessageDialog(null, codigo+","+nombre+","+dpi+","+turno+","+sexo+","+password);
                    if (cajeros.ingresarCajero(cajero)) {
                        UsuarioDTO usuario = new UsuarioDTO( codigo, password, "CAJERO");
                        UsuarioDAO user = new UsuarioDAO();
                        if (user.ingresarUsuario(usuario)) {
                            ingresados += "Cajero " + codigo + "codigo " + codigo + " \n";
                        } else {
                            ingresados += "Cajero " + codigo + " -No pudo crearse el usuario\n";
                        }
                    } else {
                        ingresados += "Cajero " + codigo + " -No se ingreso a la base de datos\n";
                    }
                }
            } 
            
            else if (tipo.equalsIgnoreCase("3")) {
                //JOptionPane.showMessageDialog(null,"Cliente");
                for (JsonElement obj : elements) {
                    // Object of array
                    JsonObject gsonObj = obj.getAsJsonObject();
                    // Primitives elements of object
                    
                    String codigo = gsonObj.get("codigo1").getAsString();
                    String nombre = encoding(gsonObj.get("nombre").getAsString());
                    String dpi = gsonObj.get("dpi").getAsString();
                    String cumple = gsonObj.get("fecha").getAsString();
                    String sexo = gsonObj.get("sexo").getAsString();
                    String password = gsonObj.get("password").getAsString();
                    String direccion = encoding(gsonObj.get("direccion").getAsString());


                    ClienteDTO cliente = new ClienteDTO(codigo, nombre, dpi,  cumple, direccion, sexo, password);
                    ClienteDAO clientes = new ClienteDAO();
                                    
                    cliente.setArchivoPDF(null);
                    //cliente
                    if (clientes.ingresarCliente(cliente)) {
                        UsuarioDTO usuario = new UsuarioDTO( codigo, password, "CLIENTE");
                        UsuarioDAO user = new UsuarioDAO();
                        //JOptionPane.showMessageDialog(null,carga.class.getResource("Resourrcess/documento.pdf").getPath()); 
                        if (user.ingresarUsuario(usuario)) {
                            ingresados += "Cliente " + codigo + " ID: " + codigo + " \n";
                        } 
                        
                        else {
                            ingresados += "Cliente " + codigo + " -No pudo crear el usuario\n";
                        }
                    } else {
                        ingresados += "Cliente " + codigo + " -No se ingreso el cliente\n";
                    } 
                } 
            }
            
            else if (tipo.equalsIgnoreCase("4")) {
                
                for (JsonElement obj : elements) {
                    // Object of array
                    JsonObject gsonObj = obj.getAsJsonObject();
                    // Primitives elements of object
                    String cliente = gsonObj.get("cliente").getAsString();
                    int codigo = Integer.parseInt(gsonObj.get("codigo").getAsString());
                    String fecha = gsonObj.get("fecha").getAsString();
                    Double monto = gsonObj.get("monto").getAsDouble();
                    
                    CuentaDTO cuenta = new CuentaDTO(codigo, cliente, fecha, monto);
                    CuentaDAO cuentas = new CuentaDAO();
                    
                    if (cuentas.ingresarCuenta(cuenta)) {
                        ingresados += "Cuenta " + codigo + "\n";
                    } else {
                        ingresados += "Cuenta " + codigo + " -No se ingreso a la base de datos\n";
                    }
                }
            } 
            
            else if (tipo.equalsIgnoreCase("5")) {
                for (JsonElement obj : elements) {
                    // Object of array
                    JsonObject gsonObj = obj.getAsJsonObject();
                    // Primitives elements of object
                    int codigo = Integer.parseInt(gsonObj.get("codigo").getAsString());
                    int cuenta = Integer.parseInt(gsonObj.get("cuenta").getAsString());
                    String fecha = gsonObj.get("fecha").getAsString();
                    String hora = gsonObj.get("hora").getAsString();    
                    String tipo_transaccion = gsonObj.get("tipo").getAsString();
                    Double monto = gsonObj.get("monto").getAsDouble();
                    String cajero = gsonObj.get("cajero").getAsString();
                    
///////////////////////////////////////////////////                    
                    TransaccionDAO transaccion = new TransaccionDAO();
                    TransaccionDTO transac = new TransaccionDTO(codigo, cuenta, fecha, hora, tipo_transaccion.toUpperCase(),monto, cajero);
                    
                    
///////////////////////////////////////////////////

//                    if (transaccion.ingresarTransaccion(transac) ) {
//                        ingresados += "Transaccion " + codigo + "\n";
//                    } else {
//                        ingresados += "Transaccion " + codigo + "No se ha guardado\n";
//                    }
                    
                    
                    CuentaDAO cuentas = new CuentaDAO();
                    
                    
                    
                    
                        if (transaccion.ingresarTransaccion(transac)) {
                            
                            if (tipo.equalsIgnoreCase("DEBITO")) {
                                double tempo= (-1.00)*monto;
                                        
                                    if (cuentas.actualizarSaldoMenos(cuenta, tempo)) {
                                        ingresados += "Transaccion " + codigo + "\n";
                                    } else {
                                        ingresados += "Transaccion " + codigo + " -No fue actualizado el saldo de la cuenta\n";
                                    }
                                
                            } else {
                                if (cuentas.actualizarSaldoMas(cuenta, monto)) {
                                    ingresados += "Transaccion " + codigo + "\n";
                                } else {
                                    ingresados += "Transaccion " + codigo + " -No fue actualizado el saldo de la cuenta\n";
                                }
                            }
                        } else {
                            ingresados += "Transaccion " + codigo + " -No fue ingresada a la base de datos\n";
                        }
                    
                
                    
                    

                }
            }
            response.getWriter().write(ingresados);
        } else {
            response.getWriter().write("");
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

    public String encoding(String palabra) throws UnsupportedEncodingException {
        return new String(palabra.getBytes("ISO-8859-1"), "UTF-8");
    }
}
