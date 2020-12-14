package Encuestas;

import Controlador.ctrlEncuesta;
import Controlador.ctrlInicioSesion;
import Controlador.ctrlMenuPrincipal;
import Controlador.ctrlPassword;
import Controlador.ctrlPerfilUsuario;
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
import Vista.frmEncuesta;
import Vista.frmInicioSesion;
import Vista.frmMenuPrincipal;
import Vista.frmPassword;
import Vista.frmPerfilUsuario;
import Vista.frmRegistroUsuario;

public class Encuestas {
    public static void main ( String args[] ) {
        Persona persona = new Persona();
        sqlPersona sqlPersona = new sqlPersona();
        Usuario usuario = new Usuario();
        sqlUsuario sqlUsuario = new sqlUsuario();
        
        /*frmCatalogoUsuarios frmCatalogoUsuarios = new frmCatalogoUsuarios();
        frmCatalogoPreguntas frmCatalogoPreguntas = new frmCatalogoPreguntas();
        frmCatalogoRespuestas frmCatalogoRespuestas = new frmCatalogoRespuestas();*/
        frmEncuesta frmEncuesta = new frmEncuesta();
        frmInicioSesion frmInicioSesion = new frmInicioSesion();
        frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
        frmPassword frmPassword = new frmPassword();
        frmPerfilUsuario frmPerfilUsuario = new frmPerfilUsuario();
        frmRegistroUsuario frmRegistroUsuario = new frmRegistroUsuario();
        
        ctrlPassword ctrlPassword = new ctrlPassword (usuario, sqlUsuario, frmPerfilUsuario, frmPassword);
        ctrlPerfilUsuario ctrlPerfilUsuario = new ctrlPerfilUsuario(persona, sqlPersona, usuario, sqlUsuario, frmMenuPrincipal, frmPerfilUsuario, frmPassword, ctrlPassword);
        ctrlEncuesta ctrlEncuesta = new ctrlEncuesta(frmMenuPrincipal, frmEncuesta);
        ctrlMenuPrincipal ctrlMenuPrincipal = new ctrlMenuPrincipal(frmMenuPrincipal, frmPerfilUsuario, frmEncuesta, frmInicioSesion, ctrlPerfilUsuario, ctrlEncuesta);
        ctrlRegistroUsuario ctrlRegistroUsuario = new ctrlRegistroUsuario(persona, sqlPersona, usuario, sqlUsuario, frmRegistroUsuario, frmInicioSesion);
        ctrlInicioSesion ctrlInicioSesion = new ctrlInicioSesion(usuario, sqlUsuario, frmInicioSesion, frmMenuPrincipal, frmRegistroUsuario, ctrlMenuPrincipal, ctrlRegistroUsuario);
        
        ctrlInicioSesion.ejecutarFormuluario();
        frmInicioSesion.setVisible(true);
    }
}
