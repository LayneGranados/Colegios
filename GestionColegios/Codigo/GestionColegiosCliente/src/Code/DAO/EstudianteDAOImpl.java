/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Estudiante;
import Code.Domain.Persona;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laynegranadosmogollon
 */
public class EstudianteDAOImpl {

    String todosLosEstudiantes="select * from estudiante";
    String estudiantePorId="SELECT * FROM estudiante WHERE estudiante_id=";
    String estudiantePorCodigo="SELECT * FROM estudiante WHERE codigo=";
    String estudiantePorPersona="SELECT * FROM estudiante WHERE persona_id=";
    String guardarEstudiante="insert into estudiante (persona_id) values(";
    
    public Boolean guardarEstudiante(Estudiante e){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                result = st.execute(this.guardarEstudiante +e.getPersona().getId()+")");
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return result;
    }
    
    public Estudiante getEstudianteMasCampos(Estudiante e){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();              
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(this.estudiantePorPersona+e.getPersona().getId());
                while (rs.next())
                {
                   e.setId(rs.getInt("estudiante_id"));
                }
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return e;
    }
    
    
    
}
