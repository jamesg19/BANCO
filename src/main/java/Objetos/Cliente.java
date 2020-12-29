/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.InputStream;

/**
 *
 * @author james
 */
public class Cliente {
    private String codigo;
    private String nombre;
    private String dpi;
    private String cumple;
    private String direccion;
    private String sexo;
    private String dpiPdf;
    private String password;
    private String codCuenta;
    private InputStream archivopdf;
    private byte[] archivopdf2;

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }
    /**
     * Constructor cliente
     * @param codigo
     * @param nombre
     * @param dpi
     * @param cumple
     * @param direccion
     * @param sexo
     * @param dpiPdf
     * @param password 
     */
    public Cliente(String codigo, String nombre, String dpi, String cumple, String direccion, String sexo, String dpiPdf, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.cumple = cumple;
        this.direccion = direccion;
        this.sexo = sexo;
        this.dpiPdf = dpiPdf;
        this.password = password;
    }

    public Cliente() {
    }
    private double saldo; 
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDpiPdf() {
        return dpiPdf;
    }

    public void setDpiPdf(String dpiPdf) {
        this.dpiPdf = dpiPdf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public InputStream getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(InputStream archivopdf) {
        this.archivopdf = archivopdf;
    }

    public byte[] getArchivopdf2() {
        return archivopdf2;
    }

    public void setArchivopdf2(byte[] archivopdf2) {
        this.archivopdf2 = archivopdf2;
    }
    
    
    
}
