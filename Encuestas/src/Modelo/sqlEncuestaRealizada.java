package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlEncuestaRealizada extends ConexionBD {
    public boolean registrarEncuestaRealizada(EncuestaRealizada encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_encuestasrealizadas (iIdEncuestaActiva, iIdUsuario, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuestaActiva());
            ps.setInt(2, encuesta.getIdUsuario());
            ps.setInt(3, encuesta.getActivo());
            ps.setString(4, encuesta.getAlta());
            ps.setString(5, encuesta.getModificacion());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean modificarEncuestaRealizada(EncuestaRealizada encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasrealizadas SET iIdEncuestaActiva = ?, iIdUsuario = ?, dtModificacion = ? WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuestaActiva());
            ps.setInt(2, encuesta.getIdUsuario());
            ps.setString(3, encuesta.getModificacion());
            ps.setInt(4, encuesta.getIdEncuestaRealizada());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean inactivarEncuestaRealizada(EncuestaRealizada encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasrealizadas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuestaRealizada());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean activarEncuestaRealizada(EncuestaRealizada encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasrealizadas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuestaRealizada());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean visualizarEncuestaRealizada(EncuestaRealizada encuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_encuestasrealizadas WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuestaRealizada());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                encuesta.setIdEncuestaRealizada(Integer.parseInt(rs.getString("iIdEncuestaRealizada")));
                encuesta.setIdEncuestaActiva(Integer.parseInt(rs.getString("iIdEncuestaActiva")));
                encuesta.setIdUsuario(Integer.parseInt(rs.getString("iIdUsuario")));
                encuesta.setActivo(Integer.parseInt(rs.getString("lActivo")));
                encuesta.setAlta(rs.getString("dtAlta"));
                encuesta.setModificacion(rs.getString("dtModificacion"));
                
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}