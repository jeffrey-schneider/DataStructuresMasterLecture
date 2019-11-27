/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JCSchneider
 */
public class DequeForPalindromes {

    public static void main(String[] args) {

        Deque deck = new LinkedList<>();
        Deque deck2 = new LinkedList<>();
        //String words = "sense stab deep stoops stink Devil looks animal spins real lies state Ono etats seil laer snips lamina skool lived knits spoots peed bats esnes";
        //String words = "Devil evil slit secret ogre spit stink spins animal looks sleep lies cyc seil peels skool lamina snips knits tips ergo terces tils live lived";
        String words = "Dennis, Nell, Edna, Leon, Nedra, Anita, Rolf, Nora, Alice, Carol, Leo, Jane, Reed, Dena, Dale, Basil, Rae, Penny, Lana, Dave, Denny, "
                + "Lena, Ida, Bernadette, Ben, Ray, Lila, Nina, Jo, Ira, Mara, Sara, Mario, Jan, Ina, Lily, Arne, Bette, Dan, Reba, Diane, Lynn, Ed, Eva, Dana, Lynne, Pearl, Isabel, Ada, Ned, Dee, Rena, Joel, Lora, Cecil, Aaron, Flora, Tina, Arden, Noel, and Ellen sinned.";
        words = words.replaceAll("\\s", "");
        words = words.replaceAll("[^a-zA-Z0-9]", "");
        
        char a;
        char b;

        char[] chars = words.toCharArray();

        for (char aChar : chars) {
            //System.out.println(aChar); 
            aChar = Character.toLowerCase(aChar);
            deck.addFirst(aChar);
            deck2.addLast(aChar);
        }

        if (deck.equals(deck2)) {
            System.out.println("\nPalindrome.");
        } else {
            System.out.println("\nNot palindrome.");
        }

        System.out.println("size of: " + deck.size() + " " + deck2.size());
        while (!deck.isEmpty()) {
            a = (char) deck.pollFirst();
            b = (char) deck2.pollLast();
            if (a == b) {
                System.out.print(a);
            }

        }

    }
}
