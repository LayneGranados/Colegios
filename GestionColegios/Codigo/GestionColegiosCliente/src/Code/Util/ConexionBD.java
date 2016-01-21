/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Util;

import Code.Business.ConfiguracionBusiness;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author laynegranadosmogollon
 */
public class ConexionBD {
    
    public static Connection GetConnection()
    {
        Connection conexion=null;
        ConfiguracionBusiness c = new ConfiguracionBusiness();
      
        try
        {   
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.0.21:3306/colegios";
            //String servidor = "jdbc:mysql://"+c.getIp().replace("ip: ", "")+":3306/colegios";
            String usuarioDB="root";
            String passwordDB="root";
            conexion= (Connection) DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
}