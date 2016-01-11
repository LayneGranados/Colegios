
package Code.Domain;

import java.util.ArrayList;

/**
 *
 * @author Felix.Orduz
 */
public class CertificacionOldstyle {
    private int cer_old_id;
    private String annio;
    private String sede;
    private String grado;
    private String curso;
    private String apellido1;
    private String apellido2;
    private String nombre1;
    private String nombre2;
    private String observaciones;
    private String comportamiento;
    private int fallas;
    private ArrayList<DetalleCertificadoOld> detalle;

    public CertificacionOldstyle() {
    }
    
    
    
    public int getCer_old_id() {
        return cer_old_id;
    }

    public void setCer_old_id(int cer_old_id) {
        this.cer_old_id = cer_old_id;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getFallas() {
        return fallas;
    }

    public void setFallas(int fallas) {
        this.fallas = fallas;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }

    public ArrayList<DetalleCertificadoOld> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<DetalleCertificadoOld> detalle) {
        this.detalle = detalle;
    }
    
    public String getComboAntiguo(){
        return  this.getAnnio()+"-"+
                this.getSede()+"-"+
                this.getGrado()+"-"+
                this.getCurso()+"-"+
                this.getNombre1()+" "+
                this.getNombre2()+" "+
                this.getApellido1()+" "+
                this.getApellido2();
    }
    
    public String textoCertificacionHTML(){
        String html="<html><p>";
        html+=this.getAnnio()+"-"+
                this.getSede()+"-"+
                this.getGrado()+"-"+
                this.getCurso()+"-"+
                this.getNombre1()+" "+
                this.getNombre2()+" "+
                this.getApellido1()+" "+
                this.getApellido2();
        html+="<ul>";
        for(DetalleCertificadoOld d : detalle){
            html+="<li>"+d.getNombre_detalle()+":"+d.getValor_detalle()+"</li>";
        }
        html+="</ul>";
        html+="</p></html>";
        
        String prueba ="<html>\n" +
                        "  <head>\n" +
                        "    <style type=\"text/css\">\n" +
                        "      table.db-table 		{ border-right:1px solid #CCCCCC; border-bottom:1px solid #CCCCCC; }\n" +
                        "table.db-table th	{ background:#D8D8D8; padding:5px; border-left:1px solid #CCCCCC; border-top:1px solid #CCCCCC; }\n" +
                        "table.db-table td	{ padding:5px; border-left:1px solid #CCCCCC; border-top:1px solid #CCCCCC; }\n" +
                        "    </style>\n" +
                        "  </head>\n" +
                        "<body>  \n" +
                        "<div style=\"margin: 0 auto;\" >\n" +
                        "  <h4 style=\"margin:0;text-align:center\">Republica de colombia</h4> \n" +
                        "  <h4 style=\"margin:0;text-align:center\">Ministerio de educacion nacional</h4> \n" +
                        "  <h4 style=\"margin:0;text-align:center\">Institucion Educativa San Isidro</h4> \n" +
                        "  <h5 style=\"margin:0;text-align:center\">Carrera 6 # 4-15 - San Luis 300 900 14 30 - San Jose De Cucuta</h5> \n" +
                        "</div>\n" +
                        "<div>\n" +
                        "  <p style=\"text-align:center\">El rector de la institucion educativa san isidro de Cucuta (Norte De Santander) con resolucion de integracion y otras maricadas que deben ir en una tabla</p>\n" +
                        "  <p style=\"text-align:center; font-size:25px;letter-spacing:10px;\">CERTIFICA:</p>\n" +
                        "</div>\n" +
                        "\n" +
                        "<div>\n" +
                        "  <p style=\"text-align:justify\">Que <b>Granados Mogollon Layne Otilia</b>, identificado(a) con TI. 1090410879 curso en esta institucion el grado SEXTO, durante el año lectivo 2013 en la jornada MAÑANA de conformidad con el plan de estudios del PROYECTO EDUCATIVO INSTITUCIONAL <b>REPROBADO</b> </p>\n" +
                        "</div>\n" +
                        "<div style=\"margin: 10px 0;text-align:center; font-size:15px;font-weight:bold;\">REGISTRO FINAL DE VALORACION</div>\n" +
                        "\n" +
                        "<div style=\"margin:0 auto; text-align:center\">\n" +
                        "  <table class=\"db-table\" style=\"margin:10px auto;\">\n" +
                        "    <tr>\n" +
                        "      <th>AREAS/ASIGNATUTAS</th>\n" +
                        "       <th>DEFINITIVA</th>	\n" +
                        "    </tr>\n" +
                        "   	<tr>\n" +
                        "      <td>Matematicas</td>\n" +
                        "       <td>Aprobo</td>	 \n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "      <td>Lenguaje</td>\n" +
                        "       <td>Reprobo</td>	\n" +
                        "    </tr>\n" +
                        "  </table>\n" +
                        "  <p style=\"text-align:left;\">Expedido en San Jose De Cucuta (N. de S.) a los 10 dias de Enero del 2016</p>\n" +
                        "</div>\n" +
                        "  </body></html>";
        
        return prueba;
    }
    
}
