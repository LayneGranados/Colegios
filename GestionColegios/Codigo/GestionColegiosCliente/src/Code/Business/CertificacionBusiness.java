
package Code.Business;

import Code.DAO.CertificacionDAOImpl;
import Code.DAO.DetalleCertificacionDAOImpl;
import Code.Util.UtilidadesArchivo;
import java.util.ArrayList;

import Code.Domain.CertificacionOldstyle;
import Code.Domain.DetalleCertificadoOld;
import Code.Util.PDFUtil;

/**
 *
 * @author felix.orduz
 */
public class CertificacionBusiness {
    
    CertificacionDAOImpl certificacionDAO;
    
    DetalleCertificacionDAOImpl detalleCertificacionDAO;

    public CertificacionBusiness() {
        this.certificacionDAO = new CertificacionDAOImpl();
        
        this.detalleCertificacionDAO = new DetalleCertificacionDAOImpl();
    }
    
    public void procesarArchivoCertificaciones(String file){
        CertificacionDAOImpl cerDao = new CertificacionDAOImpl();
        DetalleCertificacionDAOImpl dcdaoi = new DetalleCertificacionDAOImpl();
        ArrayList<String> lista = UtilidadesArchivo.leerLineasArchivo(file);
        String anio="", colegio="",sede="";
        for (String item: lista) {
            String[] fields = item.split(";");
            switch (fields[0]){
                case "1":

                   anio = fields[1];
                   colegio = fields[2];
                   sede = fields[3];
                break;
                case "2":
                    CertificacionOldstyle co = new CertificacionOldstyle();
                    co.setAnnio(anio);
                    co.setSede(sede);
                    co.setGrado(fields[1]);
                    co.setCurso(fields[2]);
                    co.setApellido1(fields[3]);
                    co.setApellido2(fields[4]);
                    co.setNombre1(fields[5]);
                    co.setNombre2(fields[6]);
                    co.setObservaciones(fields[7]);
                    co.setComportamiento(fields[8]);
                    try{
                        co.setFallas(Integer.parseInt(fields[9]));
                    }catch(Exception e){
                        co.setFallas(0);
                    }
                    cerDao.guardarCertificacion(co);
                    System.out.println("Prueba: "+co.getCer_old_id());
                    
                    for(int i = 10 ; i<fields.length; i=i+2 ){
                        DetalleCertificadoOld dco = new DetalleCertificadoOld();
                        dco.setCer_old_id(co.getCer_old_id());
                        try{
                            dco.setNombre_detalle(fields[i]);
                            dco.setValor_detalle(fields[i+1]);
                        }catch(Exception ex){
                            System.out.println("Error:"+i);
                            dco.setNombre_detalle("");
                            dco.setValor_detalle("");
                        }
                        dcdaoi.guardarCertificacion(dco);
                    }
                break;
            }
        };
    
    }
    
    public ArrayList<CertificacionOldstyle> buscarCertificacionesAntiguas(CertificacionOldstyle c){
        return this.certificacionDAO.buscarCertificacionesAntiguas(c);
    }
    
    public void generarPDFCertificacionOLD(String rutaArchivo, String contenidoArchivo){
        PDFUtil.generatePDF(rutaArchivo, contenidoArchivo);
    }
    
    public ArrayList<DetalleCertificadoOld> getDetalleCertificadoOLD(int id){
        return this.detalleCertificacionDAO.getDetalleCertificadoOLD(id);
        
    }
}
