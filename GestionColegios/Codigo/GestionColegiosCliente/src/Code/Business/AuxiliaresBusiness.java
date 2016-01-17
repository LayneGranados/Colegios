/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AuxiliaresDAOImpl;
import Code.Domain.Departamento;
import Code.Domain.Etnia;
import Code.Domain.Municipio;
import Code.Domain.Resguardo;
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
    
    
    public ArrayList<String> getAllCursoPorGrado(int g) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllCursoPorGrado(g);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
    public ArrayList<String> getAllGradoPorJornada(int g) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllGradoPorJornada(g);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
    public ArrayList<String> getAllPeriodoPorJornada(int p) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllPeriodoPorJornada(p);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
    public ArrayList<String> getAllJornadaPorAnio(int j) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllJornadaPorAnio(j);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
    public ArrayList<String> getAllAnio(int a) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllAnio(a);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
    public ArrayList<String> getAllSedes(int c) throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllSedes(c);
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
        
    }
    
    public ArrayList<String> getAllColegios() throws SQLException{
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllColegios();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
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
    public ArrayList<String> getAllSituacionesAnteriores(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllSituacionesAnteriores();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllCondicionesAnteriores(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllCondicionesAnteriores();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllFuentesRecursos(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllFuentesRecursos();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllInstitucionFamiliar(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllInstitucionFamiliar();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllCapacidadExcepcional(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllCapacidadExcepcional();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllTipDiscapacidad(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllTipoDiscapacidad();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllPoblacionVictima(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllPoblacionVictima();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllCaracter(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllCaracter();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllMetodologia(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllMetodologia();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllEspecialidad(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllEspecialidad();
        }catch(SQLException e){
            combo = new ArrayList<String>();
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
}
