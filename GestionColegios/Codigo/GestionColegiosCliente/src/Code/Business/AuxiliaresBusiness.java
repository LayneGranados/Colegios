/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AuxiliaresDAOImpl;
import Code.Domain.Departamento;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<String> getAllDepartamentos(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllDepartamentos();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllMunicipiosPorDepartamento(int d){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllMunicipiosPorDepartamento(d);
        }catch(SQLException e){
            combo = new ArrayList<String>();
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
    public ArrayList<String> getAllResguardo(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllResguardo();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllEtnia(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllEtnia();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    public ArrayList<String> getAllTipoDocumento(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllTipoDocumento();
        }catch(SQLException e){
            combo = new ArrayList<String>();
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
}
