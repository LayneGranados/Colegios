/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Asignatura;
import Code.Domain.Grado;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class AsignaturaDAOImpl {
    
    String todosLosGrados="select * from grado";
    String asignaturasPorCurso="select a.*, ac.asignatura_curso_id from asignatura_curso ac inner join curso c on ac.curso_id = c.curso_id inner join asignatura a on ac.asignatura_id = a.asignatura_id where c.curso_id =?";
    String insert="insert into grado (nombre, jornada_id)"
            + "values (";
    String update="update grado set";
    
    
     public Grado guardarGrado(Grado g) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+""+
                g.getNombre()+","+
                g.getJornadaId()+"')";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    g.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return g;
    }
     
     public Grado updateSede(Grado g) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                "nombre="+g.getNombre()+", "+
                "jornada:Id='"+g.getJornadaId()+"' where grado_id="+g.getId();
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    g.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return g;
    }
    
    public ArrayList<Asignatura> selectAllAsignaturaPorCurso(int curso){
        ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        try{
            if(miConexion!=null)
            {   
                PreparedStatement preparedStatement = miConexion.prepareStatement(this.asignaturasPorCurso);
                preparedStatement.setInt(1, curso);
                Statement st = miConexion.createStatement();
                ResultSet rs = preparedStatement.executeQuery();
                Asignatura a = new Asignatura();
                a.setId(-1);
                a.setNombre("No Seleccionado");
                asignaturas.add(a);
                while (rs.next())
                {
                    a = new Asignatura();
                    a.setId(rs.getInt("asignatura_id"));
                    a.setNombre(rs.getString("nombre"));
                    a.setIdAsignaturaCurso(rs.getInt("asignatura_curso_id"));
                    asignaturas.add(a);
                }
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return asignaturas;
        
    }
    
}
