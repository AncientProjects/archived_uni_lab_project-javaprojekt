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
public class View {
    public void printCodes(Node root, String s){
        if(root.left == null && root.right == null){
            System.out.println(root.getId() + ": " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }
    
    public void printTree(Node root, int i) {
        i++;
        if(root.right != null)
            printTree(root.right, i);
        System.out.println("");
        for(int o = i; o > 0; o--)
            System.out.print("  ");
        System.out.print(root.getValue());
        if(root.left != null)
            printTree(root.left, i);
        
    }
}
