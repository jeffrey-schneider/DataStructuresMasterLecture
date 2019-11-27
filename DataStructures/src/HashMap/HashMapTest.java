/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

/**
 *
 * @author JCSchneider
 */
public class HashMapTest {
    public static void main(String[] args) {
       HashMapChain<Integer,String> chain = new HashMapChain<>();
       
       chain.put(1,"Jeff");
       
        System.out.println(chain.size());
        for (int i = 0; i < chain.size(); i++) {
            System.out.println(chain.get(i));
        }
    }
    
}
