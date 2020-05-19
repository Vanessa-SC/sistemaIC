
package Datos;

import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa Hwang
 */
public class Proveedor {
    private int idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    
    public Proveedor()
    {
    	
    }
    
    public Proveedor (int idProveedor, String nombre, String telefono, String direccion, String email)
    {
        this.idProveedor=idProveedor;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.email=email;
    }
    
    public Proveedor (String nombre, String telefono, String direccion, String email)
    {
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
        this.email=email;
    }
    
    public Proveedor (String nombre)
    {
        this.nombre=nombre;
    }
    
    public int getId(){
        return idProveedor;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getTelefono()
    {
        return telefono;
    }
    
    public String getDireccion ()
    {
        return direccion;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void solicitarDatos()
    {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
    	telefono = JOptionPane.showInputDialog("Ingrese el numero de telefono:");
        direccion = JOptionPane.showInputDialog("Ingrese la direccion:");
        email = JOptionPane.showInputDialog("Ingrese el correo electronico:");   
    }
    
    public void solicitarNombre()
    {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
    }
 
    public void solicitarID()
    {
    	idProveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proveedor"));
    }
}

