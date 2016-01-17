/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

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
    
    String todosLasSedes="select * from sede";
    String sedePorColegio="select * from sede where colegio_id=";
    String sedePorId="select * from sede where sede_id=";
    String insert="insert into sede (colegio_id, municipio_id, antiguo_codigo_dane, consecutivo, nombre)"
            + "values (";
    String update="update sede set";
    
    
     public Sede guardarSede(Sede s) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+""+
                s.getColegio()+","+
                s.getMunicipio()+",'"+
                s.getCodigoDANEantiguo()+"',"+
                s.getConsecutivo()+",'"+
                s.getNombre()+"')";
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
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return s;
    }
     
     public Sede updateSede(Sede s) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.update+" "+
                "municipio_id="+s.getMunicipio()+", "+
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
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return s;
    }
    
    public ArrayList<Sede> selectAllSedes(int colegio){
        
        ArrayList<Sede> sedes = new ArrayList<Sede>();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
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
                    s.setMunicipio(rs.getInt("municipio_id"));
                    s.setConsecutivo(rs.getInt("consecutivo"));
                    s.setNombre(rs.getString("nombre"));
                    s.setCodigoDANEantiguo(rs.getString("antiguo_codigo_dane"));
                    s.setId(rs.getInt("sede_id"));
                    sedes.add(s);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return sedes;
    }
    
}
