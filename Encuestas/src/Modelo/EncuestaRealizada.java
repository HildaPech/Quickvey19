package Modelo;

public class EncuestaRealizada {
    protected int iIdEncuestaRealizada;
    protected int iIdEncuestaActiva;
    protected int iIdUsuario;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public EncuestaRealizada() {
        this.iIdEncuestaRealizada = 0;
        this.iIdEncuestaActiva = 0;
        this.iIdUsuario = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public EncuestaRealizada(int iIdEncuestaRealizada, int iIdEncuestaActiva, int iIdUsuario, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuestaRealizada = iIdEncuestaRealizada;
        this.iIdEncuestaActiva = iIdEncuestaActiva;
        this.iIdUsuario = iIdUsuario;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuestaRealizada() {
        return this.iIdEncuestaRealizada;
    }
    
    public int getIdEncuestaActiva() {
        return this.iIdEncuestaActiva;
    }
    
    public int getIdUsuario() {
        return this.iIdUsuario;
    }
        
    public int getActivo() {
        return this.lActivo;
    }
    
    public String getAlta() {
        return this.dtAlta;
    }
    
    public String getModificacion() {
        return this.dtModificacion;
    }
    
    public void setIdEncuestaRealizada(int iIdEncuestaRealizada) {
        this.iIdEncuestaActiva = iIdEncuestaRealizada;
    }
    
    public void setIdEncuestaActiva(int iIdEncuestaActiva) {
        this.iIdEncuestaActiva = iIdEncuestaActiva;
    }
    
    public void setIdUsuario(int iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }
         
    public void setActivo(int lActivo) {
        this.lActivo = lActivo;
    }
    
    public void setAlta(String dtAlta) {
        this.dtAlta = dtAlta;
    }
    
    public void setModificacion(String dtModificacion) {
        this.dtModificacion = dtModificacion;
    }
}
