/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Periodo;
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
public class PeriodoDAOImpl {
    
    String todosLosPeriodos="select * from periodo";
    String periodoPorJornada="select * from periodo where jornada_id=";
    String periodoPorId="select * from periodo where periodo_id=";
    String insert="insert into periodo (periodo_id, jornada_id, fecha_inicio, fecha_fin, comentario)"
            + "values (";
    String update="update periodo set";
    
    
     public Periodo guardarPeriodo(Periodo p) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+""+
                p.getId()+","+
                p.getJornadaId()+",'"+
                p.getFechaInicio()+"',"+
                p.getFechaFin()+",'"+
                p.getComentario()+"')";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
     
     public Periodo updatePeriodo(Periodo p) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                "jornada_id="+p.getJornadaId()+", "+
                "fechaInicio='"+p.getFechaInicio()+"', "+
                "fechaFin="+p.getFechaFin()+", "+
                "comentario='"+p.getComentario()+"' where periodo_id="+p.getId();
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
    
    public ArrayList<Periodo> selectAllPeriodos(int colegio){
        
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.periodoPorJornada+""+colegio;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Periodo p = new Periodo();
                    p.setId(rs.getInt("jornada_id"));
                    p.setFechaInicio(rs.getDate("fecha_inicio"));
                    p.setFechaFin(rs.getDate("fecha_fin"));
                    p.setComentario(rs.getString("comentario"));
                    p.setId(rs.getInt("periodo_id"));
                    periodos.add(p);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return periodos;
    }
    
}
