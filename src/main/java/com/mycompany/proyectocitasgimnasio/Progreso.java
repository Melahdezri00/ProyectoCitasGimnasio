/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Progreso {
    private String cliente;
    private double peso;
    private double altura;
    private double porcentajeGrasa;

    public Progreso() {
    }

    public void registrarPeso(double peso) {
        this.peso = peso;
    }

    public void registrarAltura(double altura) {
        this.altura = altura;
    }

    public void registrarProgreso(String cliente, double peso, double altura, double porcentajeGrasa) {
        this.cliente = cliente;
        this.peso = peso;
        this.altura = altura;
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public String consultarProgreso() {
        return "Peso: " + peso + " kg | Altura: " + altura + " m | % Grasa: " + porcentajeGrasa + "%";
    }

    public String getCliente() {
        return cliente;
    }
}
