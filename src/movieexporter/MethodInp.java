/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieexporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casey
 */
public class MethodInp  {

    
    private void readDetails(File file) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(file); 
        int num = (int) file.length();
        char a[] = new char[num];
        
        fr.read(a);
        for(char c : a)
            System.out.print(c); //prints the characters one by one
        fr.close();
    }

    void methodIn()
    {
        String fileName;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the file which has the details of the methods : ");
        
        fileName = in.nextLine();
        File file = new File(fileName);
        
        boolean exists;  
        if (file.exists()){
            exists =  true;
        }else{
            exists = false;
            System.out.println("No such file exists");
        } 
        
        try 
        {
            if(exists == true)
            {
                readDetails(file);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
    