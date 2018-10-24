/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kompresja;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 *
 * @author Kappa123
 */



public class Compression {
  
    public static void main(String[] args) throws FileNotFoundException {
        
        
        Frequency f = new Frequency();
        String s = "Inwokacja\n" +
"\n" +
"Litwo! Ojczyzno maja! Ty jesteś jak zdrowie,\n" +
"Ile cię trzeba cenić, ten tylko się dowie,\n" +
"Kto cię stracił. Dziś piękność twą w całej ozdobie\n" +
"Widzę i opisuję, bo tęsknię po tobie\"\n" +
"Panno święta, co Jasnej bronisz Częstochowy\n" +
"I w Ostrej świecisz Bramie! Ty, co gród zamkowy\n" +
"Nowogródzki ochraniasz z jego wiernym ludem!\n" +
"Jak mnie dziecko do zdrowia powróciłaś cudem,\n" +
"(Gdy od płaczącej matki pod Twoją opiekę\n" +
"Ofiarowany, martwą podniosłem powiekę\n" +
"I zaraz mogłem pieszo do Twych świątyń progu\n" +
"Iść za wrócone życie podziękować Bogu),\n" +
"Tak nas powrócisz cudem na Ojczyzny łono.\n" +
"Tymczasem przenoś moją duszę utęsknioną\n" +
"Do tych pagórków leśnych, do tych łąk zielonych,\n" +
"Szeroko nad błękitnym Niemnem rozciągnionych;\n" +
"Do tych pól malowanych zbożem rozmaitem,\n" +
"Wyzłacanych pszenicą, posrebrzanych żytem;\n" +
"Gdzie bursztynowy świerzop, gryka jak śnieg biała,\n" +
"Gdzie panieńskim rumieńcem dzięcielina pała,\n" +
"A wszystko przepasane jakby wstęgą, miedzą\n" +
"Zieloną, na niej z rzadka ciche grusze siedzą."; //ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA | aaaabbbcdeeeffg;;; |aaaaabbbbbbbbbccccccccccccdddddddddddddeeeeeeeeeeeeeeeefffffffffffffffffffffffffffffffffffffffffffff
        //String encoded_string = new String("");
        HuffmanCode hc = new HuffmanCode();
        PriorityQueue<Node> pq = f.addToPriorityQueue(s);
        Node root = hc.createTree(s, pq);
        hc.codeCharacters(root, "");
        
        View view = new View();
        view.printCodes(root, "");
        view.printTree(root, 0);
        
        System.out.println("");
        String code = hc.codeString(s, f.pq);
        HuffmanDecode hd = new HuffmanDecode();
        String original = hd.decodeHuffman(root, code);
        System.out.println(original);
        System.out.println(s);
        
        try (PrintWriter out = new PrintWriter("inwokacja.txt")) {
            out.println(s);
            out.println("\n");
            out.println(code);
        }
        /*for(int i = 0; i < f.tabn.length; i++){
            System.out.println(f.tabn[i].getId() + ": " + f.tabn[i].getValue());
        }*/
    /*public String get_input(){
              //Scanner input = new Scanner(System.in);
              //String s = input.nextLine();
              String s = "ABKLGASKLSAGKOAWKOPAKWGLKLBNKLASNKSANKLASJLKKJSAKFJAIWOJFA";
            return s;
        }*/
    }
    
}
