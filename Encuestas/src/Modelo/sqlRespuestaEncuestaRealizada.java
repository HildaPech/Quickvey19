package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlRespuestaEncuestaRealizada extends ConexionBD {
    public boolean registrarRespuestaEncuestaRealizada(RespuestaEncuestaRealizada respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_respuestasencuestarealizada (iIdEncuestaRealizada, iIdPregunta, iIdRespuesta, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdEncuestaRealizada());
            ps.setInt(2, respuesta.getIdPregunta());
            ps.setInt(3, respuesta.getIdRespuesta());
            ps.setString(4, respuesta.getAlta());
            ps.setString(5, respuesta.getModificacion());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e);
            }
        }
    }
    
    public boolean modificarRespuestaEncuestaRealizada(RespuestaEncuestaRealizada respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_respuestasencuestarealizada SET iIdRespuesta = ?, dtModificacion = ? WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdRespuesta());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdEncuestaRealizada());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error de Ejecución", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
    public boolean visualizarRespuestaEncuestaRealizada(RespuestaEncuestaRealizada respuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_respuestasencuestarealizada WHERE iIdEncuestaRealizada = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdEncuestaRealizada());
            ps.setInt(2, respuesta.getIdPregunta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta.setIdEncuestaRealizada(Integer.parseInt(rs.getString("iIdEncuestaRealizada")));
                respuesta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                respuesta.setIdRespuesta(Integer.parseInt(rs.getString("iIdRespuesta")));
                respuesta.setAlta(rs.getString("dtAlta"));
                respuesta.setModificacion(rs.getString("dtModificacion"));
                
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error de Ejecución", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error de Conexión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
