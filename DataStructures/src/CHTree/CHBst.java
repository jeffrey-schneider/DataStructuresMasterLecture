/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHTree;

import java.util.NoSuchElementException;
import CHQueue.LinkedQueue;

/**
 *
 * @author jeffrey.schneider
 */
public class CHBST<Key extends Comparable<Key>, Value> {
    
    private Node root;

    private boolean isEmpty() {
        return root==null;
    }
    
    private class Node{
        private Key key;        //key
        private Value val;      //associated value
        private Node left, right;   //links to subtree
        private int n;              // #nodes in subtree rooted here
        
        public Node(Key key, Value val, int n){
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }
    
    public int size(){
        return size(root);
    }
    
    private int size(Node x){
        if(x==null) 
            return 0;
        else
            return x.n;
    }
    
    public Value get(Key key){
        return get(root, key);
    }
    
    private Value get(Node x, Key key){
        // return value associated with key in the subtree rooted at x
        // return null if key not present in subtree rooted at x.
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) return get(x.left, key);
        else if(cmp > 0) return get(x.right, key);
        else return x.val;
    }
    
    public void put(Key key, Value val){
        //Search for key, update value if found: grow table if new.
        root = put(root, key, val);
    }
    
    private Node put(Node x, Key key, Value val){
        //Change key's value to val if key in subtree rooted at x.
        //Otherwise, add new node to subtree associating key with val..
        if(x==null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = put(x.left, key, val);
        else if(cmp>0)x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.left) + size(x.right) +1;
        return x;
    }
    
    public Key min(){
        if(isEmpty()) throw new NoSuchElementException();
        Node x = min(root);
        return x.key;
    }
    
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    
    public Key max(){
        if(isEmpty()) throw new NoSuchElementException();
        Node x= max(root);
        return x.key;
    }
    
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }
    
    
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x== null) throw new NoSuchElementException();
        return x.key;
    }
    
    private Node floor(Node x, Key key){
        if(x== null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);
        Node t=floor(x.right, key);
        if(t!= null) return t;
        else
                return x;
    }
    
    public Key select(int k){
        if(k<0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }
    
    private Node select(Node x, int k){
        //Return Node containing key of rank k.
        if(x== null) return null;
        int t = size(x.left);
        if(t> k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }
    
    public int rank(Key key){
        return rank(key, root);
    }
    
    private int rank(Key key, Node x){
        //Return number of keys less than key in the subtree rooted at
        if(x==null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return rank(key, x.left);
        else if(cmp>0) return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }
    
    
    public void deleteMin(){
        if(isEmpty()) throw new NoSuchElementException();
        root = deleteMin(root);
    }
    
    
    private Node deleteMin(Node x){
        if(x.left== null) return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public void delete(Key key){
        root = delete(root, key);
    }
    
    private Node delete(Node x, Key key){
        if(x==null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(x.left, key);
        else if(cmp > 0) x.right = delete(x.right, key);
        else{
            if(x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public Iterable<Key> keys(){
        return keys(min(), max());
    }
    
    public Iterable<Key> keys(Key lo, Key hi){
        LinkedQueue<Key> queue = new LinkedQueue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }
    
    private void keys(Node x, LinkedQueue<Key> queue, Key lo, Key hi){
        if(x==null)return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left, queue, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right, queue, lo, hi);
    }
    
}
