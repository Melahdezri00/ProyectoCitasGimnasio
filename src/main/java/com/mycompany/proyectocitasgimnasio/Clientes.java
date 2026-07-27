/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Clientes {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    
    // Objetos vinculados
    private Horario horario;
    private Membresia membresia;
    private Entrenador entrenador;
    private Progreso progreso;

    public Clientes() {
    }

    public void registrar(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public Horario getHorario() {
        return horario;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Membresia getMembresia() {
        return membresia;
    }
    
    public Progreso getProgreso() {
        return progreso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setProgreso(Progreso progreso) {
        this.progreso = progreso;
    }

    public String consultar() {
        String infoMembresia = (membresia != null) ? membresia.consultarMembresia() : "Sin membresía";
        String infoHorario = (horario != null) ? horario.consultarHorario() : "Sin horario asignado";
        String infoEntrenador = (entrenador != null) ? "Entrenador: " + entrenador.getEntrenadorNom() + " " + entrenador.getApellidoEntre() : "Sin entrenador asignado";
        String infoProgreso = (progreso != null) ? progreso.consultarProgreso() : "Sin registro de progreso";

        return "Cliente: " + nombre + " " + apellido 
                + "\n  - Tel: " + telefono + " | Correo: " + correo
                + "\n  - " + infoMembresia
                + "\n  - " + infoHorario
                + "\n  - " + infoEntrenador
                + "\n  - Progreso Físico: " + infoProgreso;
    }
}
