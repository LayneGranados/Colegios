/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Business;

import Code.DAO.ColegioDAOImpl;
import Code.Util.PDFUtil;
import Code.Util.UtilidadesArchivo;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author laynegranadosmogollon
 */
public class ConfiguracionBusiness {
    
    ColegioDAOImpl colegio;

    public ConfiguracionBusiness() {
        colegio = new ColegioDAOImpl();
    }
    
    
    
    public String guardarIP(String ip){
        String msg="";
        try{
            UtilidadesArchivo.escribirNuevaLineaEnArchivo(this.getRutaResources()+"/properties.txt", "IP="+ip);  
            msg=this.getIp();
        }catch(Exception e){
            
        }
        
        PDFUtil pdf = new PDFUtil();
        pdf.create(this.getRutaResources()+"/ejemplo.pdf");
        return msg;
    }
    
    public String getIp(){
        String ip="";
        try{
            String rutaProyecto = System.getProperty("user.dir");
            ArrayList<String> lineas =  UtilidadesArchivo.leerLineasArchivo(rutaProyecto+"/properties.txt");  
            if(!lineas.isEmpty()){
                ip=lineas.get(lineas.size()-1);
                ip = ip.replaceAll("IP=","");
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error");
        }
        return ip;
    }
    
    public void guardarLogo(String rutaCopiar){
        File from = new File(rutaCopiar);
        String[] extensiones = rutaCopiar.split("\\.");
        String extension =  extensiones[extensiones.length-1];
        File to = new File(this.getRutaResources()+"/Logo"+new Date().toString().trim()+"."+extension);
        UtilidadesArchivo.copyFile(from, to);
    }
    
    private String getRutaResources(){
        return System.getProperty("user.dir")+"/rsc-gescol-ownres";
    }
    
    public ArrayList<String> getColegios() throws SQLException{
        return this.colegio.getColegio();
    }
    
    
    
    
}
