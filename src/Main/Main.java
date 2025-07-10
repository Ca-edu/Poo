package Main;

import PaqueteModelo.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Operador operador = new Operador("OperadorGeneral", "12345678");

        System.out.println("=== SISTEMA DE ELECCIONES ===");

        System.out.print("Ingrese usuario: ");
        String user = sc.next();

        System.out.print("Ingrese contraseña: ");
        String pass = sc.next();

        if (!operador.Autenticar(user, pass)) {
            System.out.println("Acceso denegado. Finalizando programa.");
            return;
        }
        System.out.println("Acceso permitido.\n");

        GestorDePartidos gestorPartidos = new GestorDePartidos(10);
        GestorDeCandidato gestorCandidatos = new GestorDeCandidato(10);
        GestorDeElecciones gestorElecciones = new GestorDeElecciones(10);
        GestorDeMesasElectorales gestorMesas = new GestorDeMesasElectorales(10);
        GestorDeMiembrosDeMesa gestorMiembros = new GestorDeMiembrosDeMesa(10);
        GestorDeActas gestorActas = new GestorDeActas(10);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar partidos políticos");
            System.out.println("2. Gestionar candidatos");
            System.out.println("3. Gestionar elecciones");
            System.out.println("4. Gestionar mesas electorales");
            System.out.println("5. Gestionar miembros de mesa");
            System.out.println("6. Gestionar actas electorales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (opcion) {
                case 1 ->
                    MenuPartidos(gestorPartidos, sc);
                case 2 ->
                    MenuCandidatos(gestorCandidatos, sc);
                case 3 ->
                    MenuElecciones(gestorElecciones, gestorCandidatos, sc);
                case 4 ->
                    MenuMesas(gestorMesas, sc);
                case 5 ->
                    MenuMiembros(gestorMiembros, sc);
                case 6 ->
                    MenuActas(gestorActas, sc);
                case 0 ->
                    System.out.println("Saliendo del sistema...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }

    }

    public static void MenuPartidos(GestorDePartidos gestor, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Partidos ---");
            System.out.println("1. Registrar partido");
            System.out.println("2. Modificar partido");
            System.out.println("3. Eliminar partido");
            System.out.println("4. Listar partidos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Sigla: ");
                    String sigla = sc.next();
                    System.out.print("Logo: ");
                    String logo = sc.next();
                    System.out.print("Representante legal: ");
                    String rep = sc.next();

                    PartidoPolitico p = new PartidoPolitico(nombre, sigla, logo, rep);
                    gestor.RegistrarPartido(p);
                }
                case 2 -> {
                    System.out.print("Nombre del partido a modificar: ");
                    String nombreBuscar = sc.next();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.next();
                    System.out.print("Nueva sigla: ");
                    String nuevaSigla = sc.next();
                    System.out.print("Nuevo logo: ");
                    String nuevoLogo = sc.next();
                    System.out.print("Nuevo representante: ");
                    String nuevoRep = sc.next();

                    gestor.ModificarPartido(nombreBuscar, nuevoNombre, nuevaSigla, nuevoLogo, nuevoRep);
                }
                case 3 -> {
                    System.out.print("Nombre del partido a eliminar: ");
                    String nombreEliminar = sc.next();
                    gestor.EliminarPartido(nombreEliminar);
                }
                case 4 ->
                    gestor.MostrarPartidos();
                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void MenuCandidatos(GestorDeCandidato gestor, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Candidatos ---");
            System.out.println("1. Registrar candidato");
            System.out.println("2. Modificar candidato");
            System.out.println("3. Eliminar candidato");
            System.out.println("4. Listar candidatos");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Apellido: ");
                    String apellido = sc.next();
                    System.out.print("DNI: ");
                    int dni = sc.nextInt();
                    System.out.print("Partido (solo nombre, simulado): ");
                    String partidoNombre = sc.next();

                    PartidoPolitico partido = new PartidoPolitico(partidoNombre, "-", "-", "-");
                    Candidato c = new Candidato(nombre, apellido, dni, partido);
                    gestor.RegistrarCandidato(c);
                }
                case 2 -> {
                    System.out.print("DNI del candidato a modificar: ");
                    int dniBuscar = sc.nextInt();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.next();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = sc.next();
                    System.out.print("Nuevo partido (solo nombre, simulado): ");
                    String nuevoPartidoNombre = sc.next();

                    PartidoPolitico nuevoPartido = new PartidoPolitico(nuevoPartidoNombre, "-", "-", "-");
                    gestor.ModificarCandidato(dniBuscar, nuevoNombre, nuevoApellido, nuevoPartido);
                }
                case 3 -> {
                    System.out.print("DNI del candidato a eliminar: ");
                    int dniEliminar = sc.nextInt();
                    gestor.EliminarCandidato(dniEliminar);
                }
                case 4 ->
                    gestor.MostrarCandidatos();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void MenuElecciones(GestorDeElecciones gestor, GestorDeCandidato gestorCandidatos, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Elecciones ---");
            System.out.println("1. Registrar elección");
            System.out.println("2. Modificar elección");
            System.out.println("3. Eliminar elección");
            System.out.println("4. Listar elecciones");
            System.out.println("5. Mostrar resultados de elecciones");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Fecha: ");
                    String fecha = sc.next();
                    System.out.print("Tipo: ");
                    String tipo = sc.next();

                    Eleccion e = new Eleccion(fecha, tipo, 10, 10);
                    gestor.RegistrarEleccion(e);

                    System.out.print("¿Cuántos candidatos desea agregar a esta elección?: ");
                    int numCand = sc.nextInt();

                    for (int i = 0; i < numCand; i++) {
                        System.out.print("DNI del candidato a agregar: ");
                        int dniBuscar = sc.nextInt();
                        Candidato c = gestorCandidatos.BuscarCandidato(dniBuscar);
                        if (c != null) {
                            e.agregarCandidato(c);
                        } else {
                            System.out.println("Candidato no encontrado en el gestor.");
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Fecha de la elección a modificar: ");
                    String fechaBuscar = sc.next();
                    System.out.print("Nueva fecha: ");
                    String nuevaFecha = sc.next();
                    System.out.print("Nuevo tipo: ");
                    String nuevoTipo = sc.next();
                    gestor.ModificarEleccion(fechaBuscar, nuevaFecha, nuevoTipo);
                }
                case 3 -> {
                    System.out.print("Fecha de la elección a eliminar: ");
                    String fechaEliminar = sc.next();
                    gestor.EliminarEleccion(fechaEliminar);
                }
                case 4 ->
                    gestor.ListarElecciones();
                case 5 ->
                    gestor.MostrarResultadosElecciones();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void MenuMesas(GestorDeMesasElectorales gestor, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Mesas Electorales ---");
            System.out.println("1. Registrar mesa");
            System.out.println("2. Modificar mesa");
            System.out.println("3. Eliminar mesa");
            System.out.println("4. Listar mesas");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Número de mesa: ");
                    int numero = sc.nextInt();
                    MesaElectoral m = new MesaElectoral(numero, 3);
                    gestor.RegistrarMesa(m);
                }
                case 2 -> {
                    System.out.print("Número de mesa a modificar: ");
                    int numeroBuscar = sc.nextInt();
                    System.out.print("Nuevo número de mesa: ");
                    int nuevoNumero = sc.nextInt();
                    gestor.ModificarMesa(numeroBuscar, nuevoNumero);
                }
                case 3 -> {
                    System.out.print("Número de mesa a eliminar: ");
                    int numeroEliminar = sc.nextInt();
                    gestor.EliminarMesa(numeroEliminar);
                }
                case 4 ->
                    gestor.ListarMesas();
                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void MenuMiembros(GestorDeMiembrosDeMesa gestor, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Miembros de Mesa ---");
            System.out.println("1. Registrar miembro");
            System.out.println("2. Modificar miembro");
            System.out.println("3. Eliminar miembro");
            System.out.println("4. Listar miembros");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.next();
                    System.out.print("Apellido: ");
                    String apellido = sc.next();
                    System.out.print("Tipo (Presidente, Secretario, Vocal): ");
                    String tipo = sc.next();

                    MiembroDeMesa m = new MiembroDeMesa(nombre, apellido, tipo);
                    gestor.RegistrarMiembroDeMesa(m);
                }
                case 2 -> {
                    System.out.print("Nombre del miembro a modificar: ");
                    String nombreBuscar = sc.next();
                    System.out.print("Apellido del miembro a modificar: ");
                    String apellidoBuscar = sc.next();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.next();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = sc.next();
                    System.out.print("Nuevo tipo: ");
                    String nuevoTipo = sc.next();

                    gestor.ModificarMiembroDeMesa(nombreBuscar, apellidoBuscar, nuevoNombre, nuevoApellido, nuevoTipo);
                }
                case 3 -> {
                    System.out.print("Nombre del miembro a eliminar: ");
                    String nombreEliminar = sc.next();
                    System.out.print("Apellido del miembro a eliminar: ");
                    String apellidoEliminar = sc.next();
                    gestor.EliminarMiembroDeMesa(nombreEliminar, apellidoEliminar);
                }
                case 4 ->
                    gestor.ListarMiembrosDeMesa();
                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

    public static void MenuActas(GestorDeActas gestor, Scanner sc) {
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- Gestión de Actas Electorales ---");
            System.out.println("1. Registrar acta");
            System.out.println("2. Eliminar acta");
            System.out.println("3. Listar actas");
            System.out.println("4. Mostrar resultados de un acta");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                continue;
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = sc.next();

                    System.out.print("Fecha: ");
                    String fecha = sc.next();

                    System.out.print("Hora: ");
                    String hora = sc.next();

                    System.out.print("Lugar: ");
                    String lugar = sc.next();

                    System.out.print("Número de acta: ");
                    String numeroActa = sc.next();

                    ActaElectoral a = new ActaElectoral(titulo, fecha, hora, lugar, numeroActa, 3);

                    System.out.print("Total de votantes registrados: ");
                    int totalRegistrados = sc.nextInt();
                    System.out.print("Total de votantes efectivos: ");
                    int totalVotantes = sc.nextInt();
                    System.out.print("Votos en blanco: ");
                    int blancos = sc.nextInt();
                    System.out.print("Votos nulos: ");
                    int nulos = sc.nextInt();

                    a.registrarVotantes(totalRegistrados, totalVotantes, blancos, nulos);

                    System.out.print("Observaciones: ");
                    String obs = sc.next();
                    a.AgregarObservaciones(obs);

                    System.out.print("Firma responsable: ");
                    String firma = sc.next();
                    a.Firmar(firma);

                    a.setResultados(new ResultadoDeCandidato[5]);

                    System.out.print("¿Cuántos resultados de candidatos desea registrar?: ");
                    int numResultados = sc.nextInt();

                    for (int i = 0; i < numResultados; i++) {
                        System.out.println("Resultado " + (i + 1) + ":");
                        System.out.print("Nombre del candidato: ");
                        String nombreCandidato = sc.next();
                        System.out.print("Apellido del candidato: ");
                        String apellidoCandidato = sc.next();
                        System.out.print("DNI del candidato: ");
                        int dniCandidato = sc.nextInt();
                        System.out.print("Partido (nombre simulado): ");
                        String partidoNombre = sc.next();

                        PartidoPolitico partido = new PartidoPolitico(partidoNombre, "-", "-", "-");
                        Candidato c = new Candidato(nombreCandidato, apellidoCandidato, dniCandidato, partido);

                        System.out.print("Votos obtenidos: ");
                        int votos = sc.nextInt();

                        ResultadoDeCandidato r = new ResultadoDeCandidato(c, votos);
                        a.AgregarResultado(r);
                    }

                    boolean agregado = gestor.registrarActa(a);
                    if (agregado) {
                        System.out.println("Acta registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar el acta. Lista llena.");
                    }
                }
                case 2 -> {
                    System.out.print("Número de acta a eliminar: ");
                    String numeroEliminar = sc.next();
                    boolean eliminado = gestor.eliminarActa(numeroEliminar);
                    if (eliminado) {
                        System.out.println("Acta eliminada correctamente.");
                    } else {
                        System.out.println("Acta no encontrada.");
                    }
                }
                case 3 ->
                    gestor.listarActas();

                case 4 -> {
                    System.out.print("Número de acta para ver resultados: ");
                    String numActa = sc.next();
                    ActaElectoral a = gestor.buscarActa(numActa);
                    if (a != null) {
                        a.MostrarResultados();
                    } else {
                        System.out.println("Acta no encontrada.");
                    }
                }

                case 0 ->
                    System.out.println("Volviendo al menú principal...");
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }

}
