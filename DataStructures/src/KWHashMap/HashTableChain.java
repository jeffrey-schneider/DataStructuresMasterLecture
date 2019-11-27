
package KWHashMap;


import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Hash table implementation using chaining.
 * @param <K> The key type
 * @param <V> The value type
 * @author Koffman and Wolfgang
 **/
public class HashTableChain<K, V> extends AbstractMap<K, V> implements KWHashMap<K, V> {

    /** The table */
    private LinkedList<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    // Note this is equivalent to java.util.AbstractMap.SimpleEntry
    /** Contains key-value pairs for a hash table. 
        @param <K> the key type
        @param <V> the value type
     */
    public static class Entry<K, V>  implements Map.Entry<K, V> 
    {
        /** The key */
        private final K key;
        /** The value */
        private V value;

        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Retrieves the key.
         * @return The key
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value.
         * @return The value
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Sets the value.
         * @param val The new value
         * @return The old value
         */
        @Override
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /**
         * Return a String representation of the Entry
         * @return a String representation of the Entry
         *         in the form key = value
         */
        @Override
        public String toString() {
            return key.toString() + "=" + value.toString();
        }
    }

    // Constructor
    public HashTableChain() {
        table = new LinkedList[CAPACITY];
    }
    
    // Constructor for test purposes
    HashTableChain(int capacity) {
        table = new LinkedList[capacity];
    }

    /**
     * Method get for class HashTableChain.
     * @param key The key being sought
     * @return The value associated with this key if found;
     *         otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // key is not in the table.
        }
        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            if (nextItem.getKey().equals(key)) {
                return nextItem.getValue();
            }
        }

        // assert: key is not in the table.
        return null;
    }
    
    
    
    
    /**
     * Method put for class HashTableChain.
     * @post This key-value pair is inserted in the
     *       table and numKeys is incremented. If the key is already
     *       in the table, its value is changed to the argument
     *       value and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if
     *         found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;       
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            // Create a new linked list at table[index].
            table[index] = new LinkedList<>();
        }

        // Search the list at table[index] to find the key.
        for (Entry<K, V> nextItem : table[index]) {
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) {
            rehash();
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        for (List<Entry<K, V>> cell : table) {
            if (cell != null) {
                cell.forEach(e -> sj.add(e.toString()));
            }
        }
        return sj.toString();
    }

    /** Returns the number of entries in the map 
        @return the number of entries in the map
     */
    @Override
    public int size() {
        return numKeys;
    }

    /** Returns true if empty 
        @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null; // Key not in table
        }
        Iterator<Entry<K, V>> iter = table[index].iterator();
        while (iter.hasNext()) {
            Entry<K, V> nextItem = iter.next();
            // If the search is successful, return the value.
            if (nextItem.getKey().equals(key)) {
                V returnValue = nextItem.getValue();
                iter.remove();
                numKeys--;
                return returnValue;
            }
        }
        return null; // Key not in table
    }

    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * @post the size of table is doubled and is an
     *       odd integer. Each non-deleted entry from the original
     *       table is reinserted into the expanded table.
     *       The value of numKeys is reset to the number of items
     *       actually inserted; numDeletes is reset to 0.
     */
    public void rehash() {
        //System.out.println("Rehashing! ");
        // Save a reference to oldTable
        List<Entry<K, V>>[] oldTable = table;
        // Double capacity of this table
        table = new LinkedList[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        for (List<Entry<K,V>> cell : oldTable) {
            if (cell != null) {
                cell.forEach(nextEntry -> put(nextEntry.getKey(), nextEntry.getValue()));
            }
        }
    }


    @Override
    public java.util.Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }
    
    

    /** Inner class to implement the set view. */
    private class EntrySet
            extends java.util.AbstractSet<Map.Entry<K, V>> {

        /** Return the size of the set. */
        @Override
        public int size() {
            return numKeys;
        }

        /** Return an iterator over the set. */
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new SetIterator();
        }
    }

    private class SetIterator implements Iterator<Map.Entry<K, V>> {

        int index = 0;
        Iterator<Entry<K, V>> localIterator = null;

        @Override
        public boolean hasNext() {
            if (localIterator != null) {
                if (localIterator.hasNext()) {
                    return true;
                } else {
                    localIterator = null;
                    index++;
                }
            }
            while (index < table.length
                    && table[index] == null) {
                index++;
            }
            if (index == table.length) {
                return false;
            }
            localIterator = table[index].iterator();
            return localIterator.hasNext();
        }

        @Override
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return localIterator.next();
        }

        @Override
        public void remove() {
            localIterator.remove();
            if (table[index].size() == 0) {
                table[index] = null;
            }
            numKeys--;
        }
    }
}
