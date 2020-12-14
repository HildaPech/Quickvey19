package Controlador;

import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmEncuesta;
import Vista.frmMenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ctrlEncuesta implements ActionListener {
    private frmMenuPrincipal frmMenuPrincipal;
    private frmEncuesta frmEncuesta;
    
    public ctrlEncuesta(frmMenuPrincipal frmMenuPrincipal, frmEncuesta frmEncuesta) {
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmEncuesta = frmEncuesta;
        this.frmEncuesta.btnCerrar.addActionListener(this);
        this.frmEncuesta.btnGuardar.addActionListener(this);
        this.frmEncuesta.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmEncuesta.setTitle("Información del Perfil");
        frmEncuesta.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEncuesta.btnCerrar) {
            frmEncuesta.setVisible(false);
            frmMenuPrincipal.setVisible(true);
        }
           
        if (e.getSource() == frmEncuesta.btnGuardar) {
            
        }
        
        if (e.getSource() == frmEncuesta.btnCancelar) {
            frmEncuesta.setVisible(false);
            frmMenuPrincipal.setVisible(true);
        }
    }
}
