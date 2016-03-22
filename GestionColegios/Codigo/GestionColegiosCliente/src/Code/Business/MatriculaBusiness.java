/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AuxiliaresDAOImpl;
import Code.DAO.EstudianteDAOImpl;
import Code.DAO.InstitucionEducativaDAOImpl;
import Code.DAO.MatriculaDAOImpl;
import Code.DAO.PersonaDAOImpl;
import Code.DAO.SedeDAOImpl;
import Code.Domain.Etnia;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Matricula;
import Code.Domain.Municipio;
import Code.Domain.Persona;
import Code.Domain.Resguardo;
import Code.Domain.Sede;
import Code.Domain.TipoDocumento;
import Code.Util.PDFUtil;
import Code.Util.UtilidadesArchivo;
import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laynegranadosmogollon
 */
public class MatriculaBusiness {
    
    EstudianteDAOImpl estudianteDAO;
    MatriculaDAOImpl matriculaDAO;
    AuxiliaresDAOImpl auxiliaresDAO;
    InstitucionEducativaDAOImpl instuticionDAO;
    SedeDAOImpl sedeDAO;
    PersonaDAOImpl personaDAO;

    public MatriculaBusiness() {
        this.estudianteDAO = new EstudianteDAOImpl();
        this.matriculaDAO = new MatriculaDAOImpl();
        this.auxiliaresDAO = new AuxiliaresDAOImpl();
        this.instuticionDAO = new InstitucionEducativaDAOImpl();
        this.sedeDAO = new SedeDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public EstudianteDAOImpl getEstudianteDAO() {
        return estudianteDAO;
    }

    public void setEstudianteDAO(EstudianteDAOImpl estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }
    
    public void procesarArchivoMatricula(String file){

        ArrayList<String> lineas = UtilidadesArchivo.leerLineasArchivo(file);
        Map<String, Municipio> municipios = null;
        Map<String, InstitucionEducativa> colegios = null;
        Map<Long,Sede> sedes = null;
        Map<String, InstitucionEducativa> guardarColegios = new HashMap<String, InstitucionEducativa>();
        Map<Long,Sede> guardarSedes = new HashMap<Long,Sede>();
        Map<Integer, TipoDocumento> tiposDocumentos = null;
        Map<String, Persona> personas = null;
        Map<String, Persona> guardarPersonas = new HashMap<String, Persona>();
        Map<Integer, Etnia> etnias = null;
        Map<Integer, Resguardo> resguardos = null;
        
        try {
            municipios = this.auxiliaresDAO.getMapMunicipios();
            colegios = this.instuticionDAO.selectMapAllColegio();
            sedes = this.sedeDAO.getMapTodasLasSedes();
            tiposDocumentos = this.auxiliaresDAO.getMapAllTipoDocumento();
            personas = this.personaDAO.getMapPersonas();
            etnias = this.auxiliaresDAO.getMapEtnia();
            resguardos = this.auxiliaresDAO.getMapAllResguardo();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<lineas.size();i++){
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            System.out.println(lineas.get(i));
            String codigoDANE = campos[5].trim().replaceAll(" ", "");
            InstitucionEducativa exIE = colegios.get(codigoDANE);
            if(exIE == null){
                exIE = guardarColegios.get(codigoDANE);
                if(exIE == null){
                    InstitucionEducativa c = new InstitucionEducativa();
                    c.setCodigoDANEActual(codigoDANE);
                    c.setCodigoDANEAnterior(campos[6]);
                    c.setNombre(campos[1]);
                    Integer codigoMunicipio = Integer.parseInt(campos[4].trim().replaceAll(" ", ""));
                    Municipio m = municipios.get(String.valueOf(codigoMunicipio));
                    c.setMunicipio(m);
                    guardarColegios.put(codigoDANE, c);
                }
            }
        }
        this.instuticionDAO.guardarMapColegio(guardarColegios);
        try {
            municipios = this.auxiliaresDAO.getMapMunicipios();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<lineas.size();i++){ 
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "");
            Sede exSede = sedes.get(consecutivo);
            if(exSede == null){
                exSede = guardarSedes.get(consecutivo);
                if(exSede == null){
                    System.out.println("linea: "+i);
                    Sede s = new Sede();
                    s.setNombre(campos[2]);
                    String codigoDANEColegio = campos[5].trim().replaceAll(" ", "");
                    if(consecutivo.equalsIgnoreCase("")){
                        consecutivo = codigoDANEColegio+"99";
                    }
                    s.setConsecutivo(Long.parseLong(consecutivo));
                    InstitucionEducativa ie = colegios.get(codigoDANEColegio);
                    s.setColegio(ie.getId());
                    guardarSedes.put(s.getConsecutivo(), s);
                }
            }
        }
        this.sedeDAO.guardarMapSede(guardarSedes);
        sedes = this.sedeDAO.getMapTodasLasSedes();
        
        for(int i=0;i<lineas.size();i++){ 
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String campoTipoDocumento = campos[8].trim().replaceAll(" ","");
            if(campoTipoDocumento.equalsIgnoreCase("")){
                campoTipoDocumento = "2"; 
            }
            TipoDocumento t = tiposDocumentos.get(Integer.parseInt(campoTipoDocumento));
            String campoNumeroDocumento = campos[9].trim().replaceAll(" ","");
            if(!campoNumeroDocumento.equalsIgnoreCase("")){
                Persona p = personas.get(t.getId()+""+campoNumeroDocumento);
                if(p == null){
                    p = guardarPersonas.get(t.getId()+""+campoNumeroDocumento);
                    if(p == null){
                        p = new Persona();
                        p.setTipoPersona("E");
                        p.setTipoDocumento(t);
                        p.setDocumento(campoNumeroDocumento);
                        Municipio mExpedicion = municipios.get(campos[10].trim().replace(" ", "")+""+campos[11].trim().replace(" ", ""));
                        if(mExpedicion != null){
                            p.setMunicipioExpedicion(mExpedicion.getId());
                        }
                        p.setApellido1(campos[12].trim().replaceAll(" ", ""));
                        p.setApellido2(campos[13].trim().replaceAll(" ", ""));
                        p.setNombre1(campos[14].trim().replaceAll(" ", ""));
                        p.setNombre2(campos[15].trim().replaceAll(" ", ""));
                        p.setDireccionResidencia(campos[16].trim());
                        p.setTelefonoResidencia(campos[17].trim());
                        Municipio mResidencia = municipios.get(campos[18].trim().replace(" ", "")+""+campos[19].trim().replace(" ", ""));
                        if(mResidencia != null){
                            p.setMunicipioResidencia(mResidencia.getId());
                        }
                        String campoEstrato = campos[20].trim();
                        if(campoEstrato.equalsIgnoreCase("")){
                            campoEstrato = "-1";
                        }
                        p.setEstrato(Integer.parseInt(campoEstrato));
                        String campoSisben = campos[21].trim();
                        if(campoSisben.equalsIgnoreCase("")){
                            campoSisben = "-1";
                        }
                        p.setSisben(Integer.parseInt(campoSisben));
                        
                        try {
                            String campoFecha = campos[22].trim();
                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = format.parse(campoFecha);
                            p.setFechaNacimiento(date);
                        } catch(java.text.ParseException ex) {
                            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
                            p.setFechaNacimiento(new Date());
                        }
                        
                        Municipio mNacimiento = municipios.get(campos[23].trim().replace(" ", "")+""+campos[24].trim().replace(" ", ""));
                        if(mNacimiento != null){
                            p.setMunicipioNacimiento(mNacimiento.getId());
                        }
                        p.setGenero(campos[25].trim().replace(" ", ""));
                        String campoEtnia = campos[33].trim().replace(" ", "");
                        Integer numeroEtnia = -1;
                        if(campoEtnia.isEmpty() || campoEtnia.equalsIgnoreCase("0")  || 
                                campoEtnia.equalsIgnoreCase("00") || campoEtnia.equalsIgnoreCase("000")){
                            campoEtnia = "-1";
                            try{
                                numeroEtnia = Integer.parseInt(campoEtnia);
                            }catch(NumberFormatException ex){
                                numeroEtnia = -1;
                            }
                        }
                        
                        Etnia e = etnias.get(numeroEtnia);
                        
                        String campoResguardo = campos[34].trim().replace(" ", "");
                        Integer numeroResguardo = -1;
                        if(campoResguardo.isEmpty() || campoResguardo.equalsIgnoreCase("0")  || 
                                campoResguardo.equalsIgnoreCase("00") || campoResguardo.equalsIgnoreCase("000")){
                            campoResguardo = "-1";
                            try{
                                numeroResguardo = Integer.parseInt(campoResguardo);
                            }catch(NumberFormatException ex){
                                numeroResguardo = -1;
                            } 
                        }
                        Resguardo r = resguardos.get(numeroResguardo);
                        p.setResguardo(r);
                        p.setEtnia(e);
                        guardarPersonas.put(t.getId()+""+campoNumeroDocumento, p);
                    }
                }
            }else{
                System.out.println("linea "+i+" no tiene numero de documento");
            }
        }
        this.personaDAO.guardarMapPersonas(guardarPersonas);
    }
    
    public boolean guardarMatricula(Matricula m){
        boolean rs = false;
        try {
            rs = this.matriculaDAO.insertMatricula(m);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public Matricula getMatriculaEstudianteCurso(int estudianteId, int cursoId){
        Matricula m = new Matricula();
        m = this.matriculaDAO.getMatriculaPorEstudianteCurso(estudianteId, cursoId);
        return m;
    }
    
    public boolean buscarEstudianteMatriculadoEnCurso(int idEstudiante, int idCurso){
        return this.matriculaDAO.buscarEstudianteMatriculadoEnCurso(idEstudiante, idCurso);
    }
    
    public ArrayList<Matricula> getEstudiantesMatriculadoEnCurso(int idCurso){
        return this.matriculaDAO.getEstudiantesMatriculadoEnCurso(idCurso);
    }
    
    
    
}
