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
 */


//the class with huffman code 
public class HuffmanCode {
    
    public Node createTreeFromPriorityQueue(PriorityQueue<Node> pq) {
        
        Node root = null;
        
        while (pq.size() > 1){
            Node x = pq.peek();
            pq.poll();
            Node y = pq.peek();
            pq.poll();
            
            Node z = new Node('-', x.getValue() + y.getValue());
            z.setLeft(x);
            z.setRight(y);
            pq.add(z);
            root = z;
        }
        return root;
    }
    
    public void codeCharacters(Node root, String s){
        if(root.getLeft() == null && root.getRight() == null){
            root.setCode(s);
            return;
        }
        codeCharacters(root.getLeft(), s + "0");
        codeCharacters(root.getRight(), s + "1");
    }
    
    public String codeString(String s, PriorityQueue<Node> pq){
        String code = "";
        Node[] arr = pq.toArray(new Node[pq.size()]);
        for(int i = 0; i < s.length(); i++){
            for(int o = 0; o < pq.size(); o++){
                if(s.charAt(i) == arr[o].getId()){
                    //code += arr[o].value;
                    //code += Integer.toString(arr[o].getValue());
                    
                    System.out.print(arr[o].getCode());
                    code += arr[o].getCode();
                }
            }
        }
        
        System.out.println("\n" + code);
        //for(int i = 0; i < arr.length; i++)
        //    System.out.println(Integer.toString(arr[i].getValue()));
        
        return code;
    }
    
}
