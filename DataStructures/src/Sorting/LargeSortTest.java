/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
E:\ChattState\Courses\SharedFiles\IntegerLists
 */
package Sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JCSchneider
 */
public class LargeSortTest<T> {

    public static boolean GENERIC_ITERATIVE_QUICKSORT_DEBUG_MODE = true;
    
    public static void main(String[] args) throws FileNotFoundException {

        // 1Kints, 2Kints, 4Kints, 8Kints, 16Kints, 32Kints, 1Mints
        String driveName = "G:";
        
        String dirName = "\\ChattState\\Courses\\SharedFiles\\IntegerLists\\";
        String fileName = "1Kints.txt";
        File file = new File(driveName + dirName + fileName);

        int lineCounter = 0;
        int arrayStop = 0;
        switch(fileName){
            case "1Kints.txt":
                arrayStop = 1000;
                break;
            case "2Kints.txt":
                arrayStop = 2000;
                break;
            case "4Kints.txt":
                arrayStop = 4000;
                break;
            case "8Kints.txt":
                arrayStop = 8000;
                break;
            case "16Kints.txt":
                arrayStop = 16000;
                break;
            case "32Kints.txt":
                arrayStop = 32000;
                break;
            case "1Mints.txt":
                arrayStop = 1000000;
                break;
            default:
                throw new IllegalArgumentException("Can't find the file. Review code.");
        }

        Integer[] masterArray = new Integer[arrayStop];

        Integer[] intArray = Arrays.copyOf(masterArray, masterArray.length);
        long startTime, endTime;
        double duration;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        
        
        try {
            while ((st = br.readLine()) != null) {
                //System.out.println(st);
                try {                    
                    masterArray[lineCounter] = Integer.parseInt(st.replaceAll("\\s", ""), 10 );  //replaceAll removes the spaces from the file
                } catch (Exception ex) {
                    Logger.getLogger(LargeSortTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                lineCounter++;
            }
        } catch (IOException ex) {
            Logger.getLogger(LargeSortTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Lines: " + lineCounter);
        
        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);  
        if(masterArray.length <= 32000){
            runBubbleSort(intArray);
            for (int i = 0; i < 10; i++) System.out.println(intArray[i]);
        }
        
        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);        
        if(masterArray.length <= 32000)
        runSelectionSort(intArray);
        for (int i = 0; i < 10; i++) System.out.println(intArray[i]);
        

        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);
        if(masterArray.length <= 32000){
            runInsertionSort(masterArray);
            for (int i = 0; i < 10; i++) System.out.println(intArray[i]);
        }
        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);        
        
        runMergeSort(masterArray);
        for (int i = 0; i < 10; i++) System.out.println(intArray[i]);
        
        
        //
        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);        
       if(masterArray.length <= 16000){
            runQuickSort(masterArray);
            for (int i = 0; i < 10; i++) System.out.println(intArray[i]);
       }
       
       
       intArray = null;
       intArray = Arrays.copyOf(masterArray, masterArray.length);
       if(!GENERIC_ITERATIVE_QUICKSORT_DEBUG_MODE)  //if we are not in debug mode.  Generic Iterative Quicksort is broken for now.
            runIterativeQuickSort(masterArray);
       
       
       
        intArray = null;
        intArray = Arrays.copyOf(masterArray, masterArray.length);        
        runShellSort(masterArray);
        for (int i = 0; i < 10; i++) System.out.println(intArray[i]);      
    }

    
    
    
    protected static void runShellSort(Integer[] intArray) {
        //Integer[] intArray;
        long startTime;
        long endTime;
        double duration;
        //intArray = null;
        //intArray = Arrays.copyOf(masterArray, masterArray.length);        
        //Shell sort
        System.out.println("\nShell Sort");
        ShellSort shellSort = new ShellSort();
        startTime = System.nanoTime();
        shellSort.sort(intArray);
        endTime = System.nanoTime();
        //Print.print(intArray);
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
    }

    protected static void runQuickSort(Integer[] intArray) {
        //Integer[] intArray;
        long startTime;
        long endTime;
        double duration;
        //intArray = null;
        //intArray = Arrays.copyOf(masterArray, masterArray.length);
        System.out.println("\nQuick Sort");
        /**
         * Quick sort
         */
        startTime = System.nanoTime();
        QuickSort.sort(intArray);
        endTime = System.nanoTime();
        //Print.print(intArray);
        duration = (endTime - startTime) / 1000000.0;
        System.out.println("Time to execute: " + duration);
    }

    protected static void runMergeSort(Integer[] intArray) {
        //Integer[] intArray;
        long startTime;
        long endTime;
        double duration;
        //intArray = null;
        //intArray = Arrays.copyOf(masterArray, masterArray.length);
        System.out.println("\nMerge Sort");
        MergeSort mergeSort = new MergeSort();
        //Print.print(intArray5);
        startTime = System.nanoTime();
        mergeSort.sort(intArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        //Print.print(intArray);
        System.out.println("Time to execute: " + duration);
    }

    protected static void runInsertionSort(Integer[] intArray) {        
        long startTime;
        long endTime;
        double duration;
        //intArray = null;
        //intArray = Arrays.copyOf(masterArray, masterArray.length);
        System.out.println("\nInsertion Sort");
        InsertionSort insertionSort = new InsertionSort();
        startTime = System.nanoTime();
        insertionSort.sort(intArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        //Print.print(intArray);
        System.out.println("Time to execute: " + duration);
    }

    protected static void runSelectionSort(Integer[] intArray) {
        long startTime;
        long endTime;
        double duration;
        System.out.println("\nSelection Sort");
        SelectionSort selectionSort = new SelectionSort();
        startTime = System.nanoTime();
        selectionSort.sort(intArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        //Print.print(intArray);
        System.out.println("Time to execute: " + duration);
    }

    protected static void runBubbleSort(Integer[] intArray) {
        long startTime;
        long endTime;
        double duration;
        //Bubble Sort
        System.out.println("\nBubble Sort:");
        BubbleSort bubbleSort = new BubbleSort();
        startTime = System.nanoTime();
        BubbleSort.sort(intArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;
        //Print.print(intArray);
        System.out.println("Time: " + duration);
    }

    private static void runIterativeQuickSort(Integer[] masterArray) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //    //Integer[] intArray;
    //    long startTime;
    //    long endTime;
    //    double duration;
    //    //intArray = null;
    //    //intArray = Arrays.copyOf(masterArray, masterArray.length);
    //    System.out.println("\nIterative Quick Sort");
    //    /**
    //     * Iterative Quick sort
    //     */
    //    startTime = System.nanoTime();
    //    IterativeQuickSort iterativeQuickSort = new IterativeQuickSort(); 
    //    iterativeQuickSort.sort(masterArray, 0, masterArray.length);
    //    endTime = System.nanoTime();
    //    //Print.print(intArray);
    //    duration = (endTime - startTime) / 1000000.0;
    //    System.out.println("Time to execute: " + duration);
    }

    


    
    
}
