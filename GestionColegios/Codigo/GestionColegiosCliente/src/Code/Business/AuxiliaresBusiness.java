/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AuxiliaresDAOImpl;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class AuxiliaresBusiness {
    
    AuxiliaresDAOImpl auxiliarDAO;
    
    public ArrayList<String> getAllCaracter(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllCaracter();
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
    
    public ArrayList<String> getAllEtnia(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllEtnia();
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
    
    public ArrayList<String> getAllPoblacionVictima(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllPoblacionVictima();
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
    
    public ArrayList<String> getAllTipDocumento(){
        ArrayList<String> combo;
        try{
            combo = this.auxiliarDAO.getAllTipoDocumento();
        }catch(SQLException e){
            combo = new ArrayList<String>();
        }
        return combo;
    }
    
}
