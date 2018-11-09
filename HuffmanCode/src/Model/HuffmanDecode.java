/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Adam Olechno
 * @version 1.2
 */

//class for decoding the code with pre-existing tree functioning as a key
public class HuffmanDecode {
    
    
    public String decodeHuffman(Node root, String s) {
        String decodedString = "";
        Node temp = root;
        //for every character in String 
        for(int i = 0; i < s.length(); i++){
            //if 0 - go left, if 1 - go right down the tree
            if(s.charAt(i) == '0')
                temp = temp.getLeft();
            else if (s.charAt(i) == '1')
                temp = temp.getRight();
            //check if it's possible to go further down the tree
            if(temp.getLeft() == null || temp.getRight() == null){
                //if not - character in the last node is the coded character
                //then add it to the final String
                decodedString += temp.getId();
                temp = root;
            }
        }
        return decodedString;
    }
}
