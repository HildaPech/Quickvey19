package Controlador;

import Modelo.Persona;
import Modelo.Usuario;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmMenuPrincipal;
import Vista.frmPassword;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ctrlPerfilUsuario implements ActionListener {
    private Persona persona;
    private sqlPersona sqlPersona;
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmMenuPrincipal frmMenuPrincipal;
    private frmPassword frmPassword;
    private frmPerfilUsuario frmPerfilUsuario;
    private ctrlPassword ctrlPassword;
    
    public ctrlPerfilUsuario(Persona persona, sqlPersona sqlPersona, Usuario usuario, sqlUsuario sqlUsuario, frmMenuPrincipal frmMenuPrincipal, frmPerfilUsuario frmPerfilUsuario, frmPassword frmPassword, ctrlPassword ctrlPassword) {
        this.persona = persona;
        this.sqlPersona = sqlPersona;
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmPassword = frmPassword;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.ctrlPassword = ctrlPassword;
        this.frmPerfilUsuario.btnCerrar.addActionListener(this);
        this.frmPerfilUsuario.btnPerfil.addActionListener(this);
        this.frmPerfilUsuario.btnPassword.addActionListener(this);
        this.frmPerfilUsuario.btnGuardar.addActionListener(this);
        this.frmPerfilUsuario.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmPerfilUsuario.setTitle("Información del Perfil");
        frmPerfilUsuario.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPerfilUsuario.btnCerrar) {
            frmPerfilUsuario.setVisible(false);
            frmMenuPrincipal.setVisible(true);
        }
        
        if (e.getSource() == frmPerfilUsuario.btnPerfil) {
            activarObjetos();
            frmPerfilUsuario.txtPrimerApellido.grabFocus();
        }
        
        if (e.getSource() == frmPerfilUsuario.btnPassword) {
            frmPerfilUsuario.setVisible(false);
            ctrlPassword.ejecutarFormuluario();
            frmPassword.setVisible(true);
        }
        
        if (e.getSource() == frmPerfilUsuario.btnGuardar) {
            Date today = new Date();
            
            /*SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaTexto;
            
            try {
                fechaTexto = formatoFecha.parse(frmPerfilUsuario.txtNombre.getText());
                frmPerfilUsuario.dtFechaNacimiento.setDate(fechaTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ctrlRegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat formatofechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            if(frmPerfilUsuario.txtPrimerApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Primer Apellido.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtPrimerApellido.grabFocus();
            } 
            else if(frmPerfilUsuario.txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtNombre.grabFocus();
            }
            else if (frmPerfilUsuario.dtFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo Fecha de Nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.dtFechaNacimiento.grabFocus();
            }   
            else if(frmPerfilUsuario.optHombre.isSelected() == false && frmPerfilUsuario.optMujer.isSelected() == false){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo Sexo.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.optHombre.grabFocus();
            }
            else if(frmPerfilUsuario.txtCorreoElectronico.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Correo Electrónico.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtCorreoElectronico.grabFocus();
            }
            else {
                persona.setPrimerApellido(frmPerfilUsuario.txtPrimerApellido.getText());
                persona.setSegundoApellido(frmPerfilUsuario.txtSegundoApellido.getText());
                persona.setNombre(frmPerfilUsuario.txtNombre.getText());
                    
                Date date = frmPerfilUsuario.dtFechaNacimiento.getDate();
                long dateLong = date.getTime();
                java.sql.Date fechaNacimiento = new java.sql.Date(dateLong);
                    
                persona.setFechaNacimiento(formatofecha.format(fechaNacimiento));
                    
                if(frmPerfilUsuario.optHombre.isSelected() == true) {
                    persona.setSexo("H");
                }
                else if (frmPerfilUsuario.optMujer.isSelected() == true) {
                    persona.setSexo("M");
                }
                
                persona.setCorreoElectronico(frmPerfilUsuario.txtCorreoElectronico.getText());
                persona.setActivo(1);
                persona.setAlta(formatofechaHora.format(today));
                persona.setModificacion(formatofechaHora.format(today));
                
                usuario.setNombreUsuario(frmPerfilUsuario.txtCorreoElectronico.getText());
                
                usuario.setModificacion(formatofechaHora.format(today));
                
                if(sqlPersona.modificarPersona(persona)) {
                    JOptionPane.showMessageDialog(null, "La actualización del perfil se realizó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    inactivarObjetos();
                }
                else {
                    JOptionPane.showMessageDialog(null, "El perfil del usuario no fue actualizado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmPerfilUsuario.btnCancelar) {
            inactivarObjetos();
        }
    }
        
    public void limpiarCampos() {
        frmPerfilUsuario.txtPrimerApellido.setText(null);
        frmPerfilUsuario.txtSegundoApellido.setText(null);
        frmPerfilUsuario.txtNombre.setText(null);
        frmPerfilUsuario.dtFechaNacimiento.setDate(null);
        frmPerfilUsuario.optHombre.setSelected(false);
        frmPerfilUsuario.optMujer.setSelected(false);
        frmPerfilUsuario.txtCorreoElectronico.setText(null);
    }
    
    public void inactivarObjetos() {
        frmPerfilUsuario.txtPrimerApellido.setEditable(false);
        frmPerfilUsuario.txtSegundoApellido.setEditable(false);
        frmPerfilUsuario.txtNombre.setEditable(false);
        frmPerfilUsuario.dtFechaNacimiento.setEnabled(false);
        frmPerfilUsuario.optHombre.setEnabled(false);
        frmPerfilUsuario.optMujer.setEnabled(false);
        frmPerfilUsuario.txtCorreoElectronico.setEditable(false);
        frmPerfilUsuario.btnGuardar.setEnabled(false);
        frmPerfilUsuario.btnCancelar.setEnabled(false);
    }
    
    public void activarObjetos() {
        frmPerfilUsuario.txtPrimerApellido.setEditable(true);
        frmPerfilUsuario.txtSegundoApellido.setEditable(true);
        frmPerfilUsuario.txtNombre.setEditable(true);
        frmPerfilUsuario.dtFechaNacimiento.setEnabled(true);
        frmPerfilUsuario.optHombre.setEnabled(true);
        frmPerfilUsuario.optMujer.setEnabled(true);
        frmPerfilUsuario.txtCorreoElectronico.setEditable(true);
        frmPerfilUsuario.btnGuardar.setEnabled(true);
        frmPerfilUsuario.btnCancelar.setEnabled(true);
    }
}