/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.CursoDAOImpl;
import Code.Domain.Curso;
import java.util.ArrayList;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class CursoBusiness {
    
    CursoDAOImpl CursoDAOImpl;

    public CursoBusiness() {
        this.CursoDAOImpl = new CursoDAOImpl();
    }
    
    public Curso guardarCurso(Curso c) {      
       return this.CursoDAOImpl.guardarCurso(c);
    }
    
    public ArrayList<Curso> selectAllCursos(int colegio){
        return this.CursoDAOImpl.selectAllCursos(colegio);
    }
    
    public Curso updateCurso(Curso c) {
        return this.CursoDAOImpl.updateCurso(c);
    }
    
    
    
}
