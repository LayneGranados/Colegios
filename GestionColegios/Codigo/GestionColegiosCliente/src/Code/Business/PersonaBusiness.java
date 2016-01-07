/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.EstudianteDAOImpl;
import Code.DAO.PersonaDAOImpl;
import Code.Domain.Persona;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class PersonaBusiness {
    
    PersonaDAOImpl personaDAO;

    public PersonaBusiness() {
        this.personaDAO = new PersonaDAOImpl();
    }

    public PersonaDAOImpl getPersonaDAO() {
        return personaDAO;
    }

    public void setPersonaDAO() {
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public Persona getPersona(Persona p){
        return this.personaDAO.getPersona(p);
    }
    
    public boolean guardarPersona(Persona p){
        return this.personaDAO.guardarPersona(p);
    }
    
    public ArrayList<Persona> buscarPersonasPorArgumentos(Persona p){
        return this.personaDAO.buscarPersonasPorArgumentos(p);
    }
    
}
