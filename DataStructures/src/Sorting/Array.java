/*
 * https://www.techiedelight.com/creating-generic-array-java/

* Arrays in java contain information about their component type for
allocating memory during runtime. If the component type is not 
known at runtime, the array cannot be instantiated. Consider:
    E[] arr = new E[capacity];
This uses Generics. Generics are not present in the byte code generated
by the compiler because of type erasure in Java. This means that Type information
is erased at runtime and the new E[capacity] won't know what type needs
to be instantiated.
    We can use the Reflection Array class to create an array of a generic type
known only at runtime. We will need to explicitly pass the Type information to the
class constructor which is further being passed to the Array.newInstance().

 */
package Sorting;

import java.util.Arrays;

/**
 *
 * @author JEFFREY.SCHNEIDER
 */
public class Array<E> {
    
    private final E[] arr;
    public final int length;
    
    //constructor
    public Array(Class<E> type, int length){
        //Creates a new array with the specified type and length at runtime
        this.arr = (E[]) java.lang.reflect.Array.newInstance(type, length);
        this.length = length;
    }
    
    //Function to get element present at index i in the array
    E get(int i){
        return arr[i];
    }
    
    //Function to set a value at index i in the array
    void set(int i, E e){
        arr[i] = e;
    }
    
    public String toString(){
        return Arrays.toString(arr);
    }
    
    
    
}
