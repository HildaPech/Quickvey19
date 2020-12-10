/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionQV19 {
    public static final String URL = "jdbc:mysql://localhost:3310/quickvey-19?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String USERNAME = "Heyner";
    public static final String PASSWORD = "Heynerk31.";
    //METODO PARA LA CONEXION
    public Connection getConnection(){
    
        Connection link= null;
        try {
            
            link = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Se ha Producido un error de Conexion con la Base de \n datos en: "+e);
        }
        return link;
    }
}
        
        
