/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Estudiante;
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
    String guardarEstudiante="insert into estudiante (codigo, persona_id) values('";
    
    public Boolean guardarEstudiante(Estudiante e){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        this.guardarEstudiante +=e.getCodigo()+"',"+e.getPersona().getId()+")";
        try{
            if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            
            result = st.equals(guardarEstudiante);
            st.close();
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return result;
    }
    
    
    
}