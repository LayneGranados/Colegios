/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Persona;
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
public class PersonaDAOImpl {
    
    String todosLasPersonas="select * from persona";
    String personaPorId="SELECT * FROM persona WHERE persona_id=";
    String personaPorIdentificacion="SELECT * FROM persona WHERE tipo_documento=";
    String guardarPersona="insert into persona "
            + "(tipo_documento_id, documento,nombre1,nombre2,apellido1,apellido2,direccion_residencia,estrato,sisben,fecha_nacimiento,genero,etnia_id,resguardo_id) "
            + "values"
            + "(";
    
    public Boolean guardarPersona(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        this.guardarPersona+=
                p.getTipoDocumento().getId()+",'"+
                p.getDocumento()+"','"+
                p.getNombre1()+"','"+
                p.getNombre2()+"','"+
                p.getApellido1()+"','"+
                p.getApellido2()+"','"+
                p.getDireccionResidencia()+"','2','"+
                p.getSisben()+
                "'1991-01-01','"+
                p.getGenero()+"',"+
                p.getEtnia().getId()+","+
                p.getResguardo().getId()+")";
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                result = st.execute(guardarPersona);
                st.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return result;
    }
    
    public Persona getPersona(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        this.personaPorIdentificacion+=p.getTipoDocumento().getId()+" and documento='"+p.getDocumento()+"'";
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(this.personaPorIdentificacion);
                while (rs.next())
                {
                    p.setId(rs.getInt("persona_id"));
                    p.setNombre1(rs.getString("nombre1"));
                    p.setNombre2(rs.getString("nombre2"));
                    p.setApellido1(rs.getString("apellido1"));
                    p.setApellido2(rs.getString("apellido2"));
                    p.setDireccionResidencia(rs.getString("direccion_residencia"));
                    p.setSisben(rs.getInt(Integer.parseInt("sisben")));
                    p.setGenero(rs.getString("genero"));
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
    
    public Persona getPersonaMasCampos(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        this.personaPorIdentificacion+=p.getTipoDocumento().getId();
        
        if(!p.getDocumento().trim().equalsIgnoreCase("")){
            this.personaPorIdentificacion+=" and documento='"+p.getDocumento()+"'";
        }
        if(!p.getNombre1().equalsIgnoreCase("")&&p.getNombre1().trim().length()!=0){
            this.personaPorIdentificacion+=" and nombre1='"+p.getNombre1()+"'";
        }
        if(!p.getNombre2().equalsIgnoreCase("")&&p.getNombre2().trim().length()!=0){
            this.personaPorIdentificacion+=" and nombre2='"+p.getNombre2()+"'";
        }
        if(!p.getApellido1().equalsIgnoreCase("")&&p.getApellido1().trim().length()!=0){
            this.personaPorIdentificacion+=" and apellido1='"+p.getApellido1()+"'";
        }
        if(!p.getApellido2().equalsIgnoreCase("")&&p.getApellido2().trim().length()!=0){
            this.personaPorIdentificacion+=" and apellido2='"+p.getApellido2()+"'";
        }
        if(!p.getGenero().equalsIgnoreCase("")&&p.getGenero().trim().length()!=0){
            this.personaPorIdentificacion+=" and genero='"+p.getGenero()+"'";
        }       
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(this.personaPorIdentificacion);
                while (rs.next())
                {
                    p.setId(rs.getInt("persona_id"));
                    p.setNombre1(rs.getString("nombre1"));
                    p.setNombre2(rs.getString("nombre2"));
                    p.setApellido1(rs.getString("apellido1"));
                    p.setApellido2(rs.getString("apellido2"));
                    p.setDireccionResidencia(rs.getString("direccion_residencia"));
                    p.setSisben(rs.getInt(Integer.parseInt("sisben")));
                    p.setGenero(rs.getString("genero"));
                }
            }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return p;
    }
    
}
