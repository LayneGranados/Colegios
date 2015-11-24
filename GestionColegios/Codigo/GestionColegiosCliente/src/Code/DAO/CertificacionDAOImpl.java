
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author felix.orduz
 */
public class CertificacionDAOImpl {
    
    String guardarCertificacion="insert into cer_old "
            + "(annio,sede,grado,curso,apellido1,apellido2,nombre1,nombre2,observaciones,fallas,comportamiento) "
            + "values"
            + "(";
    
    
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
                //result = st.execute(query);
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                
                
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    cer.setCer_old_id(rs.getInt(1));
                }
                st.close();
                miConexion.close();
                }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return result;
    }
}
