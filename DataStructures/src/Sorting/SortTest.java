/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *    https://www.geeksforgeeks.org/selection-sort/
 */
package Sorting;

import static Sorting.Print.print;
import java.util.ArrayList;

/**
 *
 * @author JCSchneider
 */
public class SortTest {

    public static void main(String[] args) {
        long startTime, endTime;
        double duration;

        Integer[] intArray = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        /**
         * Bubble Sort
         */
        System.out.println("\nBubble Sort:");

        Print.print(intArray);
        BubbleSort bubbleSort = new BubbleSort();

        startTime = System.nanoTime();
        //bubbleSort.sort(intArray);
        BubbleSort.sort(intArray);
        
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;

        Print.print(intArray);
        System.out.println("Time to execute: " + duration);

        /**
         * Selection Sort
         */
        Integer[] intArray2 = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        System.out.println("\nSelection Sort");
        SelectionSort selectionSort = new SelectionSort();
        Print.print(intArray2);
        startTime = System.nanoTime();
        selectionSort.sort(intArray2);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        Print.print(intArray2);
        System.out.println("Time to execute: " + duration);

        
        /**
         * Insertion sort
         */
        System.out.println("\nInsertion Sort");
        InsertionSort insertionSort = new InsertionSort();
        Integer[] intArray3 = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        Print.print(intArray3);

        startTime = System.nanoTime();
        selectionSort.sort(intArray3);
        endTime = System.nanoTime();

        duration = (endTime - startTime) / 1000000.0;
        Print.print(intArray3);
        System.out.println("Time to execute: " + duration);

        //Shell sort
        //System.out.println("\nShell Sort");
        //ShellSort shellSort = new ShellSort();
//
        //int[] intArray4 = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        //print(intArray4);
        //
        //System.out.println("");
        //startTime = System.nanoTime();
        ////shellSort.sort(intArray4);
        //shellSort.
        //endTime = System.nanoTime();
        //duration = (endTime - startTime) / 1000000.0;
        //printArray(intArray4);
        //for (int i = 0; i < intArray4.length; i++) {
        //    System.out.print(intArray4[i] + " " );
        //}
        //System.out.println("");
        //System.out.println("Time to execute: " + duration);

        
        System.out.println("\nMerge Sort");
        Integer[] intArray5 = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        MergeSort mergeSort = new MergeSort();        
        /**
         * Merge sort
         */
        
        //for (int i = 0; i < intArray5.length; i++) {
        //    System.out.print(intArray5[i] + "  " );
        //}
        //
        //System.out.println("");
        Print.print(intArray5);
        startTime = System.nanoTime();
        mergeSort.sort(intArray5);
        //MergeSort.sort(intArray5);
        endTime = System.nanoTime();

        duration = (endTime - startTime) / 1000000.0;
        //for (int i = 0; i < intArray5.length; i++) {
        //    System.out.print(intArray5[i] + " " );
        //}
        //System.out.println("");
        System.out.println("Time to execute: " + duration);

        System.out.println("\nQuick Sort");

        Integer[] intArray6 = {40, 55, 63, 17, 22, 68, 89, 97, 89};
        /**
         * Quick sort
         */
        for (int i = 0; i < intArray6.length; i++) {
            System.out.print(intArray6[i] + " " );
        }
        System.out.println("");

        startTime = System.nanoTime();
        QuickSort.sort(intArray6);
        endTime = System.nanoTime();

        duration = (endTime - startTime) / 1000000.0;
           
        for (int i = 0; i < intArray6.length; i++) {
            System.out.print(intArray6[i] + " " );
        }
        System.out.println("");
        System.out.println("Time to execute: " + duration);
            
        }

     

    }

