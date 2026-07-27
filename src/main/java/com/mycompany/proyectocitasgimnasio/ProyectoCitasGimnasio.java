/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectocitasgimnasio;

/**
 *
 * @author melah
 */
import javax.swing.JOptionPane;

public class ProyectoCitasGimnasio {
    public static void main(String[] args) {
        GestionSistema gestion = new GestionSistema();
        boolean salirPrograma = false;

        while (!salirPrograma) {
            boolean autenticado = gestion.iniciarSesion();

            if (autenticado) {
                boolean sesionActiva = true;

                while (sesionActiva) {
                    String menu = "=== MENÚ PRINCIPAL ===\n"
                            + "1. Gestión de Clientes\n"
                            + "2. Gestión de Membresías\n"
                            + "3. Gestión de Entrenamiento\n"
                            + "4. Gestión de Pagos\n"
                            + "5. Consulta de Pagos Totales\n"
                            + "6. Gestión de Progreso Físico\n"
                            + "7. Cerrar Sesión\n"
                            + "8. Salir del Programa\n"
                            + "Seleccione una opción:";

                    String opcionStr = JOptionPane.showInputDialog(menu);
                    
                    // Si el usuario cancela o cierra la ventana de entrada
                    if (opcionStr == null) {
                        break;
                    }

                    try {
                        int opcion = Integer.parseInt(opcionStr);

                        switch (opcion) {
                            case 1:
                                gestion.gestionarClientes();
                                break;
                            case 2:
                                gestion.gestionarMembresias();
                                break;
                            case 3:
                                gestion.gestionarEntrenamiento();
                                break;
                            case 4:
                                gestion.gestionarPagos();
                                break;
                            case 5:
                                gestion.consultarPagosTotales();
                                break;
                            case 6:
                                gestion.gestionarProgreso();
                                break;
                            case 7:
                                sesionActiva = false;
                                JOptionPane.showMessageDialog(null, "Sesión cerrada correctamente.");
                                break;
                            case 8:
                                sesionActiva = false;
                                salirPrograma = true;
                                JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡"
                                        + "Hasta luego!");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida. Ingrese un número entre 1 y 8.");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor ingrese un número entero.");
                    }
                }
            } else {
                salirPrograma = true;
            }
        }
    }
}