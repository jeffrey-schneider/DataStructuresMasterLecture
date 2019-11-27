/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author JCSchneider
 */
public class ListHomework {

    public static void main(String[] args) throws IOException {
        
        SingleLinkedList<Integer> MyList = new SingleLinkedList<>();
        
        Path source = Paths.get("G:\\ChattState\\Courses\\SharedFiles\\IntegerLists\\1Kints.txt");
        try( Scanner scanner = new Scanner(source)){
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                MyList.add(Integer.parseInt(scanner.next().trim()));
            }         
            scanner.close();
        }
        
        System.out.println("Size: " + MyList.getSize());
        System.out.println("Is number 3716 in the object? " + MyList.searchFor(3716));
        System.out.println("Is number 324110 in the object? " + MyList.searchFor(324110));
        System.out.println("Is number 5 in the object? " + MyList.searchFor(5));
        System.out.println("998473?" + MyList.searchFor(998473));
        
        ElementsStatistics(MyList);
    }

    private static void ElementsStatistics(SingleLinkedList<Integer> MyList) {
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        ArrayList<Integer> oddList = new ArrayList<Integer>();        
        
        int buffer;
        int evenBuffer = 0;
        int oddBuffer = 0;
        int bufferTotal = 0;
        int maxLargest = Integer.MIN_VALUE;
        int minLargest = Integer.MAX_VALUE;
        
            System.out.println("Even");
            
            for (int i = 0; i < MyList.getSize(); i++) {
                buffer = MyList.get(i);
                
                bufferTotal += buffer;
                if (buffer %2 == 0) {
                    evenList.add(buffer);  
                    evenBuffer += buffer;
                }else{
                    oddList.add(buffer);
                    oddBuffer += buffer;
                }
                
                if(buffer > maxLargest){
                    maxLargest = buffer;
                }
                if(buffer < minLargest){
                    minLargest = buffer;
                }
            }
            
            System.out.println("Even Max: " + Collections.max(evenList));
            System.out.println("Even Min: " + Collections.min(evenList));
            System.out.println("Even Average: " + evenBuffer/evenList.size());
            
            System.out.println("Odd Max: " + Collections.max(oddList));
            System.out.println("Odd Min: " + Collections.min(oddList));
            System.out.println("Odd Average: " + oddBuffer/oddList.size());
            
            System.out.println("Max: " + maxLargest);
            System.out.println("Min: " + minLargest);
            System.out.println("Average: " + bufferTotal/MyList.getSize());
            
            
            
            
        
    }

   
    
    
    
    

   

    
}
