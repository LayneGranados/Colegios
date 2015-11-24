/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.EstudianteDAOImpl;
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
        
        //this.getEstudianteDAO().guardarEstudiante();
    
    }
    
    /*
    estrato
    sisben
    nombre2
    nombre1
    apellido2
    apellido1
    fecha_nacimiento
    genero
    documento
    direccion_residencia
    proviene_sector_privado
    proviene_otro_municipio
    
    tipo_discapacidad_id
    
    resguardo_id
    res_mun
    res_depto
    
    poblacion_victima_id
    persona_id
    
    nac_mun
    nac_depto
    mun_expulsor
    exp_mun
    exp_depto
    etnia_id
    
    dep_expulsor
    capacidad_excepcional_id
    */
    
    
    
}
