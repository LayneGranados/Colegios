/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Anio;
import Code.Domain.Jornada;
import Code.Domain.Sede;
import Code.Domain.TipoJornada;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laynegranadosmogollon
 */
public class JornadaDAOImpl {
    
    String todasLasJornadas = "SELECT j.*, a.anio, a.descripcion as descripcion_anio, a.sede_id, t.nombre as nombre_tipo_jornada " +
                              "FROM jornada j inner join anio a on j.anio_id = a.anio_id " +
                              "inner join tipo_jornada t on j.tipo_jornada_id = t.tipo_jornada_id";
    
    String jornadaPorTipoJornada = "SELECT j.*, a.anio, a.descripcion as descripcion_anio, a.sede_id, t.nombre as nombre_tipo_jornada " +
                                   "FROM jornada j inner join anio a on j.anio_id = a.anio_id " +
                                   "inner join tipo_jornada t on j.tipo_jornada_id = t.tipo_jornada_id where j.tipo_jornada_id = ";
    
    String jornadaPorAnio_id = "SELECT j.*, a.anio, a.descripcion as descripcion_anio, a.sede_id, t.nombre as nombre_tipo_jornada " +
                               "FROM jornada j inner join anio a on j.anio_id = a.anio_id " +
                               "inner join tipo_jornada t on j.tipo_jornada_id = t.tipo_jornada_id where j.anio_id = ";
    
    String jornadaPorAnioyTipo = "SELECT j.*, a.anio, a.descripcion as descripcion_anio, a.sede_id, t.nombre as nombre_tipo_jornada " +
                               "FROM jornada j inner join anio a on j.anio_id = a.anio_id " +
                               "inner join tipo_jornada t on j.tipo_jornada_id = t.tipo_jornada_id where j.anio_id = ? and j.tipo_jornada_id = ? ";
    
    String jornadaPorId = "SELECT j.*, a.anio, a.descripcion as descripcion_anio, a.sede_id, t.nombre as nombre_tipo_jornada " +
                          "FROM jornada j inner join anio a on j.anio_id = a.anio_id " +
                          "inner join tipo_jornada t on j.tipo_jornada_id = t.tipo_jornada_id where j.jornada_id = ";
    
    String insert = "insert into jornada (nombre, tipo_jornada_id, anio_id) values (";
    
    String bulk = "insert into jornada (nombre, tipo_jornada_id, anio_id) values ";
    String update="update jornada set";
    
    
    public Jornada getJornadaPorId(int id_jorn){
        
        Jornada j = new Jornada();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.jornadaPorId+""+id_jorn;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {  
                    TipoJornada tj = new TipoJornada();
                    tj.setNombre(rs.getString("nombre_tipo_jornada"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    Anio a = new Anio();
                    a.setId(rs.getInt("anio_id"));
                    a.setDescripcion(rs.getString("descripcion_anio"));
                    a.setAnio(rs.getInt("anio"));
                    Sede s = new Sede();
                    s.setId(rs.getInt("sede_id"));
                    a.setSede(s);
                    j.setAnio(a);
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
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
        return j;
    }
    
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
                    tj.setNombre(rs.getString("nombre_tipo_jornada"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    Anio a = new Anio();
                    a.setId(rs.getInt("anio_id"));
                    a.setDescripcion(rs.getString("descripcion_anio"));
                    a.setAnio(rs.getInt("anio"));
                    Sede s = new Sede();
                    s.setId(rs.getInt("sede_id"));
                    a.setSede(s);
                    j.setAnio(a);
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
                    jornadas.add(j);
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
        return jornadas;
    }
    
     public Jornada guardarJornada(Jornada j) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.insert+"'"+
                j.getNombre()+"',"+
                j.getTipoJornada().getId()+","+
                j.getAnio().getId()+")";         
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
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return j;
    }
     
    public void guardarMapJornada(Map<String,Jornada> jornadas) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.bulk; 
        boolean primero = true;
        String bulk = "insert into jornada (nombre, tipo_jornada_id, anio_id) values ";
        for (Map.Entry<String,Jornada> entry : jornadas.entrySet())
        {
            Jornada temp = entry.getValue();
            if(!primero){
                query+=",";
            }
            query+="('"+
                temp.getNombre()+"',"+
                temp.getTipoJornada().getId()+","+
                temp.getAnio().getId()+")"; 
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
     
     public Jornada updateJornada(Jornada j) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.update+" "+
                "nombre='"+j.getNombre()+"', "+
                "tipo_jornada_id="+j.getTipoJornada().getId()+", "+
                "anio_id="+j.getAnio().getId()+" where jornada_id="+j.getId();
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
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return j;
    }
     
    public ArrayList<Jornada> selectAllJornadaPorAnio(int anio){
        ArrayList<Jornada> jornadas = new ArrayList<Jornada>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
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
                    tj.setNombre(rs.getString("nombre_tipo_jornada"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    Anio a = new Anio();
                    a.setId(rs.getInt("anio_id"));
                    a.setDescripcion(rs.getString("descripcion_anio"));
                    a.setAnio(rs.getInt("anio"));
                    Sede s = new Sede();
                    s.setId(rs.getInt("sede_id"));
                    a.setSede(s);
                    j.setAnio(a);
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
                    jornadas.add(j);
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
        return jornadas;
    }
    
    public Map<Integer,Jornada> selectAllMapJornadaPorAnioTipo(int anio, int tipoJornada){
        Map<Integer,Jornada> jornadas = new HashMap<Integer,Jornada>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.jornadaPorAnio_id+""+anio;
        try{
            if(miConexion!=null)
            {
                PreparedStatement preparedStatement = miConexion.prepareStatement(this.jornadaPorAnioyTipo);
                preparedStatement.setInt(1, anio);
                preparedStatement.setInt(2, tipoJornada);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                    Jornada j = new Jornada();
                    TipoJornada tj = new TipoJornada();
                    tj.setNombre(rs.getString("nombre_tipo_jornada"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    Anio a = new Anio();
                    a.setId(rs.getInt("anio_id"));
                    a.setDescripcion(rs.getString("descripcion_anio"));
                    a.setAnio(rs.getInt("anio"));
                    Sede s = new Sede();
                    s.setId(rs.getInt("sede_id"));
                    a.setSede(s);
                    j.setAnio(a);
                    j.setTipoJornada(tj);
                    j.setNombre(rs.getString("nombre"));
                    j.setId(rs.getInt("jornada_id"));
                    jornadas.put(j.getId(),j);
                }
                preparedStatement.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return jornadas;
    }

}
