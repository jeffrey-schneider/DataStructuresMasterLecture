/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import FlightApplication.CommercialFlight;

/**
 *
 * @author JEFFREY.SCHNEIDER
 */
public class ArrayTest {
    //program to test create a generic array in java
    public static void main(String[] args) {
        final int length = 5;
        
        //Create an Integer array of given length
        Array<Integer> intArray = new Array(Integer.class, length);
        
        for (int i = 0; i < length; i++) {
            intArray.set(i, i+1);
        }
        System.out.println(intArray);
        
        
    }
}
