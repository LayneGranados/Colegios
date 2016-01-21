/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

import Code.Business.AnioBusiness;
import Code.Business.AuxiliaresBusiness;
import Code.Business.CertificacionBusiness;
import Code.Business.ConfiguracionBusiness;
import Code.Business.EstudianteBusiness;
import Code.Business.MatriculaBusiness;
import Code.Business.PersonaBusiness;
import Code.Business.SedeBusiness;
import Code.Domain.Anio;
import Code.Domain.Sede;
import GUI.AnioModal;
import GUI.JornadaModal;
import java.util.ArrayList;

/**
 *
 * @author AndresOrlando
 */
public class ControllerComboJornada {
    
    private JornadaModal myJornada;
    private AnioModal myAnio;
    public CertificacionBusiness certificacionBusiness;
    public ConfiguracionBusiness configuracionBusiness;
    public MatriculaBusiness matriculaBusiness;
    public EstudianteBusiness estudianteBusiness;
    public PersonaBusiness personaBusiness;
    public AuxiliaresBusiness auxiliaresBusiness;
    public SedeBusiness sedeBusiness;
    public AnioBusiness anioBusiness;
    
    public ControllerComboJornada (JornadaModal jornadaModal){
        this.myJornada = jornadaModal;
        //Inicializacion de objetos del negocio
        
        certificacionBusiness = new CertificacionBusiness();
        configuracionBusiness = new ConfiguracionBusiness();
        matriculaBusiness = new MatriculaBusiness();
        auxiliaresBusiness = new AuxiliaresBusiness();
        personaBusiness = new PersonaBusiness();
        this.estudianteBusiness = new EstudianteBusiness();
        this.sedeBusiness = new SedeBusiness();
        this.anioBusiness = new AnioBusiness();
        
        this.llenarComboSedes();
        
    }
    
    public Object getObjetoSeleccionado (JComboBox combo){
        return ((JComboBox)combo).getObjectSelected();
    }
    
    private void llenarCombos() {
        //ArrayList<Sede> sedes = this.auxiliaresBusiness.getAllSedes(this.myAnio.getActualColegio().getId());
        //this.myJornada.cmbSedeJornada.setModel(new ToComboBoxModel(sedes, "getNombre"));
    }
    
    private void llenarComboSedes(){
        ArrayList<Sede> sedes = this.sedeBusiness.selectAllSedes(this.myJornada.getAcualColegio().getId());
        this.myJornada.cmbSedeJornada.setModel(new ToComboBoxModel(sedes, "getNombre"));
    }
    
    private void llenarComboAnio(){
        
        ArrayList<Anio> anios = this.anioBusiness.selectAllAnios();
        this.myJornada.cmbAnioJornada.setModel(new ToComboBoxModel(anios, "getAnio"));
    }
    
    public void setSelectedItemSede (Sede sede){
        
        ToComboBoxModel to = (ToComboBoxModel)this.myJornada.cmbSedeJornada.getModel();
        to.setSelectedItemCustomize(sede);
        this.myJornada.cmbSedeJornada.setModel(to);
    }
    
    public void setSelectedItemAnio(Anio anio){
        
        ToComboBoxModel to = (ToComboBoxModel)this.myJornada.cmbAnioJornada.getModel();
        to.setSelectedItemCustomize(anio);
        this.myJornada.cmbAnioJornada.setModel(to);
    }
}
