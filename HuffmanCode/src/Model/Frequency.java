/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author Adam Olechno
 * @version 1.2
 */



public class Frequency {
        
        /*this function creates a HashMap object that is filled with individual characters as keys
        and the number of times they appeared as frequency*/
        public void createMap(String s){
            //s here is a string that contains input from text file
            //one by one characters are added to a map and each individial character is treated like a key
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
            //in order to sort contents of the map, first these are moved to an array
            tabn = new Node[map.size()];
            int i = 0;
            for (char key : map.keySet())
            {
                tabn[i] = new Node(key, map.get(key));
                i++;
            }
            //then from the array are moved to a priority queue that sorts each Node of future Huffman Tree while adding new nodes
            //it's achieved simply by using a comparator
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
        
        public HashMap<Character, Integer> getMap(){
            return this.map;
        }
        
        //hash map is very useful in counting the amount each character(key) appears in text
        private HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //each Node constitutes character, its number of appearances, its code and pointers(left and right)
        private Node[] tabn = null;
        //priority queue is useful for sorting nodes by value(number of appearances)
        private PriorityQueue<Node> pq = null;
}
