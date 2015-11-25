/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.EstudianteDAOImpl;
import Code.Util.PDFUtil;
import Code.Util.UtilidadesArchivo;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class MatriculaBusiness {
    
    EstudianteDAOImpl estudianteDAO;

    public MatriculaBusiness() {
        this.estudianteDAO = new EstudianteDAOImpl();
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
    
    
    
    
    
}
