/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Departamento;
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
    String todosTipoDiscapacidad="select * from tipo_discapacidad";
    String todosCapacidadExcepcional="select * from capacidad_excepcional";
    String todosInstitucionFamiliar="select * from institucion_familiar";
    String todosSituacionAcademicaAnioAnterior="select * from sit_acad_anio_ant";
    String todosCondicionAnioAnterior="select * from condicion_anio_anterior";
    String todosFuentesRecursos="select * from fuentes_recursos";
    String todosDepartamentos="select * from departamento";
    String todosMunicipiosPorDepartamento="select * from municipio where departamento_id=";
    String todosColegios="select * from colegio";
    String todosSedePorColegio="select * from sede where colegio_id=";
    String todosAnioPorSede="select * from anio where sede_id=";
    String todosJornadaPorAnio="select * from jornada where jornada_id=";
    String todosPeriodoPorJornada="select * from periodo where jornada_id=";
    String todosGradoPorJornada="select * from grado where jornada_id=";
    String todosCursoPorGrado="select * from curso where grado_id=";
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
    public ArrayList<String> getAllCursoPorGrado(int c) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCursoPorGrado+c);
            while (rs.next())
            {
                int id = rs.getInt("curso_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllGradoPorJornada(int g) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todos+g);
            while (rs.next())
            {
                int id = rs.getInt("grado_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllPeriodoPorJornada(int p) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosGradoPorJornada+p);
            while (rs.next())
            {
                int id = rs.getInt("periodo_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllJornadaPorAnio(int j) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosJornadaPorAnio+j);
            while (rs.next())
            {
                int id = rs.getInt("jornada_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllAnio(int a) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosAnioPorSede+a);
            while (rs.next())
            {
                int id = rs.getInt("anio_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllSedes(int c) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosSedePorColegio+c);
            while (rs.next())
            {
                int id = rs.getInt("sede_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllColegios() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todos);
            while (rs.next())
            {
                int id = rs.getInt("colegio_id");
                String nombre = rs.getString("nombre");
                Boolean actual = rs.getBoolean("actual");
                all.add(id+"-"+nombre+"-"+actual);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllDepartamentos() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosDepartamentos);
            while (rs.next())
            {
                int id = rs.getInt("departamento_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllMunicipiosPorDepartamento(int d) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            
            ResultSet rs = st.executeQuery(this.todosMunicipiosPorDepartamento+d);
            while (rs.next())
            {   
                int id = rs.getInt("municipio_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }else{
        }
        return all;
    }
    
    public ArrayList<String> getAllSituacionesAnteriores() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosSituacionAcademicaAnioAnterior);
            while (rs.next())
            {
                int id = rs.getInt("sit_acad_anio_ant");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllCondicionesAnteriores() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCondicionAnioAnterior);
            while (rs.next())
            {
                int id = rs.getInt("condicion_anio_anterior_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllFuentesRecursos() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosFuentesRecursos);
            while (rs.next())
            {
                int id = rs.getInt("fuentes_recursos_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllInstitucionFamiliar() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosInstitucionFamiliar);
            while (rs.next())
            {
                int id = rs.getInt("institucion_familiar_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        
        return all;
    }
    
    public ArrayList<String> getAllCapacidadExcepcional() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCapacidadExcepcional);
            while (rs.next())
            {
                int id = rs.getInt("capacidad_excepcional_id");
                String nombre = rs.getString("nombre");
                all.add(id+"-"+nombre);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<String> getAllTipoDiscapacidad() throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosTipoDiscapacidad);
            while (rs.next())
            {
                int id = rs.getInt("tipo_discapacidad_id");
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
