/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author james
 */
public class TransaccionDTO {
    
    private int codigo;
    private int cuenta;
    private String fecha;
    private String hora;
    private String cajero;
    private Double monto;
    private String tipo;
    
    public TransaccionDTO(int codigo, int cuenta, String fecha, String hora, String tipo, Double monto, String cajero){
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.cajero = cajero;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha=fecha;
        this.hora=hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }
    
    
    
}
