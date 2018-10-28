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

//each object equals one tree node
public class Node {
    public Node() {}
    public Node(char _id, int _value) {
        id = _id;
        value = _value;
        code = new String(" ");
        left = null;
        right = null;
    }
    
    Node(Node node) {
        id = node.id;
        value = node.value;
        code = node.code;
        left = node.left;
        right = node.right;
    }
    
    //simple getters and setters
    public void setId(char _id){
        id = _id;
    }
    
    public char getId(){
        return id;
    }
    
    public void setValue(int _value){
        value = _value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setCode(String _code){
        code = _code;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public void setLeft(Node _left){
        this.left = _left;
    }
    
    public Node getLeft(){
        return this.left;
    }
    
    public void setRight(Node _right){
        this.right = _right;
    }
    
    public Node getRight(){
        return this.right;
    }
    
    private char id;
    private int value;
    private String code;
    
    private Node left;
    private Node right;
}
