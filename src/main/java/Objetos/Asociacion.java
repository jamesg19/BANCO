/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author james
 */
public class Asociacion {
    private String codigo;
    private String cliente;
    private String cuenta;
    private String clienteRe;

    public Asociacion(String codigo, String cliente, String cuenta) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public Asociacion(String codigo, String cliente, String cuenta, String clienteRe) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.clienteRe = clienteRe;
    }

    public Asociacion() {
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClienteRe() {
        return clienteRe;
    }

    public void setClienteRe(String clienteRe) {
        this.clienteRe = clienteRe;
    }
    
    
    
    
}
