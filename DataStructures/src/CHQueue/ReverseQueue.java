/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://www.geeksforgeeks.org/reversing-a-queue-using-another-queue/

 * Reversing a Queue using another Queue
 */
package CHQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JCSchneider
 */
public class ReverseQueue {
    
    static Queue<Integer> reverse(Queue<Integer> q){
        //Size of Queue
        int s = q.size();
        
        //Second queue
        Queue<Integer> ans =new LinkedList<>();
        
        for (int i = 0; i < s; i++) {            
            //Get the last element to the front of the Queue
            for (int j = 0; j < q.size() -1; j++) {
                int x = q.peek();
                q.remove();
                q.add(x);
            }
            
            //Get the last element and  add it to the new queue
            ans.add(q.peek());
            q.remove();
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        //Insert elements
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
        q = reverse(q);
        
        
        //Print the queue
        while(!q.isEmpty()){
            System.out.println(q.peek() + " " );
            q.remove();
        }
        

        
    }
}
