package Controlador;

import Modelo.Persona;
import Modelo.Usuario;
import Modelo.hash;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmInicioSesion;
import Vista.frmRegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrlRegistroUsuario implements ActionListener {
    private Persona persona;
    private sqlPersona sqlPersona;
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmRegistroUsuario frmRegistroUsuario;
    private frmInicioSesion frmInicioSesion;
    
    public ctrlRegistroUsuario(Persona persona, sqlPersona sqlPersona, Usuario usuario, sqlUsuario sqlUsuario, frmRegistroUsuario frmRegistroUsuario, frmInicioSesion frmInicioSesion) {
        this.persona = persona;
        this.sqlPersona = sqlPersona;
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmRegistroUsuario = frmRegistroUsuario;
        this.frmInicioSesion = frmInicioSesion;
        this.frmRegistroUsuario.btnGuardar.addActionListener(this);
        this.frmRegistroUsuario.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmRegistroUsuario.setTitle("Registro de Usuarios");
        frmRegistroUsuario.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmRegistroUsuario.btnGuardar) {
            Date today = new Date();
            
            /*SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaTexto;
            
            try {
                fechaTexto = formatoFecha.parse(frmRegistroUsuario.txtNombre.getText());
                frmRegistroUsuario.dtFechaNacimiento.setDate(fechaTexto);
            } catch (ParseException ex) {
                Logger.getLogger(ctrlRegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
            DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat formatofechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String password1 = new String(frmRegistroUsuario.txtPassword1.getPassword());
            String password2 = new String(frmRegistroUsuario.txtPassword2.getPassword());
            
            if(frmRegistroUsuario.txtPrimerApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Primer Apellido.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtPrimerApellido.grabFocus();
            } 
            else if(frmRegistroUsuario.txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtNombre.grabFocus();
            }
            else if (frmRegistroUsuario.dtFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo Fecha de Nacimiento.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.dtFechaNacimiento.grabFocus();
            }   
            else if(frmRegistroUsuario.optHombre.isSelected() == false && frmRegistroUsuario.optMujer.isSelected() == false){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo Sexo.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.optHombre.grabFocus();
            }
            else if(frmRegistroUsuario.txtCorreoElectronico.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Correo Electrónico.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtCorreoElectronico.grabFocus();
            }
            else if(password1.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtPassword1.grabFocus();
            }
            else if(password2.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo Confirmar Contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtPassword2.grabFocus();
            }
            else if(password1.equals(password2) == false) {
                JOptionPane.showMessageDialog(null, "Las contraseñas introducidas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                frmRegistroUsuario.txtPassword1.grabFocus();
            }
            else {
                persona.setPrimerApellido(frmRegistroUsuario.txtPrimerApellido.getText());
                persona.setSegundoApellido(frmRegistroUsuario.txtSegundoApellido.getText());
                persona.setNombre(frmRegistroUsuario.txtNombre.getText());
                    
                Date date = frmRegistroUsuario.dtFechaNacimiento.getDate();
                long dateLong = date.getTime();
                java.sql.Date fechaNacimiento = new java.sql.Date(dateLong);
                    
                persona.setFechaNacimiento(formatofecha.format(fechaNacimiento));
                    
                if(frmRegistroUsuario.optHombre.isSelected() == true) {
                    persona.setSexo("H");
                }
                else if (frmRegistroUsuario.optMujer.isSelected() == true) {
                    persona.setSexo("M");
                }
                
                persona.setCorreoElectronico(frmRegistroUsuario.txtCorreoElectronico.getText());
                persona.setActivo(1);
                persona.setAlta(formatofechaHora.format(today));
                persona.setModificacion(formatofechaHora.format(today));
                               
                //usuario.setIdPersona(persona.getIdPersona());
                usuario.setNombreUsuario(frmRegistroUsuario.txtCorreoElectronico.getText());
                
                String passwordCifrado = hash.md5(password1);
                usuario.setPassword(passwordCifrado);
                
                usuario.setActivo(1);
                usuario.setAlta(formatofechaHora.format(today));
                usuario.setModificacion(formatofechaHora.format(today));
                
                if(sqlPersona.registrarPersona(persona) && sqlUsuario.registrarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "El registro del usuario se realizó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    frmRegistroUsuario.setVisible(false);
                    frmInicioSesion.setVisible(true);
                    frmInicioSesion.txtNombreUsuario.setText(usuario.getNombreUsuario());
                    frmInicioSesion.txtPassword.grabFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "El registro del usuario no fue procesado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmRegistroUsuario.btnCancelar) {
            frmRegistroUsuario.setVisible(false);
            frmInicioSesion.setVisible(true);
            frmInicioSesion.txtNombreUsuario.grabFocus();
        }
    }
    
    public void limpiarCampos() {
        frmRegistroUsuario.txtPrimerApellido.setText(null);
        frmRegistroUsuario.txtSegundoApellido.setText(null);
        frmRegistroUsuario.txtNombre.setText(null);
        frmRegistroUsuario.dtFechaNacimiento.setDate(null);
        frmRegistroUsuario.optHombre.setSelected(false);
        frmRegistroUsuario.optMujer.setSelected(false);
        frmRegistroUsuario.txtCorreoElectronico.setText(null);
        frmRegistroUsuario.txtPassword1.setText(null);
        frmRegistroUsuario.txtPassword2.setText(null);
    }
}