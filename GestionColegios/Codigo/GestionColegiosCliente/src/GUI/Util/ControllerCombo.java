/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

import Code.Business.AuxiliaresBusiness;
import Code.Business.CertificacionBusiness;
import Code.Business.ConfiguracionBusiness;
import Code.Business.EstudianteBusiness;
import Code.Business.MatriculaBusiness;
import Code.Business.PersonaBusiness;
import Code.Domain.Departamento;
import Code.Domain.Etnia;
import Code.Domain.Municipio;
import Code.Domain.Resguardo;
import Code.Domain.TipoDocumento;
import GUI.Principal;
import GUI.Util.Objeto;
import GUI.Util.JComboBox;
import GUI.Util.ToComboBoxModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ControllerCombo {

    private Principal myPrincipal;
    public CertificacionBusiness certificacionBusiness;
    public ConfiguracionBusiness configuracionBusiness;
    public MatriculaBusiness matriculaBusiness;
    public EstudianteBusiness estudianteBusiness;
    public PersonaBusiness personaBusiness;
    public AuxiliaresBusiness auxiliaresBusiness;

    public ControllerCombo(Principal myPrincipal) {
        this.myPrincipal = myPrincipal;
        
        /** INICIALIZACION DE OBJETOS DEL NEGOCIO**/
        certificacionBusiness = new CertificacionBusiness();
        configuracionBusiness = new ConfiguracionBusiness();
        matriculaBusiness = new MatriculaBusiness();
        auxiliaresBusiness= new AuxiliaresBusiness();
        personaBusiness=new PersonaBusiness();
        this.estudianteBusiness = new EstudianteBusiness();
        
        this.llenarCombos();
    }

    private void llenarCombos() {
        ArrayList<TipoDocumento> tiposDeDocumento = this.auxiliaresBusiness.getAllTipoDocumento();
        ArrayList<Departamento> departamentos = this.auxiliaresBusiness.getAllDepartamentos();
        ArrayList<Resguardo> resguardos = this.auxiliaresBusiness.getAllResguardo();
        ArrayList<Etnia> etnias = this.auxiliaresBusiness.getAllEtnia();
        
        this.myPrincipal.cmbTipoDocumentoIdentificacion.setModel(new ToComboBoxModel(tiposDeDocumento, "getNombre"));
        this.myPrincipal.cmbDepartamentoExpedicion.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoNacimiento.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbDepartamentoResidencia.setModel(new ToComboBoxModel(departamentos, "getNombre"));
        this.myPrincipal.cmbEtnia.setModel(new ToComboBoxModel(etnias, "getNombre"));
        this.myPrincipal.cmbResguardo.setModel(new ToComboBoxModel(resguardos, "getNombre"));
        
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
    

}
