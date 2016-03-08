/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.CaracteristicaBoletin;
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
public class CaracteristicaBoletinDAOImpl {
    
    String getCaracteristicaBoletin="select * from caracteristica_boletin";
    
    public ArrayList<CaracteristicaBoletin> getCaracteristicaBoletin(){
        
        ArrayList<CaracteristicaBoletin> caracteristicas = new ArrayList<CaracteristicaBoletin>();
        Connection miConexion = ConexionBD.GetConnection();
        
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(getCaracteristicaBoletin);
                CaracteristicaBoletin c = new CaracteristicaBoletin();
                c.setId(-1);
                c.setNombre("No Seleccionado");
                c.setCalculo("No Aplica");
                c.setTipo_valor("No Tiene");
                caracteristicas.add(c);
                while (rs.next())
                {
                    c = new CaracteristicaBoletin();
                    c.setId(rs.getInt("caracteristica_id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setCalculo(rs.getString("calculo"));
                    c.setTipo_valor(rs.getString("tipo_valor"));
                    caracteristicas.add(c);
                }
                st.close();
            }
        miConexion.close();
        }catch(SQLException sqlException){
        }catch(NullPointerException nullPointerException){
        }catch(Exception exception){
        }
        return caracteristicas;
    }
}
