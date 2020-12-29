/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.Asociacion;
import Objetos.Cuenta;
import ReporteClass.Libreta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class GestorVerificar {
    Libreta libretaHallada;
    Connection conn = null;

    /**
     * Verifica si hay un cajero con el DPI indicado por parametro
     * @param dpi
     * @return
     */
    public boolean verificarDPIGe(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM gerente WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);

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
    /**
     * Verifica si hay un cajero con el DPI indicado por parametro
     * @param dpi
     * @return 
     */
    public boolean verificarDPICaj(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM cajero WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);

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
    
    /**
     * Verifica si hay un cliente con el DPI indicado por parametro
     * @param dpi
     * @return 
     */
    public boolean verificarDPIClie(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM cliente WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);

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
    
    /**
     * Verifica si el usuario ya esta ingresado
     * @param dpi
     * @return 
     */
    public boolean verificaUSER(String usuario) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM usuario WHERE usuario = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, usuario);

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
    
    
    public boolean verificaDATOS() {
        
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM usuario U WHERE U.tipo = ?";
        String tipo="GERENTE";
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, tipo);

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



    /**
     * Verifica si ya existe una asociacion
     * @param cuenta
     * @param cliente
     * @return booleano
     */
    public int existeAsociacion(int cuenta, String cliente) {

        int cant=0;

        String query = "SELECT * FROM asociacion WHERE cuenta = ? AND cliente = ? and estado = ?";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setInt(1,  cuenta);
            preSt.setString(2,  cliente);
            preSt.setString(3,  "ACEPTADO");

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return cant; 
            }
            do{ 
                cant=1;
                
            } while (result.next());
            preSt.close();

            return cant;
        }
        } catch (SQLException e) {
            return cant;
            
        }
    }

    /**
     * vERIFICA SI LA ASOCIACION ESTA PENDIENTE
     * @param cuenta
     * @param cliente
     * @return 
     */
        public int pendienteAsociacion(int cuenta, String cliente) {

        int cant=0;

        String query = "SELECT * FROM asociacion WHERE cuenta = ? AND cliente = ? and estado = ?";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setInt(1,  cuenta);
            preSt.setString(2,  cliente);
            preSt.setString(3,  "PENDIENTE");

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return cant; 
            }
            do{ 
                cant=1;
                
            } while (result.next());
            preSt.close();

            return cant;
        }
        } catch (SQLException e) {
            return cant;
            
        }
    }

    
    
    
    
    public int cantidadEnviada(int cuenta, String cliente) {
        
    int cant=0;

        String query = "SELECT count(*) AS CANTIDAD FROM asociacion WHERE cuenta = ? AND cliente = ? and estado = ?";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setInt(1,  cuenta);
            preSt.setString(2,  cliente);
            preSt.setString(3,  "RECHAZADO");

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return cant; 
            }
            do{ 
                cant=result.getInt(1);

            } while (result.next());
            preSt.close();

            return cant;
        }
        } catch (SQLException e) {
            return cant;
            
        }

    } 
    public ArrayList<Libreta> libreta(String cliente, String fecha, double saldo) {
        ArrayList<Libreta> lib = new ArrayList<Libreta>();
        String query = "SELECT C.codigo,C.creada,C.credito,CL.nombre FROM cuenta AS C JOIN cliente AS CL ON (C.cliente= ? AND C.cliente=CL.codigo AND C.creada=? AND C.credito=?) LIMIT 1";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(2,  fecha);
            preSt.setDouble(3,  saldo);
            preSt.setString(1,  cliente);


        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Libreta mov= new Libreta();                

                mov.setCodigo(result.getString(1));
                mov.setFecha(result.getString(2));
                mov.setSaldo(result.getDouble(3));
                mov.setNombre(result.getString(4));
                mov.setCodCliente(cliente);

                libretaHallada=mov;
                 lib.add(mov);
            } while (result.next());
            preSt.close();
            
            return lib;
        }
        } catch (SQLException e) {
            
            return null;
            
        }

    }
    
    
    
    
    

}
