package model;

public class SchoolController {

    private String nombre;
    private int horasGastadas;
    private final int PISOS = 5;
    private final int COLUMNAS = 10;
    private final int Horas_Max = 100;
    private Computer[][] matrizComputadores;

    public SchoolController(String nombre) {
        this.nombre = nombre;
        this.horasGastadas = 0;
        this.matrizComputadores = new Computer[PISOS][COLUMNAS];

    }

    public void agregarComputador(String numeroSerie, int piso, int columna) {
        if (piso < 0 || piso >= PISOS || columna < 0 || columna >= COLUMNAS) {
            System.out.println("posicion invalidad, verifique el piso y la columna");
            return;
        }
        if (matrizComputadores[piso][columna] != null) {
            System.out.println("Ya existe un computador en esta posicion");
            return;
        }

        matrizComputadores[piso][columna] = new Computer(numeroSerie, true);
        System.out.println("Computador agregado correctamente en el piso" + (piso + 1) + ", columna" + (columna + 1));
    }

    public void agregarIncidenteEnComputador(
        String numeroSerie, Incidente nuevoIncidente) {
        boolean encontrado = false;

        for (int i = 0; i < PISOS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Computer comp = matrizComputadores[i][j];
                if (comp != null && comp.getnumeroSerie().equals(numeroSerie)) {
                    comp.agregarIncidente(nuevoIncidente);
                    encontrado = true;
                    System.out.println("incidente agragado al com putador con serie:" + numeroSerie);
                    break;
                }

            }
        }
    
        if (!encontrado) {
            System.out.println("No se encontro ningun computador con el numero de serie:" + numeroSerie);
        }
    }
    
    //Metodo para obtener la lista de los computadores
    //
    public void getComputerList() {
        System.out.println("Lista de computadores registrados en la escuela:");
        for (int i = 0; i < PISOS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Computer comp = matrizComputadores[i][j];
                if (comp != null) {
                    System.out.println("- piso" + (i + 1) + ",columna" + (j + 1) + "serial:" + comp.getnumeroSerie());
                }
            }
        }
     
    }

}