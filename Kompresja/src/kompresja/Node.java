/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

/**
 *
 * @author asdf123
 */
public class Node {
    Node() {}
    Node(char _id, int _value) {
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
    
    private char id;
    private int value;
    public String code;
    
    Node left;
    Node right;
}
