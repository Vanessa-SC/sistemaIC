/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Vanessa Hwang
 */
public class Usuario {
    private int idUsuario; 
    private String nombre;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String usuario, String contrasena) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    private int tipo;
    
    public Usuario(){
        
    }

    public Usuario(String nombre, String usuario, String contrasena, int tipo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario(int idUsuario, String nombre, String usuario, String contrasena, int tipo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario(int idUsuario, String nombre, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
