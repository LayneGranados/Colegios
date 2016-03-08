/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author laynegranadosmogollon
 */
public class ColegioDAOImpl {
    
    String todosLosColegios="select * from colegio";
    String colegioPorId="SELECT * FROM colegio WHERE colegio_id=";
    String colegioPorMunicipio="SELECT * FROM colegio WHERE municipio_id=";
    
    
    public ArrayList<String> getColegio() throws SQLException{
        ArrayList<String> colegios = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            Statement st = miConexion.createStatement();
            ResultSet rs = st.executeQuery(todosLosColegios);
            while (rs.next())
            {
                int id = rs.getInt("colegio_id");
                String nombre = rs.getString("nombre");
                colegios.add(id+"-"+nombre);
            }
            st.close();
        }
        miConexion.close();
        return colegios;
    }
    
}
