/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteClass;

/**
 *
 * @author james
 */
public class Reporte2Gerente {
    
    private String codigo;
    private String cuenta;
    private String nombre;
    private String tipo;
    private String fecha;
    private double monto;

    public Reporte2Gerente(String codigo, String cuenta, String nombre, String tipo, String fecha, double monto) {
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    public Reporte2Gerente() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
