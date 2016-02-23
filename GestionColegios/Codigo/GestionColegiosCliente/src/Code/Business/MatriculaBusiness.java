/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.EstudianteDAOImpl;
import Code.DAO.MatriculaDAOImpl;
import Code.Domain.Matricula;
import Code.Util.PDFUtil;
import Code.Util.UtilidadesArchivo;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laynegranadosmogollon
 */
public class MatriculaBusiness {
    
    EstudianteDAOImpl estudianteDAO;
    MatriculaDAOImpl matriculaDAO;

    public MatriculaBusiness() {
        this.estudianteDAO = new EstudianteDAOImpl();
        this.matriculaDAO = new MatriculaDAOImpl();
    }
    
    public EstudianteDAOImpl getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAOImpl estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }
    
    public void procesarArchivoMatricula(String file){

        ArrayList<String> lineas = UtilidadesArchivo.leerLineasArchivo(file);
        for(int i=0;i<lineas.size();i++){
            System.out.println(lineas.get(i));
        }
    }
    
    public boolean guardarMatricula(Matricula m){
        boolean rs = false;
        try {
            rs = this.matriculaDAO.insertMatricula(m);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public Matricula getMatriculaEstudianteCurso(int estudianteId, int cursoId){
        Matricula m = new Matricula();
        m = this.matriculaDAO.getMatriculaPorEstudianteCurso(estudianteId, cursoId);
        return m;
    }
    
    public boolean buscarEstudianteMatriculadoEnCurso(int idEstudiante, int idCurso){
        return this.matriculaDAO.buscarEstudianteMatriculadoEnCurso(idEstudiante, idCurso);
    }
    
    
    
    
}
