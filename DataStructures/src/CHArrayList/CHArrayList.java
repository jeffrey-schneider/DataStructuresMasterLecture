/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHArrayList;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author JEFFREY.SCHNEIDER
 */
public class CHArrayList<E> implements Iterable<E> {
        public static int timesDoubled = 1;

    //Default initial capacity
    public static final int INITIAL_CAPACITY = 10;
    
    /** Underlying data array */
    private E[] theData;
    
    /** the current size */
    private int size = 0;
    
    /** The current capacity */
    private int capacity = 0;
    
    /** The constructor */
    public CHArrayList(){
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }
    
    /**
     * 
     * @param anEntry
     * @return 
     */
    public boolean add(E anEntry){
        if(size == capacity){
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * 
     * @param index
     * @param anEntry 
     */
    public void add(int index, E anEntry){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if( size == capacity){
            reallocate();
        }
        //Shift data in elements from index to size -1 
        for(int i = size; i > index; i--){
            theData[i] = theData[i-1];
        }
        //insert the new item
        theData[index] = anEntry;
        size++; 
    }
    
    //Set inserts the new item at the specified index and returns the value
    // that was previously stored at that index
    /**
     * 
     * @param index
     * @param newValue
     * @return 
     */
    public E set(int index, E newValue){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;        
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }
    
    
    //Double array to spread out the cost of copying
    private void reallocate(){
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
        timesDoubled++;
        System.out.println("Doubled: " + timesDoubled + " new size = " + capacity);               
    }
   
    /**
     * Print entire list
     */
   public void printAll(){
       System.out.println("------------------");
       for(int i =0; i<size; i++){
           System.out.print("| " + i + " |");
           System.out.println(theData[i] +" |");           
       }
       System.out.println("------------------");
   }
    
    /**
     * 
     * @param index
     * @return 
     * 
     * 
     */
    //To remove an  item, the items that follow it must be moved forward to close up
    // the space. The item removed is returned as the method result.
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for(int i = index +1; i < size; i++){
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }
    
    /**
     * 
     * @param startIndex
     * @param endIndex
     * @return 
     */
    // Remove a range of elements
    public boolean removeRange(int startIndex, int endIndex){
        boolean status = false;
        if (startIndex < 0 || startIndex >= size) {
            throw new ArrayIndexOutOfBoundsException(startIndex);
        }else if (endIndex < 0 || endIndex >= size) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        if (endIndex < startIndex) {
            int buffer = endIndex;
            endIndex = startIndex;
            startIndex = buffer;
        }
        int counter = 0;
        for(int i = startIndex; i <= endIndex; i++){
            theData[i] = theData[endIndex + counter];  //<<<Changed from last time.
            status = true;
            --size;
            counter++;
        }
        
        return status;
    }
    
     public void clear() {
        this.removeRange(0, length()-1);
    }
    
    /**
     * 
     * @return 
     */
    //is the list empty?
    public boolean isEmpty(){
        if(size ==0){
            return true;
        }
        return false;
    }
    
    
    public boolean contains(E obj){
        //boolean contains = false;
        if(!(obj == null)){
            if(!(obj == this)){
                for(int i = 0; i < size; i++){
                    if(theData[i].equals(obj)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    public int length(){
        return size;
    }
    
    
    @Override
    public Iterator iterator(){
        return new ArrayIterator();
    }
    
    public boolean hasNext(){
        return size > 0;
    }
    
    public E next(){
        return theData[--size];
    }
    private class ArrayIterator implements Iterator<E>{
        private int i = size;
        @Override
        public boolean hasNext(){
            return i>0;
        }
        
        @Override
        public E next(){
            return theData[--i];
        }
    }
}
