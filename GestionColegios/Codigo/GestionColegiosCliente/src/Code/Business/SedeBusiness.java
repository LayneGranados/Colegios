/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.SedeDAOImpl;
import Code.Domain.Sede;
import java.util.ArrayList;

/**
 *
 * @author laygrana
 */
public class SedeBusiness {
    
    SedeDAOImpl sedeDAOImpl;

    public SedeBusiness() {
        this.sedeDAOImpl = new SedeDAOImpl();
    }
    
    public Sede guardarSede(Sede s) {      
       return this.sedeDAOImpl.guardarSede(s);
    }
    
    public ArrayList<Sede> selectAllSedes(int colegio){
        return this.sedeDAOImpl.selectAllSedes(colegio);
    }
    
    public ArrayList<Sede> getTodasLasSedes(){
        return this.sedeDAOImpl.getTodasLasSedes();
    }
    
    public Sede updateSede(Sede s) {
        return this.sedeDAOImpl.updateSede(s);
    }
    
    public Sede sedePorId(int id_s){
        return this.sedeDAOImpl.sedePorid(id_s);
    }
    
    public ArrayList<Sede> allSedesPorAnio(int anio){
        
        return this.sedeDAOImpl.selectAllSedesPorAnio(anio);
    }
    
}
