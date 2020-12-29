package DTO;

/**
 *
 * @author james
 */
public class UsuarioDTO {

    private String codigo;
    private String contra;
    private String tipo;
  
    
    public UsuarioDTO(){
    
    }
    
    public UsuarioDTO( String codigo, String contra, String tipo){

        this.codigo = codigo;
        this.contra = contra;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
