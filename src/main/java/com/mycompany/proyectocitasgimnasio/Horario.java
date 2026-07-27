/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Horario {
    private String cliente;
    private String dia;
    private String horaInicio;
    private String horaFin;

    public Horario() {
    }

    public void registrarHorario(String cliente, String dia, String horaInicio, String horaFin) {
        this.cliente = cliente;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String consultarHorario() {
        return "Horario: " + dia + " (" + horaInicio + " - " + horaFin + ")";
    }

    public String getCliente() {
        return cliente;
    }
}

