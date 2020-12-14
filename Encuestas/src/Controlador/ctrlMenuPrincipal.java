package Controlador;

import Modelo.hash;
import Vista.frmEncuesta;
import Vista.frmInicioSesion;
import Vista.frmMenuPrincipal;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMenuPrincipal implements ActionListener {
    private frmMenuPrincipal frmMenuPrincipal;
    private frmPerfilUsuario frmPerfilUsuario;
    private frmEncuesta frmEncuesta;
    private frmInicioSesion frmInicioSesion;
    private ctrlPerfilUsuario ctrlPerfilUsuario;
    private ctrlEncuesta ctrlEncuesta;
    
    public ctrlMenuPrincipal(frmMenuPrincipal frmMenuPrincipal, frmPerfilUsuario frmPerfilUsuario, frmEncuesta frmEncuesta, frmInicioSesion frmInicioSesion, ctrlPerfilUsuario ctrlPerfilUsuario, ctrlEncuesta ctrlEncuesta) {
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.frmEncuesta = frmEncuesta;
        this.frmInicioSesion = frmInicioSesion;
        this.ctrlPerfilUsuario = ctrlPerfilUsuario;
        this.ctrlEncuesta = ctrlEncuesta;
        this.frmMenuPrincipal.btnPerfil.addActionListener(this);
        this.frmMenuPrincipal.btnEncuesta.addActionListener(this);
        this.frmMenuPrincipal.btnCerrar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmMenuPrincipal.setTitle("Quickvey-19");
        frmMenuPrincipal.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMenuPrincipal.btnPerfil) {
            frmMenuPrincipal.setVisible(false);
            ctrlPerfilUsuario.ejecutarFormuluario();
            frmPerfilUsuario.setVisible(true);
        }
        
        if (e.getSource() == frmMenuPrincipal.btnEncuesta) {
            frmEncuesta.setVisible(false);
            //ctrlEncuesta.ejecutarFormuluario();
            frmEncuesta.setVisible(true);
        }
        
        if (e.getSource() == frmMenuPrincipal.btnCerrar) {
            frmMenuPrincipal.setVisible(false);
            frmInicioSesion.setVisible(true);
            frmInicioSesion.txtNombreUsuario.setText(null);
            frmInicioSesion.txtPassword.setText(null);
            frmInicioSesion.txtNombreUsuario.grabFocus();
        }
    }
}