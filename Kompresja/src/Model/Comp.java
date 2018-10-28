/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Comparator;

/**
 *
 * @author Adam Olechno
 */

//comparator for priority queue
public class Comp implements Comparator<Node> {
        public int compare(Node x, Node y){
            return x.getValue() - y.getValue();
        }
}
