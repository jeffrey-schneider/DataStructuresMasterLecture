/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

import java.util.LinkedList;

/**
 *
 * @author jeffrey.schneider
 */
public class HashMapChain<K,V> implements HashMap<K,V> {
    /** the table*/
    private LinkedList<Entry <K,V>>[] table;
    /** the number of keys */
    private int numKeys;
    /** the capacity */
    private static final int CAPACITY = 101;
    /** the maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    
    //Constructor
    public HashMapChain(){
        table = new LinkedList[CAPACITY];
    }
    
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index <0)
            index += table.length;
        if(table[index] == null)
            return null;  //key is not in table
        
        //Search the list at table[index] to find the key.
        for(Entry<K,V> nextItem: table[index]){
            if(nextItem.key.equals(key))
                return nextItem.value;
        }
        
        //assert; key is not in the table;
        return null;
    }
    
    

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null){
            //create a new linked list at table[index]
            table[index] = new LinkedList<Entry<K, V>>();
        }
        
        //Search the list at table[index] to find the key.
        for(Entry<K,V> nextItem: table[index]){
            //if the search is successful, replace the old value.
            if(nextItem.key.equals(key)){
                //Replace value for this key
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }
        
        //assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<K, V>(key,value));
        numKeys++;
//        if(numKeys > (LOAD_THRESHOLD * table.length))
//            rehash();
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return numKeys;
    }
    
    public void rehash(){
    
    }
 
    
    //Inner class
    public static class Entry<K,V> {
    /** The key */
    private K key;
    /** the value */
    private V value;
    
    /** Creates a new key-value pair.
     * @param key The key
     * @param value The value
     */
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
    
    /**Retrieves the key
     * @return The key
     */
    public K getKey(){
        return key;
    }

    /**Retrieves the value
     * @return The value;
     */
    public V getValue(){
        return value;
    }
    
    /** Sets the value
     * @param val The new value
     * @return The old value
     */
    public V setValue(V val){
        V oldVal = value;
        value = val;
        return oldVal;
    }
}
}
