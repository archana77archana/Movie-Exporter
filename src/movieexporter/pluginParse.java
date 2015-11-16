/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casey
 */
public class pluginParse {
    
    private Vector<Object> objList = new Vector<>();
    private String dirName = null;
    
    private void printPlugins(){
        pluginGetter obj = new pluginGetter();
        Vector<String> inputPlugins = obj.getPlugins(dirName);
        Iterator<String> Iter = inputPlugins.listIterator();
        String pluginName;
        
        while(Iter.hasNext()){
            pluginName = Iter.next();
            try{
                Object test = Class.forName("movieexporter."+pluginName).newInstance();
                objList.add(test);
            } catch(ClassNotFoundException|InstantiationException|IllegalAccessException Ex){
                System.out.println("Unexpected error occured"+Ex);
            }
        }
    }
    Vector<Object> getpluginObjects(String dirNameArg){
        dirName = dirNameArg;
        printPlugins();
        return objList;
        
    }
}
