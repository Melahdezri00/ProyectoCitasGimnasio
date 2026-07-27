/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocitasgimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author melah
 */
public class GestionSistema {

    // Usuario principal del sistema
    private Usuario admin;

    // Arreglos de almacenamiento
    private Clientes[] listaClientes;
    private int cantClientes;

    private Membresia[] listaMembresias;
    private int cantMembresias;

    private Entrenador[] listaEntrenadores;
    private int cantEntrenadores;

    private Rutina[] listaRutinas;
    private int cantRutinas;

    private Pago[] listaPagos;
    private int cantPagos;

    private Progreso[] listaProgresos;
    private int cantProgresos;

    // Constructor: Inicializa las listas y el usuario de inicio de sesión
    public GestionSistema() {
        admin = new Usuario("admin", "admin@gym.com", "1234", "Administrador");

        listaClientes = new Clientes[10];
        cantClientes = 0;

        listaMembresias = new Membresia[10];
        cantMembresias = 0;

        listaEntrenadores = new Entrenador[10];
        cantEntrenadores = 0;

        listaRutinas = new Rutina[10];
        cantRutinas = 0;

        listaPagos = new Pago[10];
        cantPagos = 0;

        listaProgresos = new Progreso[10];
        cantProgresos = 0;
    }

    // Método para autenticar usuario
    public boolean iniciarSesion() {
        JOptionPane.showMessageDialog(null, "--- BIENVENIDO AL SISTEMA DE GIMNASIO ---");
        String user = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
        if (user == null) return false;

        String pass = JOptionPane.showInputDialog("Ingrese su contraseña:");
        if (pass == null) return false;

        if (admin.autenticar(user, pass)) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido " + admin.getNombreUsuario());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Saliendo del sistema.");
            return false;
        }
    }

    // MÓDULO 1: GESTIÓN DE CLIENTES
    public void gestionarClientes() {
        String subMenu = "--- GESTIÓN DE CLIENTES ---\n"
                + "1. Registrar Cliente\n"
                + "2. Asignar Horario a Cliente\n"
                + "3. Consultar Clientes\n"
                + "Seleccione una opción:";

        String entrada = JOptionPane.showInputDialog(subMenu);
        if (entrada == null) return;

        try {
            int opc = Integer.parseInt(entrada);

            if (opc == 1) { // Registrar Cliente
                if (cantClientes < listaClientes.length) {
                    String nom = JOptionPane.showInputDialog("Nombre:");
                    if (nom == null) return;
                    String ape = JOptionPane.showInputDialog("Apellido:");
                    if (ape == null) return;
                    String tel = JOptionPane.showInputDialog("Teléfono:");
                    if (tel == null) return;
                    String cor = JOptionPane.showInputDialog("Correo:");
                    if (cor == null) return;

                    Clientes c = new Clientes();
                    c.registrar(nom, ape, tel, cor);
                    listaClientes[cantClientes] = c;
                    cantClientes++;
                    JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay espacio para más clientes.");
                }

            } else if (opc == 2) { // Asignar Horario
                if (cantClientes == 0) {
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
                    return;
                }

                String nomBuscado = JOptionPane.showInputDialog("Ingrese el nombre del cliente para asignación de horario:");
                if (nomBuscado == null) return;

                Clientes clienteEncontrado = null;
                for (int i = 0; i < cantClientes; i++) {
                    if (listaClientes[i].getNombre().equalsIgnoreCase(nomBuscado)) {
                        clienteEncontrado = listaClientes[i];
                        break;
                    }
                }

                if (clienteEncontrado != null) {
                    String dia = JOptionPane.showInputDialog("Día asignado (ej. Lunes):");
                    if (dia == null) return;
                    String horaInicio = JOptionPane.showInputDialog("Hora de Inicio (ej. 08:00 AM):");
                    if (horaInicio == null) return;
                    String horaFin = JOptionPane.showInputDialog("Hora de Fin (ej. 10:00 AM):");
                    if (horaFin == null) return;

                    Horario h = new Horario();
                    h.registrarHorario(clienteEncontrado.getNombre(), dia, horaInicio, horaFin);

                    clienteEncontrado.setHorario(h);
                    JOptionPane.showMessageDialog(null, "Horario asignado exitosamente a " + clienteEncontrado.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }

            } else if (opc == 3) { // Consultar Clientes
                if (cantClientes == 0) {
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
                } else {
                    String resultado = "--- LISTA DE CLIENTES ---\n\n";
                    for (int i = 0; i < cantClientes; i++) {
                        resultado += (i + 1) + ". " + listaClientes[i].consultar() + "\n----------------------------------------\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }

    // MÓDULO 2: GESTIÓN DE MEMBRESÍAS
    public void gestionarMembresias() {
        String subMenu = "--- GESTIÓN DE MEMBRESÍAS ---\n"
                + "1. Registrar nueva Membresía\n"
                + "2. Asignar Membresía a un Cliente\n"
                + "3. Ver Clientes agrupados por Membresía\n"
                + "Seleccione una opción:";

        String entrada = JOptionPane.showInputDialog(subMenu);
        if (entrada == null) return;

        try {
            int opc = Integer.parseInt(entrada);

            if (opc == 1) { // Registrar Membresía
                if (cantMembresias < listaMembresias.length) {
                    String nomM = JOptionPane.showInputDialog("Nombre de la membresía (ej. VIP, Mensual):");
                    if (nomM == null) return;

                    String inputPrecio = JOptionPane.showInputDialog("Precio:");
                    if (inputPrecio == null) return;
                    double precio = Double.parseDouble(inputPrecio);

                    String duracion = JOptionPane.showInputDialog("Duración (ej. 1 mes, 1 año):");
                    if (duracion == null) return;

                    Membresia m = new Membresia();
                    m.registrarMembresia(nomM, precio, duracion);
                    listaMembresias[cantMembresias] = m;
                    cantMembresias++;
                    JOptionPane.showMessageDialog(null, "Membresía creada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Cupo de membresías lleno.");
                }

            } else if (opc == 2) { // Asignar Membresía a Cliente
                if (cantMembresias == 0 || cantClientes == 0) {
                    JOptionPane.showMessageDialog(null, "Debe tener al menos un cliente y una membresía registrados.");
                    return;
                }

                String nomCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                if (nomCliente == null) return;

                Clientes clienteEncontrado = null;
                for (int i = 0; i < cantClientes; i++) {
                    if (listaClientes[i].getNombre().equalsIgnoreCase(nomCliente)) {
                        clienteEncontrado = listaClientes[i];
                        break;
                    }
                }

                if (clienteEncontrado != null) {
                    String menuM = "Seleccione la membresía para " + clienteEncontrado.getNombre() + ":\n";
                    for (int i = 0; i < cantMembresias; i++) {
                        menuM += (i + 1) + ". " + listaMembresias[i].consultarMembresia() + "\n";
                    }

                    String inputPos = JOptionPane.showInputDialog(menuM);
                    if (inputPos == null) return;
                    int posMembresia = Integer.parseInt(inputPos) - 1;

                    if (posMembresia >= 0 && posMembresia < cantMembresias) {
                        clienteEncontrado.setMembresia(listaMembresias[posMembresia]);
                        JOptionPane.showMessageDialog(null, "Membresía asignada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }

            } else if (opc == 3) { // Ver Clientes por Membresía
                if (cantMembresias == 0) {
                    JOptionPane.showMessageDialog(null, "No hay membresías registradas.");
                    return;
                }

                String reporte = "--- CLIENTES POR MEMBRESÍA ---\n\n";

                for (int i = 0; i < cantMembresias; i++) {
                    reporte += listaMembresias[i].consultarMembresia() + "\n";
                    reporte += "   Clientes inscritos:\n";

                    boolean tieneClientes = false;
                    for (int j = 0; j < cantClientes; j++) {
                        if (listaClientes[j].getMembresia() != null &&
                            listaClientes[j].getMembresia() == listaMembresias[i]) {
                            reporte += "   - " + listaClientes[j].getNombre() + "\n";
                            tieneClientes = true;
                        }
                    }

                    if (!tieneClientes) {
                        reporte += "   (Ningún cliente asignado)\n";
                    }
                    reporte += "----------------------------------------\n";
                }

                JOptionPane.showMessageDialog(null, reporte);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada numérica no válida.");
        }
    }

    // MÓDULO 3: GESTIÓN DE ENTRENAMIENTO
    public void gestionarEntrenamiento() {
        String subMenu = "--- GESTIÓN DE ENTRENAMIENTO ---\n"
                + "1. Registrar Entrenador\n"
                + "2. Asignar Entrenador a Cliente\n"
                + "3. Ver Clientes asignados por Entrenador\n"
                + "4. Registrar Rutina para Cliente\n"
                + "5. Consultar Rutinas\n"
                + "Seleccione una opción:";

        String entrada = JOptionPane.showInputDialog(subMenu);
        if (entrada == null) return;

        try {
            int opc = Integer.parseInt(entrada);

            if (opc == 1) { // Registrar Entrenador
                if (cantEntrenadores < listaEntrenadores.length) {
                    String nomE = JOptionPane.showInputDialog("Nombre Entrenador:");
                    if (nomE == null) return;
                    String apeE = JOptionPane.showInputDialog("Apellido:");
                    if (apeE == null) return;
                    String telE = JOptionPane.showInputDialog("Teléfono:");
                    if (telE == null) return;
                    String espE = JOptionPane.showInputDialog("Especialización:");
                    if (espE == null) return;

                    Entrenador ent = new Entrenador();
                    ent.registrarEntre(nomE, apeE, telE, espE);
                    listaEntrenadores[cantEntrenadores] = ent;
                    cantEntrenadores++;
                    JOptionPane.showMessageDialog(null, "Entrenador registrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay espacio para más entrenadores.");
                }

            } else if (opc == 2) { // Asignar Entrenador a Cliente
                if (cantEntrenadores == 0 || cantClientes == 0) {
                    JOptionPane.showMessageDialog(null, "Debe registrar al menos un cliente y un entrenador.");
                    return;
                }

                String nomC = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                if (nomC == null) return;

                Clientes clienteEncontrado = null;
                for (int i = 0; i < cantClientes; i++) {
                    if (listaClientes[i].getNombre().equalsIgnoreCase(nomC)) {
                        clienteEncontrado = listaClientes[i];
                        break;
                    }
                }

                if (clienteEncontrado != null) {
                    String listaE = "Seleccione el entrenador para " + clienteEncontrado.getNombre() + ":\n";
                    for (int i = 0; i < cantEntrenadores; i++) {
                        listaE += (i + 1) + ". " + listaEntrenadores[i].consultarEntrenador() + "\n";
                    }

                    String inputPos = JOptionPane.showInputDialog(listaE);
                    if (inputPos == null) return;
                    int pos = Integer.parseInt(inputPos) - 1;

                    if (pos >= 0 && pos < cantEntrenadores) {
                        clienteEncontrado.setEntrenador(listaEntrenadores[pos]);
                        JOptionPane.showMessageDialog(null, "Entrenador asignado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                }

            } else if (opc == 3) { // Ver Clientes por Entrenador
                if (cantEntrenadores == 0) {
                    JOptionPane.showMessageDialog(null, "No hay entrenadores registrados.");
                    return;
                }

                String reporte = "--- CLIENTES POR ENTRENADOR ---\n\n";

                for (int i = 0; i < cantEntrenadores; i++) {
                    reporte += "ENTRENADOR: " + listaEntrenadores[i].getEntrenadorNom() + " " + listaEntrenadores[i].getApellidoEntre() + "\n";
                    reporte += "   Clientes asignados:\n";

                    boolean tieneClientes = false;
                    for (int j = 0; j < cantClientes; j++) {
                        if (listaClientes[j].getEntrenador() != null &&
                            listaClientes[j].getEntrenador() == listaEntrenadores[i]) {
                            reporte += "   - " + listaClientes[j].getNombre() + "\n";
                            tieneClientes = true;
                        }
                    }

                    if (!tieneClientes) {
                        reporte += "   (Sin clientes asignados)\n";
                    }
                    reporte += "----------------------------------------\n";
                }

                JOptionPane.showMessageDialog(null, reporte);

            } else if (opc == 4) { // Registrar Rutina
                if (cantRutinas < listaRutinas.length) {
                    String clienteR = JOptionPane.showInputDialog("Nombre del cliente asignado:");
                    if (clienteR == null) return;
                    String tipoR = JOptionPane.showInputDialog("Tipo de rutina (ej. Hipertrofia, Cardio):");
                    if (tipoR == null) return;
                    String ejers = JOptionPane.showInputDialog("Tipo de ejercicio (ej. Sentadillas, Pecho):");
                    if (ejers == null) return;

                    String inputReps = JOptionPane.showInputDialog("Cantidad de repeticiones:");
                    if (inputReps == null) return;
                    int reps = Integer.parseInt(inputReps);

                    Rutina r = new Rutina();
                    r.registrarRutina(clienteR, tipoR, ejers, reps);
                    listaRutinas[cantRutinas] = r;
                    cantRutinas++;
                    JOptionPane.showMessageDialog(null, "Rutina asignada a " + clienteR + " exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay espacio para más rutinas.");
                }

            } else if (opc == 5) { // Consultar Rutinas
                if (cantRutinas == 0) {
                    JOptionPane.showMessageDialog(null, "No hay rutinas registradas.");
                } else {
                    String resultado = "--- RUTINAS REGISTRADAS ---\n\n";
                    for (int i = 0; i < cantRutinas; i++) {
                        resultado += (i + 1) + ". " + listaRutinas[i].consultarRutina() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, resultado);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada numérica no válida.");
        }
    }

    // MÓDULO 4: GESTIÓN DE PAGOS
    public void gestionarPagos() {
        if (cantPagos < listaPagos.length) {
            try {
                String clienteP = JOptionPane.showInputDialog("Nombre del cliente:");
                if (clienteP == null) return;
                String fechaP = JOptionPane.showInputDialog("Fecha de pago (ej. DD/MM/AAAA):");
                if (fechaP == null) return;
                String tipoP = JOptionPane.showInputDialog("Tipo de pago (Efectivo/Tarjeta/Transferencia):");
                if (tipoP == null) return;

                String inputTotal = JOptionPane.showInputDialog("Monto Total pagado:");
                if (inputTotal == null) return;
                double totalP = Double.parseDouble(inputTotal);

                String mesesOpc = "--- ESTADO DE LA MEMBRESÍA ---\n"
                        + "1. Pagó el mes completo (Al día)\n"
                        + "2. Pago parcial / Debe saldo\n"
                        + "Seleccione una opción:";

                String inputEstado = JOptionPane.showInputDialog(mesesOpc);
                if (inputEstado == null) return;
                int estadoOpc = Integer.parseInt(inputEstado);

                String estadoMembresia = (estadoOpc == 1) ? "Al día" : "Pendiente / Debe dinero";

                Pago p = new Pago();
                p.registrarPago(clienteP, tipoP, totalP, fechaP, estadoMembresia);
                listaPagos[cantPagos] = p;
                cantPagos++;

                JOptionPane.showMessageDialog(null, "Pago registrado exitosamente.\nEstado del cliente: " + estadoMembresia);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto u opción no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para registrar más pagos.");
        }
    }

    // MÓDULO 5: CONSULTA DE PAGOS TOTALES
    public void consultarPagosTotales() {
        if (cantPagos == 0) {
            JOptionPane.showMessageDialog(null, "No hay pagos registrados en el sistema.");
        } else {
            double sumaTotal = 0;
            String historial = "--- HISTORIAL DE PAGOS ---\n\n";

            for (int i = 0; i < cantPagos; i++) {
                historial += (i + 1) + ". " + listaPagos[i].consultarPago() + "\n";
                sumaTotal += listaPagos[i].getTotal();
            }

            historial += "\nTOTAL RECAUDADO: $" + sumaTotal;
            JOptionPane.showMessageDialog(null, historial);
        }
    }

    // MÓDULO EXTRA: GESTIÓN DE PROGRESO
    public void gestionarProgreso() {
        if (cantClientes == 0) {
            JOptionPane.showMessageDialog(null, "Debe registrar un cliente primero.");
            return;
        }

        String nomC = JOptionPane.showInputDialog("Ingrese el nombre del cliente para registrar su progreso:");
        if (nomC == null) return;

        Clientes clienteEncontrado = null;
        for (int i = 0; i < cantClientes; i++) {
            if (listaClientes[i].getNombre().equalsIgnoreCase(nomC)) {
                clienteEncontrado = listaClientes[i];
                break;
            }
        }

        if (clienteEncontrado != null) {
            try {
                String inputPeso = JOptionPane.showInputDialog("Ingrese el peso (kg):");
                if (inputPeso == null) return;
                double peso = Double.parseDouble(inputPeso);

                String inputAltura = JOptionPane.showInputDialog("Ingrese la altura (m):");
                if (inputAltura == null) return;
                double altura = Double.parseDouble(inputAltura);

                String inputGrasa = JOptionPane.showInputDialog("Ingrese el porcentaje de grasa (%):");
                if (inputGrasa == null) return;
                double grasa = Double.parseDouble(inputGrasa);

                Progreso prog = new Progreso();
                prog.registrarProgreso(clienteEncontrado.getNombre(), peso, altura, grasa);

                listaProgresos[cantProgresos] = prog;
                cantProgresos++;

                clienteEncontrado.setProgreso(prog);
                JOptionPane.showMessageDialog(null, "Progreso actualizado para " + clienteEncontrado.getNombre());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valores numéricos no válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
}