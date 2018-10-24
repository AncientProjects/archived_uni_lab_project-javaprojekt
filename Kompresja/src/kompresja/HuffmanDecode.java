/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

/**
 *
 * @author Kappa123
 */
public class HuffmanDecode {
    public String decodeHuffman(Node root, String s) {
        String decodedString = "";
        Node temp = root;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')
                temp = temp.left;
            else if (s.charAt(i) == '1')
                temp = temp.right;
            
            if(temp.left == null || temp.right == null){
                decodedString += temp.getId();
                temp = root;
            }
                
        }
        return decodedString;
    }
}
