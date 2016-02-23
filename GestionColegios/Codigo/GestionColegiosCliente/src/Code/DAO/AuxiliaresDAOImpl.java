/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.CapacidadExcepcional;
import Code.Domain.Caracter;
import Code.Domain.CondicionAnioAnterior;
import Code.Domain.Departamento;
import Code.Domain.Especialidad;
import Code.Domain.Etnia;
import Code.Domain.FuenteRecursos;
import Code.Domain.InstitucionFamiliarOrigen;
import Code.Domain.Metodologia;
import Code.Domain.Municipio;
import Code.Domain.PoblacionVictimaConflicto;
import Code.Domain.Resguardo;
import Code.Domain.SituacionAnioAnterior;
import Code.Domain.TipoDiscapacidad;
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
    
    String todos="select * from ";
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
    String todosColegios="select * from colegio";
    String departamentoPorID="select * from departamento where departamento_id=";
    String todosMunicipiosPorDepartamento="select * from municipio where departamento_id=";
    String municipioPorID="select * from municipio where municipio_id=";
    String etniaPorId = "select * from etnia where etnia_id=";
    String resguardoPorId = "select * from resguardo where resguardo_id=";
    
    
    
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
    
    public ArrayList<SituacionAnioAnterior> getAllSituacionesAnteriores() throws SQLException{
        ArrayList<SituacionAnioAnterior> all = new ArrayList<SituacionAnioAnterior>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosSituacionAcademicaAnioAnterior);
            while (rs.next())
            {   
                SituacionAnioAnterior s = new SituacionAnioAnterior();
                s.setId(rs.getInt("sit_acad_anio_ant"));
                s.setNombre(rs.getString("nombre"));
                all.add(s);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<CondicionAnioAnterior> getAllCondicionesAnteriores() throws SQLException{
        ArrayList<CondicionAnioAnterior> all = new ArrayList<CondicionAnioAnterior>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCondicionAnioAnterior);
            while (rs.next())
            {   
                CondicionAnioAnterior c = new CondicionAnioAnterior();
                c.setId(rs.getInt("condicion_anio_anterior_id"));
                c.setNombre(rs.getString("nombre"));
                all.add(c);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<FuenteRecursos> getAllFuentesRecursos() throws SQLException{
        ArrayList<FuenteRecursos> all = new ArrayList<FuenteRecursos>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosFuentesRecursos);
            while (rs.next())
            {   
                FuenteRecursos f = new FuenteRecursos();
                f.setId(rs.getInt("fuentes_recursos_id"));
                f.setNombre(rs.getString("nombre"));
                all.add(f);
                if(f.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                FuenteRecursos f = new FuenteRecursos();
                f.setId(-1);
                f.setNombre("No Aplica");
                all.add(f);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<InstitucionFamiliarOrigen> getAllInstitucionFamiliar() throws SQLException{
        ArrayList<InstitucionFamiliarOrigen> all = new ArrayList<InstitucionFamiliarOrigen>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosInstitucionFamiliar);
            while (rs.next())
            {   
                InstitucionFamiliarOrigen i = new InstitucionFamiliarOrigen();
                i.setId(rs.getInt("institucion_familiar_id"));
                i.setNombre(rs.getString("nombre"));
                all.add(i);
                if(i.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                InstitucionFamiliarOrigen i = new InstitucionFamiliarOrigen();
                i.setId(-1);
                i.setNombre("No Aplica");
                all.add(i);
            }
            st.close();
        }
        
        return all;
    }
    
    public ArrayList<CapacidadExcepcional> getAllCapacidadExcepcional() throws SQLException{
        ArrayList<CapacidadExcepcional> all = new ArrayList<CapacidadExcepcional>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCapacidadExcepcional);
            while (rs.next())
            {   
                CapacidadExcepcional c = new CapacidadExcepcional();
                c.setId(rs.getInt("capacidad_excepcional_id"));
                c.setNombre(rs.getString("nombre"));
                all.add(c);
                if(c.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                CapacidadExcepcional c = new CapacidadExcepcional();
                c.setId(-1);
                c.setNombre("No Aplica");
                all.add(c);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<TipoDiscapacidad> getAllTipoDiscapacidad() throws SQLException{
        ArrayList<TipoDiscapacidad> all = new ArrayList<TipoDiscapacidad>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosTipoDiscapacidad);
            while (rs.next())
            {   
                TipoDiscapacidad t = new TipoDiscapacidad();
                t.setId(rs.getInt("tipo_discapacidad_id"));
                t.setNombre(rs.getString("nombre"));
                all.add(t);
                if(t.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                TipoDiscapacidad t = new TipoDiscapacidad();
                t.setId(-1);
                t.setNombre("No Aplica");
                all.add(t);
            }
            st.close();
        }
        return all;
    }
        
    public ArrayList<PoblacionVictimaConflicto> getAllPoblacionVictima() throws SQLException{
        ArrayList<PoblacionVictimaConflicto> all = new ArrayList<PoblacionVictimaConflicto>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosPoblacionVictima);
            while (rs.next())
            {
                PoblacionVictimaConflicto p = new PoblacionVictimaConflicto();
                p.setId(rs.getInt("poblacion_victima_id"));
                p.setNombre(rs.getString("nombre"));
                all.add(p);
                if(p.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                PoblacionVictimaConflicto p = new PoblacionVictimaConflicto();
                p.setId(-1);
                p.setNombre("No Aplica");
                all.add(p);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<Caracter> getAllCaracter() throws SQLException{
        ArrayList<Caracter> all = new ArrayList<Caracter>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica =false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosCaracteres);
            while (rs.next())
            {   
                Caracter c = new Caracter();
                c.setId(rs.getInt("caracter_id"));
                c.setNombre(rs.getString("nombre"));                
                all.add(c);
                if(c.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                Caracter c = new Caracter();
                c.setId(-1);
                c.setNombre("No Aplica");
                all.add(c);
            }
            
            st.close();
        }
        return all;
    }
    
    public ArrayList<Metodologia> getAllMetodologia() throws SQLException{
        ArrayList<Metodologia> all = new ArrayList<Metodologia>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosMetodologias);
            while (rs.next())
            {   
                Metodologia m = new Metodologia();
                m.setId(rs.getInt("metodologia_id"));
                m.setNombre(rs.getString("nombre"));
                all.add(m);
            if(m.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                Metodologia m = new Metodologia();
                m.setId(-1);
                m.setNombre("No Aplica");
                all.add(m);
            }
            st.close();
        }
        return all;
    }
    
    public ArrayList<Especialidad> getAllEspecialidad() throws SQLException{
        ArrayList<Especialidad> all = new ArrayList<Especialidad>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean noAplica = false;
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.todosEspecialiades);
            while (rs.next())
            {   
                Especialidad e = new Especialidad();
                e.setId(rs.getInt("especialidad_id"));
                e.setNombre(rs.getString("nombre"));
                all.add(e);
            if(e.getNombre().trim().equalsIgnoreCase("No Aplica")){
                    noAplica = true;
                }
            }
            if(!noAplica){
                Especialidad e = new Especialidad();
                e.setId(-1);
                e.setNombre("No Aplica");
                all.add(e);
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
    
    public Resguardo getResguardoPorId(int d) throws SQLException{
        Resguardo r = new Resguardo();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.resguardoPorId+""+d);
            while (rs.next())
            {
                r.setId(rs.getInt("resguardo_id"));
                r.setNombre(rs.getString("nombre"));
            }
            st.close();
        }else{
        }
        return r;
    }
    
    public Etnia getEtniaPorId(int d) throws SQLException{
        Etnia e = new Etnia();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(this.etniaPorId+""+d);
            while (rs.next())
            {
                e.setId(rs.getInt("etnia_id"));
                e.setNombre(rs.getString("nombre"));
            }
            st.close();
        }else{
        }
        return e;
    }
    
}
