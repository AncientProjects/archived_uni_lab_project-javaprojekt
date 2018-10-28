/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.HuffmanCode;
import Model.HuffmanDecode;
import Model.Node;
import Model.Frequency;
import Model.Frequency;
import Model.Comp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Adam Olechno
 */

//class for managing input and output
public class ManageFiles {
    
    //this method saves huffman code to output file
    public void saveCodeToFile(String filename, String code, PriorityQueue<Node> pq) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(code);
            //saveTreeToFile(out, pq);
            for(int i = pq.size(); i > 0; i--){
                out.println(pq.peek().getId() + " " + pq.poll().getValue());
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
    }
    
    /*//along with this method that saves tree structure underneath the code
    public void saveTreeToFile(PrintWriter out, Node root){
        if (root.getLeft() != null)
            saveTreeToFile(out, root.getLeft());
        out.println(root.getId() + " " + root.getValue());
        //out.println(root.getValue());
        if (root.getRight() != null)
            saveTreeToFile(out, root.getRight());
    }*/
    
    //method for saving decoded code
    public void saveDecodedTextToFile(String filename, String s){
        try (PrintWriter out = new PrintWriter(filename)){
            out.println(s);
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
    }
    
    //method used to read ONLY text that hasn't been coded yet
    public String readTextFromFile(String filename){
        String s = "";
        String line = "";
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                s += line + "\n";
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
        catch(IOException ex){
            System.out.println("Error reading file '" + filename + "' ...");
        }
        
        return s;
    }
    
    //separate method for reading the already coded text
    public String readCodeFromFile(String filename){
        String code = "";
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            code = bufferedReader.readLine();
            
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
        catch(IOException ex){
            System.out.println("Error reading file '" + filename + "' ...");
        }
        
        return code;
    }
    
    //this method is used for reading the tree saved to file, but in the form of priority queue
    public PriorityQueue<Node> readPriorityQueueFromFile(String filename) {
        String line = "";
        Node node = new Node();
        int i = 0;
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
                i++;
            pq = new PriorityQueue<Node>(i - 1, new Comp());
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            
            line = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                Scanner scanner = new Scanner(line);

                node = new Node();
                while(scanner.hasNext()){
                    if(scanner.hasNextInt()){
                        node.setValue(scanner.nextInt());
                    }
                    else{
                        node.setId(scanner.next().charAt(0));
                    }
                }
                pq.add(node);
            }
            
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
        catch(IOException ex){
            System.out.println("Error reading file '" + filename + "' ...");
        }
        return pq;
    }
    
    //method for managing console parameters
    public void consoleControl(String[] args){
        HuffmanCode hc = new HuffmanCode();
        try {
            if (args[2].equals("code")){
                String s = readTextFromFile(args[0]);
                
                
                PriorityQueue<Node> pq = f.addToPriorityQueue(s);
                Node root = hc.createTreeFromPriorityQueue(pq);
                hc.codeCharacters(root, "");
                String code = hc.codeString(s, f.getPriorityQueue());
                saveCodeToFile(args[1], code, f.getPriorityQueue());
            }
            if (args[2].equals("decode")){
                String code = readTextFromFile(args[0]);
                
                PriorityQueue<Node> pq = readPriorityQueueFromFile(args[0]);
                Node root = hc.createTreeFromPriorityQueue(pq);
                HuffmanDecode hd = new HuffmanDecode();
                String original = hd.decodeHuffman(root, code);
                saveDecodedTextToFile(args[1], original);
            }
            
            
            
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Not enough parameters ...");
        }
    }
    
    private Frequency f = new Frequency();
    
    private PriorityQueue<Node> pq = null;
}
