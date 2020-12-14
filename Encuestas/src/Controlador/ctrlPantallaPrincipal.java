package Controlador;

import Vista.frmInicioSesion;
import Vista.frmPantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ctrlPantallaPrincipal implements ActionListener {
    private frmPantallaPrincipal frmPantallaPrincipal;
    private frmInicioSesion frmInicioSesion;
    
    public ctrlPantallaPrincipal(frmPantallaPrincipal frmPantallaPrincipal, frmInicioSesion frmInicioSesion) {
        this.frmPantallaPrincipal = frmPantallaPrincipal;
        this.frmInicioSesion = frmInicioSesion;
    }
    
    public void ejecutarFormuluario() {
        frmPantallaPrincipal.setTitle("Sistema de Encuestas \"Quickvey-19\"");
        frmPantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmPantallaPrincipal.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPantallaPrincipal.opmResponderEncuesta) {
            JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Nombre del Usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (e.getSource() == frmPantallaPrincipal.opmCerrarSesion) {
            frmPantallaPrincipal.setVisible(false);
            frmInicioSesion.setVisible(true);
        }
    }
}
