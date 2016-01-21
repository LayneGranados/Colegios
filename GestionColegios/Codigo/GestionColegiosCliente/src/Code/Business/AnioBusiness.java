/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AnioDAOImpl;
import Code.Domain.Anio;
import java.util.ArrayList;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class AnioBusiness {
    
    AnioDAOImpl anioDAOImpl;

    public AnioBusiness() {
        this.anioDAOImpl = new AnioDAOImpl();
    }
    
    public Anio guardarAnio(Anio a) {      
       return this.anioDAOImpl.guardarAnio(a);
    }
    
    public ArrayList<Anio> selectAllAnios(){
        return this.anioDAOImpl.selectAllAnios();
    }
    
    public Anio updateAnio(Anio a) {
        return this.anioDAOImpl.updateAnio(a);
    }
       
}
