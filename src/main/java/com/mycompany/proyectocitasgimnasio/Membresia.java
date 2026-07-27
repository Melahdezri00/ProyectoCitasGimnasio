/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Membresia {
    private String nombre;
    private double precio;
    private String duracion;

    public Membresia() {
    }

    public void registrarMembresia(String nombre, double precio, String duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
    }

    public String consultarMembresia() {
        return "Membresía: " + nombre + " | Precio: $" + precio + " | Duración: " + duracion;
    }
}