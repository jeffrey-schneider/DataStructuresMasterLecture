/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHBST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

    

/**
 *
 * @author JCSchneider
 */
public class LargeCHBSTTest {
    public static void main(String[] args) throws FileNotFoundException {
        
        CHBSTGeneric<Integer> b = new CHBSTGeneric<Integer>();
        
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
                    Logger.getLogger(LargeCHBSTTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                lineCounter++;
            }
        } catch (IOException ex) {
            Logger.getLogger(LargeCHBSTTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Lines: " + lineCounter);
        
        
        b.add(intArray[0]);
        //for (int i = 1; i < intArray.length; i++) {
        //    b.add(intArray[i]);
        //}
        
        
        System.out.println("Leaf Nodes:");
        b.printLeafNodes();

        System.out.print("\nPre order: ");
        b.preOrderTraversal();

        System.out.print("\nIn order: ");        
        b.inOrderTraversal();
        
        System.out.print("\nPost order: ");
        b.postOrderTraversal();
        
        System.out.print("\nBreadth first: ");
        b.levelOrderTraversal();
        
        System.out.print("\nDepth first: ");
        b.printDepthFirst();
        
        System.out.print("\nfindMin: ");
        System.out.println(b.findMin());        
        
        System.out.print("\nfindMax: ");
        System.out.println(b.findMax());        
    }
    
}
