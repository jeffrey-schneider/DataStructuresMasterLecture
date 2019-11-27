/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

/**
 *
 * @author jeffrey.schneider
 */
public interface HashMap<K, V> {
    public  V get(Object key);
    public boolean isEmpty();
    public V put(K key, V value);
    public V remove(Object key);
    public int size();
    
}
