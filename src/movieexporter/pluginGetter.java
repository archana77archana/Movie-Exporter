/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import static com.itextpdf.text.Annotation.URL;
import static com.itextpdf.text.pdf.PdfName.URL;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Vector;

/**
 *
 * @author Casey
 */
public class pluginGetter {
    private Vector<String> pluginNames = new Vector<String>();
    private String directoryName = null;
    
    private void getFileList(){
        File directory = new File(directoryName);
            File[] fList = directory.listFiles();
            
            for (File file : fList){
                if (file.isFile()){
                    pluginNames.add(file.getName().substring(0,file.getName().indexOf(".")));
                }
            }
    }
    Vector<String> getPlugins(String directoryNameArg){
        directoryName = directoryNameArg;
        getFileList();
        return pluginNames;
    }
}

