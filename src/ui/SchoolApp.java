package ui;

import java.util.Scanner;
import model.SchoolController;
import model.Incidente;
import java.time.LocalDate;

public class SchoolApp {

    private SchoolController controlador;
    private Scanner input;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controlador = new SchoolController("computaricemos"); // aqui se inicia el controlador 
    }

    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con más incidentes");
            System.out.println("0) Salir del sistema");
            System.out.println("Opcion:");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    /*
     * ATENCION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Los siguientes metodos estan incompletos.
     * Agregue la logica necesaria (instrucciones) para satisfacer los
     * requerimientos
     */

    public void registrarComputador() {
        System.out.println("\n-- registrar computador");
        System.out.print("ingrese numero de serie:");
        String numeroSerie = readLine();

        System.out.print("ingrese piso del (1-5):");
        int piso = readInt(); // el usuario ingersa un numero del 1 al 5
        System.out.print("Ingrese columna de (1-10):");
        int columna = readInt();

        int pisoIdx = piso - 1;
        int colIdx = columna - 1;

        controlador.agregarComputador(numeroSerie, pisoIdx, colIdx);

    }

    public void registrarIncidenteEnComputador() {
        System.out.println("\n-- registrar un incidente en computador");
        System.out.print("Ingrese numero de serie del computador:");
        String numeroSerie = readLine();

        System.out.print("Describa el incidente");
        String descripcion = readLine();

        Incidente incidente = new Incidente(LocalDate.now(), descripcion);

        controlador.agregarIncidenteEnComputador(numeroSerie, incidente);

    }

    public void consultarComputadorConMasIncidentes() {
        System.out.println("\n-- computador con mas incidentes");

        Computer[][] matriz = controlador.getMatrizComputadores();
        if (matriz == null) {
            System.out.println("No hay computadores registrados");
            return;
        }

        Computer masIncidentesComp = null;
        int maxIncidentes = -1;
        int pisoEncontrado = -1;
        int colEncontrado = -1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Computer c = matriz[i][j];
                if (c != null) {
                    int cantidad = 0;
                    if (c.getIncidentes() != null) {
                        cantidad = c.getIncidentes().size();
                    }
                    
                    if (cantidad > maxIncidentes) {
                        maxIncidentes = cantidad;
                        masIncidentesComp = c;
                        pisoEncontrado = i;
                        colEncontrado = j;

                    }
                }   
            }

        }

        if (masIncidentesComp == null) {
            System.out.println("No hay computadores registrados");
        
        } else if (maxIncidentes == 0) {
            System.out.println("Ningun computador tiene incidentes registrados todavia");
        } else {
            System.out.println("Computador con más incidentes:");
            System.out.println(" - Número de serie: " + masIncidentesComp.getnumeroSerie());
            System.out.println(" - Piso: " + (pisoEncontrado + 1) + ", Columna: " + (colEncontrado + 1));
            System.out.println(" - Cantidad de incidentes: " + maxIncidentes);
            System.out.println(" - Detalle de incidentes:");
            masIncidentesComp.getIncidentes().forEach(i -> System.out.println("    * " + i.toString()));
        }
    }
    
    private int readInt() {
        while (true) {
            try{
                String line = input.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inavlida por favor ingrese un numero");
            }
          }
        }

    private String readLine() {
        String line = input.nextLine();
        return line != null ? line.trim() : "";
    }
    
}