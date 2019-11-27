/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *   https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
 */
package CHBST;


import FlightApplication.BaseFlight;
import FlightApplication.CommercialFlight;
import java.util.Arrays;

/**
 *
 * @author JCSchneider
 */
public class CHBSTGenericTest {

    public static void main(String[] args) {

        CHBSTGeneric<Integer> b = new CHBSTGeneric<Integer>();
        
        b.add(40);
        b.add(20);
        b.add(50);
        b.add(10);
        b.add(60);
        b.add(30);
        b.add(15);
        b.add(35);
        b.add(33);
        b.add(-44);
        //int[] arr = new int[]{6,4,2,5,1,3,8,7,9,10};
        //Arrays.sort(arr);
        //b.CreateBinaryTree(arr);
       
        
        System.out.print("\nPre order: ");
        b.preOrderTraversal();
        System.out.println("");
        
        System.out.print("In order: ");        
        b.inOrderTraversal();
        System.out.println("");
       
        
        //* <- these comments indicate that this part of lecture has not been given.
        //*System.out.println("Find 20 " + b.find(20));
        //*System.out.println("Find -1 " + b.find(-1));
        
        //*System.out.println("Contains 20? "+ b.contains(20));
        //*System.out.println("Contains -1? " + b.contains(-1));
        
        //*System.out.println("Leaf Nodes:");
        //*b.printLeafNodes();

        
        System.out.print("\nPost order: ");
        b.postOrderTraversal();
        
        System.out.print("\nBreadth first: ");
        b.levelOrderTraversal();
        
        System.out.print("\nDepth first: ");
        b.printDepthFirst();
        
        //*System.out.print("\nfindMin: ");
        //*System.out.println(b.findMin());        
        
        //*System.out.print("\nfindMax: ");
        //*System.out.println(b.findMax());
        
        
        //*testing diameter
        //*System.out.println("\nDiameter: " + b.diameter());
        //*testing width
        //*System.out.println("Width: " + b.width());
        //*testing height
        //*System.out.println("Height: " + b.height());
        //*System.out.println("Is 10 in the tree? " +  b.search(10));        
        //*System.out.println("Is 99 in the tree? " + b.search(99));        
        //*System.out.println("\nLeaves: " + b.countLeaves());
        
        CHBSTGeneric<Integer> c = new CHBSTGeneric<Integer>();
        c = b.clone();        
        System.out.println("are b and c equal? " + b.isEqual(c));
        
        //System.out.println("PrintAllPath");
        //b.printAllPath();
        //
        //System.out.println("Number of full nodes:");
        //System.out.println(b.numFullNodesBT());
        
        
        System.out.println("========");
        
        
        CHBSTGeneric<BaseFlight> bst = new CHBSTGeneric<BaseFlight>();
        
        
        CommercialFlight comm1 = new CommercialFlight(65, "EMC2", "CHA", "DTX", null, 290, 34, 
                34.0, 125.0, "Boeing737-400", 2750, 25);
        bst.insert(comm1);
        CommercialFlight comm2 = new CommercialFlight(0, "Flight667", "DTW", 
                "CHA", null, 890, 6500, 32.4, -123.0, "Airbus A320", 234, 180);
        bst.insert(comm2);
        
        CommercialFlight comm3 = new CommercialFlight(250, "616", "CHA", "LAX", null, 230, 550, 
                34.0, -133.5, "MD88", 2500, 175);
        bst.insert(comm3);
        
        bst.insert(new CommercialFlight(250, "1588", "CHA", "DTW", null, 230, 3400, 
                34.0, -133.5, "MD88", 2500, 175));
        
        bst.inOrderTraversal();
       
        
        System.out.println("\nHeight: " + bst.height());
        System.out.println("Width: " + bst.width());
        System.out.println("Hey: " + bst.toString());
        System.out.println("Diameter: " + bst.diameter());
        
        String abc = "aa";
        System.out.println("String: " + abc + " hashCode: " + abc.hashCode() );
    }
}
