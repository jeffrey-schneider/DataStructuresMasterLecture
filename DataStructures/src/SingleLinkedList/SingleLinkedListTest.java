/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

/**
 *
 * @author jcschneider
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList<String> names = new SingleLinkedList<>();
        names.addFirst("Sam");
        names.addFirst("Harry");
        names.addFirst("Dick");
        names.addFirst("Tom");
        
        names.add("Jeff");
        names.printAll();
        for (int i = 0; i < names.getSize(); i++) {
            System.out.print(names.get(i) + " -> ");
        }
        
       SingleLinkedList<Integer> numbers = new SingleLinkedList<>();
       int counter = 0;
       while(counter<10){
           numbers.add(counter++);           
       }

       System.out.println("\nGetSize(): " + numbers.getSize());
        //for (int i = 0; i < numbers.getSize(); i++) {
        //    System.out.println(numbers.get(i) + " -> ");
        //}
        
        numbers.printAll();
        
        numbers.reverse();
        numbers.printAll();
        System.out.println("Length: " + numbers.findLength());
    }
    
}
