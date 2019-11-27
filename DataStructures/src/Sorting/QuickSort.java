/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
From: http://cs.boisestate.edu/~cs221/examples/searching_sorting/QuickSort3.java
 */
package Sorting;

/**
 *
 * @author JCSchneider
 */
public class QuickSort<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void sort(T[] table){
        //sort the whole table
        quickSort(table, 0, table.length -1);
    }
    
    private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last){
        if(first < last){ // there is data to be sorted.
            //Partition the table
            int pivIndex = partition(table, first, last);
            //Sort the left half
            quickSort(table, first, pivIndex - 1);
            // Sort the right half
            quickSort(table, pivIndex + 1, last);
        }
    }
    
    
    /**
     * Partition the table so that values from first to pivIndex
     * are less than or equal to the pivot value, and values from
     * pivIndex to last are greater than the pivot value.
     * @param <T>
     * @param table     The table to be partitioned
     * @param first     The index of the low bound.
     * @param last      The index of the high bound.
     * @return          The location of the pivot value.
     */
    private static <T extends Comparable<T>> int partition(T[] table, int first, int last){
        //Select the first item as the pivot value
        T pivot = table[first];
        int up = first;
        int down  = last;
        do{
            /* Invariant:
            All items in table[first ... up-1] <= pivot
            All items in table[down + 1... last} > pivot
            */
            while((up < last) && (pivot.compareTo(table[up])>= 0)){
                    up++;
            }
            //assert: up equals last or table[up] > pivot
            while(pivot.compareTo(table[down]) < 0){
                down--;
            }
            //assert: down equals first or table[down] <= pivot
            if(up<down){  // if up is to the left of down.
                //Exchange table[up] and table[down]
                swap(table, up, down);
            }
        }while(up<down);
        //Exchange table[first] and table[down] thus putting the pivot value where it belongs
        swap(table, first, down);
        //Return the index of the pivot value.
        return  down;
    }
    
    
    
    
    private static <T extends Comparable<T>> void swap(T[] table, int i, int j){
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
}
