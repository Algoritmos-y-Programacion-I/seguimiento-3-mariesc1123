package model;

import java.util.ArrayList;

public class Computer {

    // Atributos 
    //
    private String numeroSerie;
    private boolean proximaVentana;
    private ArrayList <Incidente> incidentes; 

    public Computer(String numeroSerie, boolean proximaVentana) {
        this.numeroSerie = numeroSerie;
        this.proximaVentana = proximaVentana; 
        this.incidentes = new ArrayList<>();

    }

    public void agregarIncidente(Incidente nuevoIncidente) {
        if (nuevoIncidente != null) {
            this.incidentes.add(nuevoIncidente);
        }

    }

    //Get
    //
    public String getnumeroSerie() {
        return numeroSerie;
    }

    public boolean isproximaVentana() {
        return proximaVentana;
    }

    public ArrayList<Incidente> getIncidentes() {
        return incidentes;
    }

    //Set
    //
    public void setproximaVentana(boolean proximaVentana) {
        this.proximaVentana = proximaVentana;
    }

}