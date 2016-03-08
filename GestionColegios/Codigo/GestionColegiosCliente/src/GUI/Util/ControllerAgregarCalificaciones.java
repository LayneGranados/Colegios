/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Util;

import Code.Business.AsignaturaBusiness;
import Code.Business.CaracteristicaBoletinBusiness;
import Code.Domain.Asignatura;
import Code.Domain.CaracteristicaBoletin;
import GUI.CalificacionEstudianteModal;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class ControllerAgregarCalificaciones {
    
    AsignaturaBusiness asignaturaBusiness;
    CaracteristicaBoletinBusiness caracteristicaBoletinBusiness;
    CalificacionEstudianteModal myCalificacion;

    public ControllerAgregarCalificaciones(CalificacionEstudianteModal calificacionEstudianteModal) {
        this.asignaturaBusiness = new AsignaturaBusiness();
        this.caracteristicaBoletinBusiness = new CaracteristicaBoletinBusiness();
        this.myCalificacion = calificacionEstudianteModal;
    }
    
    public void llenarAsignaturaPorCursoCalificacion(int curso){
        ArrayList<Asignatura> asignaturas = this.asignaturaBusiness.asignaturasPorCurso(curso);
        this.myCalificacion.cmbAsignaturaCalificaciones.setModel(new ToComboBoxModel(asignaturas, "getNombre"));
    }
    
    public void llenarCaracteristicaBoletin(){
        ArrayList<CaracteristicaBoletin> caracteristicas = this.caracteristicaBoletinBusiness.getCaracteristicaBoletin();
        this.myCalificacion.cmbTipoCalificacion.setModel(new ToComboBoxModel(caracteristicas, "getNombre"));
    }
    
    public Object getObjetoSeleccionado(JComboBox combo) {
        return ((JComboBox) combo).getObjectSelected();
    }
    
    public void setSelectedItemAsignatura(Asignatura asig){
        ToComboBoxModel to = (ToComboBoxModel)this.myCalificacion.cmbAsignaturaCalificaciones.getModel(); 
        to.setSelectedItemCustomize(asig);
        this.myCalificacion.cmbAsignaturaCalificaciones.setModel(to);
        this.myCalificacion.cmbAsignaturaCalificaciones.requestFocusInWindow();
    }
    
    public void setSelectedItemTipoCalificacion(CaracteristicaBoletin carac){
        ToComboBoxModel to = (ToComboBoxModel)this.myCalificacion.cmbTipoCalificacion.getModel(); 
        to.setSelectedItemCustomize(carac);
        this.myCalificacion.cmbTipoCalificacion.setModel(to);
        this.myCalificacion.cmbTipoCalificacion.requestFocusInWindow();
    }
}
