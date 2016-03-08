/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Domain;

/**
 *
 * @author laynegranadosmogollon
 */
public class DetalleCalificacion {
    
    private int id;
    private Calificacion calificacion;
    private CaracteristicaBoletin caracteristicaBoletin;
    private String valorNota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public CaracteristicaBoletin getCaracteristicaBoletin() {
        return caracteristicaBoletin;
    }

    public void setCaracteristicaBoletin(CaracteristicaBoletin caracteristicaBoletin) {
        this.caracteristicaBoletin = caracteristicaBoletin;
    }

    public String getValorNota() {
        return valorNota;
    }

    public void setValorNota(String valorNota) {
        this.valorNota = valorNota;
    }
    
    
    
}
