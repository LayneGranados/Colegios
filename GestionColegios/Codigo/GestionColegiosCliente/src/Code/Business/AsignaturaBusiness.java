/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AsignaturaDAOImpl;
import Code.Domain.Asignatura;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class AsignaturaBusiness {
    
    AsignaturaDAOImpl asignaturaDAO;

    public AsignaturaBusiness() {
        this.asignaturaDAO = new AsignaturaDAOImpl();
    }
    
    public ArrayList<Asignatura> asignaturasPorCurso(int curso){
        return asignaturaDAO.selectAllAsignaturaPorCurso(curso);
    }
    
    
    
}
