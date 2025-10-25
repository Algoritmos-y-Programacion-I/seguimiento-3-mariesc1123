package model;

import java.time.LocalDate;

public class Incident {

    private LocalDate fechaReporte;
    private String descripcion;
    private boolean solucionado;
    private int horasSolucion;

    public Incident(LocalDate fechaReporte, String descripcion) {
        this.fechaReporte = fechaReporte;
        this.descripcion = descripcion;
        this.solucionado = false;
        this.horasSolucion = 0;
    }

    //Get
    // 
    public LocalDate getfechaReporte() {
        return fechaReporte;
    }
        
    public String getDescripcion() {
        return descripcion;
    }

    public boolean isSolucionado() {
        return solucionado;
    }

    public int gethorasSolucion() {
        return horasSolucion;
    }

    //Set
    //
    public void setSolucionado(boolean solucionado) {
        this.solucionado = solucionado;
    }

    public void sethorasSolucion(int horasSolucion) {
        this.horasSolucion = horasSolucion;
    }

    @Override
    public String toString() {
        return "Incidente{" +
               "Fecha reporte=" + fechaReporte +
               "Descripcion=" + descripcion + '\'' +
               ", solucionado=" + solucionado +
               ", horas de solucion=" + horasSolucion +
               '}';
    }
}