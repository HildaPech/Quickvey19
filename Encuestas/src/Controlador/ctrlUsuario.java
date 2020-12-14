package Controlador;

import Modelo.Persona;
import Modelo.Usuario;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmRegistroUsuario;
import java.awt.event.ActionEvent;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
