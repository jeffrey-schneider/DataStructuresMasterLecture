/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Original non-generic source from https://www.geeksforgeeks.org/java-program-for-iterative-quick-sort/
 */
package Sorting;

/**
 *
 * @author JCSchneider
 */
public class IterativeQuickSort <T extends Comparable<T>> {
    
public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) 
    { 
        T t = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = t; 
    } 
  
    /* This function is same in both iterative and 
       recursive*/
private static <T extends Comparable<T>>  int partition(T[] arr, int l, int h) 
    { 
        T x = arr[h]; 
        int i = (l - 1); 
  
        for (int j = l; j <= h - 1; j++) { 
            if (arr[j].compareTo(x) < 0) { 
                i++; 
                // swap arr[i] and arr[j] 
                swap(arr, i, j); 
            } 
        } 
        // swap arr[i+1] and arr[h] 
        swap(arr, i + 1, h); 
        return (i + 1); 
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    public static<T extends Comparable<T>> void sort(int[] arr, int l, int h) 
    { 
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //// create auxiliary stack 
        //int[] stack = new int[h - l + 1]; 
  //
        //// initialize top of stack 
        //int top = -1; 
  //
        //// push initial values in the stack 
        //stack[++top] = l; 
        //stack[++top] = h; 
  //
        //// keep popping elements until stack is not empty 
        //while (top >= 0) { 
        //    // pop h and l 
        //    h = stack[top--]; 
        //    l = stack[top--]; 
  //
        //    // set pivot element at it's proper position 
        //    int p = partition(arr, l, h); 
  //
        //    // If there are elements on left side of pivot, 
        //    // then push left side to stack 
        //    if (p - 1 > l) { 
        //        stack[++top] = l; 
        //        stack[++top] = p - 1; 
        //    } 
  //
        //    // If there are elements on right side of pivot, 
        //    // then push right side to stack 
        //    if (p + 1 < h) { 
        //        stack[++top] = p + 1; 
        //        stack[++top] = h; 
        //    } 
        //} 
    } 
  
    // A utility function to print contents of arr 
    void printArr(T[] arr, int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        //Create an Integer array of given length
        IterativeQuickSort ob = new IterativeQuickSort(); 
        Integer arr[] = { 63, 4, 3, 5, 2, 1, 3, 2, 3 }; 
        //ob.sort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 
/*This code is contributed by Rajat Mishra */
