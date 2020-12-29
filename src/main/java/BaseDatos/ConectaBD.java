/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.servlet.SessionTrackingMode.URL;

public class ConectaBD {

    public static Connection con = null;
    private Connection conexion;
    private Statement sentencia;
    private static String bd = "banco";
    public static String usuario = "root";
    public static String passw = "Guatemala13.";
    //public static String url = "jdbc:mysql://localhost/"+bd+"?useTimezona=true&serverTimezone=CST";
    public static String url = "jdbc:mysql://localhost:3306/"+bd+"?useTimezona=true&serverTimezone=CST";

    
    public ConectaBD(String encender){
        this.conexion = null;
        this.sentencia = null;
        conectar();
    }

    public boolean conectar() {
        boolean estado = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                //Establecer la conexion con la BD
                conexion = DriverManager.getConnection(url, usuario, passw);
                estado = true;
            } catch (SQLException ex) {
                System.err.print("ERROR: ConectorBD.conectar()");
                System.err.print("Al intentar conectar con la Base de Datos");
                System.err.print(ex.getMessage());
            }
        } catch (ClassNotFoundException cex) {
            System.err.print("ERROR: ConectorBD.conectar()");
            System.err.print("No se encontró el Driver de Conexion con MYSQL");
            System.err.print(cex.getMessage());
        }
        return estado;
    }
    
    public static Connection abrir() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, usuario, passw);
            System.out.println("Conexión exitosa:" + con);

        } catch (Exception e) {
            System.out.println("Error en la conexion...");
            e.printStackTrace();
            return null;
        }
        return con;
    }
    public Connection getConexion() {
        return conexion;
    }

    public static void cerrar() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error: No se logro cerrarla conexion:\n" + e);
        }
    }

}
