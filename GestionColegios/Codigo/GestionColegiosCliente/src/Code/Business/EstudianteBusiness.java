/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.EstudianteDAOImpl;
import Code.DAO.PersonaDAOImpl;
import Code.Domain.Estudiante;
import Code.Domain.Persona;

/**
 *
 * @author laynegranadosmogollon
 */
public class EstudianteBusiness {
    
    EstudianteDAOImpl estudianteDAO;
    PersonaDAOImpl personaDAO;

    public EstudianteBusiness() {
        this.estudianteDAO = new EstudianteDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public void guardarEstudiante(Estudiante e){
        this.personaDAO.guardarPersona(e.getPersona());
        Persona p = this.personaDAO.getPersona(e.getPersona());
        e.setPersona(p);
        this.estudianteDAO.guardarEstudiante(e);
    }
    
    public Estudiante buscarEstudiante(Estudiante e){
        Persona p = this.personaDAO.getPersona(e.getPersona());
        e.setPersona(p);
        Estudiante encontrado = this.estudianteDAO.getEstudianteMasCampos(e);  
        return encontrado;
    }
    
    public Estudiante buscarEstudiantePorDocumento(Estudiante e){
        Persona p = this.personaDAO.getPersonaMasCampos(e.getPersona());
        e.setPersona(p);
        Estudiante encontrado = this.estudianteDAO.getEstudianteMasCampos(e);  
        return encontrado;
    }
    
}
