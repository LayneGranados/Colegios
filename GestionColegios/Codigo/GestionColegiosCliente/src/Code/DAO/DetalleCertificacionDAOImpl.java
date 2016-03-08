
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Domain.DetalleCertificadoOld;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author axidsugar
 */
public class DetalleCertificacionDAOImpl {
    String guardarDetalleCertificacion="insert into det_cer_old "
            + "(cer_old_id,nombre_detalle,valor_detalle) "
            + "values"
            + "(";
    String detalleCertificacionOLD="select * from det_cer_old where cer_old_id=";
    
    
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
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
        return result;
    }
    
    public ArrayList<DetalleCertificadoOld> getDetalleCertificadoOLD(int id){
        ArrayList<DetalleCertificadoOld> detalle = new ArrayList<DetalleCertificadoOld>();
        String cadena=this.detalleCertificacionOLD+""+id;
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(cadena);
                while (rs.next())
                {   DetalleCertificadoOld d = new DetalleCertificadoOld();
                    d.setCer_old_id(rs.getInt("det_cer_old_id"));
                    d.setDet_cer_old_id(rs.getInt("cer_old_id"));
                    d.setNombre_detalle(rs.getString("nombre_detalle"));
                    d.setValor_detalle(rs.getString("valor_detalle"));
                    detalle.add(d);
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
        return detalle;
    }
}
