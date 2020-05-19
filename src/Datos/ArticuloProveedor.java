/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa Hwang
 */
public class ArticuloProveedor {
    private int idArticulo;
    private int idProveedor;
    
    public ArticuloProveedor()
    {
        
    }
    
    public ArticuloProveedor(int idArticulo, int idProveedor)
    {
        this.idArticulo=idArticulo;
        this.idProveedor=idProveedor;
    }
    
    public int getIdArticulo()
    {
        return idArticulo;
    }
    
    public int getIdProveedor()
    {
        return idProveedor;
    }
    
}
