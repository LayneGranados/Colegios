
package Code.Business;

import Code.Util.UtilidadesArchivo;
import java.util.ArrayList;

import Code.Domain.CertificacionOldstyle;

/**
 *
 * @author felix.orduz
 */
public class CertificacionBusiness {
    
    public void procesarArchivoCertificaciones(String file){
        
        ArrayList<String> lista = UtilidadesArchivo.leerLineasArchivo(file);
        lista.stream().forEach((item) -> {
            String anio="", colegio="",sede="";
            String[] fields = item.split(";");
            System.out.println("Este es un campo -> " + fields[0]);
            switch (fields[0]){
                case "1":
                   anio = fields[1];
                   colegio = fields[2];
                   sede = fields[3];
                break;
                case "2":
                    CertificacionOldstyle co = new CertificacionOldstyle();
                    co.setSede(sede);
                    co.setGrado(fields[1]);
                    co.setCurso(fields[2]);
                    co.setApellido1(fields[3]);
                    co.setApellido2(fields[4]);
                    co.setNombre1(fields[5]);
                    co.setNombre2(fields[6]);
                    co.setObservaciones(fields[7]);
                    co.setC(fields[7]);
                break;
            }
        });
    
    }
}
