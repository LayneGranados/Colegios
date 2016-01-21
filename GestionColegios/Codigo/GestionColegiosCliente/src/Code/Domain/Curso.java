/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Domain;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class Curso {
    
    private int Id;
    private int gradoId;
    private String nombre;
    private int caracterId;
    private int especialidadId;
    private int metodologiaId;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getGradoId() {
        return gradoId;
    }

    public void setGradoId(int gradoId) {
        this.gradoId = gradoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCaracterId() {
        return caracterId;
    }

    public void setCaracterId(int caracterId) {
        this.caracterId = caracterId;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    public int getMetodologiaId() {
        return metodologiaId;
    }

    public void setMetodologiaId(int metodologiaId) {
        this.metodologiaId = metodologiaId;
    }
    
    
}
