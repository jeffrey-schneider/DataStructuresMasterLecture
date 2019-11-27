/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KWHashMap;

/**
 *
 * @author JCSchneider
 */
public class HashTableChainTest {
    
    public static void main(String[] args) {
        HashTableChain<Integer, Integer> hash = new HashTableChain<>();

        hash.put(0, 50);
        hash.put(1, 100);
        hash.put(2,200);
        hash.put(3,300);
        hash.put(4,400);
        
        System.out.println("hash.containsKey(4)" + hash.containsKey(4));
        System.out.println("hash.containsKey(42)" + hash.containsKey(42));
        System.out.println("hash.containsValue(400)" + hash.containsValue(400));
        
        
        //for (int i = 0; i < hash.size(); i++) {
        //    System.out.println(hash.get(i).toString()); 
        //}
        
       
        for (int i = 5; i < 1000; i++) {
            hash.put(i,i*100);
        }
        for (int i = 0; i < hash.size(); i++) {
            System.out.println(" " + hash.get(i));
        }
      
        
    }
    
    
    
}
