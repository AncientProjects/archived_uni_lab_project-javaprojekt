/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.ManageFiles;
import java.io.FileNotFoundException;


/**
 *
 * @author Adam Olechno
 */



public class Main {
  
    public static void main(String[] args) throws FileNotFoundException {
        
        ManageFiles control = new ManageFiles();

        control.consoleControl(args);
        
        
    }
    
}

//comments for reference

//View view = new View();
//Frequency f = new Frequency();
/*String s = control.readTextFromFile(args[1]);
        
        HuffmanCode hc = new HuffmanCode();
        PriorityQueue<Node> pq = f.addToPriorityQueue(s);
        Node root = hc.createTreeFromPriorityQueue(pq);
        hc.codeCharacters(root, "");
        
       
        view.printCodes(root, "");
        view.printTree(root, 0);
        
        System.out.println("");
        String code = hc.codeString(s, f.getPriorityQueue());
        HuffmanDecode hd = new HuffmanDecode();
        String original = hd.decodeHuffman(root, code);
        System.out.println(original);
        System.out.println(s);
        
        control.saveCodeToFile("E:\\przedmioty\\JwIiUM\\javaprojekt\\Kompresja\\inwokacja.txt", code, root);
        control.saveDecodedTextToFile("test.txt", s);
        pq = control.readPriorityQueueFromFile("E:\\przedmioty\\JwIiUM\\javaprojekt\\Kompresja\\inwokacja.txt");*/