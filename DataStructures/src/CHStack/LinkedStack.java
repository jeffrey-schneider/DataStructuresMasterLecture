/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author JCSchneider
 */
public class LinkedStack<E> implements StackInt<E> {
    //Reference to the first stack node
    private Node<E> topOfStackRef = null;

    @Override
    public E push(E obj) {
        topOfStackRef = new Node<>(obj, topOfStackRef);
        return obj;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            E result = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            return result;
        }
    }
    
    public <E> E popAll(){
        ArrayList<E> retVal = new ArrayList<E>();
        int index = 0;
        while (!isEmpty()) {
            retVal.add(index++, (E) pop());
        }
        return (E) retVal;
    }
    
    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            return topOfStackRef.data;
        }
    }

    
    @Override
    public boolean isEmpty() {
        return topOfStackRef == null;
    }
    
    
    
    
    
 
    private static class Node<E> {

    private E data;
    private Node<E> next;

    private Node(E dataItem) {
        data = dataItem;
        next = null;
    }

    private Node(E dataItem, Node<E> nodeRef) {
        data = dataItem;
        next = nodeRef;
    }
}
}
