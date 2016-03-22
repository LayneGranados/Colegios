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
public class Sede {
    
    private int id;
    private String codigoDANEantiguo;
    private Municipio municipio;
    private Long consecutivo;
    private int colegio;
    private String nombre;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoDANEantiguo() {
        return codigoDANEantiguo;
    }

    public void setCodigoDANEantiguo(String codigoDANEantiguo) {
        this.codigoDANEantiguo = codigoDANEantiguo;
    }

    public Long getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Long consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getColegio() {
        return colegio;
    }

    public void setColegio(int colegio) {
        this.colegio = colegio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
}
