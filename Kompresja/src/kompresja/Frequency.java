/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author asdf123
 */
public class Frequency {
    
        public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        public void createMap(String s){
                    
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val != null) {
                map.put(c, val + 1);
            }
            else 
                map.put(c, 1);
        }
        
        }
        
        
}
