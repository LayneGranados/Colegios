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
import Code.Business.TipoJornadaBusiness;
import Code.Domain.Anio;
import Code.Domain.Sede;
import Code.Domain.TipoJornada;
import GUI.AnioModal;
import GUI.JornadaModal;
import java.util.ArrayList;

/**
 *
 * @author AndresOrlando
 */
public class ControllerComboJornada {
    
    private TipoJornadaBusiness tipoJornadaBusiness;
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
        this.tipoJornadaBusiness = new TipoJornadaBusiness();
        
        this.llenarCombos();
        
    }
    
    public Object getObjetoSeleccionado (JComboBox combo){
        return ((JComboBox)combo).getObjectSelected();
    }
    
    public void llenarCombos() {
        ArrayList<Sede> sedes = this.sedeBusiness.getTodasLasSedes();
        this.myJornada.cmbSedeJornada.setModel(new ToComboBoxModel(sedes, "getNombre"));
        
        ArrayList<TipoJornada> tipoJornada = this.tipoJornadaBusiness.getTodasLosTipoJornada();
        this.myJornada.cmbTipoDeJornada.setModel(new ToComboBoxModel(tipoJornada, "getNombre"));
    }
    
         
    public void llenarAnioJornada(int id_sede){
       ArrayList<Anio> anios = this.anioBusiness.getAllAniosPorSede(id_sede);
        this.myJornada.cmbAnioJornada.setModel(new ToComboBoxModel(anios, "getAnio"));
    }
    
    public void setSelectedItemTipoJornada (TipoJornada tj){
        
        ToComboBoxModel to = (ToComboBoxModel)this.myJornada.cmbTipoDeJornada.getModel();
        to.setSelectedItemCustomize(tj);
        this.myJornada.cmbTipoDeJornada.setModel(to);
        this.myJornada.cmbTipoDeJornada.requestFocusInWindow();
    }
    
    public void setSelectedItemSede (Sede sede){
        
        ToComboBoxModel to = (ToComboBoxModel)this.myJornada.cmbSedeJornada.getModel();
        to.setSelectedItemCustomize(sede);
        this.myJornada.cmbSedeJornada.setModel(to);
        this.myJornada.cmbSedeJornada.requestFocusInWindow();
    }
    
    public void setSelectedItemAnio(Anio anio){
        
        ToComboBoxModel to = (ToComboBoxModel)this.myJornada.cmbAnioJornada.getModel();
        to.setSelectedItemCustomize(anio);
        this.myJornada.cmbAnioJornada.setModel(to);
        this.myJornada.cmbAnioJornada.requestFocusInWindow();
    }
}
