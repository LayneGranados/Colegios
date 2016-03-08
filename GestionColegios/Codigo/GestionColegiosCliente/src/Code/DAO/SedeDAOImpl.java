/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Municipio;
import Code.Domain.Sede;
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
public class SedeDAOImpl {
 
    String sedesPorAnio = "select s.*, m.nombre as nombre_municipio from sede s inner join municipio m on s.municipio_id = m.municipio_id where s.sede_id=";
    String todasLasSedes="select s.*, m.nombre as nombre_municipio from sede s inner join municipio m on s.municipio_id = m.municipio_id";
    String sedePorColegio="select s.*, m.nombre as nombre_municipio from sede s inner join municipio m on s.municipio_id = m.municipio_id where s.colegio_id=";
    String sedePorId="select s.*, m.nombre as nombre_municipio from sede s inner join municipio m on s.municipio_id = m.municipio_id where s.sede_id=";
    String insert="insert into sede (colegio_id, municipio_id, antiguo_codigo_dane, consecutivo, nombre)"
            + "values (";
    String update="update sede set";

    public ArrayList<Sede> getTodasLasSedes(){
        
        ArrayList<Sede> sedes = new ArrayList<Sede>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.todasLasSedes;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Sede s = new Sede();
                    s.setColegio(rs.getInt("colegio_id"));
                    Municipio m = new Municipio();
                    m.setId(rs.getInt("municipio_id"));
                    m.setNombre(rs.getString("nombre_municipio"));
                    s.setMunicipio(m);
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setId(rs.getInt("sede_id"));
                    sedes.add(s);
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
        return sedes;
    }
    
    public ArrayList<Sede> selectAllSedesPorAnio (int anio){
        
        ArrayList<Sede> sedes = new ArrayList<Sede>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.sedesPorAnio+""+anio;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Sede s = new Sede();
                    s.setColegio(rs.getInt("colegio_id"));
                    Municipio m = new Municipio();
                    m.setId(rs.getInt("municipio_id"));
                    m.setNombre(rs.getString("nombre_municipio"));
                    s.setMunicipio(m);
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setId(rs.getInt("sede_id"));
                    sedes.add(s);
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
        return sedes;
    }
    
     public Sede sedePorid (int id_s){
         
        Sede s = new Sede();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.sedePorId+""+id_s;         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    s.setColegio(rs.getInt("colegio_id"));
                    Municipio m = new Municipio();
                    m.setId(rs.getInt("municipio_id"));
                    m.setNombre(rs.getString("nombre_municipio"));
                    s.setMunicipio(m);
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setId(rs.getInt("sede_id"));          
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
        return s;
                 
     }    
     public Sede guardarSede(Sede s) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.insert+""+
                s.getColegio()+","+
                s.getMunicipio()+",'"+
                s.getCodigoDANEantiguo()+"',"+
                s.getConsecutivo()+",'"+
                s.getNombre()+"')";         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    s.setId(rs.getInt(1));
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
        return s;
    }
     
     public Sede updateSede(Sede s) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.update+" "+
                "municipio_id="+s.getMunicipio().getId()+", "+
                "antiguo_codigo_dane='"+s.getCodigoDANEantiguo()+"', "+
                "consecutivo="+s.getConsecutivo()+", "+
                "nombre='"+s.getNombre()+"' where sede_id="+s.getId();
        System.out.println("query: "+query);
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    s.setId(rs.getInt(1));
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
        return s;
    }
    
    public ArrayList<Sede> selectAllSedes(int colegio){
        ArrayList<Sede> sedes = new ArrayList<Sede>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.sedePorColegio+""+colegio;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Sede s = new Sede();
                    s.setColegio(rs.getInt("colegio_id"));
                    Municipio m = new Municipio();
                    m.setId(rs.getInt("municipio_id"));
                    m.setNombre(rs.getString("nombre_municipio"));
                    s.setMunicipio(m);
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setId(rs.getInt("sede_id"));
                    sedes.add(s);
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
        return sedes;
    }
    
}
