/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.GradoDAOImpl;
import Code.Domain.Grado;
import java.util.ArrayList;

/**
 *
 * @author laygrana
 */
public class GradoBusiness {
    
    GradoDAOImpl gradoDAOImpl;

    public GradoBusiness() {
        this.gradoDAOImpl = new GradoDAOImpl();
    }
    
    public Grado guardarGrado(Grado g) {      
       return this.gradoDAOImpl.guardarGrado(g);
    }
    
    public ArrayList<Grado> selectAllGrados(int colegio){
        return this.gradoDAOImpl.selectAllGrados(colegio);
    }
    
    public Grado updateGrado(Grado g) {
        return this.gradoDAOImpl.guardarGrado(g);
    }
    
    
    
}
