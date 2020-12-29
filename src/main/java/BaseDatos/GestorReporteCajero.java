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
import ReporteClass.Reporte2CajeroO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author james
 */
public class GestorReporteCajero {
    
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Historial_Cambios historialHallado;
    Transaccion transaccionHallada;
    Reporte2CajeroO reporte2Hallado;
    private double totDep=0;
    private double totRet=0;
    
    
    
    public ArrayList<Transaccion> Reporte1(String cajero) {
        
    ArrayList<Transaccion> transaccion = new ArrayList<Transaccion>();
    java.time.LocalDate today = java.time.LocalDate.now();
    String fecha=today+"";    
    
        String query = "SELECT * FROM transaccion WHERE cajero= ? AND fecha = ? ORDER BY tipo ASC";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  cajero);
            preSt.setString(2,  fecha);

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Transaccion mov= new Transaccion();                

                mov.setCodigo(result.getString(1));
                mov.setCuentaID(result.getString(2));
                mov.setFecha(result.getString(3));
                mov.setHora(result.getString(4));
                mov.setTipo(result.getString(5));
                mov.setMonto(result.getDouble(6));
                mov.setCajeroID(result.getString(7));
                
                transaccionHallada=mov;
                transaccion.add(transaccionHallada); 
                
                if(result.getString(5).equals("CREDITO")){
                    
                    totDep+=result.getDouble(6);
                    mov.setTotDepo(totDep);
                }else if(result.getString(5).equals("DEBITO")){
                    totRet+=result.getDouble(6);
                    mov.setTotReti(totRet);
                }
                
                
            } while (result.next());
            preSt.close();

            return transaccion;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }


    /**
     * REPORTE 2 CAJERO
     * @param cajero
     * @return 
     */
    public ArrayList<Reporte2CajeroO> Reporte2(String USER, String fecha1, String fecha2) {
        
    ArrayList<Reporte2CajeroO> repo2 = new ArrayList<Reporte2CajeroO>();
    
        String query = "SELECT T.fecha,SUM(T.monto AND T.tipo='DEBITO') AS debito,SUM(T.monto AND T.tipo='CREDITO') AS credito,COUNT(T.tipo) AS total_transaccion,SUM(T.monto) AS total FROM transaccion AS T WHERE T.cajero = ? AND T.fecha BETWEEN ? AND ? GROUP BY T.fecha ORDER BY T.fecha ASC;";
        
        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {    
            
            preSt.setString(1,  USER);
            preSt.setString(2,  fecha1);
            preSt.setString(3,  fecha2);

        try (ResultSet result = preSt.executeQuery()) {
            
            if(!result.next()){
                ConectaBD.cerrar();
                return null; 
            }
            do{
                
                Reporte2CajeroO mov= new Reporte2CajeroO();                

                mov.setFecha(result.getString(1));
                mov.setTotDebito(result.getInt(2));
                mov.setTotCredito(result.getInt(3));
                mov.setTotTransaccion(result.getInt(4));
                mov.setBalanceFinal(result.getInt(5));

                
                reporte2Hallado=mov;
                repo2.add(reporte2Hallado); 
                
            } while (result.next());
            preSt.close();

            return repo2;
        }
        } catch (SQLException e) {
            return null;
            
        }

    }
    
    

    public double getTotDep() {
        return totDep;
    }

    public void setTotDep(double totDep) {
        this.totDep = totDep;
    }

    public double getTotRet() {
        return totRet;
    }

    public void setTotRet(double totRet) {
        this.totRet = totRet;
    }
        
        

    
    
    
    
    
    
    
    
}
