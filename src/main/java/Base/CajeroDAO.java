/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import BaseDatos.ConectaBD;
import DTO.CajeroDTO;
import DTO.GerenteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class CajeroDAO {
    
    Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    
    

    public CajeroDAO() {
    }
    
    
    
    public boolean ingresarCajero(CajeroDTO cajero){
        String sql = "INSERT INTO cajero VALUES (?,?,?,?,?,?,?)";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            int c =  cajero.getCodigo();
            
            String m= c+"";
                        
            ps.setString(1, m);
            ps.setString(2, cajero.getNombre());
            ps.setString(3, cajero.getTurno()); 
            ps.setString(4, cajero.getDpi());
            ps.setString(5, cajero.getDireccion());
            ps.setString(6, cajero.getSexo());
            ps.setString(7, cajero.getPassword());

            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){
//        JOptionPane.showMessageDialog(null, sqle);
        }
        return ingresado;
    }
    
}
