/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.ArrayList;

/**
 *
 * @author jeffrey.schneider
 */
public class Print<T> {  
    
    static <T> void print(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " " );
        }
        System.out.println("");
    }
    
}
