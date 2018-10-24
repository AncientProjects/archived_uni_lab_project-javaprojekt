/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Kappa123
 */

//komparator pozwala zamknąć dodawanie nowych węzlów do kolejki priorytetowej w kolejności od najmniejszego do największego w jednej linijce
class Comp implements Comparator<Node> {
        public int compare(Node x, Node y){
            return x.getValue() - y.getValue();
        }
}

public class HuffmanCode {
    
    HuffmanCode(){
        
    }
    public Node createTree(String s, PriorityQueue<Node> pq) {
        
        Node root = null;
        
        while (pq.size() > 1){
            Node x = pq.peek();
            pq.poll();
            Node y = pq.peek();
            pq.poll();
            
            Node z = new Node('-', x.getValue() + y.getValue());
            z.left = x;
            z.right = y;
            pq.add(z);
            root = z;
        }
        return root;
    }
    
    public void codeCharacters(Node root, String s){
        if(root.left == null && root.right == null){
            root.setCode(s);
            return;
        }
        codeCharacters(root.left, s + "0");
        codeCharacters(root.right, s + "1");
    }
    
    public String codeString(String s, PriorityQueue<Node> pq){
        String code = "";
        Node[] arr = pq.toArray(new Node[pq.size()]);
        for(int i = 0; i < s.length(); i++){
            for(int o = 0; o < pq.size(); o++){
                if(s.charAt(i) == arr[o].getId()){
                    //code += arr[o].value;
                    //code += Integer.toString(arr[o].getValue());
                    
                    System.out.print(arr[o].code);
                    code += arr[o].code;
                }
            }
        }
        
        System.out.println("\n" + code);
        //for(int i = 0; i < arr.length; i++)
        //    System.out.println(Integer.toString(arr[i].getValue()));
        
        return code;
    }
    
    public Frequency f;
}
