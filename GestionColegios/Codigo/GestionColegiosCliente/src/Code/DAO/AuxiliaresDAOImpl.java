/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Departamento;
import Code.Domain.Etnia;
import Code.Domain.Municipio;
import Code.Domain.Resguardo;
import Code.Domain.Sede;
import Code.Domain.TipoDocumento;
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
    String todosMetodologias="select * from metodologia";
    String todosCaracteres="select * from caracter";
    String todosPoblacionVictima="select * from poblacion_victima";
    String todosTipoDiscapacidad="select * from tipo_discapacidad";
    String todosCapacidadExcepcional="select * from capacidad_excepcional";
    String todosInstitucionFamiliar="select * from institucion_familiar";
    String todosSituacionAcademicaAnioAnterior="select * from sit_acad_anio_ant";
    String todosCondicionAnioAnterior="select * from condicion_anio_anterior";
    String todosFuentesRecursos="select * from fuentes_recursos";
    String todosDepartamentos="select * from departamento";
    String departamentoPorID="select * from departamento where departamento_id=";
    String todosMunicipiosPorDepartamento="select * from municipio where departamento_id=";
    String municipioPorID="select * from municipio where municipio_id=";
    String sedePorId = "select * from sede where anio_id=";
    String todosColegios="select * from colegio";
    String todosSedePorColegio="select * from sede where colegio_id=";
    String todosAnioPorSede="select * from anio where sede_id=";
    String todosJornadaPorAnio="select * from jornada where anio_id=";
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
            System.out.println("grado por jornada:"+this.todosGradoPorJornada+g);
            ResultSet rs = st.executeQuery(this.todosGradoPorJornada+g);
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
            //Statement st = miConexion.createStatement();
            //ResultSet rs = st.executeQuery(this.todosGradoPorJornada+p);
            //while (rs.next())
            //{
                //int id = rs.getInt("periodo_id");
                //String nombre = rs.getString("nombre");
                //all.add(id+"-"+nombre);
                
            //}
            all.add("PERIODO - 1");
            all.add("PERIODO - 2");
            all.add("PERIODO - 3");
            all.add("PERIODO - 4");
            //st.close();
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
            System.out.println(this.todosJornadaPorAnio+j);
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
            System.out.println(this.todosAnioPorSede+a);
            ResultSet rs = st.executeQuery(this.todosAnioPorSede+a);
            while (rs.next())
            {   System.out.println("imp");
                int id = rs.getInt("anio_id");
                String nombre = rs.getString("anio");
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
            ResultSet rs = st.executeQuery(this.todosColegios);
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
    
    public ArrayList<Departamento> getAllDepartamentos() throws SQLException{
        ArrayList<Departamento> all = new ArrayList<Departamento>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosDepartamentos);
            Departamento d = new Departamento();
            d.setId(-1);
            d.setNombre("No seleccionado");
            all.add(d);
            while (rs.next())
            {   
                d = new Departamento();
                d.setId(rs.getInt("departamento_id"));
                d.setNombre(rs.getString("nombre"));
                all.add(d);
            }
            st.close();
        }
        return all;
    }
    
    public Departamento getDepartamentoPorId(int id) throws SQLException{
        Departamento d = new Departamento();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.departamentoPorID+""+id);

            while (rs.next())
            {   
                d = new Departamento();
                d.setId(rs.getInt("departamento_id"));
                d.setNombre(rs.getString("nombre"));
            }
            st.close();
        }
        return d;
    }
    
    public ArrayList<Municipio> getAllMunicipiosPorDepartamento(int d) throws SQLException{
        ArrayList<Municipio> all = new ArrayList<Municipio>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosMunicipiosPorDepartamento+d);
            Municipio m = new Municipio();
            m.setId(-1);
            m.setNombre("No Seleccionado");
            m.setCodigoDANE("");
            all.add(m);
            while (rs.next())
            {
                m = new Municipio();
                m.setId(rs.getInt("municipio_id"));
                m.setNombre(rs.getString("nombre"));
                m.setCodigoDANE(rs.getString("codigo_dane"));
                all.add(m);
            }
            st.close();
        }else{
        }
        return all;
    }
    public Sede getSedePorId (int d) throws SQLException{
        
        Sede s = new Sede();
        Connection miConexion;
        miConexion = ConexionBD.GetConnection();
        
        if(miConexion!=null){
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.sedePorId+""+d);
            while (rs.next()){
                s = new Sede();
                s.setId(rs.getInt("sede_id"));
                s.setColegio(rs.getInt("colegio_id"));
                s.setMunicipio(rs.getInt("municipio_id"));
                s.setCodigoDANEantiguo(rs.getString("antiguo_colegio_dane"));
                s.setConsecutivo(rs.getInt("consecutivo"));
                s.setNombre(rs.getString("nombre"));
            }
            st.close();
        }else{
            
        }
        return s;
    }
    public Municipio getMunicipioPorId(int d) throws SQLException{
        Municipio m = new Municipio();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.municipioPorID+""+d);
            while (rs.next())
            {
                m = new Municipio();
                m.setId(rs.getInt("municipio_id"));
                m.setNombre(rs.getString("nombre"));
                m.setCodigoDANE(rs.getString("codigo_dane"));
                m.setDepartamentoId(rs.getInt("departamento_id"));
            }
            st.close();
        }else{
        }
        return m;
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
    
    public ArrayList<Resguardo> getAllResguardo() throws SQLException{
        ArrayList<Resguardo> all = new ArrayList<Resguardo>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosResguardo);
            Resguardo r = new Resguardo();
            r.setId(-1);
            r.setNombre("No Aplica");
            all.add(r);
            while (rs.next())
            {   
                r = new Resguardo();
                r.setId(rs.getInt("resguardo_id"));
                r.setNombre(rs.getString("nombre"));
                all.add(r);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<Etnia> getAllEtnia() throws SQLException{
        ArrayList<Etnia> all = new ArrayList<Etnia>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosEtnia);
            Etnia e = new Etnia();
            e.setId(-1);
            e.setNombre("No Aplica");
            all.add(e);
            
            while (rs.next())
            {   
                e = new Etnia();
                e.setId(rs.getInt("etnia_id"));
                e.setNombre(rs.getString("nombre"));
                all.add(e);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<TipoDocumento> getAllTipoDocumento() throws SQLException{
        ArrayList<TipoDocumento> all = new ArrayList<TipoDocumento>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosTipoDocumento);
            
            TipoDocumento tipo = new TipoDocumento();
            tipo.setId(-1);
            tipo.setNombre("No Seleccionado");
            all.add(tipo);
            
            while (rs.next())
            {
                tipo = new TipoDocumento();
                tipo.setId(rs.getInt("tipo_documento_id"));
                tipo.setNombre(rs.getString("nombre"));
                all.add(tipo);
            }
            st.close();
        }
        return all;
    }
    
    public Integer getColegioActual() throws SQLException{
        Integer codigoColegio=0;
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery("select * from colegio where actual=true");
            while (rs.next())
            {
                codigoColegio = rs.getInt("colegio_id");
            }
            st.close();
        }
        return codigoColegio;
    }
    
}
