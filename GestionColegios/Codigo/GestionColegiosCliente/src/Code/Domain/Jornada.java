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
public class Jornada {
    
    private int id;
    private String nombre;
    private int tipoJornadaId;
    private int anioId;

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

    public int getTipoJornadaId() {
        return tipoJornadaId;
    }

    public void setTipoJornadaId(int tipoJornadaId) {
        this.tipoJornadaId = tipoJornadaId;
    }

    public int getAnioId() {
        return anioId;
    }

    public void setAnioId(int anioId) {
        this.anioId = anioId;
    }
    
    
    
}