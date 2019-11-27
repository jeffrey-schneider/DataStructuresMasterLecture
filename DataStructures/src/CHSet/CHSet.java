/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * https://algs4.cs.princeton.edu/35applications/SET.java.html
 */
package CHSet;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 *
 * @author JCSchneider
 */
public class CHSet<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

       
     /**
     * Initializes a new set that is an independent copy of the specified set.
     *
     * @param x the set to copy
     */
    public CHSet(CHSet<Key> x) {
        set = new TreeSet<Key>(x.set);
    }

    public CHSet() {
        set = new TreeSet<>();
    }

    /** 
     * Adds the key to this set
     */
    public void add(Key key){
        if(key == null) throw new IllegalArgumentException("Called add() with a null key.");
        set.add(key);
    }
    
    /** 
     * Returns true if this set contains the given key
     */
    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException("Called add() with a null key.");
        return set.contains(key);
    }
    
    /**
     * Removes the specified key from this set
     */
    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("Called delete() with a null key.");
        set.remove(key);
    }
    
    /**
     * Returns the number of keys in this set.
     */
    public int size(){
        return set.size();
    }
    
    /**
     * Returns true if set is empty
     */
    public boolean isEmpty(){
        return size() == 0;
    }
    
     /**
     * Returns all of the keys in this set, as an iterator.
     * To iterate over all of the keys in a set named {@code set}, use the
     * foreach notation: {@code for (Key key : set)}.
     *
     * @return an iterator to all of the keys in this set
     */
    @Override
    public Iterator<Key> iterator() {
        return set.iterator();
    }
    
    /**
     * Returns the largest key in this set
     */
    public Key max(){
        if(isEmpty()) throw new NoSuchElementException("Called max() on an empty set.");
        return set.last();
    }
    
    /**
     * Returns the smallest key in this set
     */
    public Key min(){
        if(isEmpty()) throw new NoSuchElementException("Called max() on an empty set.");
        return set.first();        
    }
    
    
 /**
     * Returns the smallest key in this set greater than or equal to {@code key}.
     *
     * @param  key the key
     * @return the smallest key in this set greater than or equal to {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @throws NoSuchElementException if there is no such key
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("called ceiling() with a null key");
        Key k = set.ceiling(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    /**
     * Returns the largest key in this set less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in this set table less than or equal to {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @throws NoSuchElementException if there is no such key
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("called floor() with a null key");
        Key k = set.floor(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }
    
    
     /**
     * Returns the union of this set and that set.
     *
     * @param  that the other set
     * @return the union of this set and that set
     * @throws IllegalArgumentException if {@code that} is {@code null}
     */
    public CHSet<Key> union(CHSet<Key> that) {
        if (that == null) throw new IllegalArgumentException("called union() with a null argument");
        CHSet<Key> c = new CHSet<Key>();
        for (Key x : this) {
            c.add(x);
        }
        for (Key x : that) {
            c.add(x);
        }
        return c;
    }
    
    /**
     * Returns the intersection of this set and that set.
     *
     * @param  that the other set
     * @return the intersection of this set and that set
     * @throws IllegalArgumentException if {@code that} is {@code null}
     */
    public CHSet<Key> intersects(CHSet<Key> that) {
        if (that == null) throw new IllegalArgumentException("called intersects() with a null argument");
        CHSet<Key> c = new CHSet<Key>();
        if (this.size() < that.size()) {
            for (Key x : this) {
                if (that.contains(x)) c.add(x);
            }
        }
        else {
            for (Key x : that) {
                if (this.contains(x)) c.add(x);
            }
        }
        return c;
    }

    /**       
     * Compares this set to the specified set.
     * <p>
     * Note that this method declares two empty sets to be equal
     * even if they are parameterized by different generic types.
     * This is consistent with the behavior of {@code equals()} 
     * within Java's Collections framework.
     *       
     * @param  other the other set
     * @return {@code true} if this set equals {@code other};
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        CHSet that = (CHSet) other;
        return this.set.equals(that.set);
    }

    /**
     * This operation is not supported because sets are mutable.
     *
     * @return does not return a value
     * @throws UnsupportedOperationException if called
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() is not supported because sets are mutable");
    }

    /**
     * Returns a string representation of this set.
     *
     * @return a string representation of this set, enclosed in curly braces,
     *         with adjacent keys separated by a comma and a space
     */
    @Override
    public String toString() {
        String s = set.toString();
        return "{ " + s.substring(1, s.length() - 1) + " }";
    }

    
    

}
