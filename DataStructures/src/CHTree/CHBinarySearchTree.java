/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHTree;

/**
 *
 * @author JCSchneider
 */
public class CHBinarySearchTree<E extends Comparable<E>> {
    //Data fields
    /** Return value from the public add method */
    protected boolean addReturn;
    /* Return value from the public delete method */
    protected E deleteReturn;


    //public E find(E target){
    //    return find(root, target);
    //}
    
    //Recursive find method
    public E find(Node<E> localRoot, E target){
        if(localRoot == null)
            return null;
        
        //Compare the target with the data field at the root
        int compResult = target.compareTo(localRoot.data);
        if(compResult == 0)
            return localRoot.data;
        else if(compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }
    
    
    //public boolean add(E item){
    //    root = add(root, item);
    //    return addReturn;
    //}
    
    //Recursive add method
    private Node<E> add(Node<E> localRoot, E item) {
        //item is not in the tree - insert it
        if (localRoot == null) {
            addReturn = true;
            return new Node<>(item);
        }else if(item.compareTo(localRoot.data) == 0){
            //item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }else if(item.compareTo(localRoot.data) < 0){
            //item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }else{
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    
    protected static class Node<E> {
        //Data fields
        protected E data;
        //Reference to left child
        protected Node<E> left;
        //Reference to the right child
        protected Node<E> right;
        
        //Constructors
        //Construct a node with given data and no children
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
        
        //Methods
        public String toString(){
            return data.toString();
        }
    }
}
