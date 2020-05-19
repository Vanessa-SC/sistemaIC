/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Vanessa Hwang
 */
public class ArticuloVenta {
    private int idArticulo;
    private int idVenta;
    private int cantidad;
    private float subtotal;
    
    public ArticuloVenta()
    {
        
    }
    
    public ArticuloVenta(int idArticulo,int idVenta, int cantidad, float subtotal )
    {
        this.idArticulo=idArticulo;
        this.idVenta=idVenta;
        this.cantidad=cantidad;
        this.subtotal=subtotal;
    }

    public ArticuloVenta(int idArticulo, int idVenta) {
        this.idArticulo = idArticulo;
        this.idVenta = idVenta;
    }
    
    
    
    public int getIdArticulo()
    {
        return idArticulo;
    }
    
    public int getIdVenta()
    {
        return idVenta;
    }
    
    public int getCantidad()
    {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }
    
    
}
