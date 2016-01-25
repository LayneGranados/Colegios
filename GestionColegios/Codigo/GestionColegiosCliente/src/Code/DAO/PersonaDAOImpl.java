/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Etnia;
import Code.Domain.Persona;
import Code.Domain.Resguardo;
import Code.Domain.TipoDocumento;
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
 * @author laynegranadosmogollon
 */
public class PersonaDAOImpl {
    
    String todosLasPersonas="select p.*, t.tipo_documento_id , t.nombre as tipo_documento_nombre, e.etnia_id, e.nombre as etnia_nombre, r.resguardo_id, r.nombre as resguardo_nombre from persona p , tipo_documento t, etnia e, resguardo r  where p.tipo_documento_id = t.tipo_documento_id and e.etnia_id=p.etnia_id and r.resguardo_id = p.resguardo_id";
    String personaPorId="SELECT * FROM persona WHERE persona_id=";
    String personaPorIdentificacion="SELECT * FROM persona WHERE tipo_documento_id=";
    String buscarPersonaArgumentos="SELECT * FROM persona where ";
    String guardarPersona="insert into persona "
            + "("
            + "tipo_persona, "
            + "tipo_documento_id, "
            + "documento,"
            + "exp_depto,"
            + "exp_mun,"
            + "nombre1,"
            + "nombre2,"
            + "apellido1,"
            + "apellido2,"
            + "fecha_nacimiento,"
            + "genero,"
            + "nac_depto,"
            + "nac_mun,"
            + "telefono_residencia,"
            + "direccion_residencia,"
            + "res_depto,"
            + "res_mun,"
            + "estrato,"
            + "sisben,"
            + "etnia_id,"
            + "resguardo_id) "
            + "values"
            + "(";
    
    public Boolean guardarPersona(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formatter.format(p.getFechaNacimiento());
        String consulta="'"+
                p.getTipoPersona()+"',"+
                p.getTipoDocumento().getId()+",'"+
                p.getDocumento()+"',"+
                p.getDepartamentoExpedicion()+","+
                p.getMunicipioExpedicion()+",'"+
                p.getNombre1()+"','"+
                p.getNombre2()+"','"+
                p.getApellido1()+"','"+
                p.getApellido2()+"',str_to_date('"+
                fecha+"','%d/%m/%Y'),'"+
                p.getGenero()+"',"+
                p.getDepartamentoNacimiento()+","+
                p.getMunicipioNacimiento()+",'"+
                p.getTelefonoResidencia()+"','"+
                p.getDireccionResidencia()+"',"+
                p.getDepartamentoResidencia()+","+
                p.getMunicipioResidencia()+",'"+
                p.getEstrato()+"','"+
                p.getSisben()+"',"+
                p.getEtnia().getId()+","+
                p.getResguardo().getId()+")";
        try{
            if(miConexion!=null)
            {
                String q = this.guardarPersona+""+consulta;
                System.out.println("query de insert persona: "+q);
                Statement st = miConexion.createStatement();
                result = st.execute(q);
                st.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception ex){
            System.out.println("exception:"+ex.getMessage());
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
    
    public ArrayList<Persona> buscarPersonasPorArgumentos(Persona p){
        ArrayList<Persona> personas = new ArrayList<Persona>();
        int i=0;

        String query=" ";
        if(p.getTipoDocumento()!=null){
            if(p.getTipoDocumento().getId()>0){
                query+=" and t.tipo_documento_id="+p.getTipoDocumento().getId();
                i++;
            }
        }
        if(!p.getDocumento().isEmpty()&&!p.getDocumento().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="documento='"+p.getDocumento()+"'";
            
            i++;
        }
        if(p.getTipoPersona()!=null){
            if(!p.getTipoPersona().isEmpty()){
                if(i>0){
                    query+=" and ";
                }
                query+="tipo_persona='"+p.getTipoPersona()+"'";
                i++;
            }
        }
        
        if(!p.getNombre1().isEmpty()&&!p.getNombre1().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="nombre1='"+p.getNombre1()+"'";
            
            i++;
        }
        if(!p.getNombre2().isEmpty()&&!p.getNombre2().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="nombre2='"+p.getNombre2()+"'";
            
            i++;
        }
        if(!p.getApellido1().isEmpty()&&!p.getApellido1().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="apellido1='"+p.getApellido1()+"'";
            
            i++;
        }
        if(!p.getGenero().isEmpty()&&!p.getGenero().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="genero='"+p.getGenero()+"'";
            
            i++;
        }
        if(!p.getApellido2().isEmpty()&&!p.getApellido2().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="apellido2='"+p.getApellido2()+"'";
            i++;
        }
        if(p.getSisben()>0){
            if(i>0){
                query+=" and ";
            }
            query+="sisben='"+p.getSisben()+"'";
    
            i++;
        }
        if(p.getEstrato()>0){
            if(i>0){
                query+=" and ";
            }
            query="estrato='"+p.getEstrato()+"'";

            i++;
        }
        if(p.getDepartamentoNacimiento()>0){
            if(i>0){
                query+=" and ";
            }
            query+="nac_depto="+p.getDepartamentoNacimiento();
            
            i++;
        }
        if(p.getDepartamentoResidencia()>0){
            query+="res_depto="+p.getDepartamentoResidencia();
            if(i>0){
                query+=" and ";
            }
            i++;
        }
        if(p.getDepartamentoExpedicion()>0){
            if(i>0){
                query+=" and ";
            }
            query+="exp_depto="+p.getDepartamentoExpedicion();
           
            i++;
        }
        if(p.getMunicipioNacimiento()>0){
            if(i>0){
                query+=" and ";
            }
            query+="nac_mun="+p.getMunicipioNacimiento();
            
            i++;
        }
        if(p.getMunicipioResidencia()>0){
            if(i>0){
                query+=" and ";
            }
            query+="res_mun="+p.getMunicipioResidencia();
           
            i++;
        }
        if(p.getMunicipioExpedicion()>0){
            if(i>0){
                query+=" and ";
            }
            query+="exp_mun="+p.getMunicipioExpedicion();
            
            i++;
        }
        
        String cadena = this.todosLasPersonas+ " "+query;
        
        System.out.println("cadena persona: "+cadena);
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(cadena);
                while (rs.next())
                {   Persona persona = new Persona(); 
                    TipoDocumento tipo = new TipoDocumento();
                    tipo.setId(rs.getInt("tipo_documento_id"));
                    tipo.setNombre(rs.getString("tipo_documento_nombre"));
                    persona.setTipoDocumento(tipo);
                    persona.setTipoPersona(rs.getString("tipo_persona"));
                    persona.setDocumento(rs.getString("documento"));
                    persona.setId(rs.getInt("persona_id"));
                    persona.setNombre1(rs.getString("nombre1"));
                    persona.setNombre2(rs.getString("nombre2"));
                    persona.setApellido1(rs.getString("apellido1"));
                    persona.setApellido2(rs.getString("apellido2"));
                    persona.setDireccionResidencia(rs.getString("direccion_residencia"));
                    persona.setSisben(Integer.parseInt(rs.getString("sisben")));
                    persona.setEstrato(Integer.parseInt(rs.getString("estrato")));
                    persona.setGenero(rs.getString("genero"));
                    persona.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    persona.setDepartamentoExpedicion(rs.getInt("exp_depto"));
                    persona.setMunicipioExpedicion(rs.getInt("exp_mun"));
                    persona.setDepartamentoResidencia(rs.getInt("res_depto"));
                    persona.setMunicipioResidencia(rs.getInt("res_mun"));
                    persona.setDepartamentoNacimiento(rs.getInt("nac_depto"));
                    persona.setMunicipioNacimiento(rs.getInt("nac_mun"));
                    Etnia e = new Etnia();
                    e.setId(rs.getInt("etnia_id"));
                    e.setNombre(rs.getString("etnia_nombre"));
                    persona.setEtnia(e);
                    
                    Resguardo r = new Resguardo();
                    r.setId(rs.getInt("resguardo_id"));
                    r.setNombre(rs.getString("resguardo_nombre"));
                    persona.setResguardo(r);
                    
                    persona.setTelefonoResidencia(rs.getString("telefono_residencia"));
                    personas.add(persona);
                }
        }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        
        return personas;
    }
    
}
