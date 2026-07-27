/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Rutina {
    private String cliente;
    private String tipoRutina;
    private String tipoEjercicio;
    private int repeticiones;

    public Rutina() {
    }
   
    public String getCliente() {
        return cliente;
    }

    public String getTipoRutina() {
        return tipoRutina;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTipoRutina(String tipoRutina) {
        this.tipoRutina = tipoRutina;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void registrarRutina(String cliente, String tipoRutina, String tipoEjercicio, int repeticiones) {
        this.cliente = cliente;
        this.tipoRutina = tipoRutina;
        this.tipoEjercicio = tipoEjercicio;
        this.repeticiones = repeticiones;
    }

    public String consultarRutina() {
        return "Cliente: " + cliente + " | Rutina: " + tipoRutina 
                + " | Ejercicio: " + tipoEjercicio + " | Repeticiones: " + repeticiones;
    }
}
