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
        left = null;
        right = null;
    }
    char id;
    int value;
    
    Node left;
    Node right;
}
