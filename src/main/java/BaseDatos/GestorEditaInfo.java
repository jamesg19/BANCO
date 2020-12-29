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
import Objetos.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author james
 */
public class GestorEditaInfo {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Historial_Cambios historialHallado;
    Transaccion transaccionHallada;
    private double totDep=0;
    private double totRet=0;

    /**
     * 
     * @param identidad
     * @param busqueda
     * @param parametro
     * @return 
     */
    public ArrayList<Cajero> BuscaCajeroP(String identidad, String busqueda, String parametro) {
        
    ArrayList<Cajero> cajero = new ArrayList<Cajero>();
  
        String query = "SELECT * FROM cajero WHERE "+parametro+" LIKE ?;";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    

            
            preSt.setString(1,  "%"+busqueda+"%");
            

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                Cajero mov= new Cajero();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setTurno(result.getString(3));
                mov.setDpi(result.getString(4));
                mov.setDireccion(result.getString(5));
                mov.setSexo(result.getString(6));
                mov.setPassword(result.getString(7));

                cajeroHallado=mov;
                cajero.add(cajeroHallado); 
            } while (result.next());
            preSt.close();
            return cajero;
        }
        } catch (SQLException e) {
            
            return null;  
        }
    }
    
    
    /**
     * Busca un cliente con un parametro establecido por el usuario
     * @param identidad
     * @param busqueda
     * @param parametro
     * @return 
     */
    public ArrayList<Cliente> BuscaClienteP(String identidad, String busqueda, String parametro) {
        
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();
  
        String query = "SELECT * FROM cliente WHERE "+parametro+" LIKE ?;";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    

            preSt.setString(1,  "%"+busqueda+"%");
            //preSt.setString(3,  parametro);

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                Cliente mov= new Cliente();                

                mov.setCodigo(result.getString(1));
                mov.setNombre(result.getString(2));
                mov.setCumple(result.getString(4));
                mov.setDpi(result.getString(3));
                mov.setDireccion(result.getString(5));
                mov.setSexo(result.getString(6));
                
                mov.setPassword(result.getString(8));

                clienteHallado=mov;
                cliente.add(clienteHallado); 
            } while (result.next());
            preSt.close();
            return cliente;
        }
        } catch (SQLException e) {
            
            return null;  
        }
    }
}
