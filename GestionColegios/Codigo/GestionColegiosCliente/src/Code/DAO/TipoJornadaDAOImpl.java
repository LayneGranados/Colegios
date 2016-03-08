/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.TipoJornada;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author AndresOrlando
 */
public class TipoJornadaDAOImpl {
    
    String tipoJornadaPorId="select * from tipo_jornada where tipo_jornada_id=";
    String insert="insert into tipo_jornada (tipo_jornada_id, nombre)"
            + "values (";
    String update="update tipo_jornada set";
    String todosLosTipoJornada="Select * from tipo_jornada";
    
     public ArrayList<TipoJornada> getTodosLosTipoJornada(){
        
        ArrayList<TipoJornada> tiposJornada = new ArrayList<TipoJornada>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.todosLosTipoJornada;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    TipoJornada tj = new TipoJornada();
                    tj.setNombre(rs.getString("nombre"));
                    tj.setId(rs.getInt("tipo_jornada_id"));
                    tiposJornada.add(tj);
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
        return tiposJornada;
    }
    
    public TipoJornada tipoJornadaPorId (int id_tj){
         
        TipoJornada tj= new TipoJornada();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.tipoJornadaPorId+""+id_tj;
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    tj.setNombre(rs.getString("nombre"));
                    tj.setId(rs.getInt("tipo_jornada_id"));          
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
        return tj;
                 
     }
    
    public TipoJornada guardarTipoJornada(TipoJornada tj) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.insert+"'"+tj.getNombre()+"',"+tj.getId()+"')";         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    tj.setId(rs.getInt(1));
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
        return tj;
    }
    
    
    public TipoJornada updateTipoJornada(TipoJornada tj) {      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.update+" "+"nombre='"+tj.getNombre()+"' where tipo_jornada_id="+tj.getId();
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    tj.setId(rs.getInt(1));
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
        return tj;
    }
}
