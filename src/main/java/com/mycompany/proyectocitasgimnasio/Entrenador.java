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
    
    public void setEntrenadorNom(String entrenadorNom) {
        this.entrenadorNom = entrenadorNom;
    }

    public void setApellidoEntre(String apellidoEntre) {
        this.apellidoEntre = apellidoEntre;
    }

    public void setTelefonoEntre(String telefonoEntre) {
        this.telefonoEntre = telefonoEntre;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
    
    public String getEntrenadorNom() {
        return entrenadorNom;
    }

    public String getApellidoEntre() {
        return apellidoEntre;
    }
    
    public String getTelefonoEntre() {
        return telefonoEntre;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public String consultarEntrenador() {
        return "Entrenador: " + entrenadorNom + " " + apellidoEntre + " | Especialización: " + especializacion + " | Tel: " + telefonoEntre;
    }
}