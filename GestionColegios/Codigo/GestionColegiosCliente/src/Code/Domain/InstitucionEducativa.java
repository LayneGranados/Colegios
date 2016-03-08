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
public class InstitucionEducativa {
    
    private int id;
    private String nombre;
    private String codigoDANEActual;
    private String codigoDANEAnterior;
    private Municipio municipio;
    private String rutaLogo;
    private String rutaArchivosGenerados;
    private String telefono;
    private String direccion;

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

    public String getCodigoDANEActual() {
        return codigoDANEActual;
    }

    public void setCodigoDANEActual(String codigoDANEActual) {
        this.codigoDANEActual = codigoDANEActual;
    }

    public String getCodigoDANEAnterior() {
        return codigoDANEAnterior;
    }

    public void setCodigoDANEAnterior(String codigoDANEAnterior) {
        this.codigoDANEAnterior = codigoDANEAnterior;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    public String getRutaLogo() {
        return rutaLogo;
    }

    public void setRutaLogo(String rutaLogo) {
        this.rutaLogo = rutaLogo;
    }

    public String getRutaArchivosGenerados() {
        return rutaArchivosGenerados;
    }

    public void setRutaArchivosGenerados(String rutaArchivosGenerados) {
        this.rutaArchivosGenerados = rutaArchivosGenerados;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
