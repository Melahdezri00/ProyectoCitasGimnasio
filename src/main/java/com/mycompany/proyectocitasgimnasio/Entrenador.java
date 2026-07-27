/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Entrenador {
    private String entrenadorNom;
    private String apellidoEntre;
    private String telefonoEntre;
    private String especializacion;

    public Entrenador() {
    }

    public void registrarEntre(String nombre, String apellido, String telefono, String especializacion) {
        this.entrenadorNom = nombre;
        this.apellidoEntre = apellido;
        this.telefonoEntre = telefono;
        this.especializacion = especializacion;
    }

    public String consultarEntrenador() {
        return "Entrenador: " + entrenadorNom + " " + apellidoEntre + " | Especialización: " + especializacion + " | Tel: " + telefonoEntre;
    }

    public String getEntrenadorNom() {
        return entrenadorNom;
    }

    public String getApellidoEntre() {
        return apellidoEntre;
    }
}