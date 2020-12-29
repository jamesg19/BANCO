package Base;

import BaseDatos.ConectaBD;
import DTO.TransaccionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author james
 */
public class TransaccionDAO {

    Connection cn;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;

    public TransaccionDAO() {
        
    }
    
      public boolean ingresarTransaccion(TransaccionDTO transaccion){
        String query = "INSERT INTO transaccion  VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        conn = ConectaBD.abrir();
        boolean ingresado = false;
        try(PreparedStatement ps = conn.prepareStatement(query)){
            
                        
            ps.setInt(1, transaccion.getCodigo());
            ps.setInt(2, transaccion.getCuenta());
            ps.setString(3, transaccion.getFecha());
            ps.setString(4, transaccion.getHora());
            ps.setString(5, transaccion.getTipo());
            ps.setDouble(6, transaccion.getMonto());
            ps.setString(7, transaccion.getCajero());

            ps.executeUpdate();  
            ingresado = true;
        } catch (SQLException sqle){

        }
        return ingresado;
    }
    
    public boolean existeTransaccion(TransaccionDTO transaccion){
        String sql = "SELECT COUNT(*) AS total FROM Transaccion WHERE codigo = ?";
        boolean ingresado = false;
        
        try(PreparedStatement ps = cn.prepareStatement(sql)){
            ps.setInt(1, transaccion.getCodigo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ingresado = rs.getInt("total") > 0;
            }
        } catch (SQLException sqle){
            System.err.print("Error en método existeTransaccion() de la clase TransaccionDAO por: "+sqle);
            System.out.print("Error en método existeTransaccion() de la clase TransaccionDAO por: "+sqle);
        }
        return ingresado;
    }
}
