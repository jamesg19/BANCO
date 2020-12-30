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
import java.util.ArrayList;

/**
 *
 * @author james
 */
public class GestorAsociar {

    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Gerente gerenteHallado;
    Cajero cajeroHallado;
    Cliente clienteHallado;
    Cuenta cuentaHallada;
    Solicitud solicitudHallada;
    Double monto;

    public ArrayList<Cliente> validarCuenta(int codigo) {
        ArrayList<Cliente> clientee = new ArrayList<Cliente>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct a.codigo, c.nombre,c.dpi, c.sexo, c.direccion, c.cumple,a.credito FROM cliente c INNER JOIN cuenta a ON c.codigo = a.cliente AND a.codigo = '" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Cliente cliente = new Cliente();

                cliente.setCodCuenta(usuarioResultSet.getString("codigo"));
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

            public Boolean verificarPropiedadCuenta(int codigo, String cliente) {
                Cuenta cuentas = new Cuenta();
                try {
                    conn = ConectaBD.abrir();
                    stm = conn.createStatement();
                    usuarioResultSet = stm.executeQuery("SELECT * FROM cuenta WHERE codigo = '" + codigo + "' AND cliente = '" + cliente + "' ");
                    if (!usuarioResultSet.next()) {
                        System.out.println(" No se encontraron registros");
                        ConectaBD.cerrar();
                        return false;
                    } else {
                        do {
                            monto = usuarioResultSet.getDouble("credito");
                            Cuenta account = new Cuenta();
                            account.setCredito(monto);
                            cuentaHallada = account;
                            cuentas = cuentaHallada;
                        } while (usuarioResultSet.next());
                        ConectaBD.cerrar();
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("Error en la base de datos.");
                    e.printStackTrace();
                    return false;
                }
            }

    /**
     * Verificar si existe cuenta
     *
     * @param codigo
     * @param cliente
     * @return
     */
            public Boolean verificarExisteCuenta(int codigo) {
                Cuenta cuentas = new Cuenta();
                try {
                    conn = ConectaBD.abrir();
                    stm = conn.createStatement();
                    usuarioResultSet = stm.executeQuery("SELECT * FROM cuenta WHERE codigo = '" + codigo + "' ");
                    if (!usuarioResultSet.next()) {
                        System.out.println(" No se encontraron registros");
                        ConectaBD.cerrar();
                        return false;
                    } else {
                        do {
                            monto = usuarioResultSet.getDouble("credito");
                            Cuenta account = new Cuenta();
                            account.setCredito(monto);
                            cuentaHallada = account;
                            cuentas = cuentaHallada;
                        } while (usuarioResultSet.next());
                        ConectaBD.cerrar();
                        return true;
                    }
                } catch (Exception e) {
                    System.out.println("Error en la base de datos.");
                    e.printStackTrace();
                    return false;
                }
            }

    /**
     * Enviar solicitud de Asociacion
     *
     * @param cuenta
     * @param fecha
     * @param hora
     * @param tipo
     * @param monto
     * @param cajero
     * @return
     */
    public boolean registraSolicitud(int cuenta, String cliente,String clienteRe) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "INSERT INTO asociacion VALUES (?,?,?,?,?)";
        int c = 0;
        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setInt(1, c);
            preSt.setString(2, cliente);
            preSt.setString(3, clienteRe);
            preSt.setInt(4, cuenta);
            preSt.setString(5, "PENDIENTE");

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

    /**
     * Obtener informacion del cuenta habiente
     *
     * @param codigo
     * @return
     */
    public Cliente consultaInfoCuenta(int codigo) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinct c.codigo,c.nombre,c.direccion, c.sexo, c.dpi,a.codigo FROM cliente c INNER JOIN cuenta a ON c.codigo = a.cliente AND a.codigo = '" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                Cliente usuario = new Cliente();
                
                usuario.setCodigo(usuarioResultSet.getString("c.codigo"));
                usuario.setNombre(usuarioResultSet.getString("c.nombre"));
                usuario.setDireccion(usuarioResultSet.getString("c.direccion"));
                usuario.setSexo(usuarioResultSet.getString("c.sexo"));
                usuario.setDpi(usuarioResultSet.getString("c.dpi"));
                usuario.setCumple(usuarioResultSet.getString("a.codigo"));
                clienteHallado = usuario;
                ConectaBD.cerrar();
                return clienteHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 
     * @param usuario
     * @return 
     */
    public ArrayList<Solicitud> verSolicitudesRecibidas(String usuario) {
        ArrayList<Solicitud> clientee = new ArrayList<Solicitud>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT cl.nombre,cl.dpi,cl.sexo,cl.direccion,ac.codigo,a.estado,a.codigo FROM asociacion a  INNER JOIN cuenta ac ON ac.codigo = a.cuenta AND a.estado = 'PENDIENTE' AND ac.cliente='" + usuario + "' INNER JOIN cliente cl ON cl.codigo = a.cliente;");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Solicitud solic = new Solicitud();

                    solic.setNombre(usuarioResultSet.getString("nombre"));
                    solic.setDpi(usuarioResultSet.getString("dpi"));
                    solic.setSexo(usuarioResultSet.getString("sexo"));
                    solic.setDireccion(usuarioResultSet.getString("direccion"));
                    solic.setCodigo(usuarioResultSet.getString("ac.codigo"));
                    solic.setEstado(usuarioResultSet.getString("a.estado"));
                    solic.setId(usuarioResultSet.getInt("a.codigo"));

                    solicitudHallada = solic;
                    clientee.add(solicitudHallada);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }
    /**
     * Modifica el estado de la Solicitud de asociacion ENTRE ACEPTADA O RECHAZADA
     * @param estado
     * @param codigo
     * @return 
     */
    public boolean accionSolicitud(String estado, int codigo) {

        int resultUpdate = 0;
        conn = ConectaBD.abrir();

        String query = "UPDATE asociacion SET estado = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, estado);
            preSt.setInt(2, codigo);

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

    public ArrayList<Solicitud> verSolicitudesAceptadas(String usuario) {
        ArrayList<Solicitud> clientee = new ArrayList<Solicitud>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT cl.nombre,cl.dpi,cl.sexo,cl.direccion,ac.codigo,a.estado,a.codigo FROM asociacion a  INNER JOIN cuenta ac ON ac.codigo = a.cuenta AND a.estado = 'ACEPTADO' AND ac.cliente='" + usuario + "' INNER JOIN cliente cl ON cl.codigo = a.cliente;");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    System.out.println("Se encontró el registro");
                    Solicitud solic = new Solicitud();

                    solic.setNombre(usuarioResultSet.getString("nombre"));
                    solic.setDpi(usuarioResultSet.getString("dpi"));
                    solic.setSexo(usuarioResultSet.getString("sexo"));
                    solic.setDireccion(usuarioResultSet.getString("direccion"));
                    solic.setCodigo(usuarioResultSet.getString("ac.codigo"));
                    solic.setEstado(usuarioResultSet.getString("a.estado"));
                    solic.setId(usuarioResultSet.getInt("a.codigo"));

                    solicitudHallada = solic;
                    clientee.add(solicitudHallada);
                } while (usuarioResultSet.next());

                ConectaBD.cerrar();
                return clientee;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return clientee;
        }
    }

}
