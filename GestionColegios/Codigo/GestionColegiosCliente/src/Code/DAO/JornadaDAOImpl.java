/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Jornada;
import Code.Domain.TipoJornada;
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
public class JornadaDAOImpl {
    
    
    String todasLasJornadas="select * from jornada";
    String jornadaPorTipoJornada="select * from jornada where tipo_jornada_id=";
    String jornadaPorAnio_id="select * from jornada where anio_id=";
    String jornadaPorId="select * from sede where jornada_id=";
    String insert="insert into jornada (nombre, tipo_jornada_id, anio_id)"
            + "values (";
    String update="update jornada set";
    
    
    public ArrayList<Jornada> getTodasLasJornadas(){
        
        ArrayList<Jornada> jornadas= new ArrayList<Jornada>();
        Connection miConexion;
        miConexion = ConexionBD.GetConnection();
        String query=this.todasLasJornadas;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Jornada j = new Jornada();
                    TipoJornada tj = new TipoJornada();
                    j.setAnioId(rs.getInt("anio_id"));
                    tj.setNombre(rs.getString("nombre"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
                    jornadas.add(j);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return jornadas;
                
                
    }
    
     public Jornada guardarJornada(Jornada j) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+"'"+
                j.getNombre()+"',"+
                j.getTipoJornada().getId()+","+
                j.getAnioId()+")";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    j.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return j;
    }
     
     public Jornada updateJornada(Jornada j) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                
                "nombre='"+j.getNombre()+"', "+
                "tipo_jornada_id="+j.getTipoJornada().getId()+", "+
                "anio_id="+j.getAnioId()+" where jornada_id="+j.getId();
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    j.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return j;
    }
    
    public ArrayList<Jornada> selectAllJornada(int anio){
        
        ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.jornadaPorAnio_id+""+anio;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Jornada j = new Jornada();
                    TipoJornada tj = new TipoJornada();
                    j.setAnioId(rs.getInt("anio_id"));
                    tj.setNombre(rs.getString("nombre"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
                    jornadas.add(j);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return jornadas;
    }
    
}
