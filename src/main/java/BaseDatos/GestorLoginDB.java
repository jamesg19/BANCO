/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Objetos.Usuario;
import ReporteClass.Horario;
import ReporteClass.Reporte2Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author james
 */
public class GestorLoginDB {

    Usuario usuarioHallado;
    Horario horarioHallado;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;

    public Usuario consultar(String username, String password)  {
    
    String query = "SELECT * FROM usuario u WHERE u.usuario = ? AND u.password = ?";

        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            //preSt.setString(1, tipo);
            preSt.setString(1, username);
            preSt.setString(2, password);

            try (ResultSet result = preSt.executeQuery()) {

                if (!result.next()) {
                    ConectaBD.cerrar();
                    return null;
                }
                do {

                    Usuario mov = new Usuario();

                    mov.setUser(result.getString(1));
                    mov.setTipo(result.getString(3));
                    
                    usuarioHallado = mov;
                    
                } while (result.next());
                preSt.close();

                return usuarioHallado;
            }
        } catch (SQLException e) {
            return null;

        }
     
    }

    public Horario consultarJornada(String username, String tipo) {

        
        Horario horario = new Horario();

        String query = "SELECT * FROM "+tipo+" WHERE codigo = ?";

        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            //preSt.setString(1, tipo);
            preSt.setString(1, username);

            try (ResultSet result = preSt.executeQuery()) {

                if (!result.next()) {
                    ConectaBD.cerrar();
                    return horario;
                }
                do {

                    Horario mov = new Horario();

                    mov.setHorario(result.getString(3));
                    mov.setUsuario(result.getString(1));
                    
                    horarioHallado = mov;
                    
                } while (result.next());
                preSt.close();

                return horarioHallado;
            }
        } catch (SQLException e) {
            return horario;

        }

    }
    
    public boolean Disponible(String turno,String hora) {
        

        Horario horario = new Horario();

        String query = "SELECT * FROM turno WHERE turno = ? AND hora1 <= ? AND hora2 >= ?";

        conn = ConectaBD.abrir();
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, turno);
            preSt.setString(2, hora);
            preSt.setString(3, hora);


            try (ResultSet result = preSt.executeQuery()) {

                if (!result.next()) {
                    ConectaBD.cerrar();
                    return false;
                }
                do {

                    Horario mov = new Horario();

                    mov.setHoraInicio(result.getString(2));
                    mov.setHoraFin(result.getString(3));

                    horarioHallado = mov;
                    
                } while (result.next());
                preSt.close();

                return true;
            }
        } catch (SQLException e) {
            return false;

        }

    }
    
    
    
    
}
