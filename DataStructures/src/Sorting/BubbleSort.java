/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author jeffrey.schneider
 */
public class BubbleSort<T> {
    
    public static <T extends Comparable<T>> void sort(T[] table){    
        for (int i = (table.length -1 ); i> 0; i--) {
            for (int j = 1; j <= i; j++) {                
                if(table[j-1].compareTo(table[j])>0){
                    T temp = table[j-1];
                    table[j-1] = table[j];
                    table[j] = temp;
                }
            }
        }
    }

    

 
}
