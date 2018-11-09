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
 * @version 1.2
 */

//comparator for priority queue
public class Comp implements Comparator<Node> {
        //comparator ensures that each newly added node will be immediately sorted in correct order
        public int compare(Node x, Node y){
            //in this case Nodes with smaller values will be closer to head
            return x.getValue() - y.getValue();
        }
}
