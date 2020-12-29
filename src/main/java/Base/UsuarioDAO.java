/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import BaseDatos.ConectaBD;
import DTO.GerenteDTO;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author james
 */
public class UsuarioDAO {
    
        Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    
    
    public UsuarioDAO(){
        
    }
    
    public boolean ingresarUsuario(UsuarioDTO usuario){
        String sql = "INSERT INTO usuario VALUES (?,?,?)";
        boolean ingresado = false;
        conn = ConectaBD.abrir();
        try(PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, usuario.getCodigo());
            ps.setString(2, usuario.getContra());
            ps.setString(3, usuario.getTipo());


            ps.executeUpdate();
            ingresado = true;
        } catch (SQLException sqle){
            
        }
        return ingresado;
    }
    
}
