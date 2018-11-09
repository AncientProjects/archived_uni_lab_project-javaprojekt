/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.PriorityQueue;

/**
 *
 * @author Adam Olechno
 * @version 1.2
 */



public class HuffmanCode {
    
    //as the name suggests, this class creates a Huffman Tree from existing Priority Queue containing nodes
    public Node createTreeFromPriorityQueue(PriorityQueue<Node> pq) {
        Node root = null;
        //as long as priority queue has more than 1 node
        while (pq.size() > 1){
            //retrieve head and assign to a variable
            Node x = pq.peek();
            //remove head
            pq.poll();
            //retrieve new head and assign to another variable
            Node y = pq.peek();
            pq.poll();
            //create new node that exists solely to create unique codes
            //its value is the combined values of the previous and new heads
            Node z = new Node('-', x.getValue() + y.getValue());
            //it will act as a root to the two nodes that were retrieved
            z.setLeft(x);
            z.setRight(y);
            //the new node is added as a new head
            pq.add(z);
            root = z;
            //the cycle continues until there's only one node in priority queue
        }
        //returns root of the Huffman Tree
        return root;
    }
    
    //assigns codes for each character in the Huffman Tree using recursion
    public void codeCharacters(Node root, String s){
        //if it's last node on this specific path, then set it's code to currently generated String
        if(root.getLeft() == null && root.getRight() == null){
            root.setCode(s);
            return;
        }
        //String parameter starts as an empty String
        //each node to the left of the previous one has '0' character added to its code
        codeCharacters(root.getLeft(), s + "0");
        //likewise each node to the right has '1' char added
        codeCharacters(root.getRight(), s + "1");
    }
    
    //This function generates end String with all characters coded
    public String codeString(String s, PriorityQueue<Node> pq){
        //initial code String is empty
        String code = "";
        //for easy access contents of priority queue are copied to an array
        Node[] arr = pq.toArray(new Node[pq.size()]);
        //for each character in input String
        for(int i = 0; i < s.length(); i++){
            //and each Node in Priority Queue
            for(int o = 0; o < pq.size(); o++){
                //if the character is the same as either one in any of the Nodes
                if(s.charAt(i) == arr[o].getId()){
                    //add previously generated code to output String
                    code += arr[o].getCode();
                }
            }
        }
        
        return code;
    }
    
}
