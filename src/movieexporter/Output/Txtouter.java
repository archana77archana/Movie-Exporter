/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casey
 */
class Txtouter extends DataWriter {
    
    private HashMap<String,String> movieDetails=null;
    private String fileName=null;
    
    
    void printDetails(){
        System.out.println(" Output details in Text format");
    }
    
    private FileWriter createTxt(){
        File f = new File(fileName);
        if(f.exists()){
            f.delete();
        }
        try {
            FileWriter writer = new FileWriter(f,false);
            return writer;
        } catch (IOException ex) {
            System.out.println("Unexpected error occured : " + ex);
        }
        return null;
    }
    
    private void addDetails(FileWriter writer){
        Iterator<String> keyIter = movieDetails.keySet().iterator();
        String key;
        
        try{
            writer.write("Movie Details");
            writer.append(System.lineSeparator());
            
            while(keyIter.hasNext()){
                    key= keyIter.next();
                    writer.append(System.lineSeparator());
                    writer.write(key+movieDetails.get(key));
            }
            writer.close();
        }catch(IOException ex){
            System.out.println("Unexpected error occured : "+ex);
        }     
    }
    
    
    @Override
    void outFile(HashMap<String, String> movieDetailsArg) {
        movieDetails = movieDetailsArg;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter output filename : ");
        fileName = in.nextLine();
        
        if(fileName.isEmpty()){
            fileName = "Movie Aggregator";
        }
        
        FileWriter writer = createTxt();
        if(writer != null){
            addDetails(writer);
        }
    }
}