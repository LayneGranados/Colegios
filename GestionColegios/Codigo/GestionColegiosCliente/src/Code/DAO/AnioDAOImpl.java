/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Anio;
import Code.Domain.Sede;
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
public class AnioDAOImpl {
    
    String todosLasAniosConSede="select anio.*, sede.* from anio, sede where anio.sede_id = sede.sede_id";
    String anioPorSede="select * from anio where sede_id=";
    String anioPorId="select * from sede where anio_id=";
    String insert="insert into anio (anio_id, anio, descripcion, sede_id)"
            + "values (";
    String update="update anio set";
    
    
     public Anio guardarAnio(Anio a) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+""+
                a.getId()+","+
                a.getAnio()+",'"+
                a.getDescripcion()+"',"+
                a.getSede().getId()+")";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    a.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return a;
    }
     
     public Anio updateAnio(Anio a) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                "anio_id="+a.getId()+", "+
                "anio='"+a.getAnio()+"', '"+
                "descripcion="+a.getDescripcion()+"', "+
                "sede_id="+a.getSede()+", "+"' where anio_id="+a.getId();;
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    a.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return a;
    }
    
    public ArrayList<Anio> selectAllAnios(){
        
        ArrayList<Anio> anio = new ArrayList<Anio>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.todosLasAniosConSede;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    
                    Anio a = new Anio();
                    Sede s = new Sede();
                    a.setId(rs.getInt("anio_id"));
                    a.setAnio(rs.getInt("anio"));
                  
                    a.setDescripcion(rs.getString("descripcion"));
                    s.setId(rs.getInt("sede_id"));
                    s.setColegio(rs.getInt("colegio_id"));
                    s.setMunicipio(rs.getInt("municipio_id"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    a.setSede(s);
                    anio.add(a);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return anio;
    }
    
}
