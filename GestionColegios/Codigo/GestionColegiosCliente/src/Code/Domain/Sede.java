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
    private String codigoDANEActual;
    private String codigoDANEantiguo;
    private Municipio municipio;
    private InstitucionEducativa institucionEducativa;
    private int consecutivo;
    private Boolean actual;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoDANEActual() {
        return codigoDANEActual;
    }

    public void setCodigoDANEActual(String codigoDANEActual) {
        this.codigoDANEActual = codigoDANEActual;
    }

    public String getCodigoDANEantiguo() {
        return codigoDANEantiguo;
    }

    public void setCodigoDANEantiguo(String codigoDANEantiguo) {
        this.codigoDANEantiguo = codigoDANEantiguo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public InstitucionEducativa getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    
    
}
