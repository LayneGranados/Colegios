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
import Code.Business.JornadaBusiness;
import Code.Business.MatriculaBusiness;
import Code.Business.PersonaBusiness;
import Code.Domain.Jornada;
import GUI.PeriodoModal;
import java.util.ArrayList;

/**
 *
 * @author AndresOrlando
 */
public class ControllerComboPeriodo {
    
    private PeriodoModal myPeriodo;
    private CertificacionBusiness certificacionBusiness;
    private ConfiguracionBusiness configutacionBusiness;
    public MatriculaBusiness matriculaBusiness;
    public EstudianteBusiness estudianteBusiness;
    public PersonaBusiness personaBusiness;
    public AuxiliaresBusiness auxiliaresBusiness;
    public JornadaBusiness jornadaBusiness;
    
    public ControllerComboPeriodo (PeriodoModal periodoModal){
        this.myPeriodo = periodoModal;
        
        //Inicializacion de objetos del negocio
        jornadaBusiness = new JornadaBusiness();
        this.certificacionBusiness = new CertificacionBusiness();
        this.configutacionBusiness = new ConfiguracionBusiness();
        this.matriculaBusiness = new MatriculaBusiness();
        this.auxiliaresBusiness = new AuxiliaresBusiness();
        this.personaBusiness = new PersonaBusiness();
        this.estudianteBusiness = new EstudianteBusiness();
        
        this.llenarCombos();
    }
    
    private void llenarCombos(){
        ArrayList<Jornada> jornadas = this.jornadaBusiness.getTodasLasJornadas();
        this.myPeriodo.cmbJornadaPeriodo.setModel(new ToComboBoxModel(jornadas,"getNombre"));
    }
    
    public Object getObjetoSeleccionado(JComboBox combo){
        return ((JComboBox) combo).getObjectSelected();
    }
    
    public void setSelectItemJornada (Jornada jor){
        ToComboBoxModel to = (ToComboBoxModel)this.myPeriodo.cmbJornadaPeriodo.getModel();
        to.setSelectedItemCustomize(jor);
        this.myPeriodo.cmbJornadaPeriodo.setModel(to);
        this.myPeriodo.cmbJornadaPeriodo.requestFocusInWindow();
    }
}
