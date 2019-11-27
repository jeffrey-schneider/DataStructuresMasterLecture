/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHSet;

/**
 *
 * @author JCSchneider
 */
public class CHSetTest {

    public static void main(String[] args) {
        CHSet<String> set = new CHSet<String>();
        System.out.println("set = " + set);
        // insert some keys
        set.add("www.cs.princeton.edu");
        set.add("www.cs.princeton.edu");    // overwrite old value
        set.add("www.princeton.edu");
        set.add("www.math.princeton.edu");
        set.add("www.yale.edu");
        set.add("www.amazon.com");
        set.add("www.simpsons.com");
        set.add("www.stanford.edu");
        set.add("www.google.com");
        set.add("www.ibm.com");
        set.add("www.apple.com");
        set.add("www.slashdot.com");
        set.add("www.whitehouse.gov");
        set.add("www.espn.com");
        set.add("www.snopes.com");
        set.add("www.movies.com");
        set.add("www.cnn.com");
        set.add("www.iitb.ac.in");

        System.out.println(set.contains("www.cs.princeton.edu"));
        System.out.println(!set.contains("www.harvardsucks.com"));
        System.out.println(set.contains("www.simpsons.com"));
        System.out.println();

        System.out.println("ceiling(www.simpsonr.com) = " + set.ceiling("www.simpsonr.com"));
        System.out.println("ceiling(www.simpsons.com) = " + set.ceiling("www.simpsons.com"));
        System.out.println("ceiling(www.simpsont.com) = " + set.ceiling("www.simpsont.com"));
        System.out.println("floor(www.simpsonr.com)   = " + set.floor("www.simpsonr.com"));
        System.out.println("floor(www.simpsons.com)   = " + set.floor("www.simpsons.com"));
        System.out.println("floor(www.simpsont.com)   = " + set.floor("www.simpsont.com"));
        set.delete("www.amazon.com");
        
        
        System.out.println();

        System.out.println("set = " + set);
        System.out.println();

        // print out all keys in this set in lexicographic order
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println();
        CHSet<String> set2 = new CHSet<String>(set);
        System.out.println(set.equals(set2));
    }

}
