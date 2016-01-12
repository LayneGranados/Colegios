/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Domain.InstitucionEducativa;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laygrana
 */
public class InstitucionEducativaDAOImpl {
    
    String select ="select * from colegio";

    String insert= "insert into colegio "
            + "(codigo_dane, dane_anterior, municipio_id, nombre, path_logo, ruta_archivos_generados, direccion, telefono) values (";
    
    
    public InstitucionEducativa guardarColegio(InstitucionEducativa ie) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.insert+"'"+
                ie.getCodigoDANEActual()+"','"+
                ie.getCodigoDANEAnterior()+"',"+
                ie.getMunicipio()+",'"+
                ie.getNombre()+"','"+
                ie.getRutaLogo()+"','"+
                ie.getRutaArchivosGenerados()+"','"+
                ie.getDireccion()+"','"+
                ie.getTelefono()+"')";
        
        System.out.println("query: "+query);
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    ie.setId(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return ie;
    }
    
    public InstitucionEducativa selectColegio(){
        
        InstitucionEducativa i = new InstitucionEducativa();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(this.select);
                while (rs.next())
                {
                    i.setId(rs.getInt("colegio_id"));
                    i.setNombre(rs.getString("nombre"));
                    i.setCodigoDANEActual(rs.getString("codigo_dane"));
                    i.setCodigoDANEAnterior(rs.getString("dane_anterior"));
                    i.setMunicipio(rs.getInt("municipio_id"));
                    i.setDireccion(rs.getString("direccion"));
                    i.setTelefono(rs.getString("telefono"));
                    i.setRutaArchivosGenerados(rs.getString("ruta_archivos_generados"));
                    i.setRutaLogo(rs.getString("path_logo"));
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return i;
    }
    
    
}
