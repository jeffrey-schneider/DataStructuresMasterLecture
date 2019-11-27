/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHBST;

import java.util.*;

/**
 *
 * @author JCSchneider
 */
public class CHBSTGeneric<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root;
    private Comparator<T> comparator;
    
    protected boolean addReturn = false;
    protected T deleteReturn;

    public CHBSTGeneric() {
        root = null;
        comparator = null;
    }

    public CHBSTGeneric(Comparator<T> comp) {
        root = null;
        comparator = comp;
    }

    private int compare(T x, T y) {
        if (comparator == null) {
            return x.compareTo(y);
        } else {
            return comparator.compare(x, y);
        }
    }

    /**
     * ***************************************************
     *
     * INSERT
     *
     * * Sample exercise, given this code, we see that the compare method is called twice.
     *   Can this be improved?
     
     *Return type, void
     *****************************************************
     */
    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T toInsert) {
        if (root == null) {
            return new Node<T>(toInsert);
        }

        if (compare(toInsert, root.data) == 0) {
            return root;
        }

        if (compare(toInsert, root.data) < 0) {
            root.left = insert(root.left, toInsert);
        } else {
            root.right = insert(root.right, toInsert);
        }

        return root;
    }

    
    /**
     * complexity O(n)
     * @param T2
     * @return 
     */
    public boolean isEqual(CHBSTGeneric T2){
        return isEqual(root, T2.root);
    }
    
    private boolean isEqual(Node node1, Node node2){
        if(node1 == null && node2 == null)
            return true;
        
        else if(node1 == null || node2 == null )
            return false;
        else{
            return(isEqual(node1.left, node2.left)
                    && isEqual(node1.right, node2.right)
                    &&(node1.data == node2.data));
        }
    }
    
    public void printAllPath(){
        Stack<T> stk = new Stack<T>();
        printAllPath(root, (Stack<Integer>) stk);
    }
    
    private void printAllPath(Node curr, Stack<Integer> stk){
        if(curr == null){
            return;
        }
        stk.push((Integer) curr.data);
        if(curr.left == null && curr.right == null){
            System.out.println(stk.toString());
            stk.pop();
            return;
        }
        printAllPath(curr.right, stk);
        printAllPath(curr.left, stk);
        stk.pop();
    }
    
    public int numFullNodesBT(){
        return numFullNodesBT(root);
    }
    
    private int numFullNodesBT(Node curr){
        int count = 0;
        if(curr == null){
            return 0;
        }
        count = numFullNodesBT(curr.right) + numFullNodesBT(curr.left);
        if(curr.right != null && curr.left != null){
            count++;
        }
        return count;       
    }
    
    /**
     * ***************************************************
     *
     * SEARCH
     *
     * * Sample exercise, given this code, we see that the compare method is called twice.
     *   Can this be improved?
     
     *****************************************************
     */
    public boolean search(T toSearch) {
        return search(root, toSearch);
    }

    private boolean search(Node<T> root, T toSearch) {
        if (root == null) {
            return false;
        } else {
            if (compare(toSearch, root.data) == 0) {
                return true;
            } else {
                if (compare(toSearch, root.data) < 0) {
                    return search(root.left, toSearch);
                } else {
                    return search(root.right, toSearch);
                }
            }
        }
    }

    /**
     * ***************************************************
     *
     * DELETE
     *
     *****************************************************
     */
    public void delete(T toDelete) {
        root = delete(root, toDelete);
    }

    
    /**
     * Sample exercise, given this code, we see that the compare method is called twice.
     *   Can this be improved?
     * @param root
     * @param toDelete
     * @return 
     */
    private Node<T> delete(Node<T> root, T toDelete) {
        //if (root == null)  throw new RuntimeException("cannot delete.");
        if (root == null) {
            return null;
        } else {
            if (compare(toDelete, root.data) < 0) {
                root.left = delete(root.left, toDelete);
            } else {
                if (compare(toDelete, root.data) > 0) {
                    root.right = delete(root.right, toDelete);
                } else if (root.left == null) {
                    return root.right;
                } else {
                    if (root.right == null) {
                        return root.left;
                    } else {
                        // get data from the rightmost node in the left subtree
                        root.data = retrieveData(root.left);
                        // delete the rightmost node in the left subtree
                        root.left = delete(root.left, root.data);
                    }
                }
            }
        }
        return root;
    }

    private T retrieveData(Node<T> root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    /**
     * ***********************************************
     *
     * toString
     *
     *************************************************
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (T data : this) {
            sb.append(data.toString());
        }

        return sb.toString();
    }

    /**
     * ***********************************************
     *
     * TRAVERSAL     *
     *************************************************
     */
    
    /**
     * Preorder traversal is used to create a copy of the tree.
     * from: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
     */
    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node r) {
        if (r != null) {
            System.out.print(r + " -> ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    
    /**
     * Postorder traversal is used to delete the tree. 
     * * from: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
     */
    public void postOrderTraversal() {
        postOrderHelper(root);
    }

    private void postOrderHelper(Node r) {
        if (r != null) {
            postOrderHelper(r.left);
            postOrderHelper(r.right);            
            System.out.print(r + " <-- ");
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node r) {
        if (r != null) {
            inOrderHelper(r.left);
            System.out.print(r + " <-> ");
            inOrderHelper(r.right);
        }
    }

    
    /** 
     * Wikipedia 
     * Breadth First Search
     * Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. 
     * It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 
     * 'search key'[1]), and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
     * 
     * https://www.baeldung.com/java-breadth-first-search
     * The basic approach of the Breadth-First Search (BFS) algorithm is to search for a node into a tree or graph structure by exploring neighbors before children.
     * The idea behind the BFS algorithm for trees is to maintain a queue of nodes that will ensure the order of traversal. At the beginning of the algorithm, the queue contains only the root node. We'll repeat these steps as long as the queue still contains one or more nodes:
        Pop the first node from the queue
        If that node is the one we're searching for, then the search is over
        Otherwise, add this node's children to the end of the queue and repeat the steps
     */
    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(Node root) {
        if (root != null) {
            int h = height(root);
            for (int i = 1; i <= h; i++) {
                printGivenLevel(root, i);
            }
        }
    }
    
    
    /**
     * Prints all nodes at desired level
     * @param root
     * @param level 
     */
    private void printGivenLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    /**
     * ***********************************************
     *
     * CLONE
     * 
     * Deep copy of an object will have exact copy of all the fields of original 
     * object just like shallow copy. But in additional, if original object has 
     * any references to other objects as fields, then copy of those objects are
     * also created by calling clone() method on them.
     * From https://javaconceptoftheday.com/difference-between-shallow-copy-vs-deep-copy-in-java/
     *
     *************************************************
     */
    public CHBSTGeneric<T> clone() {
        CHBSTGeneric<T> twin = null;

        if (comparator == null) {
            twin = new CHBSTGeneric<T>();
        } else {
            twin = new CHBSTGeneric<T>(comparator);
        }

        twin.root = clone(root);
        return twin;
    }

    private Node<T> clone(Node<T> root) {
        if (root == null) {
            return null;
        } else {
            return new Node<T>(root.data, clone(root.left), clone(root.right));
        }
    }

    /**
     * ***********************************************
     *
     * MISC
     *
     * @return 
 *************************************************
     */
    public int height() {
        return height(root);
    }

    private int height(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                return countLeaves(root.left) + countLeaves(root.right);
            }
        }
    }

    //This method restores a CHBSTGeneric given preorder and inorder traversals
    public void restore(T[] pre, T[] in) {
        root = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private Node<T> restore(T[] pre, int preL, int preR, T[] in, int inL, int inR) {
        if (preL <= preR) {
            int count = 0;
            //find the root in the inorder array
            while (pre[preL] != in[inL + count]) {
                count++;
            }

            Node<T> tmp = new Node<T>(pre[preL]);
            tmp.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
            tmp.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
            return tmp;
        } else {
            return null;
        }
    }

    //The width of a binary tree is the maximum number of elements on one level of the tree.
    public int width() {
        int max = 0;
        for (int k = 0; k <= height(); k++) {
            int tmp = width(root, k);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
    //rerturns the number of node on a given level

    public int width(Node<T> root, int depth) {
        if (root == null) {
            return 0;
        } else {
            if (depth == 0) {
                return 1;
            } else {
                return width(root.left, depth - 1) + width(root.right, depth - 1);
            }
        }
    }

    //The diameter of a tree is the number of nodes
    //on the longest path between two leaves in the tree.
    public int diameter() {
        return diameter(root);
    }

    private int diameter(Node<T> root) {
        if (root == null) {
            return 0;
        }

        //the path goes through the root
        int len1 = height(root.left) + height(root.right) + 3;

        //the path does not pass the root
        int len2 = Math.max(diameter(root.left), diameter(root.right));

        return Math.max(len1, len2);
    }

    
    /*********************************
     * From Data Structures, Edition 2, Koffman and Wolfgang
     * page 319-328
     */
    /**
     * Starter method find
     * pre: The target object must implement the Comparable interface.
     * @param target        The object being sought
     * @return              The object, if found, otherwise null;
     */
    public T find(T target){
        return find(root, target);
    }
    
    /**
     * Recursive find method.
     * It is more efficient to call compareTo once and save the result in a local variable.
     * @param localRoot
     * @param target
     * @return              The object, if found, otherwise null;
     */
    private T find(Node<T> localRoot, T target){
        if(localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if(compResult == 0)
            return localRoot.data;
        else if(compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }
    
    public boolean contains(T target){
        return contains(root, target);
    }
    
    private boolean contains(Node<T> localRoot, T target){
        if (find(localRoot, target) == null)
            return false;
        return true;
    }

    /**
     * Starter method add
     * pre: the object to insert must implement the Comparable interface
     * 
     * @param data
     * @return      If the object is inserted, true
     *              if the object already exists in the tree, false
     * 
     * returns boolean
     */
    public boolean add(T data){
        root = add(root, data);
        return addReturn;
    }
    
    /**
     * post:    the data field addReturn is set true if the data is added to the tree
          false if the data is already in the tree
     * @param localRoot
     * @param data
     * @return  True if the object is inserted, false if the object already exists.
     */
    
    private Node<T> add(Node<T> localRoot, T data){
        if(localRoot == null){
            //item is not in tree - insert it.
            addReturn = true;
            return new Node<T>(data);
        }else if(data.compareTo(localRoot.data) == 0){
            //item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }else if(data.compareTo(localRoot.data) < 0){
            //item is less than localRoot.data
            localRoot.left = add(localRoot.left, data);
            return localRoot;
        }else{
            //Item is greater than localRoot.data
            localRoot.right = add(localRoot.right, data);
            return localRoot;
        }
    }
    
    
    
    /** find the node that is the inorder predecessor and replace it with its left child(if any)
     * post:        The inorder predecessor is removed from the tree.
     * @param       parent  the parent of possible inorder predecessor(ip)
     * @return      The data in the ip
     */
    private T findLargestChild(Node<T> parent){
        //If the right child has no right child, it is the inorder predecessor
        if(parent.right.right == null){
            T returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }else{
            return findLargestChild(parent.right);
        }
    }
    /**
     * ***************************************************
     *
     * TREE ITERATOR
     *
     * Lecture given
     *****************************************************
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    //pre-order
    private class MyIterator implements Iterator<T> {

        Stack<Node<T>> stk = new Stack<Node<T>>();

        public MyIterator() {
            if (root != null) {
                stk.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stk.isEmpty();
        }

        @Override
        public T next() {
            Node<T> cur = stk.peek();
            if (cur.left != null) {
                stk.push(cur.left);
            } else {
                Node<T> tmp = stk.pop();
                while (tmp.right == null) {
                    if (stk.isEmpty()) {
                        return cur.data;
                    }
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }

            return cur.data;
        }//end of next()

        @Override
        public void remove() {

        }
    }//end of MyIterator

  
    
    public void printDepthFirst(){
        Stack<Node> stk = new Stack<Node>();
        Node temp;
        
        if(root != null){
            stk.push(root);
        }
        while(stk.size() != 0){
            temp = stk.pop();
            System.out.print(temp.data + " ");
            
            if(temp.left != null){
                stk.push(temp.left);
            }
            if(temp.right != null){
                stk.push(temp.right);
            }
        }
    }//end of printDepthFirst
    
    public void CreateBinaryTree(int[] arr){
        root = CreateBinaryTree(arr, 0, arr.length -1);
    }
    
      
    private Node CreateBinaryTree(int[] arr, int start, int end){        
        Node curr = null;
        if(start>end)
            return null;
        int mid = (start + end)/2;
        curr = new Node(arr[mid]);
        curr.left = CreateBinaryTree(arr, start, mid-1);
        curr.right = CreateBinaryTree(arr, mid+1, end);
        return curr;
    }
    
    public void printLeafNodes(){
        printLeafNodes(root);
    }
    private void printLeafNodes(Node node){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            System.out.printf("%d ", node.data);
        }
        
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }
    
    
    public Node<T> findMin(){
        Node node = root;
        if(node == null)
            return null;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    
    public Node<T> findMax(){
        Node node = root;
        if(node == null)
            return null;
        while(node.right != null){
            node  = node.right;
        }
        return node;
    }
    
    /**
     * ***************************************************
     *
     * the Node class
     * Given in last week's lecture
     *****************************************************
     */
    private class Node<T> {

        private T key;
        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r) {
            left = l;
            right = r;
            this.data = data;
        }

        public Node(T data) {
            this(data, null, null);
        }

        public String toString() {
            return data.toString();
        }
    } //end of Node  
   
}//end of CHBSTGeneric

/**
 * Include in 10/30/19 lecture. Nah.
 * @author JCSchneider
 */
class MyComp1 implements Comparator<Integer> {

    public int compare(Integer x, Integer y) {
        return y - x;
    }
}
