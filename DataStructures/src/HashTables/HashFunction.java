/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTables;

import java.util.Arrays;

/**
 *
 * @author jeffrey.schneider
 * source: www.newthinktank.com/2013/03/java-hash-table
 * 
 * If we think of a Hash Table as an array
 * then a hash function is used to generate
 * a unique key for every item in the array.
 * The position the item goes in is known
 * as the slot. Hashing doesn't work very well
 * in situations in which duplicate data
 * is stored. Also, it isn't good for searching
 * for anything except a specific key.
 * However a Hash Table is a data structure that
 * offers fast insertion and searching capabilities.
 */
public class HashFunction {
    static int collisions = 0;
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;
    int hashFactor = 30;      //first run of part 2
    //int hashFactor = 29;        //second run of part 2
    
    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction(30);
        
        //First part of lecture
        //Simplest hash function
        String[] elementsToAdd = { "1", "5", "17", "21", "26"};
        hashFunction.hashFunction1(elementsToAdd, hashFunction.theArray);      
        
        ////////////////////////////////////////////////////////////
        //Second part of lecture:
        //Mod hash function
        // This contains exactly 30 items to show how collisions
        // will work
        String[] elementsToAdd2 = { "100","510","170","214","268","398",
	"235","802","900","723","699","1","16","999","890",
	"725","998","978","988","990","989","984","320","321",
	"400","415","450","50","660","624" };
        
        //hashFunction.hashFunction2(elementsToAdd2, hashFunction.theArray);
        //////////////////////////////////////////////////////////////
        
        /////////////////////////////////////////////////////////
        //Third part of lecture:
        //Locate the value 660 in the Hash Table
//        hashFunction.findKey("660");
        /////////////////////////////////////////////////////////        
        hashFunction.displayTheHash();
        hashFunction.findKey("990");
                
    }
    
    //First part of the lecture
    HashFunction(int size){
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, " ");
        
    }
    
    //First part of the lecture
    public void displayTheHash() {
		int increment = 0;

                //3 sections for output
                // 10 columns each
                for (int m = 0; m < 3; m++) {
			increment += 10;
                        ///////////////////
                        //Top line
                        ///////////////////
			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();
			for (int n = increment - 10; n < increment; n++) {
				System.out.format("| %3s " + " ", n);
			}

			System.out.println("|");
                        
                        ////////////////////
                        //Middle line
                        ////////////////////
			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
                                if (theArray[n].equals(" "))
					System.out.print("|      ");
				else
					System.out.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

                        /////////////
                        //Bottom Line
                        /////////////
			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();
		}

	}
    
    
    ////////////////////////////////////////////////////////////////////////
    //first part of lecture
    //Simple hash function that puts values in the same
    //index that matches their value
    // Open 
    // NOT A GOOD FUNCTION, JUST A DEMO
    public void hashFunction1(String[] stringsForArray, String[] theArray){
        for (int n = 0; n < stringsForArray.length; n++) {            
            String newElementVal = stringsForArray[n];
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }
    
    
    ////////////////////////////////////////////////////////////////////////
    //Second part of lecture
    /** Now lets say we have to hold values between 0 & 998 but
     * we never plan to have more than 30 values in all.
     * It wouldn't make sense to have a 1000 item array, so 
     * what can we do?
     * 
     * One way to fit these numbers into a 30 item array is
     * to use the mod function. All you do is take the modulus
     * of the value versus the array size.
     * 
     * The goal is to make the array big enough to avoid 
     * collisions, but not so big that we waste memory
     */
    public void hashFunction2(String[] stringsForArray, String[] theArray){
        
        for (int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];
            //Create an index to store the value in by taking
            // the modulus
            int arrayIndex = Integer.parseInt(newElementVal) % hashFactor;  //modulus guarantees we won't have an index > 30
            //for pass 2 change the hashFactor to a prime number ie 29
            System.out.println("Modulus index = " + arrayIndex + " for value " + newElementVal);
            
            //Cycle through the array until we find an empty space
            while(theArray[arrayIndex]!= " "){
                ++arrayIndex;
                ++collisions;
                System.out.println("Collision number: " + collisions + "! Try: " + arrayIndex + " Instead ");
                
                //If we get to the end of the array, go back to index 0
                arrayIndex %= arraySize;
            }
            
            theArray[arrayIndex] = newElementVal;
                
        }
    }
    
    
    /////////////////////////////////////////////////////////////////////////////
    //Third part of the lecture
    //Returns the value stored in the hash table
    public String findKey(String key){
        //find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key)%hashFactor;
        while(theArray[arrayIndexHash] != " "){
            if (theArray[arrayIndexHash] == key){
                //found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            
            //Look in the next index
            ++arrayIndexHash;
            
            //if we get to the end of the array, go back to index 0
            arrayIndexHash %= arraySize;
        }
        //Couldn't find the key
        return null;
    }
}
