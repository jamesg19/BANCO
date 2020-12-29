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
public class Usuario {
    private String codigo;
    private String user;
    private String password;
    private String tipo;

    /**
     * COnstructor usuario
     * @param codigo
     * @param user
     * @param password
     * @param tipo 
     */
    public Usuario(String codigo, String user, String password, String tipo) {
        this.codigo = codigo;
        this.user = user;
        this.password = password;
        this.tipo = tipo;
    }

    public Usuario(String codigo, String password, String tipo) {
        this.codigo = codigo;
        this.password = password;
        this.tipo = tipo;
    }
    
    
    public Usuario() {
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
