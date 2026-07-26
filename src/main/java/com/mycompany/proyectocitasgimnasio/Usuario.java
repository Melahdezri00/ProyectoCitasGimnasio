/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private String tipo;

    public Usuario(String nombreUsuario, String correo, String contrasena, String tipo) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public boolean autenticar(String user, String pass) {
        if(this.nombreUsuario.equals(user) && this.contrasena.equals(pass)) {
            return true;
        }
        return false;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTipo() {
        return tipo;
    }
}
