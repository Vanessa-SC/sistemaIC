package Datos;

import javax.swing.JOptionPane;

/**
 *
 * @author Vanessa Hwang
 */
public class Articulo {

    private int idArticulo;
    private String nombre;
    private String clave;
    private String descripcion;
    private String marca;
    private float precio;
    private int cantidad;

    public Articulo() {

    }

    public Articulo(int idArticulo, String clave, String nombre, String descripcion, String marca, float precio, int cantidad) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.clave = clave;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Articulo(String clave, String nombre, String descripcion, String marca, float precio, int cantidad) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Articulo(String nombre, String descripcion, String marca, float precio, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Articulo(String clave) {
        this.clave = clave;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrecio() {
        return precio;
    }

    public void solicitarDatos() {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo:");
        clave = JOptionPane.showInputDialog("Ingrese la clave:");
        descripcion = JOptionPane.showInputDialog("Ingrese la descripcion:");
        marca = JOptionPane.showInputDialog("Ingrese el nombre de la marca:");
        precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio:"));

    }

    public void solicitarClave() {
        clave = JOptionPane.showInputDialog("Ingrese la clave del producto:");
    }

    public void solicitarID() {
        idArticulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del articulo:"));
    }

}
