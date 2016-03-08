/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.CalificacionDAOImpl;
import Code.Domain.Asignatura;
import Code.Domain.CaracteristicaBoletin;
import Code.Domain.DetalleCalificacion;
import Code.Domain.Matricula;
import Code.Domain.Periodo;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class CalificacionBusiness {
    
    CalificacionDAOImpl calificacionDAO;

    public CalificacionBusiness() {
        this.calificacionDAO = new CalificacionDAOImpl();
    }
    
    public DetalleCalificacion guardarCalificacion(Matricula matricula, Periodo periodo, String observaciones, Asignatura asignatura, CaracteristicaBoletin caractacteristica, String valorNota, String observacionesNota){
        return this.calificacionDAO.guardarCalificacion(matricula, periodo, observaciones, asignatura, caractacteristica, valorNota, observacionesNota);
    }
    
    public ArrayList<DetalleCalificacion> getListadoTabla(Matricula matricula, Periodo periodo) {
        return this.calificacionDAO.getListadoTabla(matricula, periodo);
    }
    
    public void deleteCalificacionYDetalle(int idCalificacion){
        this.calificacionDAO.deleteCalificacionYDetalle(idCalificacion);
    }
    
    public void updateCalificacion(DetalleCalificacion detalle){
        this.calificacionDAO.updateCalificacion(detalle);
    }
    
    public ArrayList<String> buscarCalificacionDeAsignatura(int idCurso, int periodoId){
        return this.calificacionDAO.buscarCalificacionDeAsignatura(idCurso,periodoId);
    }
    
    
    
    
}
