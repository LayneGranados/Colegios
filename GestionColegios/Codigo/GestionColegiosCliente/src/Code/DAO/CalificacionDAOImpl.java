/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Asignatura;
import Code.Domain.AsignaturaCurso;
import Code.Domain.Boletin;
import Code.Domain.Calificacion;
import Code.Domain.CaracteristicaBoletin;
import Code.Domain.DetalleCalificacion;
import Code.Domain.Matricula;
import Code.Domain.Periodo;
import Code.Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author laynegranadosmogollon
 */
public class CalificacionDAOImpl {
    
    String getBoletin = "select b.* from boletin b where b.matricula_id= ? and periodo_id= ?";
    String insertBoletin = "insert into boletin (matricula_id, periodo_id, observaciones) values (?, ?, ?)";
    String updateBoletin = "update boletin set observaciones = ? where boletin_id = ?";
    String getCalificacion = "select c.* from calificacion c where c.asignatura_curso_id= ? and c.boletin_id = ?";
    String insertCalificacion = "insert into calificacion (asignatura_curso_id, boletin_id, observaciones) values (?, ?, ?)";
    String updateCalificacion = "update calificacion set observaciones = ? where calificacion_id = ?";
    String getDetalleCalificacion = "select * from detalle_calificacion where calificacion_id = ?";
    String insertDetalleCalificacion = "insert into detalle_calificacion (calificacion_id, caracteristica_id, valor_caracteristica) values (?, ?, ?)";
    String updateDetalleCalificacion = "update detalle_calificacion set valor_caracteristica = ?, caracteristica_id = ? where detalle_calificacion_id = ?";
    String getListaTablaCalificaciones= "select b.boletin_id, b.observaciones as observaciones_boletin, a.asignatura_id, a.nombre as asignatura_nombre, c.observaciones as observaciones_calificacion, " +
                                        "d.detalle_calificacion_id, d.valor_caracteristica, cb.caracteristica_id, cb.nombre, c.calificacion_id, ac.asignatura_curso_id from matricula m " +
                                        "inner join boletin b on m.matricula_id = b.matricula_id " +
                                        "inner join calificacion c on b.boletin_id = c.boletin_id " +
                                        "inner join detalle_calificacion d on c.calificacion_id = d.calificacion_id " +
                                        "inner join asignatura_curso ac on c.asignatura_curso_id = ac.asignatura_curso_id " +
                                        "inner join asignatura a on ac.asignatura_id = a.asignatura_id " +
                                        "inner join periodo prd on b.periodo_id = prd.periodo_id " +
                                        "inner join caracteristica_boletin cb on d.caracteristica_id = cb.caracteristica_id " +
                                        "where m.matricula_id = ? and b.periodo_id= ?";
    
    String buscarCalificaciondeAsignatura = "select c.* from matricula m " +
                                            "inner join boletin b on m.matricula_id = b.matricula_id " +
                                            "inner join calificacion c on b.boletin_id = c.boletin_id " +
                                            "inner join asignatura_curso ac on c.asignatura_curso_id = ac.asignatura_curso_id " +
                                            "inner join asignatura a on ac.asignatura_id = a.asignatura_id " +
                                            "inner join periodo prd on b.periodo_id = prd.periodo_id " +
                                            "where m.matricula_id = ? and b.periodo_id = ? and a.asignatura_id = ?"; 
    
    String deleteCalificacion = "delete from calificacion where calificacion_id = ?";
    
    String getListaTablaEstudiantes = "select m.codigo, a.nombre, dc.valor_caracteristica from matricula m " +
                                      "inner join curso cur on m.curso_id = cur.curso_id " +
                                      "inner join boletin b on m.matricula_id = b.matricula_id " +
                                      "inner join calificacion c on b.boletin_id = c.boletin_id " +
                                      "inner join detalle_calificacion dc on c.calificacion_id = dc.calificacion_id " +
                                      "inner join asignatura_curso ac on c.asignatura_curso_id = ac.asignatura_curso_id " +
                                      "inner join asignatura a on ac.asignatura_id = a.asignatura_id " +
                                      "inner join periodo prd on b.periodo_id = prd.periodo_id " +
                                      "where cur.curso_id = ? and b.periodo_id = ? " +
                                      "order by m.codigo asc, a.nombre asc";
    
    public DetalleCalificacion guardarCalificacion(Matricula matricula, Periodo periodo, String observaciones, 
            Asignatura asignatura, CaracteristicaBoletin caracteristica, String valorCalificacion, String observacionesCalificacion){
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        DetalleCalificacion detalleCalificacion = null;
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                
                Calificacion validacion = null;
                validacion = this.buscarCalificacionDeAsignatura(matricula, periodo, asignatura);
                if(validacion != null){
                    JOptionPane.showMessageDialog(null, "Ya se encuentra una calificacion para esta asignatura registrada", "Error al guardar Calificación", JOptionPane.INFORMATION_MESSAGE);
                    return null;
                }
                    
                Boletin boletin = null;
                preparedStatement = miConexion.prepareStatement(this.getBoletin);
                preparedStatement.setInt(1, matricula.getId());
                preparedStatement.setInt(2, periodo.getId());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                   boletin = new Boletin();
                   boletin.setId(rs.getInt("boletin_id"));
                   Matricula m = new Matricula();
                   m.setId(rs.getInt("matricula_id"));
                   Periodo p = new Periodo();
                   p.setId(rs.getInt("periodo_id"));
                   boletin.setMatricula(m);
                   boletin.setPeriodo(p);
                   boletin.setObservaciones(rs.getString("observaciones"));
                   
                   if(!boletin.getObservaciones().trim().equalsIgnoreCase(observaciones.trim())){
                        preparedStatement = miConexion.prepareStatement(this.updateBoletin);
                        preparedStatement.setString(1, observaciones);
                        preparedStatement.setInt(2, boletin.getId());
                        preparedStatement.executeUpdate();
                   }
                }
                if(boletin == null){
                    preparedStatement = miConexion.prepareStatement(this.insertBoletin, new String[] { "boletin_id"});
                    preparedStatement.setInt(1, matricula.getId());
                    preparedStatement.setInt(2, periodo.getId());
                    preparedStatement.setString(3, observaciones);
                    preparedStatement.executeUpdate();
 
                    ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                    if (null != generatedKeys && generatedKeys.next()) {
                        Long primaryKey = generatedKeys.getLong(1);
                        System.out.println(primaryKey);
                        boletin = new Boletin();
                        boletin.setId(primaryKey.intValue());
                        boletin.setMatricula(matricula);
                        boletin.setPeriodo(periodo);
                        boletin.setObservaciones(observaciones);
                    }
                    
                }
                /*COMIENZA EL ESPACIO EN EL QUE SE BUSCA Y SE GUARDA UNA CALIFICACION POR BOLETIN*/
                if(boletin != null){
                    Calificacion calificacion = null;
                    preparedStatement = miConexion.prepareStatement(this.getCalificacion);
                    preparedStatement.setInt(1, asignatura.getIdAsignaturaCurso());
                    preparedStatement.setInt(2, boletin.getId());
                    rs = preparedStatement.executeQuery();
                    while (rs.next())
                    {
                       calificacion = new Calificacion();
                       calificacion.setId(rs.getInt("calificacion_id"));
                       AsignaturaCurso asignaturaCurso = new AsignaturaCurso();
                       asignaturaCurso.setId(asignatura.getIdAsignaturaCurso());
                       calificacion.setAsignaturaCursoId(asignaturaCurso);
                       calificacion.setBoletin(boletin);
                       calificacion.setObservaciones(rs.getString("observaciones"));

                       if(!calificacion.getObservaciones().trim().equalsIgnoreCase(observacionesCalificacion.trim())){
                            preparedStatement = miConexion.prepareStatement(this.updateCalificacion);
                            preparedStatement.setString(1, observacionesCalificacion);
                            preparedStatement.setInt(2, calificacion.getId());
                            preparedStatement.executeUpdate();
                       }
                    }
                    if(calificacion == null){
                        preparedStatement = miConexion.prepareStatement(this.insertCalificacion, new String[] { "calificacion_id"});
                        preparedStatement.setInt(1, asignatura.getIdAsignaturaCurso());
                        preparedStatement.setInt(2, boletin.getId());
                        preparedStatement.setString(3, observacionesCalificacion);
                        preparedStatement.executeUpdate();

                        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                        if (null != generatedKeys && generatedKeys.next()) {
                            Long primaryKey = generatedKeys.getLong(1);
                            System.out.println(primaryKey);
                            calificacion = new Calificacion();
                            calificacion.setId(primaryKey.intValue());
                            AsignaturaCurso ac = new AsignaturaCurso();
                            ac.setId(asignatura.getId());
                            calificacion.setAsignaturaCursoId(ac);
                            calificacion.setBoletin(boletin);
                            calificacion.setObservaciones(observacionesCalificacion);
                        }
                    }
                    /*COMIENZA A GUARDAR EL DETALLE DE CALIFICACION*/
                    if(calificacion != null){
                        
                        preparedStatement = miConexion.prepareStatement(this.getDetalleCalificacion);
                        preparedStatement.setInt(1, calificacion.getId());
                        rs = preparedStatement.executeQuery();
                        while (rs.next())
                        {
                           detalleCalificacion = new DetalleCalificacion();
                           detalleCalificacion.setId(rs.getInt("detalle_calificacion_id"));
                           detalleCalificacion.setCalificacion(calificacion);
                           CaracteristicaBoletin caracteristicaGuardada = new CaracteristicaBoletin();
                           caracteristicaGuardada.setId(rs.getInt("caracteristica_id"));
                           detalleCalificacion.setCaracteristicaBoletin(caracteristicaGuardada);
                           detalleCalificacion.setValorNota(rs.getString("valor_caracteristica"));
                           String updateDetalleCalificacion = "update detalle_calificacion set valor_caracteristica = ?, caracteristica_id = ? where detalle_calificacion_id = ?";
                           if(detalleCalificacion.getCaracteristicaBoletin().getId() == caracteristica.getId()){
                               if(!detalleCalificacion.getValorNota().trim().equalsIgnoreCase(valorCalificacion.trim())){
                                    preparedStatement = miConexion.prepareStatement(this.updateDetalleCalificacion);
                                    preparedStatement.setString(1, valorCalificacion);
                                    preparedStatement.executeUpdate();
                               }
                           }
                        }
                        if(detalleCalificacion == null){
                            preparedStatement = miConexion.prepareStatement(this.insertDetalleCalificacion, new String[] { "detalle_calificacion_id"});
                            preparedStatement.setInt(1, calificacion.getId());
                            preparedStatement.setInt(2, caracteristica.getId());
                            preparedStatement.setString(3, valorCalificacion);
                            preparedStatement.executeUpdate();

                            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                            if (null != generatedKeys && generatedKeys.next()) {
                                Long primaryKey = generatedKeys.getLong(1);
                                System.out.println(primaryKey);
                                detalleCalificacion = new DetalleCalificacion();
                                detalleCalificacion.setId(primaryKey.intValue());
                                detalleCalificacion.setCaracteristicaBoletin(caracteristica);
                                detalleCalificacion.setCalificacion(calificacion);
                                detalleCalificacion.setValorNota(valorCalificacion);
                            }
                        }
                    }
                }
                preparedStatement.close();
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return detalleCalificacion;
    }
    
    
    public ArrayList<DetalleCalificacion> getListadoTabla(Matricula matricula, Periodo periodo) {
        ArrayList<DetalleCalificacion> detalles = new ArrayList<DetalleCalificacion>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.getListaTablaCalificaciones);
                preparedStatement.setInt(1, matricula.getId());
                preparedStatement.setInt(2, periodo.getId());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                    DetalleCalificacion detalle = new DetalleCalificacion();
                    detalle.setValorNota(rs.getString("valor_caracteristica"));
                    detalle.setId(rs.getInt("detalle_calificacion_id"));
                    CaracteristicaBoletin caracteristica = new CaracteristicaBoletin();
                    caracteristica.setId(rs.getInt("caracteristica_id"));
                    caracteristica.setNombre(rs.getString("nombre"));
                    detalle.setCaracteristicaBoletin(caracteristica);
                    Calificacion calificacion = new Calificacion();
                    calificacion.setId(rs.getInt("calificacion_id"));
                    Boletin boletin = new Boletin();
                    boletin.setId(rs.getInt("boletin_id"));
                    boletin.setObservaciones(rs.getString("observaciones_boletin"));
                    calificacion.setBoletin(boletin);
                    AsignaturaCurso asignaturaCurso = new AsignaturaCurso();
                    asignaturaCurso.setId(rs.getInt("asignatura_curso_id"));
                    Asignatura asignatura = new Asignatura();
                    asignatura.setId(rs.getInt("asignatura_id"));
                    asignatura.setNombre(rs.getString("asignatura_nombre"));
                    asignaturaCurso.setAsignatura(asignatura);
                    calificacion.setAsignaturaCursoId(asignaturaCurso);
                    calificacion.setObservaciones(rs.getString("observaciones_calificacion"));
                    detalle.setCalificacion(calificacion);
                    detalles.add(detalle);
                }
                preparedStatement.close();
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return detalles;
    }
    
    
    public Calificacion buscarCalificacionDeAsignatura(Matricula matricula, Periodo periodo, Asignatura asignatura){
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Calificacion calificacion = null;
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.buscarCalificaciondeAsignatura);
                preparedStatement.setInt(1, matricula.getId());
                preparedStatement.setInt(2, periodo.getId());
                preparedStatement.setInt(3, asignatura.getId());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                   calificacion  = new Calificacion();
                   calificacion.setId(rs.getInt("calificacion_id"));
                   calificacion.setObservaciones(rs.getString("observaciones"));
                }
                preparedStatement.close();
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return calificacion;
    }
    
    public void deleteCalificacionYDetalle(int idCalificacion){
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.deleteCalificacion);
                preparedStatement.setInt(1, idCalificacion);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                miConexion.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void updateCalificacion(DetalleCalificacion detalle){
        
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.updateCalificacion);
                preparedStatement.setString(1, detalle.getCalificacion().getObservaciones());
                preparedStatement.setInt(2, detalle.getCalificacion().getId());
                preparedStatement.executeUpdate();
                
                preparedStatement = miConexion.prepareStatement(this.updateDetalleCalificacion);
                preparedStatement.setString(1, detalle.getValorNota());
                preparedStatement.setInt(2, detalle.getCaracteristicaBoletin().getId());
                preparedStatement.setInt(3, detalle.getId());
                preparedStatement.executeUpdate();
                
                preparedStatement.close();
                miConexion.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<String> buscarCalificacionDeAsignatura(int idCurso, int periodoId){
        ArrayList<String> tablas = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        if(miConexion!=null)
        {
            PreparedStatement preparedStatement;
            try {
                preparedStatement = miConexion.prepareStatement(this.getListaTablaEstudiantes);
                preparedStatement.setInt(1, idCurso);
                preparedStatement.setInt(2, periodoId);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next())
                {
                   String cadena = "";
                   cadena += rs.getString("codigo");
                   cadena += "/-/"+rs.getString("nombre");
                   cadena += "/-/"+rs.getString("valor_caracteristica");
                   tablas.add(cadena);
                }
                preparedStatement.close();
                miConexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tablas;
    }
}
