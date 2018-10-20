/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;
import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.io.Console;
import java.util.HashMap;
import java.util.Comparator; 
/**
 *
 * @author Kappa123
 */

class Comp implements Comparator<Node> {
        public int compare(Node x, Node y){
            return x.value - y.value;
        }
}

public class Kompresja {
    public static void printCodes(Node root, String s){
        if(root.left == null && root.right == null){
            System.out.println(root.id + ": " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }
    
    public static void printTree(Node root, int i) {
        i++;
        if(root.right != null)
            printTree(root.right, i);
        System.out.println("");
        for(int o = i; o > 0; o--)
            System.out.print("  ");
        System.out.print(root.value);
        if(root.left != null)
            printTree(root.left, i);
        
    }
    
    public static void main(String[] args) {
        
        char[] tabc;
        int[] tabi;
        String s = "aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff"; //ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA | aaaabbbcdeeeffg;;; |aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff
        
        
        Frequency f = new Frequency();
        
        f.createMap(s);
        
        System.out.println(f.map.values());
        System.out.println(f.map.keySet());
        tabc = new char[f.map.size()];
        tabi = new int[f.map.size()];
        int i = 0;
        for (char key : f.map.keySet())
        {
            tabi[i] = f.map.get(key);
            tabc[i] = key;
            //System.out.println(map.get(key));
            i++;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(f.map.size(), new Comp());
        
        for (int o = 0; o < f.map.size(); o++){
            Node hn = new Node(tabc[o], tabi[o]);
            pq.add(hn);
        }
        
        
        Node root = null;
        
        while (pq.size() > 1){
            Node x = pq.peek();
            pq.poll();
            Node y = pq.peek();
            pq.poll();
            
            Node z = new Node('-', x.value + y.value);
            z.left = x;
            z.right = y;
            pq.add(z);
            root = z;
        }
        printCodes(root, "");
        printTree(root, 0);
    }
    
    /*public String get_input(){
              //Scanner input = new Scanner(System.in);
              //String s = input.nextLine();
              String s = "ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA";
            return s;
        }*/
    
}
