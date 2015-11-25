
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Domain.DetalleCertificadoOld;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author axidsugar
 */
public class DetalleCertificacionDAOImpl {
    String guardarDetalleCertificacion="insert into det_cer_old "
            + "(cer_old_id,nombre_detalle,valor_detalle) "
            + "values"
            + "(";
    
    
    public Boolean guardarCertificacion(DetalleCertificadoOld detCer){      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Boolean result=false;
        String query="";
        query=this.guardarDetalleCertificacion+
                detCer.getCer_old_id()+",'"+
                detCer.getNombre_detalle()+"','"+
                detCer.getValor_detalle()+"');";
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                System.out.println(query);
                //result = st.execute(query);
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                
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
