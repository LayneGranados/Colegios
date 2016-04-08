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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laynegranadosmogollon
 */
public class PersonaDAOImpl {
    
    String todosLasPersonas="select p.*, t.tipo_documento_id , t.nombre as tipo_documento_nombre, e.etnia_id, e.nombre as etnia_nombre, r.resguardo_id, r.nombre as resguardo_nombre from persona p inner join tipo_documento t on p.tipo_documento_id = t.tipo_documento_id left join etnia e on p.etnia_id = e.etnia_id left join resguardo r on p.resguardo_id = r.resguardo_id";
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
    
    String bulk="insert into persona (tipo_persona,tipo_documento_id,documento,exp_depto,exp_mun,nombre1,nombre2,apellido1,"
            + "apellido2,fecha_nacimiento,genero,nac_depto,nac_mun,telefono_residencia,direccion_residencia,res_depto,"
            + "res_mun,estrato,sisben,etnia_id,resguardo_id) values ";
    
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
                int id = st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
                
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    id = rs.getInt(1);
                }
                int idEstudiante = -1;
                p.setId(id);
                if(p.getTipoPersona().equalsIgnoreCase("E")){
                    String insertPersona ="insert into estudiante (codigo, persona_id) values ('',"+p.getId()+")";
                    idEstudiante = st.executeUpdate(insertPersona, Statement.RETURN_GENERATED_KEYS);
                    rs = st.getGeneratedKeys();
                    if(rs.next()){
                        idEstudiante = rs.getInt(1);
                        if(idEstudiante >0){
                            result = true;
                        }
                    }
                }
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public String guardarMapPersonas(Map<String, Persona> personas){      
        String cedulasPersonas = "";
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        System.out.println("cantidad de personas: "+personas.size());
        int dividir = 1;
        if(personas.size()>0){
            dividir = (personas.size()/50)+1;
            
            String query = this.bulk; 
            boolean primero = true;
            int contador = 0;
            for (Map.Entry<String, Persona> entry : personas.entrySet())
            {  
                contador ++;
                Persona p = entry.getValue();
                Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = formatter.format(p.getFechaNacimiento());
                if(!primero){
                    query+=",";
                }
                query +="('"+p.getTipoPersona()+"',"+p.getTipoDocumento().getId()+",'"+p.getDocumento()+"',"+p.getDepartamentoExpedicion()+","+p.getMunicipioExpedicion()+",'"+p.getNombre1()+"','"+p.getNombre2()+"','"+p.getApellido1()+"','"+p.getApellido2()+"',str_to_date('"+fecha+"','%d/%m/%Y'),'"+p.getGenero()+"',"+p.getDepartamentoNacimiento()+","+p.getMunicipioNacimiento()+",'"+p.getTelefonoResidencia()+"','"+p.getDireccionResidencia()+"',"+p.getDepartamentoResidencia()+","+p.getMunicipioResidencia()+",'"+p.getEstrato()+"','"+p.getSisben()+"',"+p.getEtnia().getId()+","+p.getResguardo().getId()+")";
                primero = false;
                if(contador==50){
                    System.out.println("imprime en linea 153: "+query);
                    try{
                        if(miConexion!=null)
                        {
                            Statement st = miConexion.createStatement();
                            st.executeUpdate(query);                
                            st.close();
                        }
                    }catch(SQLException sqlException){sqlException.printStackTrace();}catch(NullPointerException nullPointerException){}catch(Exception ex){ex.printStackTrace();}
                    
                    query = this.bulk; 
                    primero = true; 
                    contador =0;
                }
            }
            System.out.println("imprime en linea 153: "+query);
            try{
                if(miConexion!=null)
                {
                    Statement st = miConexion.createStatement();
                    System.out.println("query en personas: "+query);
                    st.executeUpdate(query);                
                    st.close();
                }
            }catch(SQLException sqlException){sqlException.printStackTrace();}catch(NullPointerException nullPointerException){}catch(Exception ex){ex.printStackTrace();}
        }
        try {
            miConexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public Persona getPersona(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
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
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return persona;
    }
    
    public Persona getPersonaMasCampos(Persona p){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
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
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
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
            query+=" and documento='"+p.getDocumento()+"'";
        }
        if(p.getTipoPersona()!=null){
            if(!p.getTipoPersona().isEmpty()){
                query+=" and tipo_persona='"+p.getTipoPersona()+"'";
            }
        }
        
        if(!p.getNombre1().isEmpty()&&!p.getNombre1().equalsIgnoreCase("")){
            query+=" and nombre1='"+p.getNombre1()+"'";
        }
        if(!p.getNombre2().isEmpty()&&!p.getNombre2().equalsIgnoreCase("")){
            query+=" and nombre2='"+p.getNombre2()+"'";
        }
        if(!p.getApellido1().isEmpty()&&!p.getApellido1().equalsIgnoreCase("")){
            query+=" and apellido1='"+p.getApellido1()+"'";
        }
        if(!p.getGenero().isEmpty()&&!p.getGenero().equalsIgnoreCase("")){
            query+=" and genero='"+p.getGenero()+"'";
        }
        if(!p.getApellido2().isEmpty()&&!p.getApellido2().equalsIgnoreCase("")){
            query+=" and apellido2='"+p.getApellido2()+"'";
        }
        if(p.getSisben()>0){
            query+=" and sisben='"+p.getSisben()+"'";
        }
        if(p.getEstrato()>0){
            query=" and estrato='"+p.getEstrato()+"'";
        }
        if(p.getDepartamentoNacimiento()>0){
            query+=" and nac_depto="+p.getDepartamentoNacimiento();
        }
        if(p.getDepartamentoResidencia()>0){
            query+=" and res_depto="+p.getDepartamentoResidencia();
        }
        if(p.getDepartamentoExpedicion()>0){
            query+=" and exp_depto="+p.getDepartamentoExpedicion();
        }
        if(p.getMunicipioNacimiento()>0){
            query+=" and nac_mun="+p.getMunicipioNacimiento();
        }
        if(p.getMunicipioResidencia()>0){
            query+=" and res_mun="+p.getMunicipioResidencia();
        }
        if(p.getMunicipioExpedicion()>0){
            query+=" and exp_mun="+p.getMunicipioExpedicion();
        }
        
        String cadena = this.todosLasPersonas+ " "+query;
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        try{
            if(miConexion!=null)
            {   System.out.println("Cadena:"+cadena);
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
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return personas;
    }
    
    public Map<String, Persona> getMapPersonas(){
        Map<String, Persona> personas = new HashMap<String, Persona>();
        String cadena = this.todosLasPersonas;
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        try{
            if(miConexion!=null)
            {   System.out.println("Cadena:"+cadena);
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
                    personas.put(persona.getTipoDocumento().getId()+""+persona.getDocumento(),persona);
                }
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return personas;
    }
    
    
}
