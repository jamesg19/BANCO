/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.InputStream;

/**
 *
 * @author james
 */
public class ClienteDTO {
    
    private String codigo;
    private String nombre;
    private String dpi;
    private String sexo;   
    private String direccion;
    private String cumple;
    private byte[] archivopdf;
    private String password;
    private InputStream archivoPDF;
    
    public ClienteDTO(){
    
    }
    
    public ClienteDTO(String codigo, String nombre, String dpi, String cumple, String direccion, String sexo,String password){
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.cumple=cumple;
        this.direccion = direccion;
        this.sexo = sexo;
        this.password=password;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public InputStream getArchivoPDF() {
        return archivoPDF;
    }

    public void setArchivoPDF(InputStream archivoPDF) {
        this.archivoPDF = archivoPDF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }
    
    
}
