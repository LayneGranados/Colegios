/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.PeriodoDAOImpl;
import Code.Domain.Periodo;
import java.util.ArrayList;

/**
 *
 * @author laygrana
 */
public class PeriodoBusiness {
    
    PeriodoDAOImpl PeriodoDAOImpl;

    public PeriodoBusiness() {
        this.PeriodoDAOImpl = new PeriodoDAOImpl();
    }
    
    public Periodo guardarPeriodo(Periodo p) {      
       return this.PeriodoDAOImpl.guardarPeriodo(p);
    }
    
    public ArrayList<Periodo> selectAllPeriodo(int colegio){
        return this.PeriodoDAOImpl.selectAllPeriodos(colegio);
    }
    
    public Periodo updatePeriodo(Periodo p) {
        return this.PeriodoDAOImpl.updatePeriodo(p);
    }
    
    public ArrayList<Periodo> getTodosLosPeriodos(){
        return this.PeriodoDAOImpl.getTodosLosPeriodos();
    }
    
}