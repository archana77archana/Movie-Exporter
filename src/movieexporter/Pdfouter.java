/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author Casey
 */
public class Pdfouter extends DataWriter {
    @Override
    void outFile(HashMap<String, String> movieDetails) {
        
        Iterator<String> keyIter = movieDetails.keySet().iterator();
        
        String key;
        
        try{
            Document doc;
            doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("Movie Aggregator"));
            doc.open();
        
            while(keyIter.hasNext()){
                key= keyIter.next();
                doc.add(new Paragraph(key+movieDetails.get(key)));
            }
            
            doc.close();
        }
        catch (FileNotFoundException|DocumentException ex) {
                System.out.println("Unexpected error occured :"+ ex);
        }
    }
}
