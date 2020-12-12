package Controlador;

import Modelo.Persona;
import Modelo.Usuario;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmRegistroUsuario;
import java.awt.event.ActionListener;

public class ctrlUsuario implements ActionListener {
    private Persona persona;
    private sqlPersona sqlPersona;
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmRegistroUsuario frmUsuario;
    
    public ctrlUsuario(Persona persona, sqlPersona sqlPersona, Usuario usuario, sqlUsuario sqlUsuario, frmRegistroUsuario frmUsuario) {
        this.persona = persona;
        this.sqlPersona = sqlPersona;
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmUsuario = frmUsuario;
    }
}
