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
    
    EstudianteDAOImpl estudiante;
    PersonaDAOImpl persona;

    public EstudianteBusiness() {
        this.estudiante = new EstudianteDAOImpl();
        this.persona = new PersonaDAOImpl();
    }
    
    public void guardarEstudiante(Estudiante e){
        this.persona.guardarPersona(e.getPersona());
        Persona p = this.persona.getPersona(e.getPersona());
        e.setPersona(p);
        this.estudiante.guardarEstudiante(e);
    }
    
    public void buscarEstudiante(Estudiante e){
        this.persona.guardarPersona(e.getPersona());
        Persona p = this.persona.getPersona(e.getPersona());
        e.setPersona(p);
        this.estudiante.guardarEstudiante(e);
    }
    
}
