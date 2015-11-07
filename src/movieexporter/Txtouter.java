/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Casey
 */
class Txtouter extends DataWriter {

    @Override
    void outFile(HashMap<String, String> movieDetails) {
        try{
            FileWriter writer = new FileWriter("Movie Aggregator.txt", true);
            
            Iterator<String> keyIter = movieDetails.keySet().iterator();
            
            String key;
            
            while(keyIter.hasNext()){
                key= keyIter.next();
                writer.write(key+movieDetails.get(key));
            }
            
            writer.close();
        }
        catch(IOException ex){
            System.out.println("Unexpected error occured : "+ex);
        }
        
        
    }
    
}
