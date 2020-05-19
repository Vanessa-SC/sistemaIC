/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Conexion {
    static Connection con = null;
    
    public static Connection getConnection(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistemaIC", "root", "");
            
            JOptionPane.showMessageDialog(null,"Ya se conectó","Información",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
