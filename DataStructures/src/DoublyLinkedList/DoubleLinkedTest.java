/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author JCSchneider
 */
public class DoubleLinkedTest {

    public static void main(String[] args) {
        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.add("Sam");
        names.add("Harry");
        names.add("Dick");
        names.add("Tom");
        
        names.add("Jeff");
               
        names.printAll();
        
        System.out.println("At index 3: " + names.getNode(3));
        System.out.println("Finding Jeff: " + names.searchFor("Jeff"));
        System.out.println("Finding Luther: " + names.searchFor("Luther"));
        
        
    }
}
