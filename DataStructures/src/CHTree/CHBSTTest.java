/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHTree;

/**
 *
 * @author JEFFREY.SCHNEIDER
 */
public class CHBSTTest {
public static void main(String[] args) {
        CHBST t = new CHBST();
        String line = "qwertyasdf";
        int len = line.length();
        Comparable[] z= new Comparable[len];
        for (int j = 0; j < len; j++) {
            z[j] = new Character(line.charAt(j));
        }
        
    }    
}
