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
    
    public void registrarProgreso(String cliente, double peso, double altura, double porcentajeGrasa) {
        this.cliente = cliente;
        this.peso = peso;
        this.altura = altura;
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public Progreso() {
    }
    
    public String getCliente() {
        return cliente;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPorcentajeGrasa(double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }
    
    public String consultarProgreso() {
        return "Peso: " + peso + " kg | Altura: " + altura + " m | % Grasa: " + porcentajeGrasa + "%";
    }
}
