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
public class Asignatura {
    
    private int id;
    private int idAsignaturaCurso;
    private String nombre;
    private int areaConocimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(int areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    public int getIdAsignaturaCurso() {
        return idAsignaturaCurso;
    }

    public void setIdAsignaturaCurso(int idAsignaturaCurso) {
        this.idAsignaturaCurso = idAsignaturaCurso;
    }
    
    
}
