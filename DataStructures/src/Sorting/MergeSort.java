/**
    Implements the recursive merge sort algorithm. In this version, copies
    * of the subtables are made, sorted and them merged.
*/
package Sorting;

import Sorting.Merge.*;
import java.util.Arrays;
/**
 *
 * @author JCSchneider
 */
public class MergeSort {
    
    /**
     * Sort the array using the merge sort algorithm.
     * @pre:    table       contains Comparable objects.
     * @post:   table       is sorted
     * @param <T>
     * @param table         the array to be sorted. 
     */
    
    public static <T extends Comparable<T>> void sort(T[] table){
        //sort the whole table
        MergeSort(table);
    }
    
    public static <T extends Comparable<T>> void MergeSort(T[] table){
        //A table with one element is sorted already
        if(table.length > 1){
            //Split the table into halves
            int halfSize = table.length/ 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
            //System.arraycopy(table, 0, leftTable, 0, halfSize);
            //System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
            leftTable = Arrays.copyOf(table, halfSize);
            rightTable = Arrays.copyOfRange(table, halfSize, table.length);
            
            
            //Sort the halves
            sort(leftTable);
            sort(rightTable);
            
            //Merge the halves
            Merge.merge(table, leftTable, rightTable);
           
        }
    }

    void sort(int[] intArray5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
