/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Business.SedeBusiness;
import Code.Domain.Anio;
import Code.Domain.Municipio;
import Code.Domain.Sede;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class AnioDAOImpl {
    
    SedeBusiness sedeBusiness;
    String aniosPorSede="select * from anio where sede_id=";
    String todosLasAniosConSede="select anio.*, sede.* from anio, sede where anio.sede_id = sede.sede_id";
    String anioPorSede="select * from anio where sede_id=";
    String anioPorId="select * from anio where anio_id=";
    String insert="insert into anio (anio_id, anio, descripcion, sede_id) values (";
    String bulk="insert into anio (anio, descripcion, sede_id) values ";
    String update="update anio set";

    public AnioDAOImpl() {
        this.sedeBusiness = new SedeBusiness();
    }
    
    public ArrayList<Anio> getAniosPorSede(int id_sede){
        
        ArrayList<Anio> anio = new ArrayList<Anio>();
        Connection miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.aniosPorSede+""+id_sede;
        
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
                    a.setSede(s);
                    anio.add(a);
                }
                st.close();
            }
        }catch(SQLException sqlException){
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AnioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(NullPointerException nullPointerException){
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AnioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception exception){
            try {
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AnioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anio;
    }
    
    public Anio anioPorId (int id){
        Anio a = new Anio();
        Connection miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.anioPorId+""+id;         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    a.setAnio(rs.getInt("anio"));
                    a.setDescripcion(rs.getString("descripcion"));
                    int id_sede = rs.getInt("sede_id");
                    Sede s = sedeBusiness.sedePorId(id_sede);
                    a.setSede(s);
                    a.setId(rs.getInt("anio_id"));          
                }
                st.close();
            }
            miConexion.close();
        }catch(SQLException sqlException){
        }catch(NullPointerException nullPointerException){
        }catch(Exception exception){
        }
        return a;
    }
    public Anio guardarAnio(Anio a){      
        Connection miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.insert+""+
                a.getId()+","+
                a.getAnio()+",'"+
                a.getDescripcion()+"',"+
                a.getSede().getId()+")";
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
            }
            miConexion.close();
        }catch(SQLException sqlException){
        }catch(NullPointerException nullPointerException){
        }catch(Exception exception){
        }
        return a;
    }

    public void guardarMapAnio(Map<Integer,Anio> anios) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.bulk; 
        boolean primero = true;
        for (Map.Entry<Integer, Anio> entry : anios.entrySet())
        {
            Anio temp = entry.getValue();
            if(!primero){
                query+=",";
            }
            query+="("+
                temp.getAnio()+",'"+
                temp.getDescripcion()+"',"+
                temp.getSede().getId()+")"; 
            primero = false;
        }
        System.out.println(query);
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                st.executeUpdate(query);
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
    }
     
     public Anio updateAnio(Anio a) {      
        Connection miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.update+" "+
                "anio_id="+a.getId()+", "+
                "anio='"+a.getAnio()+"', "+
                "descripcion='"+a.getDescripcion()+"', "+
                "sede_id="+a.getSede().getId()+" where anio_id="+a.getId();
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
                }
            miConexion.close();
        }catch(SQLException sqlException){
        }catch(NullPointerException nullPointerException){
        }catch(Exception exception){
        }
        return a;
    }
    
    public ArrayList<Anio> selectAllAnios(){
        
        ArrayList<Anio> anio = new ArrayList<Anio>();
        Connection miConexion=ConexionBD.GetConnection();
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
                    Municipio m = new Municipio();
                    m.setId(rs.getInt("municipio_id"));
                    s.setMunicipio(m);
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setConsecutivo(rs.getLong("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    a.setSede(s);
                    anio.add(a);
                }
                st.close();
            }
            miConexion.close();
        }catch(SQLException sqlException){    
        }catch(NullPointerException nullPointerException){
        }catch(Exception exception){
        }
        return anio;
    }
    
    public Map<Integer, Anio> getMapAniosPorSedes(int id_sede){
        Map<Integer, Anio> anios = new HashMap<Integer, Anio>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.aniosPorSede+""+id_sede;
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
                    a.setSede(s);
                    anios.put(a.getAnio(), a);
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
        return anios;
    }
    
}
