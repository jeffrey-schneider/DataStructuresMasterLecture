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
public class Merge {

    /**
     * Merge two sequences
     * @pre     leftSequence and rightSequence are sorted.
     * @post    outputSequence is the merged result and is sorted
     * @param <T>
     * @param outputSequence    The destination
     * @param leftSequence      The left input
     * @param rightSequence     The right input
     */
    protected static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence){
        int i = 0;
        //Index into the left input sequence
        int j= 0;
        //Index into the right input sequence
        int k = 0;
        //Index into the output sequence.
        //While there is data in both input sequences
        while(i<leftSequence.length && j < rightSequence.length){
            //find the smaller and 
            //insert it into the output sequence.
            if(leftSequence[i].compareTo(rightSequence[j]) < 0){
                outputSequence[k++] = leftSequence[i++];
            }else{
                outputSequence[k++] = rightSequence[j++];
            }
                    
        }
        //assert: one of the sequences has more items to copy.
        //Copy remaining input from left sequence into the output.
        while(i< leftSequence.length){
            outputSequence[k++] = leftSequence[i++];
        }
        //copy remaining input from right sequence into output
        while(j<rightSequence.length){
            outputSequence[k++] = rightSequence[j++];
        }
    }

}
