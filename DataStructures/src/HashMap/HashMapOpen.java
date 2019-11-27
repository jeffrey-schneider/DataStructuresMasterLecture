/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

* Hash map using open addressing
 */
package HashMap;

/**
 *
 * @author jeffrey.schneider
 */
public class HashMapOpen<K,V> implements HashMap<K,V> {
    //Data fields
    private Entry<K,V>[] table;
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K,V> DELETED =
            new Entry<K,V>(null,null);
    
    //Constructor
    public HashMapOpen(){
        table = new Entry[START_CAPACITY];
        
    }

   

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
    
    /** 
     * Finds either the target key or the first empty slot in the 
     * search chain using linear probing.
     * pre: the table is not full.
     * @param key The key of the target object
     * @return The position of the target or the first empty slot if 
     *      the target is not in the table.
     */
    
    private int find(Object key){
        //Calculate the starting index
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;  //make it positive
        
        //Increment index until an empty slot is reached or
        // the key is found.
        while((table[index] != null) 
                && (!key.equals(table[index].key))){
            index++;
            //Check for wraparound
            if(index >= table.length)
                index = 0;   //wrap around
        }
        return index;
    }
    
    @Override
    public V get(Object key) {
        //Find the first table element that is empty
        // or the table element that contains the key
        int index = find(key);
        
        //If the search is successful, return the value.
        if(table[index] != null)
            return table[index].value;
        else
            return null; //key not found
    }

    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    /**
     * Post: This key-value pair is inserted in the table and numKeys is incremented.
     *      if the key is already in the table, its value is changed to the argument
     *      value and numKeys is not changed. If the LOAD_THRESHOLD is exceeded,
     *      the table is expanded.
     * @param key   the key of item being inserted
     * @param value The value for this key
     * @return Old value associated with this key if found: otherwise, null
     */
    @Override
    public V put(K key, V value) {
       //find the first table element that is empty
       // or the table element that contains the key.
       int index = find(key);
       
       // If an empty element was found, insert new entry.
       if(table[index] == null){
           table[index] = new Entry<K,V>(key, value);
           numKeys++;
           //Check whether rehash is needed.
           double loadFactor = (double)(numKeys + numDeletes)/table.length;
           if(loadFactor > LOAD_THRESHOLD)
               rehash();
           return null;
       }
       
       //assert: table element that contains the key was found
       // Replace value for this key.
       V oldVal = table[index].value;
       table[index].value = value;
       return oldVal;
    }
    
    /** Expands table size when loadFactor exceeds LOAD_THREASHOLD
     * post: The size of the table is doubled and is an odd integer.
     *  Each non-deleted entry from the original table is
     *  reinserted into the expanded table.
     * The value of numKeys is reset to the number of items
     * actually inserted; numDeletes is reset to 0.
     */
     private void rehash() {
        //Save a reference to oldTable.
        Entry<K, V>[] oldTable = table;
        //Double cpapacity of this table.
        table = new Entry[2 * oldTable.length +1];
        
        //Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for(int i=0; i < oldTable.length; i++){
            if((oldTable[i] != null) && (oldTable[i] != DELETED)){
                //insert entry in expanded table
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return numKeys;
    }
    
}
