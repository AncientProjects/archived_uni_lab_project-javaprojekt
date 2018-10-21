/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.util.PriorityQueue;

/**
 *
 * @author Kappa123
 */



public class Compression {
  
    public static void main(String[] args) {
        
        
        Frequency f = new Frequency();
        String s = "AAAAAABCCCCCCDDEEEEE"; //ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA | aaaabbbcdeeeffg;;; |aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff
        //String encoded_string = new String("");
        HuffmanCode hc = new HuffmanCode();
        PriorityQueue<Node> pq = f.addToPriorityQueue(s);
        Node root = hc.createTree(s, pq);
        hc.codeCharacters(root, "");
        
        View view = new View();
        view.printCodes(root, "");
        view.printTree(root, 0);
        
        System.out.println("");
        String code = hc.codeString(s, f.pq);
        //System.out.println(code);
        
        
        /*for(int i = 0; i < f.tabn.length; i++){
            System.out.println(f.tabn[i].getId() + ": " + f.tabn[i].getValue());
        }*/
    /*public String get_input(){
              //Scanner input = new Scanner(System.in);
              //String s = input.nextLine();
              String s = "ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA";
            return s;
        }*/
    }
    
}
