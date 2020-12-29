/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class GestorCrearUsuarioDB {

    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    

    public boolean Registrar_Usuario(String usuario, String password, String tipo,String nombre,
            String turno, String dpi,String direccion,String sexo) {
        
        
        int resultUpdate = 0;
        
        conn = ConectaBD.abrir();
        
        String query = "INSERT INTO usuario VALUES (?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, usuario);
            preSt.setString(2, password);
            preSt.setString(3, tipo);
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
    
        public boolean Registrar_Gerente(String usuario, String password, String tipo,String nombre,
            String turno, String dpi,String direccion,String sexo) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO gerente VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, usuario);
            preSt.setString(2, nombre);
            preSt.setString(3, turno);
            preSt.setString(4, dpi);
            preSt.setString(5, direccion);
            preSt.setString(6, sexo);
            preSt.setString(7, password);
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
        
    public boolean Registrar_Cajero(String usuario, String password, String tipo,String nombre,
            String turno, String dpi,String direccion,String sexo) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO cajero VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, usuario);
            preSt.setString(2, nombre);
            preSt.setString(3, turno);
            preSt.setString(4, dpi);
            preSt.setString(5, direccion);
            preSt.setString(6, sexo);
            preSt.setString(7, password);
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
    
    
        public boolean Registrar_Cliente(String usuario, String password, String tipo, String nombre, String dpi, String direccion, String sexo, String cumple, InputStream archivopdf) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, usuario);
            preSt.setString(2, nombre);
            preSt.setString(3, dpi);
            preSt.setString(4, cumple);
            preSt.setString(5, direccion);
            preSt.setString(6, sexo);
            preSt.setBlob(7, archivopdf); 
            preSt.setString(8, password);
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

        
        
    public boolean Registrar_Cuenta(String cliente, String creada, Double credito) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO cuenta VALUES (?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, 0);
            preSt.setString(2, cliente);
            preSt.setString(3, creada);
            preSt.setDouble(4, credito);

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
     
    
        public boolean Registrar_Limite(String gerente, double minimo, double maximo) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO limites VALUES (?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, 0);
            preSt.setString(2, gerente);
            preSt.setDouble(3, minimo);
            preSt.setDouble(4, maximo);

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

        
    public boolean Actualizar_Limite(String gerente, double minimo, double maximo) {
        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE limites SET limite1 = ? , limite2 = ? WHERE gerente = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setDouble(1, minimo);
            preSt.setDouble(2, maximo);
            preSt.setString(3, gerente);

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
    public boolean verificarDPIGe(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM gerente WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);


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
    
        public boolean verificarDPICaj(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM cajero WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);


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
        
    public boolean verificarDPIClie(String dpi) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "SELECT * FROM cliente WHERE dpi = ?";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);


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

}
