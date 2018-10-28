/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Adam Olechno
 */



public class Frequency {
        
        /*this function creates a HashMap object that is filled with individual characters as keys
        and the number of times they appeared as frequency*/
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
        
        /*adding contents of HashMap to a Priority Queue simultaneously using a Comparator
        to add the contents based on frequency value of individual */
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
                pq.add(tabn[o]);
            }
            
            
            PriorityQueue<Node> pq_clone = new PriorityQueue<Node>(pq);
            return pq_clone;
        }
        
        public PriorityQueue<Node> getPriorityQueue(){
            return this.pq;
        }
        
        private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        private Node[] tabn = null;
        private PriorityQueue<Node> pq = null;
}
