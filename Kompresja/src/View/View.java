/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Node;



/**
 *
 * @author Adam Olechno
 */

//class made specifically to print out data for reference
public class View {
    public void printCodes(Node root, String s){
        if(root.getLeft() == null && root.getRight() == null){
            System.out.println(root.getId() + ": " + s);
            return;
        }
        printCodes(root.getLeft(), s + "0");
        printCodes(root.getRight(), s + "1");
    }
    
    public void printTree(Node root, int i) {
        i++;
        if(root.getRight() != null)
            printTree(root.getRight(), i);
        System.out.println("");
        for(int o = i; o > 0; o--)
            System.out.print("  ");
        System.out.print(root.getValue());
        if(root.getLeft() != null)
            printTree(root.getLeft(), i);
        
    }
    
}
