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
public interface KWHashMap<K, V> {
    
    /**
     * Returns the value associated with the specified key, or null 
     * if the key is not present.
     * @param key The key
     * @return The value associated with key, or null.
     */
    V get(Object key);
    
    /**
     * Determine if this Map is empty.
     * @return true if there are no key mappings.
     */
    boolean isEmpty();
    
    /**
     * Associates the specified value with the specified key.
     * @param key The key
     * @param value The value
     * @return The previous value associated with the key, or
     * null if there was no mapping.
     */
    V put(K key, V value);
    
    /**
     * Removes the mapping for this key if present (optional operation).
     * @param key The key
     * @return The current value associated with the key, or
     * null if there was no mapping.
     */
    V remove(Object key);
    
}
