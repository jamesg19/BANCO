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
public class Transaccion {
    private String codigo;
    private int codigoC;
    private String cuentaID;
    private String fecha;
    private String hora;
    private String tipo;
    private double monto;
    private String cajeroID;
    private double totDepo;
    private double totReti;
    
    /**
     * Constructor Transaccion
     * @param codigo
     * @param cuentaID
     * @param fecha
     * @param hora
     * @param tipo
     * @param monto
     * @param cajeroID 
     */
    public Transaccion(String codigo, String cuentaID, String fecha, String hora, String tipo, double monto, String cajeroID) {
        this.codigo = codigo;
        this.cuentaID = cuentaID;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.monto = monto;
        this.cajeroID = cajeroID;
    }

    public Transaccion() {
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCuentaID() {
        return cuentaID;
    }

    public void setCuentaID(String cuentaID) {
        this.cuentaID = cuentaID;
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

    public String getTipo() {
        return tipo;
    }
    private double totDep;
    private double totRet;
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCajeroID() {
        return cajeroID;
    }

    public void setCajeroID(String cajeroID) {
        this.cajeroID = cajeroID;
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

    public double getTotDepo() {
        return totDepo;
    }

    public void setTotDepo(double totDepo) {
        this.totDepo = totDepo;
    }

    public double getTotReti() {
        return totReti;
    }

    public void setTotReti(double totReti) {
        this.totReti = totReti;
    }

    public int getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(int codigoC) {
        this.codigoC = codigoC;
    }
    
    
    
}
