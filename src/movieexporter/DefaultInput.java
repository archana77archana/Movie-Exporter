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
 */
public class DefaultInput extends DataInput {
    @Override
    HashMap input(HashMap<String, String> movieDetails) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Movie name: ");
        movieDetails. put("Name : ",in.nextLine());
        
        System.out.println("Enter language: ");
        movieDetails. put("Lang : ", in.nextLine());
        
        System.out.println("Enter actor: ");
        movieDetails. put("Actor : ", in.nextLine());
        
        System.out.println("Enter genre: ");
        movieDetails. put("Genre : ", in.nextLine());
        
        System.out.println("Enter runtime: ");
        movieDetails. put("Runtime : ", in.nextLine());
        
        return movieDetails;
    }
}