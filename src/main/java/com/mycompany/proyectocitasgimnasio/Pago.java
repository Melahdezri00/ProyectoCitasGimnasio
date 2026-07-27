/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author denni
 */
public class Pago {
    private String cliente;
    private String tipoPago;
    private double total;
    private String fechaPago;
    private String estadoMembresia; // "Al día" o "Debe"

    public Pago() {
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstadoMembresia() {
        return estadoMembresia;
    }
    
    public double getTotal() {
        return total;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setEstadoMembresia(String estadoMembresia) {
        this.estadoMembresia = estadoMembresia;
    }
        
    public void registrarPago(String cliente, String tipoPago, double total, String fechaPago, String estadoMembresia) {
        this.cliente = cliente;
        this.tipoPago = tipoPago;
        this.total = total;
        this.fechaPago = fechaPago;
        this.estadoMembresia = estadoMembresia;
    }

    public String consultarPago() {
        return "Cliente: " + cliente 
                + " | Fecha: " + fechaPago 
                + " | Tipo: " + tipoPago 
                + " | Total: $" + total 
                + " | Estado: " + estadoMembresia;
    }
}
