/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.Cajero;
import Objetos.Cliente;
import Objetos.Gerente;
import Objetos.Historial_Cambios;
import Objetos.Limite;
import Objetos.Transaccion;
import ReporteClass.*;
import WDir.Limites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author james
 */
public class GestorReporteGerente {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Historial_Cambios historialHallado;
    Transaccion transaccionHallada;
    Reporte2Gerente repo2Hallado;
    Reporte3Gerente repo3Hallado;
    Reporte4Gerente repo4Hallado;
    Reporte7Gerente repo7Hallado;
    Limite limiteHallado;
    int C = 10;
    /**
     * CONSULTA A DB DEL REPORTE 1
     * @param tipo
     * @return 
     */
    public ArrayList<Historial_Cambios> historialCambios(String tipo, String USER) {
        ArrayList<Historial_Cambios> cambios = new ArrayList<Historial_Cambios>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT h.nombre, h.usuario, h.turno, h. cumple, h.pathdpi, h.dpi, h.direccion, h.sexo, h.fecha FROM historial_cambio h INNER JOIN usuario u ON u.usuario = h.usuario AND u.tipo='"+tipo+"' AND h.gerenteID='"+USER+"'");
            if (!usuarioResultSet.next()) {
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    
                    Historial_Cambios historial=new Historial_Cambios();
                    
                    historial.setCumple(usuarioResultSet.getString("cumple"));
                    historial.setDireccion(usuarioResultSet.getString("direccion"));
                    historial.setDpi(usuarioResultSet.getString("dpi"));
                    historial.setFecha(usuarioResultSet.getString("fecha"));
                    historial.setNombre(usuarioResultSet.getString("nombre"));
                    historial.setSexo(usuarioResultSet.getString("sexo"));
                    historial.setTurno(usuarioResultSet.getString("turno"));
                    historial.setUser(usuarioResultSet.getString("usuario")); 

                    historialHallado = historial;
                    cambios.add(historialHallado);
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
        
    public List<Historial_Cambios> historialCambiosL(String tipo,String gerenteID) {
        List<Historial_Cambios> cambios = new LinkedList<>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct h.nombre, h.usuario, h.turno, h. cumple, h.pathdpi, h.dpi, h.direccion, h.sexo, h.fecha FROM historial_cambio h INNER JOIN usuario u ON u.usuario = h.usuario AND u.tipo='"+tipo+"' AND h.gerenteID='"+gerenteID+"'");
            if (!usuarioResultSet.next()) {
                ConectaBD.cerrar();
                return cambios;
            } else {
                do {
                    
                    Historial_Cambios historial=new Historial_Cambios();
                    
                    historial.setCumple(usuarioResultSet.getString("cumple"));
                    historial.setDireccion(usuarioResultSet.getString("direccion"));
                    historial.setDpi(usuarioResultSet.getString("dpi"));
                    historial.setFecha(usuarioResultSet.getString("fecha"));
                    historial.setNombre(usuarioResultSet.getString("nombre"));
                    historial.setSexo(usuarioResultSet.getString("sexo"));
                    historial.setTurno(usuarioResultSet.getString("turno"));
                    historial.setUser(usuarioResultSet.getString("usuario")); 

                    historialHallado = historial;
                    cambios.add(historialHallado);
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
     * REPORTE 2 GERENTE
     * @param cajero
     * @return 
     */
    public ArrayList<Reporte2Gerente> reporte2(Double limite) {
        
    ArrayList<Reporte2Gerente> repo2 = new ArrayList<Reporte2Gerente>();
    java.time.LocalDate today = java.time.LocalDate.now();
    String fecha=today+"";    
    
        String query = "SELECT t.codigo,t.cuenta,cl.nombre,t.tipo,t.fecha, t.monto  FROM transaccion t INNER JOIN cuenta c ON t.cuenta = c.codigo AND t.monto >= ? INNER JOIN cliente cl ON cl.codigo = c.cliente ORDER BY t.monto DESC";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setDouble(1,  limite);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return repo2; 
            }
            do{
                
                Reporte2Gerente mov= new Reporte2Gerente();                

                mov.setCodigo(result.getString(1));
                mov.setCuenta(result.getString(2));
                mov.setNombre(result.getString(3));
                mov.setTipo(result.getString(4));
                mov.setFecha(result.getString(5));
                mov.setMonto(result.getDouble(6));

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
     * REPORTE3
     * @param limite
     * @return 
     */
    public ArrayList<Reporte3Gerente> reporte3(Double limite) {
        
    ArrayList<Reporte3Gerente> repo3 = new ArrayList<Reporte3Gerente>();
    java.time.LocalDate today = java.time.LocalDate.now();
    String fecha=today+"";    
    
        String query = "SELECT * FROM (SELECT CL.nombre,CL.dpi,SUM(T.monto) AS suma_total FROM transaccion AS T JOIN cliente AS CL JOIN cuenta AS C ON ( T.cuenta = C.codigo AND C.cliente = CL.codigo) GROUP BY CL.codigo ORDER BY suma_total DESC) AS W WHERE W.suma_total > ?";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setDouble(1,  limite);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return repo3; 
            }
            do{
                
                Reporte3Gerente mov= new Reporte3Gerente();                

                mov.setNombre(result.getString(1));
                mov.setDpi(result.getString(2));
                mov.setCantidad(result.getDouble(3));

                repo3Hallado=mov;
                repo3.add(repo3Hallado); 
            } while (result.next());
            preSt.close();

            return repo3;
        }
        } catch (SQLException e) {
            return null;
            
        }

    } 
    /**
     * CONSULTA EL LIMITE ESTABLECIDO
     * @param codigo
     * @return 
     */
    public Limite consultarLimite(String codigo) {
    try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM limites WHERE gerente='" + codigo + "';");

        if (!usuarioResultSet.next()) {

            ConectaBD.cerrar();
            return limiteHallado;
        } else {

            Limite limit= new Limite();

            limit.setLimite2(usuarioResultSet.getDouble("limite2"));

            limiteHallado = limit;
            ConectaBD.cerrar();
            return limiteHallado;
        }
    } catch (Exception e) {
        System.out.println("Error en la base de datos.");
        e.printStackTrace();
        return null;
    }
}

public ArrayList<Reporte4Gerente> reporte4() {

    ArrayList<Reporte4Gerente> repo4 = new ArrayList<Reporte4Gerente>();
    try {        
    conn = ConectaBD.abrir();
            
            stm = conn.createStatement();
            
            usuarioResultSet = stm.executeQuery("SELECT distinct cl.codigo,cl.nombre,cl.dpi,c.codigo,c.credito FROM cliente cl INNER JOIN cuenta c ON cl.codigo = c.cliente  ORDER BY credito DESC LIMIT 10;");
   
            
            
        if (!usuarioResultSet.next()) {
                ConectaBD.cerrar();
                return repo4;
            } else {
                do {
                    
                Reporte4Gerente mov= new Reporte4Gerente();                

                mov.setCodigo(usuarioResultSet.getString("codigo"));
                mov.setNombre(usuarioResultSet.getString("nombre"));
                mov.setDpi(usuarioResultSet.getString("dpi"));
                mov.setCodigoCuenta(usuarioResultSet.getString("c.codigo"));
                mov.setMonto(usuarioResultSet.getDouble("credito"));

                repo4Hallado=mov;
                repo4.add(repo4Hallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return repo4;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
        }

        
    public ArrayList<Cliente> reporte5(String fecha1,String fecha2) {
        ArrayList<Cliente> cambios = new ArrayList<Cliente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinctrow cl.codigo,cl.nombre,cl.sexo,cl.dpi,cl.cumple,cl.direccion from cliente cl INNER JOIN (SELECT * FROM cuenta c WHERE NOT EXISTS (SELECT * FROM transaccion t  WHERE c.codigo = t.cuenta AND t.fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"') ) AS b ON b.cliente = cl.codigo;");
            if (!usuarioResultSet.next()) {
                ConectaBD.cerrar();
                return cambios;
            } else {
                do {
                    
                    Cliente cliente=new Cliente();
                    
                    cliente.setCodigo(usuarioResultSet.getString("codigo"));
                    cliente.setNombre(usuarioResultSet.getString("nombre"));
                    cliente.setSexo(usuarioResultSet.getString("sexo"));
                    cliente.setDpi(usuarioResultSet.getString("dpi"));
                    cliente.setCumple(usuarioResultSet.getString("cumple"));
                    cliente.setDireccion(usuarioResultSet.getString("direccion"));
 

                    clienteHallado = cliente;
                    cambios.add(clienteHallado);
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
    
    public ArrayList<Reporte2Gerente> reporte6(String nombre) {
        
    ArrayList<Reporte2Gerente> repo2 = new ArrayList<Reporte2Gerente>();
    java.time.LocalDate today = java.time.LocalDate.now();
    String fecha=today+"";    
    
        String query = "SELECT t.codigo,t.cuenta,cl.nombre,t.tipo,t.fecha, t.monto  FROM transaccion t INNER JOIN cuenta c ON t.cuenta = c.codigo INNER JOIN cliente cl ON cl.codigo = c.cliente AND cl.nombre like ? ";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  nombre);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte2Gerente mov= new Reporte2Gerente();                

                mov.setCodigo(result.getString(1));
                mov.setCuenta(result.getString(2));
                mov.setNombre(result.getString(3));
                mov.setTipo(result.getString(4));
                mov.setFecha(result.getString(5));
                mov.setMonto(result.getDouble(6));

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
     * REPORTE 7 GERENTE
     * @param fecha1
     * @param fecha2
     * @return 
     */
    public ArrayList<Reporte7Gerente> reporte7(String fecha1, String fecha2) {
        
    ArrayList<Reporte7Gerente> repo7 = new ArrayList<Reporte7Gerente>();
    java.time.LocalDate today = java.time.LocalDate.now();
    String fecha=today+"";    
    
        String query = "SELECT C.codigo,C.nombre,C.dpi,C.direccion,COUNT(T.monto) AS cantidad_transacciones FROM transaccion AS T JOIN cajero AS C ON (C.codigo = T.cajero AND C.codigo != '101' AND T.fecha BETWEEN ? AND ?) GROUP BY T.cajero ORDER BY cantidad_transacciones DESC LIMIT 1;";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  fecha1);
            preSt.setString(2,  fecha2);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte7Gerente mov= new Reporte7Gerente();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setDpi(result.getString(3));
                mov.setDireccion(result.getString(4));
                mov.setTotalTransaccion(result.getString(5));

                repo7Hallado=mov;
                repo7.add(repo7Hallado); 
            } while (result.next());
            preSt.close();

            return repo7;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    

} 