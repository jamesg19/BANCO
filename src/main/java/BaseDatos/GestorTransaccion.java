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
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class GestorTransaccion {
  
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Cuenta cuentaHallada;
    Double monto;
   
    public ArrayList<Cliente> validarCuenta(String codigo) {
        ArrayList<Cliente> clientee = new ArrayList<Cliente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct c.codigo,a.codigo, c.nombre,c.dpi, c.sexo, c.direccion, c.cumple,a.credito FROM cliente c INNER JOIN cuenta a ON c.codigo = a.cliente AND a.codigo = '"+codigo+"';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Cliente cliente= new Cliente();
                cliente.setCodigo(usuarioResultSet.getString("c.codigo"));
                cliente.setCodCuenta(usuarioResultSet.getString("a.codigo"));
                cliente.setNombre(usuarioResultSet.getString("nombre"));
                cliente.setDpi(usuarioResultSet.getString("dpi"));
                cliente.setSexo(usuarioResultSet.getString("sexo"));
                cliente.setDireccion(usuarioResultSet.getString("direccion"));
                cliente.setCumple(usuarioResultSet.getString("cumple"));
                cliente.setSaldo(usuarioResultSet.getDouble("credito"));

                clienteHallado = cliente;
                clientee.add(clienteHallado);
                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }
            
         public boolean registraTransaccion(String cuenta, String fecha, 
        String hora,String tipo, Double monto, String cajero) {
        LocalDateTime locaDate = LocalDateTime.now();

        String horaN=locaDate.getHour()+":"+locaDate.getMinute()+":"+locaDate.getSecond();
          
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "INSERT INTO transaccion VALUES (?,?,?,?,?,?,?)";
        int c=0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, c);
            preSt.setString(2, cuenta);
            preSt.setString(3, fecha);
            preSt.setString(4, horaN);
            preSt.setString(5, tipo);
            preSt.setDouble(6, monto);
            preSt.setString(7, cajero);

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

         
    public boolean actualizarSaldoCuenta(String codigo, Double monto) {
            
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE cuenta SET credito = ?  WHERE codigo = ? ";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setDouble(1, monto);
            preSt.setString(2, codigo);

            
            
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
    

        public Cuenta consultaSaldo(String codigo) {
        Cuenta cuentas = new Cuenta();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM cuenta WHERE codigo = '"+codigo+"'");
            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    monto=usuarioResultSet.getDouble("credito");
                    
                    Cuenta account =new Cuenta ();
                    account.setCredito(monto);
                    
                    cuentaHallada = account;
                    cuentas=cuentaHallada;
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return cuentas;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
     
}
