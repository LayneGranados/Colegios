/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Domain;

import java.util.Date;

/**
 *
 * @author laynegranadosmogollon
 */
public class Persona {
    
    private int id;
    private TipoDocumento tipoDocumento;
    private String documento;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private String genero;
    private String direccionResidencia;
    private String telefonoResidencia;
    private int municipioNacimiento;
    private int departamentoNacimiento;
    private int municipioResidencia;
    private int departamentoResidencia;
    private int municipioExpedicion;
    private int departamentoExpedicion;
    private int sisben;
    private int estrato;
    private Etnia etnia;
    private Resguardo resguardo;
    private String foto;
    private String tipoPersona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getTelefonoResidencia() {
        return telefonoResidencia;
    }

    public void setTelefonoResidencia(String telefonoResidencia) {
        this.telefonoResidencia = telefonoResidencia;
    }

    public int getSisben() {
        return sisben;
    }

    public void setSisben(int sisben) {
        this.sisben = sisben;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Etnia getEtnia() {
        return etnia;
    }

    public void setEtnia(Etnia etnia) {
        this.etnia = etnia;
    }

    public Resguardo getResguardo() {
        return resguardo;
    }

    public void setResguardo(Resguardo resguardo) {
        this.resguardo = resguardo;
    }

    public int getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public void setMunicipioNacimiento(int municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }

    public int getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(int departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public int getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(int municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    public int getDepartamentoResidencia() {
        return departamentoResidencia;
    }

    public void setDepartamentoResidencia(int departamentoResidencia) {
        this.departamentoResidencia = departamentoResidencia;
    }

    public int getMunicipioExpedicion() {
        return municipioExpedicion;
    }

    public void setMunicipioExpedicion(int municipioExpedicion) {
        this.municipioExpedicion = municipioExpedicion;
    }

    public int getDepartamentoExpedicion() {
        return departamentoExpedicion;
    }

    public void setDepartamentoExpedicion(int departamentoExpedicion) {
        this.departamentoExpedicion = departamentoExpedicion;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    
    
    
    
    
}
