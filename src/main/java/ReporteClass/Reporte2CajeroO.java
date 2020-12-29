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
public class Reporte2CajeroO {
    private String fecha;
    private int totDebito;
    private int totCredito;
    private int totTransaccion;
    private double balanceFinal;

    public Reporte2CajeroO() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotDebito() {
        return totDebito;
    }

    public void setTotDebito(int totDebito) {
        this.totDebito = totDebito;
    }

    public int getTotCredito() {
        return totCredito;
    }

    public void setTotCredito(int totCredito) {
        this.totCredito = totCredito;
    }

    public int getTotTransaccion() {
        return totTransaccion;
    }

    public void setTotTransaccion(int totTransaccion) {
        this.totTransaccion = totTransaccion;
    }

    public double getBalanceFinal() {
        return balanceFinal;
    }

    public void setBalanceFinal(double balanceFinal) {
        this.balanceFinal = balanceFinal;
    }
    
    
}
