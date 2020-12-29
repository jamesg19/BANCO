/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import BaseDatos.ConectaBD;
import DTO.GerenteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author james
 */
public class GerenteDAO {
    
    Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    
    public GerenteDAO(){

    }
    
    public boolean ingresarGerente(GerenteDTO gerente){
        
        String sql = "INSERT INTO gerente VALUES (?,?,?,?,?,?,?)";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            int c =  gerente.getCodigo();
            
            String m= c+"";
                        
            ps.setString(1, m);
            ps.setString(2, gerente.getNombre());
            ps.setString(3, gerente.getTurno().trim());
            ps.setString(6, gerente.getSexo());
            ps.setString(4, gerente.getDpi());
            ps.setString(5, gerente.getDireccion());
            ps.setString(7, gerente.getPassword());

            ps.executeUpdate();
            ingresarLimite(m);
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    public boolean ingresarLimite(String gerente){
        
        String sql = "INSERT INTO limites VALUES (?,?,?,?)";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            
            
            int cc=0;
                        
            ps.setInt(1, cc);
            ps.setString(2, gerente);
            ps.setDouble(3, 0);
            ps.setDouble(4, 1000);


            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    
}
