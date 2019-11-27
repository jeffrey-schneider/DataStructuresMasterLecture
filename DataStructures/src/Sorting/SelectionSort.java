/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author JCSchneider
 */
public class SelectionSort {
   
    public static <T extends Comparable<T>> void sort(T[] table){    
    { 
        int n = table.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                //if (table[j].compareTo(table[min_idx]) > 0) 
                if (table[j].compareTo(table[min_idx]) < 0) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            T temp = table[min_idx]; 
            table[min_idx] = table[i]; 
            table[i] = temp; 
        } 
    } 
    
    }
}
