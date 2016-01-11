/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code.Util;
import java.io.FileOutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker; // deprecated
import com.itextpdf.text.pdf.PdfWriter;


/**
 *
 * @author laynegranadosmogollon
 */
public class PDFUtil {
    
    public static void generatePDF(String rutaArchivo, String contenidoArchivo){
        
        try {
      Document document = new Document(PageSize.LETTER);
      PdfWriter.getInstance(document, new FileOutputStream("/Users/laygrana/Documents/Layne/Proyectos/Git/Colegios/archivo.pdf"));
      document.open();
      document.addAuthor("GestionColegios");
      document.addCreator("");
      document.addSubject("");
      document.addCreationDate();
      document.addTitle("");

      HTMLWorker htmlWorker = new HTMLWorker(document);
      String str = "<html><head></head><body>"+
        "<p>" +contenidoArchivo+"</p>"+
        "<P><br><table border='1'><tr><td>Java HowTo<tr>" +
        "<td bgcolor='red'>Javascript HowTo<tr><td>Powerbuilder HowTo</table>" +
        "</body></html>";
        htmlWorker.parse(new StringReader(str));
        document.close();
      }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
    
  
} 
    

