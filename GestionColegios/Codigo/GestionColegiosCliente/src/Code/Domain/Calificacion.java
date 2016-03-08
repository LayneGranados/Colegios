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
public class Calificacion { 
    
    private int id;
    private AsignaturaCurso asignaturaCursoId;
    private Boletin boletin;
    private String observaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AsignaturaCurso getAsignaturaCursoId() {
        return asignaturaCursoId;
    }

    public void setAsignaturaCursoId(AsignaturaCurso asignaturaCursoId) {
        this.asignaturaCursoId = asignaturaCursoId;
    }
    
    public Boletin getBoletin() {
        return boletin;
    }

    public void setBoletin(Boletin boletin) {
        this.boletin = boletin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
    
}
