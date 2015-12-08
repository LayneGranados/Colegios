/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.DAO;

import Code.Domain.Estudiante;
import Code.Domain.Matricula;
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
public class MatriculaDAOImpl {
    
    String getMatricula="select * from matricula where";
    String insertMatricula="insert into matricula ("
            +"estudiante_id,"
            + "curso_id,"
            +"poblacion_victima_id,"
            +"departamento_expulsor,"
            +"municipio_expulsor,"
            +"proviene_sector_privado,"
            +"proviene_otro_municipio,"
            +"tipo_discapacidad_id,"
            +"capacidad_excepcional_id,"
            +"institucion_familiar_id,"
            +"subsidiado,"
            +"repitente,"
            +"nuevo,"
            +"cabeza_familia,"
            +"ben_mad_flia,"
            +"ben_vet_flia,"
            +"ben_her_nac,"
            +"caracter_id,"
            +"especialidad_id,"
            +"metodologia_id,"
            +"sit_acad_anio_ant_id,"
            +"fuentes_recursos_id,"
            +"zona_alumno,"
            +"condicion_anio_anterior_id) values (";
    
    public Matricula getMatriculaPorEstudianteCurso(int idEstudiante, int idCurso){      
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        Matricula m = new Matricula();
        try{
            if(miConexion!=null)
            {   
                String cadena = this.getMatricula+" estudiante_id="+idEstudiante+" and curso_id="+idCurso;
                System.out.println("cadena en getMatricula: "+cadena);
                Statement st = miConexion.createStatement();
                ResultSet rs = st.executeQuery(cadena);
                while (rs.next())
                {
                   m.setCurso(rs.getInt("curso_id"));
                   Estudiante e = new Estudiante();
                   e.setId(rs.getInt("estudiante_id"));
                   m.setEstudiante(e);
                   m.setVictimaConflicto(rs.getInt("poblacion_victima_id"));
                   m.setDepartamentoExpulsor(rs.getInt("departamento_expulsor"));
                   m.setMunicipioExpulsor(rs.getInt("municipio_expulsor"));
                   m.setProvieneSectorPrivado(rs.getBoolean("proviene_sector_privado"));
                   System.out.println("bool:"+rs.getBoolean("proviene_sector_privado"));
                   System.out.println("int:"+rs.getInt("proviene_sector_privado"));
                   m.setProvienteOtroMunicipio(rs.getBoolean("proviene_otro_municipio"));
                   m.setTipoDiscapacidad(rs.getInt("tipo_discapacidad_id"));
                   m.setCapacidadExcepcional(rs.getInt("capacidad_excepcional_id"));
                   m.setInstutionFamiliar(rs.getInt("institucion_familiar_id"));
                   m.setSubsidiado(rs.getBoolean("subsidiado"));
                   m.setRepitente(rs.getBoolean("repitente"));
                   m.setNuevo(rs.getBoolean("nuevo"));
                   m.setBeneficiarioCabezaFamilia(rs.getBoolean("cabeza_familia"));
                   m.setBeneficiarioMadreFamilia(rs.getBoolean("ben_mad_flia"));
                   m.setBeneficiarioVeteranoFuerzas(rs.getBoolean("ben_vet_flia"));
                   m.setBeneficiarioHeroeNacional(rs.getBoolean("ben_her_nac"));
                   m.setCaracter(rs.getInt("caracter_id"));
                   m.setEspecialidad(rs.getInt("especialidad_id"));
                   m.setMetodologia(rs.getInt("metodologia_id"));
                   m.setSituacionAnterior(rs.getInt("sit_acad_anio_ant_id"));
                   m.setFuenteRecursos(rs.getInt("fuentes_recursos_id"));
                   m.setZonaAlumno(rs.getString("zona_alumno"));
                   m.setCondicionAnterior(rs.getInt("condicion_anio_anterior_id"));
                }
            }
        }catch(SQLException sqlException){
            
        }catch(NullPointerException nullPointerException){
        }
        catch(Exception exception){
        }
        return m;
    }
    
    public Boolean insertMatricula(Matricula m) throws SQLException{
        ArrayList<String> all = new ArrayList<String>();
        Connection miConexion;
        miConexion=ConexionBD.GetConnection();
        boolean x=false;
        if(miConexion!=null)
        {   String cadena = this.insertMatricula
                +m.getEstudiante().getId()+","
                +m.getCurso()+","
                +m.getVictimaConflicto()+","
                +m.getDepartamentoExpulsor()+","
                +m.getMunicipioExpulsor()+","
                +m.getProvieneSectorPrivado()+","
                +m.getProvienteOtroMunicipio()+","
                +m.getTipoDiscapacidad()+","
                +m.getCapacidadExcepcional()+","
                +m.getInstutionFamiliar()+","
                +m.getSubsidiado()+","
                +m.getRepitente()+","
                +m.getNuevo()+","
                +m.getBeneficiarioCabezaFamilia()+","
                +m.getBeneficiarioMadreFamilia()+","
                +m.getBeneficiarioVeteranoFuerzas()+","
                +m.getBeneficiarioHeroeNacional()+","
                +m.getCaracter()+","
                +m.getEspecialidad()+","
                +m.getMetodologia()+","
                +m.getSituacionAnterior()+","
                +m.getFuenteRecursos()+",'"
                +m.getZonaAlumno()+"',"
                +m.getCondicionAnterior()+")";
            System.out.println("cadena-insert:"+cadena);
            Statement st = miConexion.createStatement();
            x =st.execute(cadena);
            
            st.close();
        }
        return x;
    }
    
    
    
}
