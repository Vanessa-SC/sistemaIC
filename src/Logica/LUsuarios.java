/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DUsuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class LUsuarios {
    Connection con = Conexion.getConnection();
    
    public DefaultTableModel mostrarUsuarios(DUsuarios misUsuarios){
        DefaultTableModel miModelo = null;
        
        try{
            String titulos [] = {"ID","Nombre","Usuario","Clave","Tipo"};
            String dts[] = new String[5];
            miModelo = new DefaultTableModel(null, titulos);
            CallableStatement cst = con.prepareCall("{ call sp_mostrarbuscar_usuarios(?)}");
            cst.setString(1,misUsuarios.getUsuario());
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                dts[0] = rs.getString("idUsuario");
                dts[1] = rs.getString("Nombre");
                dts[2] = rs.getString("Usuario");
                dts[3] = rs.getString("Tipo");
                miModelo.addRow(dts);
            }
            
        }catch(Exception e){
            
        }
        
        return miModelo;
    }
}
