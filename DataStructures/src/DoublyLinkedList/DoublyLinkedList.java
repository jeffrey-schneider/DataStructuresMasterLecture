/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

import java.util.Iterator;

/**
 *
 * @author jcschneider
 * based on:
 * https://algorithms.tutorialhorizon.com/doubly-linked-list-complete-implementation/
 */
public class DoublyLinkedList<E>{
   int size = 0;
   Node<E> head = null;
   Node<E> tail = null;
   
   
   public void add(E data){
       if(size==0){
           addFirst(data);
       }else{
           addAtEnd(data);
       }
   }
   
   public Node<E> addFirst(E data){
       Node<E> node = new Node<E>(data);
       if(size == 0){
           head = node;
           tail = node;
       }
       size++;
       return node;
   }
   
   public Node<E> addAtEnd(E data){
       Node<E> node = new Node<E>(data);
       if(size==0){
           head =node;
           tail = node;           
       }else{
           tail.next = node;
           node.previous = tail;
           tail = node;
       }
       size++;
       return node;
   }
    
   public Node addAfter(E data, Node<E>prevNode){
       if(prevNode == null){
           return null;
       }else if(prevNode == tail){ //Check if it is the last node
           return addAtEnd(data);
       }else{
           Node<E> node = new Node<E>(data);
           Node<E> nextNode = prevNode.next;
           prevNode.next = node;
           nextNode.previous = node;
           node.previous = prevNode;
           size++;
           return node;           
       }
   }
   
   public void deleteFromStart(){
       if(size == 0){
           System.out.println("Empty List");
       }else{
           head = head.next;
           size--;
       }
   }
   
   public E getNode(int index){
       Node<E> node = head;
       for (int i = 0; i < index && node != null; i++) {
           node = node.next;
       }
       return node.data;
   }
   
   public boolean searchFor(E item){
       Node<E> node = head;
       while(node != null){
           if(node.data.equals(item)){
               return true;
           }
           node=node.next;
       }
       return false;
   }
   public E deleteFromEnd(){
       if(size == 0){
           System.out.println("Empty List");
       }else if(size==1){
           deleteFromStart();
       }else{
           //store the 2nd last node
           E retVal = tail.data;
           Node<E> prevTail = tail.previous;
           
           //Detach the last node
           tail = prevTail;
           tail.next = null;
           size--;
           return retVal;
       }
       return null;
   }
   
   public E elementAt(int index){
       if(index > size){
           throw new IndexOutOfBoundsException(Integer.toString(index));
       }
       Node<E> node = head;
       while (index-1 != 0) {
           node = node.next;
           index--;
       }
       return node.data;
   }
   
   public int getSize(){
       return size;
   }
   
   public void printAll() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

 
   
private static class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> previous;
    
    private Node(E dataItem){
        data = dataItem;
        next = null;
        previous = null;
    }
    
    private Node(E dataItem, Node<E> nodeRef){
        data = dataItem;
        next = nodeRef;
    }
}
}
