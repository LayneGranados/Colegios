/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Util.ConexionBD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author laynegranadosmogollon
 */
public class EstudianteDAOImpl {

    public void guardarEstudiante(){
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
      
        if(miConexion!=null)
        {
            JOptionPane.showMessageDialog(null, "Conexión Realizada Correctamente");
        }else
        {
            JOptionPane.showMessageDialog(null, "Conexión Incorrecta");
        }
    }
    
    
    
}
