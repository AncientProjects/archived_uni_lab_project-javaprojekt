/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Adam Olechno
 */

//class for decoding the code with pre-existing tree functioning as a key
public class HuffmanDecode {
    
    
    public String decodeHuffman(Node root, String s) {
        String decodedString = "";
        Node temp = root;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')
                temp = temp.getLeft();
            else if (s.charAt(i) == '1')
                temp = temp.getRight();
            
            if(temp.getLeft() == null || temp.getRight() == null){
                decodedString += temp.getId();
                temp = root;
            }
                
        }
        return decodedString;
    }
}
