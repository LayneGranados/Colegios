/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Caracter;
import Code.Domain.Curso;
import Code.Domain.Especialidad;
import Code.Domain.Metodologia;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class CursoDAOImpl {
    
    String todosLosCursos="select * from curso";
    String cursoPorGrado="select cr.*, m.nombre as metodologia_nombre, c.nombre as caracter_nombre, e.nombre as especialidad_nombre from curso cr, metodologia m, caracter c, especialidad e where cr.caracter_id = c.caracter_id and cr.especialidad_id = e.especialidad_id and cr.metodologia_id=m.metodologia_id and grado_id=";
    String cursoPorCaracter="select * from curso where caracter_id=";
    String cursoPorEspecialidad="select * from curso where especialidad_id=";
    String cursoPorMetodologia="select * from curso where metodologia_id=";
    String cursoPorId="select * from curso where cursoid=";
    String insert="insert into curso (grado_id, nombre, caracter_id, especialidad_id, metodologia_id)"
            + "values (";
    String update="update curso set";
    
    
     public Curso guardarCurso(Curso c) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+""+
                c.getGradoId()+","+
                c.getNombre()+","+
                c.getCaracter().getId()+","+
                c.getEspecialidad().getId()+","+
                c.getMetodologia().getId()+")";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    c.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return c;
    }
     
     public Curso updateCurso(Curso c) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                "grado_id="+c.getGradoId()+", "+
                "nombre='"+c.getNombre()+"', "+
                "caracter_id="+c.getCaracter().getId()+", "+
                "especialidad_id="+c.getEspecialidad().getId()+", "+
                "metodologia_id="+c.getMetodologia().getId()+", "+
                "where sede_id="+c.getId();
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    c.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return c;
    }
    
    public ArrayList<Curso> selectAllCursosPorGrado(int grado){
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.cursoPorGrado+""+grado;
        System.out.println(query);
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Curso c = new Curso();
                    Caracter caracter = new Caracter();
                    Especialidad especialidad = new Especialidad();
                    Metodologia metodologia = new Metodologia();
                    
                    c.setGradoId(rs.getInt("grado_id"));
                    c.setNombre(rs.getString("nombre"));
                    caracter.setId(rs.getInt("caracter_id"));
                    caracter.setNombre(rs.getString("caracter_nombre"));
                    especialidad.setId(rs.getInt("especialidad_id"));
                    especialidad.setNombre(rs.getString("especialidad_nombre"));
                    metodologia.setId(rs.getInt("metodologia_id"));
                    metodologia.setNombre(rs.getString("metodologia_nombre"));
                    c.setId(rs.getInt("curso_id"));
                    cursos.add(c);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return cursos;
    }
    
}
