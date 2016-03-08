/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

import Code.Business.AnioBusiness;
import Code.Business.AsignaturaBusiness;
import Code.Business.AuxiliaresBusiness;
import Code.Business.CertificacionBusiness;
import Code.Business.ConfiguracionBusiness;
import Code.Business.CursoBusiness;
import Code.Business.EstudianteBusiness;
import Code.Business.GradoBusiness;
import Code.Business.JornadaBusiness;
import Code.Business.MatriculaBusiness;
import Code.Business.PeriodoBusiness;
import Code.Business.PersonaBusiness;
import Code.Business.SedeBusiness;
import Code.Domain.Anio;
import Code.Domain.Asignatura;
import Code.Domain.CapacidadExcepcional;
import Code.Domain.Caracter;
import Code.Domain.CertificacionOldstyle;
import Code.Domain.CondicionAnioAnterior;
import Code.Domain.Curso;
import Code.Domain.Departamento;
import Code.Domain.Especialidad;
import Code.Domain.Etnia;
import Code.Domain.FuenteRecursos;
import Code.Domain.Grado;
import Code.Domain.InstitucionFamiliarOrigen;
import Code.Domain.Jornada;
import Code.Domain.Metodologia;
import Code.Domain.Municipio;
import Code.Domain.Periodo;
import Code.Domain.PoblacionVictimaConflicto;
import Code.Domain.Resguardo;
import Code.Domain.Sede;
import Code.Domain.SituacionAnioAnterior;
import Code.Domain.TipoDiscapacidad;
import Code.Domain.TipoDocumento;
import GUI.Principal;
import GUI.Util.JComboBox;
import GUI.Util.ToComboBoxModel;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Administrador
 */
public class ControllerComboPrincipal {

    private Principal myPrincipal;
    public CertificacionBusiness certificacionBusiness;
    public ConfiguracionBusiness configuracionBusiness;
    public MatriculaBusiness matriculaBusiness;
    public EstudianteBusiness estudianteBusiness;
    public PersonaBusiness personaBusiness;
    public AuxiliaresBusiness auxiliaresBusiness;
    public SedeBusiness sedeBusiness;
    public AnioBusiness anioBusiness;
    public JornadaBusiness jornadaBusiness;
    public GradoBusiness gradoBusiness;
    public CursoBusiness cursoBusiness;
    public AsignaturaBusiness asignaturaBusiness;
    public PeriodoBusiness periodoBusiness;

    public ControllerComboPrincipal(Principal myPrincipal) {
        this.myPrincipal = myPrincipal;
        
        /** INICIALIZACION DE OBJETOS DEL NEGOCIO**/
        this.certificacionBusiness = new CertificacionBusiness();
        this.configuracionBusiness = new ConfiguracionBusiness();
        this.matriculaBusiness = new MatriculaBusiness();
        this.auxiliaresBusiness= new AuxiliaresBusiness();
        this.personaBusiness=new PersonaBusiness();
        this.estudianteBusiness = new EstudianteBusiness();
        this.anioBusiness = new AnioBusiness();
        this.jornadaBusiness = new JornadaBusiness();
        this.gradoBusiness = new GradoBusiness();
        this.cursoBusiness = new CursoBusiness();
        this.sedeBusiness = new SedeBusiness();
        this.asignaturaBusiness = new AsignaturaBusiness();
        this.periodoBusiness = new PeriodoBusiness();
    }

    public void llenarCombos() {
        combosPersonas();
        combosMatricula();
        combosCalificaciones();
    }
    
    public void combosPersonas(){
        ArrayList<TipoDocumento> tiposDeDocumento = this.auxiliaresBusiness.getAllTipoDocumento();
        ArrayList<Departamento> departamentos = this.auxiliaresBusiness.getAllDepartamentos();
        ArrayList<Resguardo> resguardos = this.auxiliaresBusiness.getAllResguardo();
        ArrayList<Etnia> etnias = this.auxiliaresBusiness.getAllEtnia();
        this.myPrincipal.cmbTipoDocumentoIdentificacion.setModel(new ToComboBoxModel(tiposDeDocumento, "getNombre"));
        this.myPrincipal.cmbDepartamentoExpedicion.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoNacimiento.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoResidencia.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoColegio.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoExpulsor.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbEtnia.setModel(new ToComboBoxModel(etnias, "getNombre"));
        this.myPrincipal.cmbResguardo.setModel(new ToComboBoxModel(resguardos, "getNombre"));
    }
    
    public void combosMatricula(){
        ArrayList<Sede> sedes = this.sedeBusiness.selectAllSedes(this.myPrincipal.getInstitucionEducativaActual().getId());
        this.myPrincipal.cmbSedeMatricula.setModel(new ToComboBoxModel(sedes, "getNombre"));
        ArrayList<Caracter> caracteres = this.auxiliaresBusiness.getAllCaracter();
        this.myPrincipal.cmbCaracterMatricula.setModel(new ToComboBoxModel(caracteres, "getNombre"));
        this.myPrincipal.cmbCaracterMatricula.setPreferredSize(new Dimension(170,this.myPrincipal.cmbCaracterMatricula.getPreferredSize().height));
        
        ArrayList<Especialidad> especialidades = this.auxiliaresBusiness.getAllEspecialidad();
        this.myPrincipal.cmbEspecialidad.setModel(new ToComboBoxModel(especialidades, "getNombre"));
        this.myPrincipal.cmbEspecialidad.setPreferredSize(new Dimension(170, this.myPrincipal.cmbEspecialidad.getPreferredSize().height));
        
        ArrayList<Metodologia> metodologias = this.auxiliaresBusiness.getAllMetodologia();
        this.myPrincipal.cmbMetodologia.setModel(new ToComboBoxModel(metodologias, "getNombre"));
        this.myPrincipal.cmbMetodologia.setPreferredSize(new Dimension(170, this.myPrincipal.cmbMetodologia.getPreferredSize().height));
        
        ArrayList<PoblacionVictimaConflicto> poblaciones = this.auxiliaresBusiness.getAllPoblacionVictima();
        this.myPrincipal.cmbVictimaConflicto.setModel(new ToComboBoxModel(poblaciones, "getNombre"));
        this.myPrincipal.cmbVictimaConflicto.setPreferredSize(new Dimension(170, this.myPrincipal.cmbVictimaConflicto.getPreferredSize().height));
        
        ArrayList<TipoDiscapacidad> discapacidades = this.auxiliaresBusiness.getAllTipDiscapacidad();
        this.myPrincipal.cmbTipoDiscapacidad.setModel(new ToComboBoxModel(discapacidades, "getNombre"));
        this.myPrincipal.cmbTipoDiscapacidad.setPreferredSize(new Dimension(170, this.myPrincipal.cmbTipoDiscapacidad.getPreferredSize().height));
        
        ArrayList<CapacidadExcepcional> capacidades = this.auxiliaresBusiness.getAllCapacidadExcepcional();
        this.myPrincipal.cmbCapacidadExcepcional.setModel(new ToComboBoxModel(capacidades, "getNombre"));
        this.myPrincipal.cmbCapacidadExcepcional.setPreferredSize(new Dimension(170, this.myPrincipal.cmbCapacidadExcepcional.getPreferredSize().height));
        
        ArrayList<InstitucionFamiliarOrigen> instituciones = this.auxiliaresBusiness.getAllInstitucionFamiliar();
        this.myPrincipal.cmbInstitucionFamiliarOrigen.setModel(new ToComboBoxModel(instituciones, "getNombre"));
        this.myPrincipal.cmbInstitucionFamiliarOrigen.setPreferredSize(new Dimension(170, this.myPrincipal.cmbInstitucionFamiliarOrigen.getPreferredSize().height));
        
        ArrayList<SituacionAnioAnterior> situaciones = this.auxiliaresBusiness.getAllSituacionesAnteriores();
        this.myPrincipal.cmbSituacionAnioAnterior.setModel(new ToComboBoxModel(situaciones, "getNombre"));
        this.myPrincipal.cmbSituacionAnioAnterior.setPreferredSize(new Dimension(170, this.myPrincipal.cmbSituacionAnioAnterior.getPreferredSize().height));
        
        ArrayList<CondicionAnioAnterior> condiciones = this.auxiliaresBusiness.getAllCondicionesAnteriores();
        this.myPrincipal.cmbCondicionAnioAnterior.setModel(new ToComboBoxModel(condiciones, "getNombre"));
        this.myPrincipal.cmbCondicionAnioAnterior.setPreferredSize(new Dimension(170, this.myPrincipal.cmbCondicionAnioAnterior.getPreferredSize().height));
        
        ArrayList<FuenteRecursos> fuentes = this.auxiliaresBusiness.getAllFuentesRecursos();
        this.myPrincipal.cmbFuenteRecursos.setModel(new ToComboBoxModel(fuentes, "getNombre"));
        this.myPrincipal.cmbSedeCalificaciones.setPreferredSize(new Dimension(170, this.myPrincipal.cmbFuenteRecursos.getPreferredSize().height));
        
    }
    
    public void combosCalificaciones(){
        ArrayList<Sede> sedes = this.sedeBusiness.selectAllSedes(this.myPrincipal.getInstitucionEducativaActual().getId());
        this.myPrincipal.cmbSedeCalificaciones.setModel(new ToComboBoxModel(sedes, "getNombre"));
        this.myPrincipal.cmbSedeCalificaciones.setPreferredSize(new Dimension(170, this.myPrincipal.cmbSedeCalificaciones.getPreferredSize().height));
    }

    public Object getObjetoSeleccionado(JComboBox combo) {
        return ((JComboBox) combo).getObjectSelected();
    }
    
    public void llenarMunicipioExpedicion(int id){
        ArrayList<Municipio> municipios = this.auxiliaresBusiness.getAllMunicipiosPorDepartamento(id);
        this.myPrincipal.cmbMunicipioExpedicion.setModel(new ToComboBoxModel(municipios, "getNombre"));
    }
    
    public void llenarMunicipioNacimiento(int id){
        ArrayList<Municipio> municipios = this.auxiliaresBusiness.getAllMunicipiosPorDepartamento(id);
        this.myPrincipal.cmbMunicipioNacimiento.setModel(new ToComboBoxModel(municipios, "getNombre"));
    }
    
    public void llenarMunicipioResidencia(int id){
        ArrayList<Municipio> municipios = this.auxiliaresBusiness.getAllMunicipiosPorDepartamento(id);
        this.myPrincipal.cmbMunicipioResidencia.setModel(new ToComboBoxModel(municipios, "getNombre"));
    }
    
    public void llenarMunicipioColegio(int id){
        ArrayList<Municipio> municipios = this.auxiliaresBusiness.getAllMunicipiosPorDepartamento(id);
        this.myPrincipal.cmbMunicipioColegio.setModel(new ToComboBoxModel(municipios, "getNombre"));
    }
    
    public void llenarMunicipioMatricula(int id){
        ArrayList<Municipio> municipios = this.auxiliaresBusiness.getAllMunicipiosPorDepartamento(id);
        this.myPrincipal.cmbMunicipioExpulsor.setModel(new ToComboBoxModel(municipios, "getNombre"));
    }
    
    public void llenarCertificadosAntiguos(ArrayList<CertificacionOldstyle> certs){
        this.myPrincipal.cmbResultadosCertificadosAntiguos.setModel(new ToComboBoxModel(certs, "getComboAntiguo"));
    }
    
    public void setSelectedItemTipoIdentificacion(TipoDocumento tipoDocumento){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbTipoDocumentoIdentificacion.getModel(); 
        to.setSelectedItemCustomize(tipoDocumento);
        this.myPrincipal.cmbTipoDocumentoIdentificacion.setModel(to);
        this.myPrincipal.cmbTipoDocumentoIdentificacion.requestFocusInWindow();
    }
    
    public void setSelectedItemDepartamentoExpedicion(Departamento departamento){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbDepartamentoExpedicion.getModel(); 
        to.setSelectedItemCustomize(departamento);
        this.myPrincipal.cmbDepartamentoExpedicion.setModel(to);
        this.myPrincipal.cmbDepartamentoExpedicion.requestFocusInWindow();
    }
    
    public void setSelectedItemMunicipioExpedicion(Municipio municipio){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbMunicipioExpedicion.getModel(); 
        to.setSelectedItemCustomize(municipio);
        this.myPrincipal.cmbMunicipioExpedicion.setModel(to);
        this.myPrincipal.cmbMunicipioExpedicion.requestFocusInWindow();
    }
    
    public void setSelectedItemDepartamentoColegio(Departamento departamento){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbDepartamentoColegio.getModel(); 
        to.setSelectedItemCustomize(departamento);
        this.myPrincipal.cmbDepartamentoColegio.setModel(to);
        this.myPrincipal.cmbDepartamentoColegio.requestFocusInWindow();
    }
    
    public void setSelectedItemMunicipioColegio(Municipio municipio){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbMunicipioColegio.getModel(); 
        to.setSelectedItemCustomize(municipio);
        this.myPrincipal.cmbMunicipioColegio.setModel(to);
        this.myPrincipal.cmbMunicipioColegio.requestFocusInWindow();
        
    }
    
    public void setSelectedItemDepartamentoNacimiento(Departamento departamento){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbDepartamentoNacimiento.getModel(); 
        to.setSelectedItemCustomize(departamento);
        this.myPrincipal.cmbDepartamentoNacimiento.setModel(to);
        this.myPrincipal.cmbDepartamentoNacimiento.requestFocusInWindow();
    }
    
    public void setSelectedItemMunicipioNacimiento(Municipio municipio){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbMunicipioNacimiento.getModel(); 
        to.setSelectedItemCustomize(municipio);
        this.myPrincipal.cmbMunicipioNacimiento.setModel(to);
        this.myPrincipal.cmbMunicipioNacimiento.requestFocusInWindow();
    }
    
    public void setSelectedItemDepartamentoResidencia(Departamento departamento){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbDepartamentoResidencia.getModel(); 
        to.setSelectedItemCustomize(departamento);
        this.myPrincipal.cmbDepartamentoResidencia.setModel(to);
        this.myPrincipal.cmbDepartamentoResidencia.requestFocusInWindow();
    }
    
    public void setSelectedItemMunicipioResidencia(Municipio municipio){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbMunicipioResidencia.getModel(); 
        to.setSelectedItemCustomize(municipio);
        this.myPrincipal.cmbMunicipioResidencia.setModel(to);
        this.myPrincipal.cmbMunicipioResidencia.requestFocusInWindow();
    }
    
    public void setSelectedItemEtnia(Etnia etnia){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbEtnia.getModel(); 
        to.setSelectedItemCustomize(etnia);
        this.myPrincipal.cmbEtnia.setModel(to);
        this.myPrincipal.cmbEtnia.requestFocusInWindow();
    }
    
    public void setSelectedItemResguardo(Resguardo resguardo){
        ToComboBoxModel to = (ToComboBoxModel)this.myPrincipal.cmbResguardo.getModel(); 
        to.setSelectedItemCustomize(resguardo);
        this.myPrincipal.cmbResguardo.setModel(to);
        this.myPrincipal.cmbResguardo.requestFocusInWindow();
    }
    
    public void setSelectedItemGenero(String nombre){
        ComboBoxModel to = this.myPrincipal.cmbGenero.getModel();
        to.setSelectedItem(nombre);
        this.myPrincipal.cmbGenero.setModel(to);
        this.myPrincipal.cmbGenero.requestFocusInWindow();
    }
    
    public void llenarAnioMatricula(int id_sede){
       ArrayList<Anio> anios = this.anioBusiness.getAllAniosPorSede(id_sede);
        this.myPrincipal.cmbAnioMatricula.setModel(new ToComboBoxModel(anios, "getAnio"));
    }
    public void llenarJornadaMatricula(int anio){
       ArrayList<Jornada> jornadas = this.jornadaBusiness.selectAllJornadaPorAnio(anio);
        this.myPrincipal.cmbJornadaMatricula.setModel(new ToComboBoxModel(jornadas, "getNombre"));
    }
    
    public void llenarGradoMatricula(int jornada){
       ArrayList<Grado> grados = this.gradoBusiness.selectAllGradosPorJornada(jornada);
        this.myPrincipal.cmbGradoMatricula.setModel(new ToComboBoxModel(grados, "getNombre"));
    }
    
    public void llenarCursoMatricula(int grado){
       ArrayList<Curso> cursos = this.cursoBusiness.selectAllCursosPorGrado(grado);
        this.myPrincipal.cmbCursoMatricula.setModel(new ToComboBoxModel(cursos, "getNombre"));
    }
    
    public void llenarAnioCalificacion(int id_sede){
       ArrayList<Anio> anios = this.anioBusiness.getAllAniosPorSede(id_sede);
        this.myPrincipal.cmbAnioCalificaciones.setModel(new ToComboBoxModel(anios, "getAnio"));
    }
    public void llenarJornadaCalificacion(int anio){
       ArrayList<Jornada> jornadas = this.jornadaBusiness.selectAllJornadaPorAnio(anio);
        this.myPrincipal.cmbJornadaCalificaciones.setModel(new ToComboBoxModel(jornadas, "getNombre"));
    }
    
    public void llenarGradoCalificacion(int jornada){
       ArrayList<Grado> grados = this.gradoBusiness.selectAllGradosPorJornada(jornada);
        this.myPrincipal.cmbGradoCalificaciones.setModel(new ToComboBoxModel(grados, "getNombre"));
    }
    
    public void llenarCursoCalificacion(int grado){
       ArrayList<Curso> cursos = this.cursoBusiness.selectAllCursosPorGrado(grado);
        this.myPrincipal.cmbCursoCalificaciones.setModel(new ToComboBoxModel(cursos, "getNombre"));
    }
      
    public void llenarPeriodoPorJornada(int jornada){
       ArrayList<Periodo> periodos = this.periodoBusiness.selectAllPeriodosSinJornada(jornada);
        this.myPrincipal.cmbPeriodoCalificaciones.setModel(new ToComboBoxModel(periodos, "getComentario"));
    }
    
}
