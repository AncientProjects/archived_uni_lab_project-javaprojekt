/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HuffmanCode;
import Model.HuffmanDecode;
import Model.Node;
import Model.Frequency;
import View.View;
import java.util.PriorityQueue;

/**
 *
 * @author Adam Olechno
 * @version 1.2
 */

//class for managing input and output
public class Controller {
    
    //method for managing console parameters
    public void consoleControl(String[] args){
        
        try {
            //if the third argument equals "code", then contents of input file will be coded and saved into output file
            if (args[2].equals("code")){
                //first argument is input file
                String s = view.readTextFromFile(args[0]);
                //create priority queue from characters in String
                PriorityQueue<Node> pq = f.addToPriorityQueue(s);
                //create Huffman Tree from Priority Queue
                Node root = hc.createTreeFromPriorityQueue(pq);
                //give each character its code
                hc.codeCharacters(root, "");
                //using codes from previous method, code input String
                String code = hc.codeString(s, f.getPriorityQueue());
                //save coded String to file along with map of characters
                view.saveCodeToFile(args[1], code, f.getMap());
            }
            //likewise if the third argument equals "decode", then input is treated as the coded version
            else if (args[2].equals("decode")){
                //first argument is input file; read coded string
                String code = view.readCodeFromFile(args[0]);
                //read map from file and convert it into Priority Queue
                PriorityQueue<Node> pq = view.readPriorityQueueFromFile(args[0]);
                //create Huffman Tree from Priority Queue
                Node root = hc.createTreeFromPriorityQueue(pq);
                //basing on tree as a key, decode input code
                String original = hd.decodeHuffman(root, code);
                //save decoded String to file
                view.saveDecodedTextToFile(args[1], original);
            }
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Not enough parameters ...");
        }
    }
    
    //classes Frequency, HuffmanCode and HuffmanDecode belong to model and are used to invoke functions
    private Frequency f = new Frequency();
    private HuffmanCode hc = new HuffmanCode();
    private HuffmanDecode hd = new HuffmanDecode();
    //class View belong to view and is used to manage input and output
    private View view = new View();
}
