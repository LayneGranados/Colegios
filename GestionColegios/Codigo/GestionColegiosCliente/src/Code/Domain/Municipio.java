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
public class Municipio {
    
    private int id;
    private String codigoDANE;
    private String nombre;
    private Departamento departamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoDANE() {
        return codigoDANE;
    }

    public void setCodigoDANE(String codigoDANE) {
        this.codigoDANE = codigoDANE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
    
    
}
