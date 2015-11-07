/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author Casey
 *
 */


abstract class DataWriter{
    abstract void outFile(HashMap<String,String> movieDetails);
}

//abstract class to take data input
//base class for inheritance
abstract class DataInput{
    abstract HashMap input(HashMap<String,String> movieDetails);
}

//
class MovieInput{
    void input(DataInput inputMethod,HashMap<String,String> movieDetails){
        //String inputType;
        inputMethod.input(movieDetails);
    }
}

class MovieOutput{
    void output(DataWriter outputMethod,HashMap<String,String> movieDetails){
        //String inputType;
        outputMethod.outFile(movieDetails);
    }
}

public class MovieExporter {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //if I have to add more values, just need to define moviedetails.put(), no need to modify the existing source code
        HashMap<String,String> movieDetails = new HashMap();
        
        Scanner in=new Scanner(System.in);
        
        try{
            System.out.println("Enter input method : ");
        
            Object test;
            test = Class.forName(in.nextLine()).newInstance();
            
            MovieInput obj = new MovieInput();
            obj.input((DataInput)test, movieDetails);
            
            System.out.println("Enter output method : ");
            
            test = Class.forName(in.nextLine()).newInstance();
            MovieOutput obj2 = new MovieOutput();
            obj2.output((DataWriter)test, movieDetails);
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.out.println("Unexpected error occured"+ex);
        }
        
    }
}
