/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.AnioDAOImpl;
import Code.DAO.AuxiliaresDAOImpl;
import Code.DAO.CursoDAOImpl;
import Code.DAO.EstudianteDAOImpl;
import Code.DAO.GradoDAOImpl;
import Code.DAO.InstitucionEducativaDAOImpl;
import Code.DAO.JornadaDAOImpl;
import Code.DAO.MatriculaDAOImpl;
import Code.DAO.PersonaDAOImpl;
import Code.DAO.SedeDAOImpl;
import Code.Domain.Anio;
import Code.Domain.Curso;
import Code.Domain.Etnia;
import Code.Domain.Grado;
import Code.Domain.InstitucionEducativa;
import Code.Domain.Jornada;
import Code.Domain.Matricula;
import Code.Domain.Municipio;
import Code.Domain.Persona;
import Code.Domain.Resguardo;
import Code.Domain.Sede;
import Code.Domain.TipoDocumento;
import Code.Domain.TipoJornada;
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
    AnioDAOImpl anioDAO;
    JornadaDAOImpl jornadaDAO;
    GradoDAOImpl gradoDAO;
    CursoDAOImpl cursoDAOImpl;
    EstudianteDAOImpl estudiateDAOImpl;
    MatriculaDAOImpl matriculaDAOImpl;

    public MatriculaBusiness() {
        this.estudianteDAO = new EstudianteDAOImpl();
        this.matriculaDAO = new MatriculaDAOImpl();
        this.auxiliaresDAO = new AuxiliaresDAOImpl();
        this.instuticionDAO = new InstitucionEducativaDAOImpl();
        this.sedeDAO = new SedeDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
        this.anioDAO = new AnioDAOImpl();
        this.jornadaDAO = new JornadaDAOImpl();
        this.gradoDAO = new GradoDAOImpl();
        this.estudiateDAOImpl = new EstudianteDAOImpl();
        this.matriculaDAOImpl = new MatriculaDAOImpl();
        this.cursoDAOImpl = new CursoDAOImpl();
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
        Map<Long,Sede> guardarSedes = new HashMap<Long,Sede>();
        Map<String,Anio> anios = null;
        Map<String,Anio> guardarAnios = new HashMap<String,Anio>();
        Map<Integer,Jornada> jornadas = null;
        Map<String,Jornada> guardarJornadas = new HashMap<String,Jornada>();
        Map<String, InstitucionEducativa> guardarColegios = new HashMap<String, InstitucionEducativa>();
        Map<Integer, TipoDocumento> tiposDocumentos = null;
        Map<String, Persona> personas = null;
        Map<String, Persona> guardarPersonas = new HashMap<String, Persona>();
        Map<Integer, Etnia> etnias = null;
        Map<Integer, Resguardo> resguardos = null;
        ArrayList<TipoJornada> tiposJornadas = new ArrayList<TipoJornada>();
        tiposJornadas.add(new TipoJornada(1,"Completa"));
        tiposJornadas.add(new TipoJornada(2,"Mañana"));
        tiposJornadas.add(new TipoJornada(3,"Tarde"));
        tiposJornadas.add(new TipoJornada(4,"Nocturna"));
        tiposJornadas.add(new TipoJornada(5,"Fin de Semana"));
        Map<Integer,String> grado = new HashMap<Integer,String>();
        Map<String, Grado> gradosBD = null;
        Map<String, Grado> guardarGrados = new HashMap<String, Grado>();
        Map<String, Curso> cursos = null;
        Map<String, Curso> guardarCursos = new HashMap<String, Curso>();
        grado.put(-2, "Pre-Jardin");
        grado.put(-1, "Jardín I o A o Kinder");
        grado.put(0, "Jardín II o B, Transición o Grado 0");
        grado.put(1, "Primero");
        grado.put(2, "Segundo");
        grado.put(3, "Tercero");
        grado.put(4, "Cuarto");
        grado.put(5, "Quinto");
        grado.put(6, "Sexto");
        grado.put(7, "Septimo");
        grado.put(8, "Octavo");
        grado.put(9, "Noveno");
        grado.put(10, "Decimo");
        grado.put(11, "Once");
        grado.put(12, "Doce - Normal Superior");
        grado.put(13, "Trece - Normal Superior");
        grado.put(14, "Educación discapacidad cognitiva no integrada");
        grado.put(15, "Educación discapacidad auditiva no integrada");
        grado.put(16, "Educación discapacidad visual no integrada");
        grado.put(17, "Educación discapacidad motora no integrada");
        grado.put(18, "Educación discapacidad múltiple no integrada");
        grado.put(21, "Ciclo 1 Adultos");
        grado.put(22, "Ciclo 2 Adultos");
        grado.put(23, "Ciclo 3 Adultos");
        grado.put(24, "Ciclo 4 Adultos");
        grado.put(25, "Ciclo 5 Adultos");
        grado.put(26, "Ciclo 6 Adultos");
        grado.put(99, "Aceleración del Aprendizaje");
        
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
        /*System.out.println("1");
        for(int i=0;i<lineas.size();i++){
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDepartamento="";
            try{
                codigoDepartamento = codigoDANE.substring(1,6);
            }catch(Exception e){
                codigoDepartamento = "54";
            }
            InstitucionEducativa exIE = colegios.get(codigoDANE);
            if(exIE == null){
                exIE = guardarColegios.get(codigoDANE);
                if(exIE == null){
                    InstitucionEducativa c = new InstitucionEducativa();
                    c.setCodigoDANEActual(codigoDANE);
                    c.setCodigoDANEAnterior(campos[6]);
                    c.setNombre(campos[1]);
                    Integer codigoMunicipio = Integer.parseInt(codigoDepartamento);
                    Municipio m = municipios.get(String.valueOf(codigoMunicipio));
                    c.setMunicipio(m);
                    guardarColegios.put(codigoDANE, c);
                }
            }
        }
        if(!guardarColegios.isEmpty()){
            this.instuticionDAO.guardarMapColegio(guardarColegios);
            colegios = this.instuticionDAO.selectMapAllColegio();
            System.out.println("Esta vacio colegio");
        }
        
        try {
            municipios = this.auxiliaresDAO.getMapMunicipios();
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("2");
        for(int i=0;i<lineas.size();i++){
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDepartamento = codigoDANE.substring(1,6).replaceAll("-", "");
            Long c = 0L;
            try{
                if(consecutivo.equalsIgnoreCase("")){
                    
                    consecutivo = codigoDANE+"99";
                    System.out.println("1 if");
                }
                else if(consecutivo.length()<4){
                    consecutivo = codigoDANE+""+consecutivo;
                    System.out.println("2 if: "+codigoDANE +" "+ consecutivo);
                }
                c = Long.parseLong(consecutivo);
            }catch(Exception e){
                System.out.println("error en esta:-----"+linea);
            }
            
            Sede exSede = sedes.get(c);
            if(exSede == null){
                exSede = guardarSedes.get(c);
                if(exSede == null){
                    Sede s = new Sede();
                    s.setNombre(campos[2]);
                    String codigoDANEColegio = campos[5].trim().replaceAll(" ", "");
                    if(consecutivo.equalsIgnoreCase("")){
                        consecutivo = codigoDANEColegio+"99";
                    }
                    s.setConsecutivo(Long.parseLong(consecutivo));
                    InstitucionEducativa ie = colegios.get(codigoDANEColegio);
                    Municipio m = municipios.get(String.valueOf(codigoDepartamento));
                    s.setColegio(ie.getId());
                    s.setMunicipio(m);
                    guardarSedes.put(s.getConsecutivo(), s);
                }
            }
        }
        if(!guardarSedes.isEmpty()){
            this.sedeDAO.guardarMapSede(guardarSedes);
            sedes = this.sedeDAO.getMapTodasLasSedes();
            System.out.println("Estan las sedes vacias");
        }*/
        /*
        System.out.println("3");
        for(int i=0;i<lineas.size();i++){
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            if(consecutivo.equalsIgnoreCase("")){
                consecutivo = codigoDANE+"99";
            }
            Long c = Long.parseLong(consecutivo);
            Sede exSede = sedes.get(c);
            if(exSede != null){
                anios = this.anioDAO.getMapAniosPorSedes(exSede.getId());
                try{
                    String numeroAnio = campos[3].trim().replaceAll("[^0-9]", "").replaceAll(" ", "");
                    Anio anioEencontrado = anios.get(numeroAnio+"-"+exSede.getId());
                    if(anioEencontrado == null){
                        Anio anioGuardado = guardarAnios.get(numeroAnio+"-"+exSede.getId());
                        if(anioGuardado == null){
                            Anio newAnio = new Anio();
                            newAnio.setDescripcion("Año creado en el cargue de matricula");
                            newAnio.setAnio(Integer.parseInt(numeroAnio));
                            newAnio.setSede(exSede);
                            guardarAnios.put(numeroAnio+"-"+exSede.getId(), newAnio);
                        }
                    }
                }catch(NumberFormatException ex){
                }
            }
        }
        
        if(!guardarAnios.isEmpty()){
            this.anioDAO.guardarMapAnio(guardarAnios);
        }
        
        System.out.println("4");
        for(int i=0;i<lineas.size();i++){
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            if(consecutivo.equalsIgnoreCase("")){
                consecutivo = codigoDANE+"99";
            }
            Long c = Long.parseLong(consecutivo);
            Sede exSede = sedes.get(c);
            if(exSede != null){   
                anios = this.anioDAO.getMapAniosPorSedes(exSede.getId());
                try{
                    Integer numeroAnio = Integer.parseInt(campos[3].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                    Anio anioEencontrado = anios.get(numeroAnio+"-"+exSede.getId());
                    if(anioEencontrado != null){
                        try{
                            Integer tipoJornadaCampo = Integer.parseInt(campos[36].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                            TipoJornada actualTipoJornada = tiposJornadas.get(tipoJornadaCampo-1);
                            jornadas = this.jornadaDAO.selectAllMapJornadaPorAnioTipo(anioEencontrado.getId(), tipoJornadaCampo);
                            if(jornadas.isEmpty()){
                                if(guardarJornadas.get(anioEencontrado.getId()+""+tipoJornadaCampo) == null){
                                    Jornada newJornada = new Jornada();
                                    newJornada.setAnio(anioEencontrado);
                                    newJornada.setTipoJornada(actualTipoJornada);
                                    newJornada.setNombre("Jornada "+actualTipoJornada.getNombre()+" 1");
                                    guardarJornadas.put(anioEencontrado.getId()+""+tipoJornadaCampo, newJornada);
                                }
                            }
                        }catch(NumberFormatException ex){
                        }
                    }
                }catch(NumberFormatException ex){
                }
            }
        }
        if(!guardarJornadas.isEmpty()){
            this.jornadaDAO.guardarMapJornada(guardarJornadas);
        }
        System.out.println("5");
        for(int i=0;i<lineas.size();i++){ 
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            if(consecutivo.equalsIgnoreCase("")){
                consecutivo = codigoDANE+"99";
            }
            Long c = Long.parseLong(consecutivo);
            Sede exSede = sedes.get(c);
            if(exSede != null){
                anios = this.anioDAO.getMapAniosPorSedes(exSede.getId());
                try{
                    Integer numeroAnio = Integer.parseInt(campos[3].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                    Anio anioEencontrado = anios.get(numeroAnio+"-"+exSede.getId());
                    if(anioEencontrado != null){
                        try{
                            Integer tipoJornadaCampo = Integer.parseInt(campos[36].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                            if(tipoJornadaCampo==0){
                                tipoJornadaCampo=1;
                            }
                            TipoJornada actualTipoJornada = tiposJornadas.get(tipoJornadaCampo-1);
                            jornadas = this.jornadaDAO.selectAllMapJornadaPorAnioTipo(anioEencontrado.getId(), tipoJornadaCampo);
                            if(!jornadas.isEmpty()){
                                Jornada jornadaActual = null;
                                for(Map.Entry<Integer,Jornada> entry : jornadas.entrySet()){
                                    jornadaActual= entry.getValue();
                                    break;
                                }
                                
                                String campoGrado = campos[39].trim().replaceAll(" ", "");
                                gradosBD = this.gradoDAO.selectMapAllGradosPorJornada(jornadaActual.getId());
                                Grado actual = gradosBD.get(jornadaActual.getId()+"-"+campoGrado);
                                if(actual==null){
                                    actual = guardarGrados.get(campoGrado);
                                    if(actual == null){
                                        Grado newGrado = new Grado();
                                        newGrado.setCodigo(campoGrado);
                                        newGrado.setNombre(grado.get(Integer.parseInt(campoGrado)));
                                        newGrado.setJornadaId(jornadaActual.getId());
                                        guardarGrados.put(jornadaActual.getId()+"-"+campoGrado, newGrado);
                                    }
                                }
                            }
                        }catch(NumberFormatException ex){
                        }
                    }
                }catch(NumberFormatException ex){
                }
            }
        }
        
        if(!guardarGrados.isEmpty()){
            this.gradoDAO.guardarMapGrados(guardarGrados);
        }
        
        //guardar curso
        System.out.println("6");
        for(int i=0;i<lineas.size();i++){
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String consecutivo = campos[7].trim().replaceAll(" ", "").replaceAll("-", "");
            String codigoDANE = campos[5].trim().replaceAll(" ", "").replaceAll("-", "");
            if(consecutivo.equalsIgnoreCase("")){
                consecutivo = codigoDANE+"99";
            }
            Long c = Long.parseLong(consecutivo);
            Sede exSede = sedes.get(c);
            if(exSede != null){
                anios = this.anioDAO.getMapAniosPorSedes(exSede.getId());
                try{
                    Integer numeroAnio = Integer.parseInt(campos[3].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                    Anio anioEencontrado = anios.get(numeroAnio+"-"+exSede.getId());
                    if(anioEencontrado != null){
                        try{
                            Integer tipoJornadaCampo = Integer.parseInt(campos[36].trim().replaceAll("[^0-9]", "").replaceAll(" ", ""));
                            if(tipoJornadaCampo==0){
                                tipoJornadaCampo=1;
                            }
                            //(TipoJornada actualTipoJornada = tiposJornadas.get(tipoJornadaCampo-1);
                            jornadas = this.jornadaDAO.selectAllMapJornadaPorAnioTipo(anioEencontrado.getId(), tipoJornadaCampo);
                            if(!jornadas.isEmpty()){
                                Jornada jornadaActual = jornadas.get(0);
                                for (Map.Entry<Integer,Jornada> entry : jornadas.entrySet()){
                                    jornadaActual = entry.getValue();
                                    break;
                                }
                                if(jornadaActual != null){
                                    String campoGrado = campos[39].trim().replaceAll(" ", "");
                                    gradosBD = this.gradoDAO.selectMapAllGradosPorJornada(jornadaActual.getId());
                                    Grado actual = gradosBD.get(campoGrado);
                                    if(actual !=null){
                                        cursos = this.cursoDAOImpl.selectMAPAllCursosPorGrado(actual.getId());
                                        String campoCurso = campos[40].trim().replaceAll(" ", "");
                                        Curso cursoActual = cursos.get(actual.getId()+"-"+campoCurso);
                                        if(cursoActual == null){
                                            cursoActual = guardarCursos.get(campoCurso);
                                            if(cursoActual == null){
                                                Curso newCurso = new Curso();
                                                newCurso.setNombre(campoCurso);
                                                newCurso.setGrado(actual);
                                                guardarCursos.put(actual.getId()+"-"+campoCurso, newCurso);
                                            }
                                        }
                                    }
                                }
                                
                            }
                        }catch(NumberFormatException ex){
                        }
                    }
                }catch(NumberFormatException ex){
                }
            }
        }
        
        if(!guardarCursos.isEmpty()){
            System.out.println("entro a guardar cursos");
            this.cursoDAOImpl.guardarMapCursos(guardarCursos);
        }else{
            System.out.println("no guardo ningun curso");
        }
        System.out.println("7");
        int x=0;
        for(int i=0;i<lineas.size();i++){ 
            x++;
            System.out.println(i);
            String linea = lineas.get(i);
            String[] campos = linea.split(";");
            String campoTipoDocumento = campos[8].trim().replaceAll(" ","").replaceAll("-", "");
            if(campoTipoDocumento.equalsIgnoreCase("")){
                campoTipoDocumento = "2"; 
            }
            TipoDocumento t = null;
            try{
                t = tiposDocumentos.get(Integer.parseInt(campoTipoDocumento));
            }catch(Exception e){
                t = null;
            }
            
            if(t==null){
                t = new TipoDocumento();
                t.setId(2);
            }
            String campoNumeroDocumento = campos[9].trim().replaceAll(" ","").replaceAll("-", "");
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
                        if(campoEstrato.equalsIgnoreCase("")|| campoEstrato.length()>1){
                            campoEstrato = "0";
                        }
                        try{
                            p.setEstrato(Integer.parseInt(campoEstrato));
                        }catch(Exception e){
                            p.setEstrato(0);
                        }
                        
                        String campoSisben = campos[21].trim();
                        if(campoSisben.equalsIgnoreCase("")|| campoSisben.length()>1){
                            campoSisben = "0";
                        }
                        
                        try{
                            p.setSisben(Integer.parseInt(campoSisben));
                        }catch(Exception e){
                            p.setSisben(0);
                        }
                        
                        try {
                            String campoFecha = campos[22].trim();
                            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = format.parse(campoFecha);
                            p.setFechaNacimiento(date);
                        } catch(java.text.ParseException ex) {
                            System.out.println("error en la fecha linea: "+i);
                            try {
                                String campoFecha = campos[22].trim();
                                DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                                Date date = format.parse(campoFecha);
                                p.setFechaNacimiento(date);
                            } catch(java.text.ParseException e) {
                                System.out.println("error en la fecha linea: "+i);
                                p.setFechaNacimiento(new Date());
                            }
                        }
                        Municipio mNacimiento = municipios.get(campos[23].trim().replace(" ", "")+""+campos[24].trim().replace(" ", ""));
                        if(mNacimiento != null){
                            p.setMunicipioNacimiento(mNacimiento.getId());
                        }
                        String gen = "";
                        try{
                            gen = campos[25].trim().replace(" ", "");
                        }catch(Exception e){
                            gen = "M";
                        }
                        if(gen.length()>1){
                            gen ="M";
                        }
                        p.setGenero(gen);
                        String campoEtnia="";
                        try{
                            campoEtnia = campos[33].trim().replace(" ", "");
                        }catch(Exception e){
                            campoEtnia="";
                        }
                        
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
                        
                        String campoResguardo = "";
                        try{
                            campoResguardo = campos[34].trim().replace(" ", "");
                        }catch(Exception ex){
                            campoResguardo = "";
                        }
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
            
            if(x==1000){
                if(!guardarPersonas.isEmpty()){
                    this.personaDAO.guardarMapPersonas(guardarPersonas);
                    guardarPersonas = null;
                    guardarPersonas = new HashMap<String, Persona>();
                    personas = this.personaDAO.getMapPersonas();
                }
                x=0;
            }
        }
        if(!guardarPersonas.isEmpty()){
            this.personaDAO.guardarMapPersonas(guardarPersonas);
            guardarPersonas = null;
            guardarPersonas = new HashMap<String, Persona>();
        }
        this.estudiateDAOImpl.guardarEstudianteDePersonas();
        */
        this.matriculaDAOImpl.cargueMatriculaTemporal(lineas);
        
        /*personas = this.personaDAO.getMapPersonas();
        
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
                if(p != null){
                    String consecutivo = campos[7].trim().replaceAll(" ", "");
                    Sede exSede = sedes.get(consecutivo);
                    
                    
                }
            }else{
                System.out.println("linea "+i+" no tiene numero de documento");
            }
        }*/
        
        
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
