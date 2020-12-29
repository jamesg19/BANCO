/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class GestorVerInfo {

    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Cuenta cuentaHallada;



    public ArrayList<Gerente> verGerente() {
        ArrayList<Gerente> clientee = new ArrayList<Gerente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM gerente ORDER BY nombre ASC");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Gerente solic = new Gerente();

                    solic.setNombre(usuarioResultSet.getString("nombre"));
                    solic.setDpi(usuarioResultSet.getString("dpi"));
                    solic.setSexo(usuarioResultSet.getString("sexo"));
                    solic.setDireccion(usuarioResultSet.getString("direccion"));
                    solic.setCodigo(usuarioResultSet.getString("codigo"));
                    solic.setTurno(usuarioResultSet.getString("turno"));

                    gerenteHallado = solic;
                    clientee.add(gerenteHallado);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }

    public ArrayList<Cajero> verCajero() {
        ArrayList<Cajero> clientee = new ArrayList<Cajero>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM cajero ORDER BY nombre ASC");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Cajero solic = new Cajero();

                    solic.setNombre(usuarioResultSet.getString("nombre"));
                    solic.setDpi(usuarioResultSet.getString("dpi"));
                    solic.setSexo(usuarioResultSet.getString("sexo"));
                    solic.setDireccion(usuarioResultSet.getString("direccion"));
                    solic.setCodigo(usuarioResultSet.getString("codigo"));
                    solic.setTurno(usuarioResultSet.getString("turno"));

                    cajeroHallado = solic;
                    clientee.add(cajeroHallado);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }

    public ArrayList<Cliente> verCliente() {
        ArrayList<Cliente> clientee = new ArrayList<Cliente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM cliente ORDER BY nombre ASC");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Cliente solic = new Cliente();

                    solic.setNombre(usuarioResultSet.getString("nombre"));
                    solic.setDpi(usuarioResultSet.getString("dpi"));
                    solic.setSexo(usuarioResultSet.getString("sexo"));
                    solic.setDireccion(usuarioResultSet.getString("direccion"));
                    solic.setCodigo(usuarioResultSet.getString("codigo"));
                    solic.setCumple(usuarioResultSet.getString("cumple"));

                    clienteHallado = solic;
                    clientee.add(clienteHallado);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }
    
    public ArrayList<Cuenta> verCuenta(String cliente) {
        ArrayList<Cuenta> clientee = new ArrayList<Cuenta>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM cuenta WHERE cliente = '"+cliente+"'");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Cuenta solic = new Cuenta();

                    solic.setCodigo(usuarioResultSet.getString("codigo"));
                    solic.setCodCliente(usuarioResultSet.getString("cliente"));
                    solic.setCreada(usuarioResultSet.getString("creada"));
                    solic.setCredito(usuarioResultSet.getDouble("credito"));

                    cuentaHallada = solic;
                    clientee.add(cuentaHallada);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }
    public ArrayList<Cuenta>  verAsoCuenta(String cliente) {
        
    ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
  
        String query = "SELECT a.cuenta,c.nombre,c.codigo  FROM cliente c INNER JOIN asociacion a on a.cliente= ? AND a.clienteRe=c.codigo";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    

            
            preSt.setString(1, cliente);
            

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                Cuenta mov= new Cuenta();                

                mov.setCodigo(result.getString(1));
                mov.setCreada(result.getString(2));
                mov.setCodCliente(result.getString(3));

                cuentaHallada=mov;
                cuenta.add(cuentaHallada); 
            } while (result.next());
            preSt.close();
            return cuenta;
        }
        } catch (SQLException e) {
            
            return null;  
        }
    }

    
    

}
