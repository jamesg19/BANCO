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
public class Historial_Cambios {
   
   private String user;
   private String nombre;
   private String turno;
   private String cumple;
   private String dpi;
   private String direccion;
   private String sexo;
   private String fecha;

    public Historial_Cambios(String user, String nombre, String turno, String cumple, String dpi, String direccion, String sexo, String fecha) {
        this.user = user;
        this.nombre = nombre;
        this.turno = turno;
        this.cumple = cumple;
        this.dpi = dpi;
        this.direccion = direccion;
        this.sexo = sexo;
        this.fecha = fecha;
    }

    public Historial_Cambios() {
    }

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
   
   
    
    
    
    
    
}
