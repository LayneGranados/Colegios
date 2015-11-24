/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

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
public class AuxiliaresDAOImpl {
    
    String todosTipoDocumento="select * from tipo_documento";
    String todosEtnia="select * from etnia";
    String todosResguardo="select * from resguardo";
    String todosEspecialiades="select * from especialidad";
    String todosMetodologias="select * from metodologias";
    String todosCaracteres="select * from caracter";
    String todosPoblacionVictima="select * from poblacion_victima";
    String todos="select * from ";
    
    public ArrayList<String> getAll() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todos);
            while (rs.next())
            {
                int id = rs.getInt("_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
        
    public ArrayList<String> getAllPoblacionVictima() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosPoblacionVictima);
            while (rs.next())
            {
                int id = rs.getInt("poblacion_victima_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllCaracter() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCaracteres);
            while (rs.next())
            {
                int id = rs.getInt("caracter_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllMetodologia() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosMetodologias);
            while (rs.next())
            {
                int id = rs.getInt("metodologia_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllEspecialidad() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosEspecialiades);
            while (rs.next())
            {
                int id = rs.getInt("especialidad_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllResguardo() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosResguardo);
            while (rs.next())
            {
                int id = rs.getInt("resguardo_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllEtnia() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosEtnia);
            while (rs.next())
            {
                int id = rs.getInt("etnia_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllTipoDocumento() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosTipoDocumento);
            while (rs.next())
            {
                int id = rs.getInt("tipo_documento_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
}
