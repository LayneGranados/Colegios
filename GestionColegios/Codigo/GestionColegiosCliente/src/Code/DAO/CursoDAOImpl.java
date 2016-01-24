/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Curso;
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
    String cursoPorGrado="select * from curso where grado_id=";
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
                c.getNombre()+",'"+
                c.getCaracterId()+"',"+
                c.getEspecialidadId()+",'"+
                c.getMetodologiaId()+"')";
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
                "caracter_id="+c.getCaracterId()+", "+
                "especialidad_id="+c.getEspecialidadId()+", "+
                "metodologia_id="+c.getMetodologiaId()+", "+
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
    
    public ArrayList<Curso> selectAllCursos(int colegio){
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.cursoPorGrado+""+colegio;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Curso c = new Curso();
                    c.setGradoId(rs.getInt("grado_id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setCaracterId(rs.getInt("caracter_id"));
                    c.setEspecialidadId(rs.getInt("especialidad_id"));
                    c.setMetodologiaId(rs.getInt("metodologia_id"));
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
