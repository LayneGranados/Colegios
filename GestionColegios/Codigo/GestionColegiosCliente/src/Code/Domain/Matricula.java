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
public class Matricula {
    
    private int id;
    private Estudiante estudiante;
    private Date fechaMatricula;
    
    private int curso;
    private int caracter;
    private int especialidad;
    private int metodologia;
    private int victimaConflicto;
    private int tipoDiscapacidad;
    private int capacidadExcepcional;
    private int instutionFamiliar;
    private int departamentoExpulsor;
    private int municipioExpulsor;
    private int situacionAnterior;
    private int condicionAnterior;
    private int fuenteRecursos;
    
    private String codigo;
    private String numeroMatricula;
    private String zonaAlumno;
    
    
    private Boolean nuevo;
    private Boolean repitente;
    private Boolean subsidiado;
    private Boolean promovido;
    private Boolean provienteOtroMunicipio;
    private Boolean provieneSectorPrivado;
    private Boolean beneficiarioMadreFamilia;
    private Boolean beneficiarioVeteranoFuerzas;
    private Boolean beneficiarioHeroeNacional;
    private Boolean beneficiarioCabezaFamilia;
    private Boolean retirado;
    private Boolean poblacionVictimaConflicto;
    

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getCaracter() {
        return caracter;
    }

    public void setCaracter(int caracter) {
        this.caracter = caracter;
    }

    public int getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(int metodologia) {
        this.metodologia = metodologia;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getVictimaConflicto() {
        return victimaConflicto;
    }

    public void setVictimaConflicto(int victimaConflicto) {
        this.victimaConflicto = victimaConflicto;
    }

    public int getInstutionFamiliar() {
        return instutionFamiliar;
    }

    public void setInstutionFamiliar(int instutionFamiliar) {
        this.instutionFamiliar = instutionFamiliar;
    }

    public int getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(int tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public int getCapacidadExcepcional() {
        return capacidadExcepcional;
    }

    public void setCapacidadExcepcional(int capacidadExcepcional) {
        this.capacidadExcepcional = capacidadExcepcional;
    }

    public int getMunicipioExpulsor() {
        return municipioExpulsor;
    }

    public void setMunicipioExpulsor(int municipioExpulsor) {
        this.municipioExpulsor = municipioExpulsor;
    }

    public int getSituacionAnterior() {
        return situacionAnterior;
    }

    public void setSituacionAnterior(int situacionAnterior) {
        this.situacionAnterior = situacionAnterior;
    }

    public int getCondicionAnterior() {
        return condicionAnterior;
    }

    public void setCondicionAnterior(int condicionAnterior) {
        this.condicionAnterior = condicionAnterior;
    }

    public int getFuenteRecursos() {
        return fuenteRecursos;
    }

    public void setFuenteRecursos(int fuenteRecursos) {
        this.fuenteRecursos = fuenteRecursos;
    }

    public String getZonaAlumno() {
        return zonaAlumno;
    }

    public void setZonaAlumno(String zonaAlumno) {
        this.zonaAlumno = zonaAlumno;
    }

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Boolean getRepitente() {
        return repitente;
    }

    public void setRepitente(Boolean repitente) {
        this.repitente = repitente;
    }

    public Boolean getSubsidiado() {
        return subsidiado;
    }

    public void setSubsidiado(Boolean subsidiado) {
        this.subsidiado = subsidiado;
    }

    public Boolean getProvienteOtroMunicipio() {
        return provienteOtroMunicipio;
    }

    public void setProvienteOtroMunicipio(Boolean provienteOtroMunicipio) {
        this.provienteOtroMunicipio = provienteOtroMunicipio;
    }

    public Boolean getProvieneSectorPrivado() {
        return provieneSectorPrivado;
    }

    public void setProvieneSectorPrivado(Boolean provieneSectorPrivado) {
        this.provieneSectorPrivado = provieneSectorPrivado;
    }

    public Boolean getBeneficiarioMadreFamilia() {
        return beneficiarioMadreFamilia;
    }

    public void setBeneficiarioMadreFamilia(Boolean beneficiarioMadreFamilia) {
        this.beneficiarioMadreFamilia = beneficiarioMadreFamilia;
    }

    public Boolean getBeneficiarioVeteranoFuerzas() {
        return beneficiarioVeteranoFuerzas;
    }

    public void setBeneficiarioVeteranoFuerzas(Boolean beneficiarioVeteranoFuerzas) {
        this.beneficiarioVeteranoFuerzas = beneficiarioVeteranoFuerzas;
    }

    public Boolean getBeneficiarioHeroeNacional() {
        return beneficiarioHeroeNacional;
    }

    public void setBeneficiarioHeroeNacional(Boolean beneficiarioHeroeNacional) {
        this.beneficiarioHeroeNacional = beneficiarioHeroeNacional;
    }

    public Boolean getBeneficiarioCabezaFamilia() {
        return beneficiarioCabezaFamilia;
    }

    public void setBeneficiarioCabezaFamilia(Boolean beneficiarioCabezaFamilia) {
        this.beneficiarioCabezaFamilia = beneficiarioCabezaFamilia;
    }

    public Boolean getRetirado() {
        return retirado;
    }

    public void setRetirado(Boolean retirado) {
        this.retirado = retirado;
    }

    public int getDepartamentoExpulsor() {
        return departamentoExpulsor;
    }

    public void setDepartamentoExpulsor(int departamentoExpulsor) {
        this.departamentoExpulsor = departamentoExpulsor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Boolean getPromovido() {
        return promovido;
    }

    public void setPromovido(Boolean promovido) {
        this.promovido = promovido;
    }

    public Boolean getPoblacionVictimaConflicto() {
        return poblacionVictimaConflicto;
    }

    public void setPoblacionVictimaConflicto(Boolean poblacionVictimaConflicto) {
        this.poblacionVictimaConflicto = poblacionVictimaConflicto;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
