/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import BaseDatos.ConectaBD;
import DTO.ClienteDTO;
import DTO.TransaccionDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class ClienteDAO {
    
    Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    
    public ClienteDAO(){
        
    }
    //ClienteDTO cliente
    public boolean ingresarCliente(ClienteDTO cliente){
        String query = "INSERT INTO `banco`.`cliente` (`codigo`, `nombre`, `dpi`, `cumple`, `direccion`, `sexo`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(query)){
            
                        
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDpi());
            ps.setString(4, cliente.getCumple());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getSexo());
            ps.setString(7, cliente.getPassword());

            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    public boolean existeCliente(ClienteDTO cliente){
        String sql = "SELECT COUNT(*) AS total FROM cliente WHERE codigo = ?";
        boolean ingresado = false;
        
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setString(1, cliente.getCodigo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ingresado = rs.getInt("total") > 0;
            }
        } catch (SQLException sqle){
            //System.err.print("Error en método existeCliente() de la clase ClienteDAO() por: "+sqle);
            //System.out.print("Error en método existeCliente() de la clase ClienteDAO() por: "+sqle);
        }
        return ingresado;
    }
    
//    public boolean ingresarArchivo(InputStream archivo, ClienteDTO cliente){
//        String sql = "UPDATE Cliente SET pdf = ? WHERE codigo = ?";
//        boolean ingresado = false;
//        try(PreparedStatement ps = cn.prepareStatement(sql)){
//            ps.setBlob(1, archivo);
//            ps.setString(2, cliente.getCodigo());
//            ps.executeUpdate();
//            ingresado = true;
//        } catch (SQLException sqle){
//            System.err.print("Error en método ingresarArchivo() de la clase ClienteDAO por: "+sqle);
//            System.out.print("Error en método ingresarArchivo() de la clase ClienteDAO por: "+sqle);
//        }
//        return ingresado;
//    }
    
    public boolean ingresarArchivo(InputStream dpi, ClienteDTO cliente){
        String query = "UPDATE cliente SET pathdpi = ? WHERE codigo = ?;";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(query)){     
                        
            ps.setBlob(1, dpi);
            ps.setString(2, cliente.getCodigo());

            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    
    
    
    
}
