/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import BaseDatos.ConectaBD;
import DTO.CuentaDTO;
import DTO.TransaccionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CuentaDAO {
    
    Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    
    public CuentaDAO() {
    }

    public boolean ingresarCuenta(CuentaDTO cuenta){
        String query = "INSERT INTO cuenta  VALUES (?, ?, ?, ?);";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        if(cuenta.getCredito() < 0){
               return false; 
            } 
        try(PreparedStatement ps = conn.prepareStatement(query)){
                        
            ps.setInt(1, cuenta.getCodigo());
            ps.setString(2, cuenta.getCliente());
            ps.setString(3, cuenta.getCreacion());
            ps.setDouble(4, cuenta.getCredito());
            
            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    public boolean actualizarSaldoMas(int cuenta, Double monto){
        
        String sql = "UPDATE cuenta SET credito = credito + ?  WHERE ( codigo = ? )";
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, monto);
            ps.setInt(2, cuenta);
            ps.executeUpdate();
            ingresado = true;
        } catch (Exception e){
            
        }
        return ingresado;
    }
    
    public boolean actualizarSaldoMenos(int cuenta, Double monto){
       
        String sql = "UPDATE cuenta SET credito = credito - ?  WHERE ( codigo = ? )";
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, monto);
            ps.setInt(2, cuenta);
            ps.executeUpdate();
            ingresado = true;
        } catch (Exception e){
            
        }
        return ingresado;
    }
    
    
    
    
}
