
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author felix.orduz
 */
public class CertificacionDAOImpl {
    
    String guardarCertificacion="insert into cer_old "
            + "(annio,sede,grado,curso,apellido1,apellido2,nombre1,nombre2,observaciones,fallas,comportamiento) "
            + "values"
            + "(";
    
    String buscarCertificadosAntiguos="select * from cer_old";
    
    
    public Boolean guardarCertificacion(CertificacionOldstyle cer){      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.guardarCertificacion+"'"+
                cer.getAnnio()+"','"+
                cer.getSede()+"','"+
                cer.getGrado()+"','"+
                cer.getCurso()+"','"+
                cer.getApellido1()+"','"+
                cer.getApellido2()+"','"+
                cer.getNombre1()+"','"+
                cer.getNombre2()+"','"+
                cer.getObservaciones()+"','"+
                cer.getFallas()+"','"+
                cer.getComportamiento()+"');";
         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    cer.setCer_old_id(rs.getInt(1));
                }
                st.close();
                miConexion.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<CertificacionOldstyle> buscarCertificacionesAntiguas(CertificacionOldstyle c){
        ArrayList<CertificacionOldstyle> certificados = new ArrayList<CertificacionOldstyle>();
        int i=0;

        String query=" ";
        if(!c.getAnnio().isEmpty()&&!c.getAnnio().equalsIgnoreCase("")){
                query+="annio='"+c.getAnnio()+"'";
                i++;
        }
        
        if(!c.getSede().isEmpty()&&!c.getSede().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="sede like '%"+c.getSede()+"%'";
            
            i++;
        }
        if(!c.getGrado().isEmpty()&&!c.getGrado().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="grado like '%"+c.getGrado()+"%'";
            i++;
        }
        
        if(!c.getCurso().isEmpty()&&!c.getCurso().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="curso like '%"+c.getCurso()+"%'";
            i++;
        }
        
        if(!c.getNombre1().isEmpty()&&!c.getNombre1().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="nombre1 like '%"+c.getNombre1()+"%'";
            i++;
        }
        if(!c.getNombre2().isEmpty()&&!c.getNombre2().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="nombre2 like '%"+c.getNombre2()+"%'";
            
            i++;
        }
        if(!c.getApellido1().isEmpty()&&!c.getApellido1().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="apellido1 like '%"+c.getApellido1()+"%'";
            
            i++;
        }
       
        if(!c.getApellido2().isEmpty()&&!c.getApellido2().equalsIgnoreCase("")){
            if(i>0){
                query+=" and ";
            }
            query+="apellido2 like '%"+c.getApellido2()+"%'";
            i++;
        }
        
        
        String cadena="";
        if(i>0){
            cadena = this.buscarCertificadosAntiguos+ " where "+query;
        }
        else{
            cadena = this.buscarCertificadosAntiguos;
        }
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(cadena);
                while (rs.next())
                {
                    CertificacionOldstyle cer = new CertificacionOldstyle();
                    cer.setCer_old_id(rs.getInt("cer_old_id"));
                    cer.setAnnio(rs.getString("annio"));
                    cer.setSede(rs.getString("sede"));
                    cer.setGrado(rs.getString("grado"));
                    cer.setCurso(rs.getString("curso"));
                    cer.setApellido1(rs.getString("apellido1"));
                    cer.setApellido2(rs.getString("apellido2"));
                    cer.setNombre1(rs.getString("nombre1"));
                    cer.setNombre2(rs.getString("nombre2"));
                    cer.setObservaciones(rs.getString("observaciones"));
                    cer.setFallas(rs.getInt("fallas"));
                    cer.setComportamiento(rs.getString("comportamiento"));
                    certificados.add(cer);
                }
        }
        miConexion.close();
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        return certificados;
    }
}
