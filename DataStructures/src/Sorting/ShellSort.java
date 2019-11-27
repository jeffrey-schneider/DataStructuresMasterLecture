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
/**
     * Implements the Shell sort algorithm.
     */
public class ShellSort<T> {
    
    /**
     * @pre     table   contains Comparable objects
     * @post    table   is sorted
     * @param <T>
     * @param table 
     */
    public static <T extends Comparable<T>> void sort(T[] table){

        //gap between adjacent elements
        int gap = table.length/2;
        while(gap>0){
            for (int nextPos = gap; nextPos < table.length; nextPos++) {
                //Insert element at nextPos in its subarray
                insert(table, nextPos, gap);
            }// end for
            //Reset gap for next pass.
            if(gap==2){
                gap = 1;
            }else{
                gap = (int) (gap/2.2);
            }
        }//end shile
    }//End Sort
    
    private static<T extends Comparable<T>> void insert(T[] table, int nextPos, int gap){
        T nextVal = table[nextPos];
        //Element to insert
        //Shift all values > nextVal in subarray down by gap
        while((nextPos > gap-1) && (nextVal.compareTo(table[nextPos - gap])<0)){
            //first element not shifted
            table[nextPos] = table[nextPos - gap];
            //Shift down
            nextPos -= gap;
            //Check next position in subarray.
        }
        table[nextPos] = nextVal;
        //Insert nextVal.
            
    }
}
