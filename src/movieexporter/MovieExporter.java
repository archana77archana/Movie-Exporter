
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

abstract class DataInput{
    abstract HashMap input(HashMap<String,String> movieDetails);
}

class MovieInput{
    private void input(DataInput inputMethod ,HashMap<String,String> movieDetails){
        inputMethod.input(movieDetails);
    }
    
    private void invokeInputMethod(Scanner in, HashMap<String,String>movieDetails){
        System.out.println("\nEnter input method : ");    
        
        Object test;
        
        try {
            test = Class.forName(in.nextLine()).newInstance();
            input((DataInput)test, movieDetails);
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException ex) {
            System.out.println("Unexpected error occured" + ex);
        }
    }
    
    void getInput(Scanner in,HashMap<String,String>movieDetails){
        invokeInputMethod(in, movieDetails);
    }
}

class MovieOutput{
    private void output(DataWriter outputMethod, HashMap<String,String> movieDetails){
        outputMethod.outFile(movieDetails);
    }
    private void invokeOutputMethord(Scanner in, HashMap<String,String>movieDetails){
        System.out.println("\nEnter output method : ");    
        Object test;
        
        try {
            test = Class.forName(in.nextLine()).newInstance();
            output((DataWriter)test, movieDetails);
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException ex) {
            System.out.println("Unexpected error occured" + ex);
        }
    }
    
    void getOutput(Scanner in,HashMap<String, String>movieDetails){
        invokeOutputMethord(in, movieDetails);
    }
}

public class MovieExporter {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap<String,String> movieDetails = new HashMap();

        Scanner in = new Scanner(System.in);
        
        try{

            MethodInp obj3 = new MethodInp();
            obj3.methodIn();

            MovieInput obj = new MovieInput();
            obj.getInput(in, movieDetails);

            obj3.methodIn();

             MovieOutput obj2 = new MovieOutput();
             obj2.getOutput(in, movieDetails);
        }
        catch(Exception ex){
            System.out.println("Unexpected error occured" + ex);
        }
        
    }
}
