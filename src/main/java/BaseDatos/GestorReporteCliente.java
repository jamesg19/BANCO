/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.Cajero;
import Objetos.Cliente;
import Objetos.Cuenta;
import Objetos.Gerente;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import Objetos.Transaccion;
import ReporteClass.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author james
 */
public class GestorReporteCliente {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Historial_Cambios historialHallado;
    Transaccion transaccionHallada;
    Reporte2Cliente repo2Hallado;
    Reporte4Cliente repo4Hallado;
    Reporte1Cliente repor1ClienteHallado;
    Cuenta cuentaHallada;
    Limite limiteHallado;
    int C = 10;
    
    public ArrayList<Reporte2Cliente> reporte2(String USER,String fecha1, String fecha2) {
        
    ArrayList<Reporte2Cliente> repo2 = new ArrayList<Reporte2Cliente>();

        String query = "SELECT T.* FROM transaccion AS T JOIN cliente AS CL JOIN cuenta AS C ON (CL.codigo = C.cliente AND T.cuenta = C.codigo AND CL.codigo = ? AND T.fecha BETWEEN ? AND ? ) ORDER BY T.fecha";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);
            preSt.setString(2,  fecha1);
            preSt.setString(3,  fecha2);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return repo2; 
            }
            do{
                
                Reporte2Cliente mov= new Reporte2Cliente();                

                mov.setCodigo(result.getString(1));
                mov.setCuenta(result.getString(2));
                mov.setFecha(result.getString(3));
                mov.setHora(result.getString(4));
                mov.setTipo(result.getString(5));
                mov.setMonto(result.getString(6));
                mov.setCajero(result.getString(7));

                repo2Hallado=mov;
                repo2.add(repo2Hallado); 
            } while (result.next());
            preSt.close();

            return repo2;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    
    
    
    
    /**
     * REPORTE 1 CLIENTE
     * @param tipo
     * @return 
     */
    public ArrayList<Reporte1Cliente> reporte1Cliente(String tipo) {
        
        ArrayList<Reporte1Cliente> cambios = new ArrayList<Reporte1Cliente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct c.codigo,c.cliente,t.fecha,t.monto,t.tipo FROM cuenta c INNER JOIN transaccion t ON c.codigo=t.cuenta AND c.cliente='"+tipo+"'  ORDER BY monto DESC LIMIT 15");
            if (!usuarioResultSet.next()) {
                ConectaBD.cerrar();
                return cambios;
            } else {
                do {
                    
                    Reporte1Cliente historial=new Reporte1Cliente();
                    
                    historial.setCodigo(usuarioResultSet.getString("c.codigo"));
                    historial.setCliente(usuarioResultSet.getString("c.cliente"));
                    historial.setFecha(usuarioResultSet.getString("t.fecha"));
                    historial.setMonto(usuarioResultSet.getString("t.monto"));
                    historial.setTipo(usuarioResultSet.getString("t.tipo"));


                    repor1ClienteHallado = historial;
                    cambios.add(repor1ClienteHallado);
                    
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return cambios;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    
        
    /**
     * REPORTE 4 CLIENTE
     * @param cajero
     * @return 
     */
    public ArrayList<Reporte4Cliente> reporte4(String USER) {
        
    ArrayList<Reporte4Cliente> repo4 = new ArrayList<Reporte4Cliente>();

    
        String query = "SELECT c.codigo,c.nombre,c.dpi, a.cuenta,a.estado FROM cliente c INNER JOIN asociacion a on a.clienteRe= ? AND a.cliente=c.codigo";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte4Cliente mov= new Reporte4Cliente();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setDpi(result.getString(3));
                mov.setCuenta(result.getString(4));
                mov.setEstado(result.getString(5));

                repo4Hallado=mov;
                repo4.add(repo4Hallado); 
            } while (result.next());
            preSt.close();

            return repo4;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }  
    public Cuenta reporte3A(String USER) {
        
        String query = "SELECT * FROM cuenta C WHERE C.cliente= ? ORDER BY C.credito DESC LIMIT 1;";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Cuenta mov= new Cuenta();                

                mov.setCodigo(result.getString(1));
                mov.setCodCliente(result.getString(2));
                mov.setCreada(result.getString(3));
                mov.setCredito(result.getDouble(4));

                cuentaHallada=mov;
                 
            } while (result.next());
            preSt.close();
            
            return cuentaHallada;
        }
        } catch (SQLException e) {
            
            return null;
            
        }

    }
    
    public ArrayList<Transaccion> reporte3B(String codigo,String fecha1, String fecha2) {
        
    ArrayList<Transaccion> transaccion = new ArrayList<Transaccion>();

    
        String query = "SELECT * FROM transaccion T WHERE T.cuenta = ? AND T.fecha BETWEEN ? AND ?";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  codigo);
            preSt.setString(2,  fecha1);
            preSt.setString(3,  fecha2);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Transaccion mov= new Transaccion();                

                mov.setCodigo(result.getString(1));
                mov.setCuentaID(result.getString(2));
                mov.setFecha(result.getString(3));
                mov.setHora(result.getString(4));
                mov.setTipo(result.getString(5));
                mov.setMonto(result.getDouble(6));
                mov.setCajeroID(result.getString(7));

                transaccionHallada=mov;
                transaccion.add(transaccionHallada); 
            } while (result.next());
            preSt.close();

            return transaccion;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    
    
    public ArrayList<Reporte4Cliente> reporte5(String USER) {
        
    ArrayList<Reporte4Cliente> repo4 = new ArrayList<Reporte4Cliente>();

    
        String query = "SELECT c.codigo,c.nombre,c.dpi, a.cuenta,a.estado FROM cliente c INNER JOIN asociacion a on a.cliente= ? AND a.clienteRe=c.codigo";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte4Cliente mov= new Reporte4Cliente();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setDpi(result.getString(3));
                mov.setCuenta(result.getString(4));
                mov.setEstado(result.getString(5));

                repo4Hallado=mov;
                repo4.add(repo4Hallado); 
            } while (result.next());
            preSt.close();

            return repo4;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    
    public ArrayList<Reporte4Cliente> cuentasDepositarAsociadas(String USER) {
        
    ArrayList<Reporte4Cliente> repo4 = new ArrayList<Reporte4Cliente>();

    
        String query = "SELECT c.codigo,c.nombre,c.dpi, a.cuenta,a.estado FROM cliente c INNER JOIN asociacion a on a.cliente= ? AND a.clienteRe=c.codigo";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte4Cliente mov= new Reporte4Cliente();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setDpi(result.getString(3));
                mov.setCuenta(result.getString(4));
                mov.setEstado(result.getString(5));

                repo4Hallado=mov;
                repo4.add(repo4Hallado); 
            } while (result.next());
            preSt.close();

            return repo4;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    
} 
     