
package modelo;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class sqlUsuarios extends ConexionQV19{
    //CODIGO PARA CREAR UNA NUEVA CUENTA DE USUARIO
    public boolean nuevoUsuario(usuarios usr){
        PreparedStatement ps = null;
        Connection con = getConnection();
        String sql = "INSERT INTO usuario (correo, nombre_usuario, contraseña) VALUES (?, ?, ?)";
        try {
            
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getCorreo());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getContraseña());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un Error en : "+e);
            return false;
        }
    }
    
    public int existeusuario(String usuario){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT count(id_usuario) FROM usuario WHERE nombre_usuario = ?";
        try {
            
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un Error en : "+e);
            return 1;
        }
    }
    
    public boolean esEmail(String correo){
        //patron para validar Email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }
    
    public boolean login(usuarios usr){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT id_usuario,nombre_usuario,contraseña  FROM usuario WHERE nombre_usuario = ?";
        try {
            
            ps=con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(usr.getContraseña().equals(rs.getString(3))){
                    usr.setId(rs.getInt(1));
                    usr.setUsuario(rs.getString(2));
                    return true;
                }else{
                    return false;
                }
            }
            return false;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un Error en : "+e);
            return false;
        }
    }
}
