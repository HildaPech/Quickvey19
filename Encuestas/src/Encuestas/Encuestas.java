package Encuestas;

import Controlador.ctrlInicioSesion;
import Controlador.ctrlPantallaPrincipal;
import Controlador.ctrlRegistroUsuario;
import Modelo.Persona;
import Modelo.Usuario;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmCatalogoEncuestas;
import Vista.frmCatalogoPreguntas;
import Vista.frmCatalogoRespuestas;
import Vista.frmCatalogoUsuarios;
import Vista.frmCatalogoEncuestas;
import Vista.frmInicioSesion;
import Vista.frmPantallaPrincipal;
import Vista.frmPassword;
import Vista.frmRegistroUsuario;

public class Encuestas {
    public static void main ( String args[] ) {
        Persona persona = new Persona();
        sqlPersona sqlPersona = new sqlPersona();
        Usuario usuario = new Usuario();
        sqlUsuario sqlUsuario = new sqlUsuario();
        frmInicioSesion frmInicioSesion = new frmInicioSesion();
        frmPantallaPrincipal frmPantallaPrincipal = new frmPantallaPrincipal();
        frmRegistroUsuario frmRegistroUsuario = new frmRegistroUsuario();
        frmCatalogoUsuarios frmCatalogoUsuarios = new frmCatalogoUsuarios();
        frmCatalogoPreguntas frmCatalogoPreguntas = new frmCatalogoPreguntas();
        frmCatalogoRespuestas frmCatalogoRespuestas = new frmCatalogoRespuestas();
        frmPassword frmPassword = new frmPassword();
        ctrlPantallaPrincipal ctrlPantallaPrincipal = new ctrlPantallaPrincipal(frmPantallaPrincipal, frmInicioSesion);
        ctrlRegistroUsuario ctrlRegistroUsuario = new ctrlRegistroUsuario(persona, sqlPersona, usuario, sqlUsuario, frmRegistroUsuario, frmInicioSesion);
        ctrlInicioSesion ctrlInicioSesion = new ctrlInicioSesion(usuario, sqlUsuario, frmInicioSesion, frmPantallaPrincipal, frmRegistroUsuario, ctrlPantallaPrincipal, ctrlRegistroUsuario);
        
        ctrlInicioSesion.ejecutarFormuluario();
        frmInicioSesion.setVisible(true);
    }
}
