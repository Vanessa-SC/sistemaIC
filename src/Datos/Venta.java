
package Datos;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa Hwang
 */

public class Venta {
    private int idVenta;
    private String fecha;
    private String hora;
    private float totalVenta;
    
    public Venta()
    {
        
    }
    
    public Venta(int idVenta,float total)
    {
        this.idVenta=idVenta;
        this.totalVenta=total;        
    }
    
    public Venta(int idVenta)
    {
        this.idVenta=idVenta;      
    }
    public Venta(float totalVenta)
    {
        this.totalVenta=totalVenta;      
    }
    
    public Venta(String fecha)
    {
        this.fecha=fecha;
    }
    
    public int getIdVenta()
    {
        return idVenta;
    }
    
    public String getFecha() 
    {
        Date hoy = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(hoy);
    }
    
    public String getHora() 
    {
        Date ahora = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
        return formatoHora.format(ahora);
    }
    
    public float getTotalVenta()
    {
        return totalVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotalVenta(float total) {
        this.totalVenta = total;
    }
    
    
    public void solicitarId()
    {
        idVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la venta:"));
    }
    public void solicitarTotal()
    {
        totalVenta = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el total de la venta:"));
    }
}
