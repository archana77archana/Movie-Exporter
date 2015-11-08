/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

 
import com.itextpdf.text.Chunk;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Scanner;
/**
 *
 * @author Casey
 */
class Pdfouter extends DataWriter {
    
    private Document createPdf(String fileName){
        Document doc;
        doc = new Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            return doc;
        } catch(FileNotFoundException|DocumentException ex){
            System.out.println("Unexpected error occured : "+ex);
        }
        return null;
    } 
    
    private void addDetails(HashMap<String, String> movieDetails,Document doc) {
        
        Iterator<String> keyIter = movieDetails.keySet().iterator();
        
        String key;
        
        try{

            doc.open();
            doc.add(new Paragraph("Movie Aggregator"));
            
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            
            while(keyIter.hasNext()){
                key= keyIter.next();
                doc.add(new Paragraph(key+movieDetails.get(key)));
            }
            
            doc.close();
        }
        catch (DocumentException ex) {
                System.out.println("Unexpected error occured :" + ex);
        }
    }

    @Override
    void outFile(HashMap<String, String> movieDetails){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter output filename : ");
        String fileName = in.nextLine();
        if(fileName.isEmpty()){
            fileName  = "Movie Aggregator";
        }
        Document doc=createPdf(fileName);
        if(doc != null){
            addDetails(movieDetails, doc);
        }
    }
}
    