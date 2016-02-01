/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AuxiliaresDAOImpl;
import Code.Domain.CapacidadExcepcional;
import Code.Domain.Caracter;
import Code.Domain.CondicionAnioAnterior;
import Code.Domain.Departamento;
import Code.Domain.Especialidad;
import Code.Domain.Etnia;
import Code.Domain.FuenteRecursos;
import Code.Domain.InstitucionFamiliarOrigen;
import Code.Domain.Metodologia;
import Code.Domain.Municipio;
import Code.Domain.PoblacionVictimaConflicto;
import Code.Domain.Resguardo;
import Code.Domain.SituacionAnioAnterior;
import Code.Domain.TipoDiscapacidad;
import Code.Domain.TipoDocumento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laynegranadosmogollon
 */
public class AuxiliaresBusiness {
    
    AuxiliaresDAOImpl auxiliarDAO;

    public AuxiliaresBusiness() {
        this.auxiliarDAO = new AuxiliaresDAOImpl();
    }
   
    
   
   
    
    public ArrayList<Departamento> getAllDepartamentos(){
        ArrayList<Departamento> combo;
        try{
            combo = this.auxiliarDAO.getAllDepartamentos();
        }catch(SQLException e){
            combo = new ArrayList<Departamento>();
        }
        return combo;
    }
    
  
    public ArrayList<Municipio> getAllMunicipiosPorDepartamento(int d){
        ArrayList<Municipio> combo;
        try{
            combo = this.auxiliarDAO.getAllMunicipiosPorDepartamento(d);
        }catch(SQLException e){
            combo = new ArrayList<Municipio>();
        }
        return combo;
    }
    public ArrayList<SituacionAnioAnterior> getAllSituacionesAnteriores(){
        ArrayList<SituacionAnioAnterior> combo;
        try{
            combo = this.auxiliarDAO.getAllSituacionesAnteriores();
        }catch(SQLException e){
            combo = new ArrayList<SituacionAnioAnterior>();
        }
        return combo;
    }
    public ArrayList<CondicionAnioAnterior> getAllCondicionesAnteriores(){
        ArrayList<CondicionAnioAnterior> combo;
        try{
            combo = this.auxiliarDAO.getAllCondicionesAnteriores();
        }catch(SQLException e){
            combo = new ArrayList<CondicionAnioAnterior>();
        }
        return combo;
    }
    public ArrayList<FuenteRecursos> getAllFuentesRecursos(){
        ArrayList<FuenteRecursos> combo;
        try{
            combo = this.auxiliarDAO.getAllFuentesRecursos();
        }catch(SQLException e){
            combo = new ArrayList<FuenteRecursos>();
        }
        return combo;
    }
    public ArrayList<InstitucionFamiliarOrigen> getAllInstitucionFamiliar(){
        ArrayList<InstitucionFamiliarOrigen> combo;
        try{
            combo = this.auxiliarDAO.getAllInstitucionFamiliar();
        }catch(SQLException e){
            combo = new ArrayList<InstitucionFamiliarOrigen>();
        }
        return combo;
    }
    public ArrayList<CapacidadExcepcional> getAllCapacidadExcepcional(){
        ArrayList<CapacidadExcepcional> combo;
        try{
            combo = this.auxiliarDAO.getAllCapacidadExcepcional();
        }catch(SQLException e){
            combo = new ArrayList<CapacidadExcepcional>();
        }
        return combo;
    }
    public ArrayList<TipoDiscapacidad> getAllTipDiscapacidad(){
        ArrayList<TipoDiscapacidad> combo;
        try{
            combo = this.auxiliarDAO.getAllTipoDiscapacidad();
        }catch(SQLException e){
            combo = new ArrayList<TipoDiscapacidad>();
        }
        return combo;
    }
    public ArrayList<PoblacionVictimaConflicto> getAllPoblacionVictima(){
        ArrayList<PoblacionVictimaConflicto> combo;
        try{
            combo = this.auxiliarDAO.getAllPoblacionVictima();
        }catch(SQLException e){
            combo = new ArrayList<PoblacionVictimaConflicto>();
        }
        return combo;
    }
    public ArrayList<Caracter> getAllCaracter(){
        ArrayList<Caracter> combo;
        try{
            combo = this.auxiliarDAO.getAllCaracter();
        }catch(SQLException e){
            combo = new ArrayList<Caracter>();
        }
        return combo;
    }
    public ArrayList<Metodologia> getAllMetodologia(){
        ArrayList<Metodologia> combo;
        try{
            combo = this.auxiliarDAO.getAllMetodologia();
        }catch(SQLException e){
            combo = new ArrayList<Metodologia>();
        }
        return combo;
    }
    public ArrayList<Especialidad> getAllEspecialidad(){
        ArrayList<Especialidad> combo;
        try{
            combo = this.auxiliarDAO.getAllEspecialidad();
        }catch(SQLException e){
            combo = new ArrayList<Especialidad>();
        }
        return combo;
    }
    public ArrayList<Resguardo> getAllResguardo(){
        ArrayList<Resguardo> combo;
        try{
            combo = this.auxiliarDAO.getAllResguardo();
        }catch(SQLException e){
            combo = new ArrayList<Resguardo>();
        }
        return combo;
    }
    public ArrayList<Etnia> getAllEtnia(){
        ArrayList<Etnia> combo;
        try{
            combo = this.auxiliarDAO.getAllEtnia();
        }catch(SQLException e){
            combo = new ArrayList<Etnia>();
        }
        return combo;
    }
    public ArrayList<TipoDocumento> getAllTipoDocumento(){
        ArrayList<TipoDocumento> combo;
        try{
            combo = this.auxiliarDAO.getAllTipoDocumento();
        }catch(SQLException e){
            combo = new ArrayList<TipoDocumento>();
        }
        return combo;
    }
    public Integer getColegioActual(){
        Integer colegioActual;
        try{
            colegioActual = this.auxiliarDAO.getColegioActual();
        }catch(SQLException e){
            colegioActual = 1;
        }
        return colegioActual;
    }
    
        
    
    public Municipio getMunicipioPorId(int id){
        Municipio m;
        try {
            m = this.auxiliarDAO.getMunicipioPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliaresBusiness.class.getName()).log(Level.SEVERE, null, ex);
            m = new Municipio();
        }
        return m;
    }
    
    public Departamento getDepartamentoPorId(int id){
        Departamento d;
        try {
            d = this.auxiliarDAO.getDepartamentoPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliaresBusiness.class.getName()).log(Level.SEVERE, null, ex);
            d = new Departamento();
        }
        return d;
    }
    
    public Resguardo getResguardoPorId(int id){
        Resguardo r;
        try {
            r = this.auxiliarDAO.getResguardoPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliaresBusiness.class.getName()).log(Level.SEVERE, null, ex);
            r = new Resguardo();
        }
        return r;
    }
    
    public Etnia getEtniaPorId(int id){
        Etnia e;
        try {
            e = this.auxiliarDAO.getEtniaPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(AuxiliaresBusiness.class.getName()).log(Level.SEVERE, null, ex);
            e = new Etnia();
        }
        return e;
    }
}
