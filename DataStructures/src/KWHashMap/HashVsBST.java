/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KWHashMap;

import CHBST.CHBSTGeneric;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author JEFFREY.SCHNEIDER
 */
public class HashVsBST {
    public static void main(String[] args) throws FileNotFoundException  {
         CHBSTGeneric<Integer> bst = new CHBSTGeneric<Integer>();
         HashTableOpen<Integer, Integer> hashOpen = new HashTableOpen<>();
         HashTableChain<Integer, Integer> hashChain = new HashTableChain<Integer,Integer>();
         long startTime, endTime;
         double duration;
         Random rand = new Random();
         int numberToAdd = 0;         

        ArrayList<Integer> ints = new ArrayList<Integer>();
        
         for (int i = 0; i < 1000000; i++) {
            ints.add(rand.nextInt());
        }
         ints.set(0, 0);
         
        System.out.println("Binary Search Tree Time to Populate");
        startTime = System.nanoTime();
        for (int i = 0; i < ints.size(); i++) {
            bst.add(ints.get(i));
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
        
        
                
        System.out.println("Open Hash Time to Populate");
        startTime = System.nanoTime();
        for (int i = 0; i < ints.size(); i++) {
            hashOpen.put(i, ints.get(i));
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
        
        
        System.out.println("Chain Hash Time to Populate");
        startTime = System.nanoTime();
        for (int i = 0; i < ints.size(); i++) {
            hashChain.put(i, ints.get(i));
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
        
        System.out.println("========SEARCHING=========================");
        
        System.out.println("Searching BST");
        startTime = System.nanoTime();
        System.out.println(bst.search(0));
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
        
        
        System.out.println("Searching Hash Open");
        startTime = System.nanoTime();
        System.out.println(hashOpen.containsValue(0));
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
         
        
        System.out.println("Searching Hash Chain");
        startTime = System.nanoTime();
        System.out.println(hashChain.containsValue(0));
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000.0;        
        System.out.println("Time to execute: " + duration);
        
         
    }
    
}
