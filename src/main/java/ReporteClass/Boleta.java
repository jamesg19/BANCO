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
public class Boleta {
    private String cuenta;
    private String propietario;
    private String monto;
    private String tipo;

    public Boleta() {
    }

    public Boleta(String cuenta, String propietario, String monto, String tipo) {
        this.cuenta = cuenta;
        this.propietario = propietario;
        this.monto = monto;
        this.tipo = tipo;
    }

    
    
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
