/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.util.Scanner;

/**
 *
 * @author asdf123
 */
public class Frequency {
        public String get_input(){
              //Scanner input = new Scanner(System.in);
              //String s = input.nextLine();
              String s = "ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA";
        return s;
        }
        
        public void calculate_frequency(){
            char[] tabc = new char[26];
            int[] tabi = new int[26];
        
        
            for (int i = 65; i < 91; i++){
                  tabc[i - 65] = (char)i;
            }
            
            for (int i = 0; i < get_input().length(); i++){
                if((int)get_input().charAt(i) > 64 && (int)get_input().charAt(i) < 91)
                    tabi[(int)get_input().charAt(i) - 65]++;
            }
            for(int i = 0; i < 26; i++)
                System.out.println(tabc[i] + ": " + tabi[i]);
            //for (int o = 0; o < s.length(); o++)    
        }
        
        
}
