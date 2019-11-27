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
public class InsertionSort {
    public static<T extends Comparable<T>> void sort(T[] table){
        for(int nextPos = 1; nextPos < table.length; nextPos++){
            insert(table, nextPos);
        }
    }
    
    private static<T extends Comparable<T>> void insert(T[] table, int nextPos){
        T nextVal = table[nextPos];
        
        while(nextPos > 0 && nextVal.compareTo(table[nextPos-1]) < 0){
            table[nextPos] = table[nextPos -1];
            nextPos--;
        }
        //Insert nextVal at nextPos.
        table[nextPos] = nextVal;
    }
    //void sort(int[] arr){
    //    for(int i = 1; i < arr.length; i++){
    //        int index = arr[i]; int j=i;
    //        while(j>0 && arr[j-1] > index){
    //            arr[j] = arr[j-1];
    //            j--;
    //        }
    //        arr[j] = index;
    //    }
    //}
    
}
