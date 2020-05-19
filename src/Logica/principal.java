/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.sql.Connection;

/**
 *
 * @author Acer
 */
public class principal {
    public static void main(String[] args) {
        DBventasIC db = new DBventasIC();
        
        db.crearTablaArticulo();
        db.crearTablaArticuloProveedor();
        db.crearTablaArticuloVenta();
        db.crearTablaProveedor();
        db.crearTablaUsuario();
        db.crearTablaVenta();
                
        
    }
    
}
