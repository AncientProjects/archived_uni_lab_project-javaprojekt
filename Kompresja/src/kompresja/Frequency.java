/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author asdf123
 */
public class Frequency {
    
        public HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        public Node[] tabn = null;
        public PriorityQueue<Node> pq = null;
        
        Frequency(){
            
        }
        
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
        
        public PriorityQueue<Node> addToPriorityQueue(String s){
            
            createMap(s);

            System.out.println(map.values());
            System.out.println(map.keySet());
            
            tabn = new Node[map.size()];
            int i = 0;
        for (char key : map.keySet())
            {
                tabn[i] = new Node(key, map.get(key));
                i++;
            }

            pq = new PriorityQueue<Node>(map.size(), new Comp());

            for (int o = 0; o < map.size(); o++){
                //Node hn = new Node(tabc[o], tabi[o]);
                //pq.add(hn);
                pq.add(tabn[o]);
            }
            
            
            PriorityQueue<Node> pq_clone = new PriorityQueue<Node>(pq);
            return pq_clone;
        }
}
