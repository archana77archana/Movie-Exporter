/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;
 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
 
/**
 *
 * @author Casey
 *
 */
 
abstract class DataWriter{
    abstract void outFile(HashMap<String, String> movieDetails);
    abstract void printDetails();
}
 
abstract class DataInput{
    abstract HashMap input(HashMap<String, String> movieDetails);
    abstract void printDetails();
}
 
class MovieInput{
    private HashMap<String,String> movieDetails = null;
    private Scanner in = null;
    Vector<Object> objList = null;
   
    private void input(DataInput inputMethod){
        inputMethod.input(movieDetails);
    }
    
    private void printDetails(DataInput inputMethod){
        inputMethod.printDetails();
    }
    
    private void printDetails(){
        pluginParse obj = new pluginParse();
        objList = obj.getpluginObjects("src/movieexporter/Input");
        Iterator iter = objList.listIterator();
        int i = 0;
        while(iter.hasNext()){
            System.out.println(" Choice ("+i+")");
            printDetails((DataInput)iter.next());
            i = i+1;
        }
    }
   
    private void invokeInputMethod(){
        /*
        System.out.println("\nEnter input method : ");    
       
        Object test;
       
        try {
            test = Class.forName(in.nextLine()).newInstance();
            input((DataInput)test);
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException ex) {
            System.out.println("Unexpected error occured" + ex);
        }
        */
        System.out.println("Enter the number corresponding to the method wanted");
        int choice = in.nextInt();
        input((DataInput)objList.elementAt(choice));
    }
   
    void getInput(Scanner inArg, HashMap<String,String>movieDetailsArg){
        in = inArg;
        movieDetails = movieDetailsArg;
        printDetails();
        invokeInputMethod();
    }
    
}
 
/*
class MovieOutput{
    private HashMap<String,String> movieDetails=null;
    private Scanner in=null;
   
    private void output(DataWriter outputMethod){
        outputMethod.outFile(movieDetails);
    }
    private void invokeOutputMethord(){
        System.out.println("\nEnter output method : ");    
        Object test;
       
        try {
            test = Class.forName(in.nextLine()).newInstance();
            output((DataWriter)test);
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException ex) {
            System.out.println("Unexpected error occured" + ex);
        }
    }
   
    void getOutput(Scanner inArg,HashMap<String, String>movieDetailsArg){
        in=inArg;
        movieDetails=movieDetailsArg;
        invokeOutputMethord();
    }
}
 
*/
 
class MovieOutput{
    private HashMap<String,String> movieDetails = null;
    private Scanner in = null;
    Vector<Object> objList = null;
   
    private void output(DataWriter outputMethod){
        outputMethod.outFile(movieDetails);
    }
   
    private void printDetails(DataWriter outputMethod){
        outputMethod.printDetails();
    }
   
    private void printDetails(){
        pluginParse obj = new pluginParse();
        objList = obj.getpluginObjects("src/movieexporter/Output");
        Iterator iter = objList.listIterator();
        int i = 0;
        while(iter.hasNext()){
            System.out.println(" Choice ("+i+")");
            printDetails((DataWriter)iter.next());
            i = i+1;
        }
    }
   
    private void invokeOutput(){
        System.out.println("Enter the number corresponding to the method wanted");
        int choice = in.nextInt();
        output((DataWriter)objList.elementAt(choice));
    }
   
    void getOutput(Scanner inArg,HashMap<String,String> movieDetailsArg){
        in = inArg;
        movieDetails = movieDetailsArg;
        printDetails();
        invokeOutput();
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
        /*
        String dir=in.nextLine();
        pluginGetter obj6 = new pluginGetter();
        Vector<String> test=obj6.getPlugins(dir);
        System.out.println(test.get(0));
        */
        try{
            /*
            MethodInp obj3 = new MethodInp();
            obj3.methodIn();
            */
            MovieInput obj = new MovieInput();
            obj.getInput(in, movieDetails);
 
            //obj3.methodIn();
               
             MovieOutput obj2 = new MovieOutput();
             obj2.getOutput(in, movieDetails);
        }
        catch(Exception ex){
            System.out.println("Unexpected error occured" + ex);
        }
       
    }
}