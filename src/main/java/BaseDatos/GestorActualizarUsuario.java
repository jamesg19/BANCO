/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author james
 */
public class GestorActualizarUsuario {
  
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;

    
    public boolean Actualizar_Usuario(String usuario, String password) {
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE usuario SET password = ? WHERE usuario = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, password);
            preSt.setString(2, usuario);
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean Actualizar_Gerente(String codigo, String nombre, 
        String turno, String dpi, String direccion,String sexo, String password) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE gerente SET nombre = ?, turno = ?, dpi = ?, direccion = ? , sexo = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, turno);
            preSt.setString(3, dpi);
            preSt.setString(4, direccion);
            preSt.setString(5, sexo);
            preSt.setString(6, password);
            preSt.setString(7, codigo);
            
            
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
        
    public boolean Actualizar_Cajero(String codigo, String nombre, 
        String turno, String dpi, String direccion,String sexo, String password) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE cajero SET nombre = ?, turno = ?, dpi = ?, direccion = ? , sexo = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, turno);
            preSt.setString(3, dpi);
            preSt.setString(4, direccion);
            preSt.setString(5, sexo);
            preSt.setString(6, password);
            preSt.setString(7, codigo);
            
            
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
    

    public boolean Actualizar_Cliente(String codigo, String nombre, 
        String cumple, String dpi, String direccion,String sexo, String password, InputStream archivoPDF) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();
            
        String query = "UPDATE cliente SET nombre = ?, dpi = ?, cumple = ?, direccion = ? , sexo = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, dpi);
            preSt.setString(3, cumple);
            preSt.setString(4, direccion);
            preSt.setString(5, sexo);
            //preSt.setBlob(6, archivopdf);
            preSt.setString(6, password);
            preSt.setString(7, codigo);
                  
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    } 
    
    
    public boolean Actualizar_ClienteC(String codigo, String nombre, 
        String cumple, String dpi, String direccion,String sexo, String password, InputStream archivoPDF) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();
            
        String query = "UPDATE cliente SET nombre = ?, dpi = ?, cumple = ?, direccion = ? , sexo = ?,pathdpi = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, dpi);
            preSt.setString(3, cumple);
            preSt.setString(4, direccion);
            preSt.setString(5, sexo);
            preSt.setBlob(6, archivoPDF);
            preSt.setString(7, password);
            preSt.setString(8, codigo);
                  
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public Gerente InfoPersonalGerente(String codigo) {
        try {
                conn = ConectaBD.abrir();
                stm = conn.createStatement();
                usuarioResultSet = stm.executeQuery("SELECT * FROM gerente WHERE codigo='" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Gerente gerente1= new Gerente();
                gerente1.setNombre(usuarioResultSet.getString("nombre"));
                gerente1.setTurno(usuarioResultSet.getString("turno")); 
                gerente1.setDpi(usuarioResultSet.getString("dpi"));
                gerente1.setDireccion(usuarioResultSet.getString("direccion"));
                gerente1.setSexo(usuarioResultSet.getString("sexo"));
                gerente1.setPassword(usuarioResultSet.getString("password"));
                
 
                gerenteHallado = gerente1;
                ConectaBD.cerrar();
                return gerenteHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
            
            
    public Cajero InfoPersonalCajero(String codigo) {
        try {
                    conn = ConectaBD.abrir();
                    stm = conn.createStatement();
                    usuarioResultSet = stm.executeQuery("SELECT * FROM cajero WHERE codigo='" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Cajero cajero1= new Cajero();
                cajero1.setNombre(usuarioResultSet.getString("nombre"));
                cajero1.setTurno(usuarioResultSet.getString("turno")); 
                cajero1.setDpi(usuarioResultSet.getString("dpi"));
                cajero1.setDireccion(usuarioResultSet.getString("direccion"));
                cajero1.setSexo(usuarioResultSet.getString("sexo"));
                cajero1.setPassword(usuarioResultSet.getString("password"));
                
 
                cajeroHallado = cajero1;
                ConectaBD.cerrar();
                return cajeroHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
        
        public Cliente InfoPersonalCliente(String codigo) {
            
        try {
                conn = ConectaBD.abrir();
                stm = conn.createStatement();
                usuarioResultSet = stm.executeQuery("SELECT * FROM cliente WHERE codigo='" + codigo + "';");
                
            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Cliente cliente= new Cliente();
                
                cliente.setNombre(usuarioResultSet.getString("nombre"));
                cliente.setCumple(usuarioResultSet.getString("cumple")); 
                cliente.setDpi(usuarioResultSet.getString("dpi"));
                cliente.setDireccion(usuarioResultSet.getString("direccion"));
                cliente.setSexo(usuarioResultSet.getString("sexo"));
                cliente.setPassword(usuarioResultSet.getString("password"));
                
 
                clienteHallado = cliente;
                ConectaBD.cerrar();
                return clienteHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }    
        
    public boolean agregarHistorial(String usuario, String nombre, 
        String turno,String cumple, String dpi, String direccion,String sexo, String fecha, String gerenteID) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "INSERT INTO historial_cambio VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int c=0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, c);
            preSt.setString(2, usuario);
            preSt.setString(3, nombre);
            preSt.setString(4, turno);
            preSt.setString(5, cumple);
            preSt.setString(6, "");
            preSt.setString(7, dpi);
            preSt.setString(8, direccion);
            preSt.setString(9, sexo);
            preSt.setString(10, fecha);
            preSt.setString(11, gerenteID);
                  
            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }   
        
}
