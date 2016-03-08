/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Grado;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author laynegranadosmogollon
 */
public class GradoDAOImpl {
    
    String todosLosGrados="select * from grado";
    String gradoPorJornada="select * from grado where jornada_id=";
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
        String query="";
        query=this.update+" "+
                "nombre="+g.getNombre()+", "+
                "jornada:Id='"+g.getJornadaId()+"' where grado_id="+g.getId();         
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
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return g;
    }
    
    public ArrayList<Grado> selectAllGradosPorJornada(int jornada){
        
        ArrayList<Grado> grados = new ArrayList<Grado>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.gradoPorJornada+""+jornada;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Grado g = new Grado();                    
                    g.setNombre(rs.getString("nombre"));
                    g.setJornadaId(rs.getInt("jornada_id"));
                    g.setId(rs.getInt("grado_id"));
                    grados.add(g);
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
        return grados;
    }
    
}
