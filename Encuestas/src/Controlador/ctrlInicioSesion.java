package Controlador;

import Modelo.Usuario;
import Modelo.sqlUsuario;
import Vista.frmInicioSesion;
import Vista.frmMenuPrincipal;
import Vista.frmRegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ctrlInicioSesion implements ActionListener {
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmInicioSesion frmInicioSesion;
    private frmMenuPrincipal frmMenuPrincipal;
    private frmRegistroUsuario frmRegistroUsuario;
    private ctrlMenuPrincipal ctrlMenuPrincipal;
    private ctrlRegistroUsuario ctrlRegistroUsuario;
    
    public ctrlInicioSesion(Usuario usuario, sqlUsuario sqlUsuario, frmInicioSesion frmInicioSesion, frmMenuPrincipal frmMenuPrincipal, frmRegistroUsuario frmRegistroUsuario, ctrlMenuPrincipal ctrlMenuPrincipal, ctrlRegistroUsuario ctrlRegistroUsuario) {
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmInicioSesion = frmInicioSesion;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmRegistroUsuario = frmRegistroUsuario;
        this.ctrlMenuPrincipal = ctrlMenuPrincipal;
        this.ctrlRegistroUsuario = ctrlRegistroUsuario;
        this.frmInicioSesion.btnIniciarSesion.addActionListener(this);
        this.frmInicioSesion.btnCrearCuenta.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmInicioSesion.setTitle("Iniciar Sesión");
        frmInicioSesion.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInicioSesion.btnIniciarSesion) {
            Usuario usuario = new Usuario();
            sqlUsuario sqlUsuario = new sqlUsuario();
            
            String password = new String(frmInicioSesion.txtPassword.getPassword());
            
            if(frmInicioSesion.txtNombreUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Nombre del Usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                frmInicioSesion.txtNombreUsuario.grabFocus();
            } 
            else if(password.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                frmInicioSesion.txtPassword.grabFocus();
            }
            else {
                usuario.setNombreUsuario(frmInicioSesion.txtNombreUsuario.getText());
                usuario.setPassword(password);
                
                if (sqlUsuario.iniciarSesion(usuario)) {
                    frmInicioSesion.setVisible(false);
                    ctrlMenuPrincipal.ejecutarFormuluario();
                    frmMenuPrincipal.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario y/o la contraseña son incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmInicioSesion.btnCrearCuenta) {
            frmInicioSesion.setVisible(false);
            ctrlRegistroUsuario.ejecutarFormuluario();
            frmRegistroUsuario.setVisible(true);
        }
    }
}