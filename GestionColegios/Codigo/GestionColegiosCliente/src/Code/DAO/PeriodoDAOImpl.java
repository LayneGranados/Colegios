/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Business.JornadaBusiness;
import Code.Domain.Jornada;
import Code.Domain.Periodo;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Andres Orduz Grimaldo
 */
public class PeriodoDAOImpl {
    JornadaBusiness jornadaBussiness;
    String todosLosPeriodos="select * from periodo";
    String periodoPorJornada="select * from periodo where jornada_id=";
    String periodoPorId="select * from periodo where periodo_id=";
    String insert="insert into periodo (jornada_id, fecha_inicio, fecha_fin, comentario) "
            + "values (";
    String update="update periodo set";

    public PeriodoDAOImpl() {
        jornadaBussiness = new JornadaBusiness();
    }
    
    
    
    public ArrayList<Periodo> getTodosLosPeriodos(){
        
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query=this.todosLosPeriodos;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Periodo p = new Periodo();
                    Jornada j = new Jornada();
                    int idJorn = rs.getInt("jornada_id");
                    j = this.jornadaBussiness.JornadaPorId(idJorn);
                    p.setJornada(j);
                    p.setFechaInicio(rs.getDate("fecha_inicio"));
                    p.setFechaFin(rs.getDate("fecha_fin"));
                    p.setComentario(rs.getString("comentario"));
                    p.setId(rs.getInt("periodo_id"));
                    periodos.add(p);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return periodos;
    }
    
    
     public Periodo guardarPeriodo(Periodo p) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaIn = formatter.format(p.getFechaInicio());
        String fechaFi = formatter.format(p.getFechaFin());
        String query="";
        query=this.insert+""+
                                    
                p.getJornada().getId()+",str_to_date('"+
                
                fechaIn+"','%d/%m/%Y'),str_to_date('"+
                
                fechaFi+"','%d/%m/%Y'),'"+
                        
                p.getComentario()+"')";
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
     
     public Periodo updatePeriodo(Periodo p) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaIn = formatter.format(p.getFechaInicio());
        String fechaFi = formatter.format(p.getFechaFin());
        String query="";
        query=this.update+" "+
                "jornada_id="+p.getJornada().getId()+", "+
                "fecha_inicio="+"str_to_date('"+fechaIn+"', '%d/%m/%Y'), "+
                "fecha_fin="+"str_to_date('"+fechaFi+"', '%d/%m/%Y'), "+
                "comentario='"+p.getComentario()+"' where periodo_id="+p.getId();
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
    
    public ArrayList<Periodo> selectAllPeriodos(int jornada){
        
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.periodoPorJornada+""+jornada;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Periodo p = new Periodo();
                    Jornada j = new Jornada();
                    
                    int idJ = rs.getInt("jornada_id");
                    j = this.jornadaBussiness.JornadaPorId(idJ);
                    p.setJornada(j);
                    p.setFechaInicio(rs.getDate("fecha_inicio"));
                    p.setFechaFin(rs.getDate("fecha_fin"));
                    p.setComentario(rs.getString("comentario"));
                    p.setId(rs.getInt("periodo_id"));
                    periodos.add(p);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return periodos;
    }
    
    
    public ArrayList<Periodo> selectAllPeriodosSinJornada(int jornada){
        
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query=this.periodoPorJornada+""+jornada;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next())
                {
                    Periodo p = new Periodo();
                    p.setFechaInicio(rs.getDate("fecha_inicio"));
                    p.setFechaFin(rs.getDate("fecha_fin"));
                    p.setComentario(rs.getString("comentario"));
                    p.setId(rs.getInt("periodo_id"));
                    periodos.add(p);
                }
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return periodos;
    }
}
