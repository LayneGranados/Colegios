/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.CertificacionOldstyle;
import Code.Domain.Departamento;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Municipio;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laygrana
 */
public class InstitucionEducativaDAOImpl {
    
    String select ="select c.*, m.codigo_dane as codigo_dane_municipio, m.nombre as nombre_municipio, d.nombre as nombre_departamento, d.departamento_id from colegio c inner join municipio m on c.municipio_id = m.municipio_id inner join departamento d on m.departamento_id =d.departamento_id";
    String insert= "insert into colegio "
            + "(codigo_dane, dane_anterior, municipio_id, nombre, path_logo, ruta_archivos_generados, direccion, telefono) values (";
    String update = "update colegio set nombre = ?, codigo_dane = ?, municipio_id = ?, dane_anterior = ? , telefono = ?, direccion = ? where colegio_id = ? ";
    
    
    public InstitucionEducativa guardarColegio(InstitucionEducativa ie) {      
       
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        String query="";
        query=this.insert+"'"+
                ie.getCodigoDANEActual()+"','"+
                ie.getCodigoDANEAnterior()+"',"+
                ie.getMunicipio().getId()+",'"+
                ie.getNombre()+"','"+
                ie.getRutaLogo()+"','"+
                ie.getRutaArchivosGenerados()+"','"+
                ie.getDireccion()+"','"+
                ie.getTelefono()+"')";         
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                int id = st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    ie.setId(rs.getInt(1));
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
        return ie;
    }
    
    public InstitucionEducativa selectColegio(){
        
        InstitucionEducativa i = new InstitucionEducativa();
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        try{
            if(miConexion!=null)
            {
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(this.select);
                while (rs.next())
                {
                    i.setId(rs.getInt("colegio_id"));
                    i.setNombre(rs.getString("nombre"));
                    i.setCodigoDANEActual(rs.getString("codigo_dane"));
                    i.setCodigoDANEAnterior(rs.getString("dane_anterior"));
                    Municipio m = new Municipio();
                    Departamento d = new Departamento();
                    d.setId(rs.getInt("departamento_id"));
                    d.setNombre(rs.getString("nombre_departamento"));
                    m.setDepartamento(d);
                    m.setDepartamentoId(d.getId());
                    m.setId(rs.getInt("municipio_id"));
                    m.setCodigoDANE(rs.getString("codigo_dane_municipio"));
                    m.setNombre(rs.getString("nombre_municipio"));
                    i.setMunicipio(m);
                    i.setDireccion(rs.getString("direccion"));
                    i.setTelefono(rs.getString("telefono"));
                    i.setRutaArchivosGenerados(rs.getString("ruta_archivos_generados"));
                    i.setRutaLogo(rs.getString("path_logo"));
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
        return i;
    }
    
    public void updateColegio(InstitucionEducativa institucionEducativa){
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.update);
                preparedStatement.setString(1, institucionEducativa.getNombre());
                preparedStatement.setString(2, institucionEducativa.getCodigoDANEActual());
                preparedStatement.setInt(3, institucionEducativa.getMunicipio().getId());
                preparedStatement.setString(4, institucionEducativa.getCodigoDANEAnterior());
                preparedStatement.setString(5, institucionEducativa.getTelefono());
                preparedStatement.setString(6, institucionEducativa.getDireccion());
                preparedStatement.setInt(7, institucionEducativa.getId());
                preparedStatement.executeUpdate();                
                preparedStatement.close();
                miConexion.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    
}
