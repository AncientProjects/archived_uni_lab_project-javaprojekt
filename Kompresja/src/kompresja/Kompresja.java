/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;
import java.util.Scanner; 
import java.io.Console;

/**
 *
 * @author Kappa123
 */


public class Kompresja {

   
    public static void main(String[] args) {
        
        Frequency f = new Frequency();
        f.get_input();
        f.calculate_frequency();
        
        //System.out.println(f.s);
        
        
    }
    
}
