/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *   https://www.geeksforgeeks.org/deque-interface-java-example/
 *      Faster than Stack and LinkedList
 */
package CHQueue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author JCSchneider
 */
public class DequeTest {
    public static void main(String[] args) 
    { 
        Deque<String> deque = new LinkedList<String>(); 
  
        // We can add elements to the queue in various ways 
        deque.add("Element 1 (Tail)"); // add to tail 
        deque.addFirst("Element 2 (Head)"); 
        deque.addLast("Element 3 (Tail)"); 
        deque.push("Element 4 (Head)"); //add to head 
        deque.offer("Element 5 (Tail)"); //adds an element to the tail and returns boolean on success
        deque.offerFirst("Element 6 (Head)"); //adds an element to the head and returns boolean on success
        deque.offerLast("Element 7 (Tail)");  //Adds an interator to the tail and returns boolean on success
  
        System.out.println(deque + "\n"); 
  
        // Iterate through the queue elements. 
        System.out.println("Standard Iterator"); 
        Iterator iterator = deque.iterator(); 
        while (iterator.hasNext()) 
            System.out.println("\t" + iterator.next()); 
  
  
        // Reverse order iterator 
        Iterator reverse = deque.descendingIterator(); 
        System.out.println("Reverse Iterator"); 
        while (reverse.hasNext()) 
            System.out.println("\t" + reverse.next()); 
  
        // Peek returns the head, without deleting 
        // it from the deque 
        System.out.println("Peek " + deque.peek()); 
        System.out.println("After peek: " + deque); 
  
        // Pop returns the head, and removes it from 
        // the deque 
        System.out.println("Pop " + deque.pop()); 
        System.out.println("After pop: " + deque); 
  
        // We can check if a specific element exists 
        // in the deque 
        System.out.println("Contains element 3: " + 
                        deque.contains("Element 3 (Tail)")); 
  
        // We can remove the first / last element. 
        deque.removeFirst(); 
        deque.removeLast(); 
        System.out.println("Deque after removing " + 
                            "first and last: " + deque); 
        
       
  
    } 
    
}
