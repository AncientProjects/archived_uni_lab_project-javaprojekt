/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Comp;
import Model.Node;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;



/**
 *
 * @author Adam Olechno
 * @version 1.2
 */

//class made specifically to print out data
public class View {
    
    //print individual codes for each character/key
    public void printCodes(Node root, String s){
        //if it's the last Node in Huffman Tree, then print out generated code
        if(root.getLeft() == null && root.getRight() == null){
            System.out.println(root.getId() + ": " + s);
            return;
        }
        //mode recursively through tree
        printCodes(root.getLeft(), s + "0");
        printCodes(root.getRight(), s + "1");
    }
    
    //this method prints generated tree for reference; left - top of the tree, right - bottom of the tree
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
    
    //this method saves huffman code to output file
    public void saveCodeToFile(String filename, String code, HashMap<Character, Integer> map) {
        try (PrintWriter out = new PrintWriter(filename)) {
            //first print code to output file
            out.println(code);
            //then size of HashMap to be saved
            out.println(map.size());
            //for each key in the map, save key and the number of times it appears in input; each one in its own line
            for (char key : map.keySet())
            {
                out.println(key + " " + map.get(key));
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File '" + filename + "' was not found ...");
        }
    }
    
    //method for saving decoded code
    public void saveDecodedTextToFile(String filename, String s){
        try (PrintWriter out = new PrintWriter(filename)){
            //saving decoded content is simple - just save the String to file
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
            //read line and then add it to the String that contains everything from input file
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
            //read only first line, because only there is the code saved
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
    //initially it's saved in the form of a map, but due to problems stemming from reading complete tree or priority queue
    //it's far simpler to just save and read a map and then just convert it into priority queue and start algorithm from the beginning
    public PriorityQueue<Node> readPriorityQueueFromFile(String filename) {
        String line = "";
        Node node = new Node();
        PriorityQueue<Node> pq = null;
        
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //first two lines are: code and size of map, so they are not needed now
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            Scanner scanner = new Scanner(line);
            //second line contains only the size of map, so it's used in PQ constructor as initial value
            pq = new PriorityQueue<Node>(scanner.nextInt(), new Comp());
            //from 3rd line each line contains character and number of times said character appears in the file
            while((line = bufferedReader.readLine()) != null){
                scanner = new Scanner(line);
                //for each line one new Node object is constructed
                node = new Node();
                //countermeasures for 'newline' character
                if(line.equals("")){
                    node.setId('\n');
                    line = bufferedReader.readLine();
                    scanner = new Scanner(line);
                }
                //reading char and value from current line
                while(scanner.hasNext()){
                    if(scanner.hasNextInt()){
                        node.setValue(scanner.nextInt());
                    }
                    else{
                        node.setId(scanner.next().charAt(0));
                    }
                }
                //countermeasures for 'space' character
                if(node.getId() == '\u0000')
                    node.setId(' ');
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
    
}
