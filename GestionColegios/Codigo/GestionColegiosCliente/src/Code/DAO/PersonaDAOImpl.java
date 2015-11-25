/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Persona;
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
public class PersonaDAOImpl {
    
    String todosLasPersonas="select * from persona";
    String personaPorId="SELECT * FROM persona WHERE persona_id=";
    String personaPorIdentificacion="SELECT * FROM persona WHERE tipo_documento_id=";
    String guardarPersona="insert into persona "
            + "("
            + "tipo_documento_id, "
            + "documento,"
            + "nombre1,"
            + "nombre2,"
            + "apellido1,"
            + "apellido2,"
            + "direccion_residencia,"
            + "estrato,"
            + "sisben,"
            + "fecha_nacimiento,"
            + "genero)"
            //+ "etnia_id,"
            //+ "resguardo_id) "
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
                p.getDireccionResidencia()+"','"+
                p.getEstrato()+"','"+
                p.getSisben()+"',"+
                "'1991-01-01','"+
                p.getGenero()+"')";
                //p.getEtnia().getId()+","+
                //p.getResguardo().getId()+")";
        
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
        Persona persona = new Persona();
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                System.out.println("query: "+this.personaPorIdentificacion+p.getTipoDocumento().getId()+" and documento='"+p.getDocumento()+"'");
                ResultSet rs = st.executeQuery(this.personaPorIdentificacion+p.getTipoDocumento().getId()+" and documento='"+p.getDocumento()+"'");
                while (rs.next())
                {
                    TipoDocumento tipo = new TipoDocumento();
                    tipo.setId(rs.getInt("tipo_documento_id"));
                    persona.setTipoDocumento(tipo);
                    persona.setDocumento(rs.getString("documento"));
                    persona.setId(rs.getInt("persona_id"));
                    persona.setNombre1(rs.getString("nombre1"));
                    persona.setNombre2(rs.getString("nombre2"));
                    persona.setApellido1(rs.getString("apellido1"));
                    persona.setApellido2(rs.getString("apellido2"));
                    persona.setDireccionResidencia(rs.getString("direccion_residencia"));
                    persona.setSisben(rs.getInt(Integer.parseInt("sisben")));
                    persona.setEstrato(rs.getInt(Integer.parseInt("estrato")));
                    persona.setGenero(rs.getString("genero"));
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return persona;
    }
    
    public Persona getPersonaMasCampos(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String x =this.personaPorIdentificacion;
        x+=p.getTipoDocumento().getId();
        
        if(!p.getDocumento().trim().equalsIgnoreCase("")){
            x+=" and documento='"+p.getDocumento()+"'";
        }
        if(!p.getNombre1().equalsIgnoreCase("")&&p.getNombre1().trim().length()!=0){
            x+=" and nombre1='"+p.getNombre1()+"'";
        }
        if(!p.getNombre2().equalsIgnoreCase("")&&p.getNombre2().trim().length()!=0){
            x+=" and nombre2='"+p.getNombre2()+"'";
        }
        if(!p.getApellido1().equalsIgnoreCase("")&&p.getApellido1().trim().length()!=0){
            x+=" and apellido1='"+p.getApellido1()+"'";
        }
        if(!p.getApellido2().equalsIgnoreCase("")&&p.getApellido2().trim().length()!=0){
            x+=" and apellido2='"+p.getApellido2()+"'";
        }
        if(p.getGenero()!=null&&!p.getGenero().equalsIgnoreCase("")&&p.getGenero().trim().length()!=0){
            x+=" and genero='"+p.getGenero()+"'";
        }       
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(x);
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
