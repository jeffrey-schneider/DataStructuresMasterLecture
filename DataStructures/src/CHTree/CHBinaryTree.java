/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author JCSchneider
 */
public class CHBinaryTree<E>  {
    //Data field
    protected Node<E> root;
    
    //Constructors
    public CHBinaryTree(){
        root = null;
    }
    
    protected CHBinaryTree(E data, CHBinaryTree<E> leftTree, CHBinaryTree<E> rightTree){
        root = new Node<>(data);
        if(leftTree != null){
            root.left = leftTree.root;
        }else{
            root.left = null;
        }
        if(rightTree != null){
            root.right = rightTree.root;
        }else{
            root.right = null;
        }
    }

    public CHBinaryTree(Node<E> root) {
        this.root = root;
    }
    
    /**Return the left subtree or null if either the root or the left subtree is null */
    public CHBinaryTree<E> getLeftSubtree(){
        if(root != null && root.left != null){
            return new CHBinaryTree<E>(root.left);
        }else{
            return null;
        }
    }
    
    public CHBinaryTree<E> getRightSubtree(){
        if(root!= null && root.right != null){
            return new CHBinaryTree<E>(root.right);
        }else{
            return null;
        }
    }
   
    public boolean isLeaf(){
        return(root.left == null && root.right == null);
    }
    
    public static CHBinaryTree<String> readCHBinaryTree(Scanner scan){
        String data = scan.nextLine().trim();
        if(data.equals("null")){
            return null;
        }else{
            CHBinaryTree<String> leftTree = readCHBinaryTree(scan);
            CHBinaryTree<String> rightTree = readCHBinaryTree(scan);
            return new CHBinaryTree<>(data, leftTree, rightTree);
        }
    }
    private void toString(Node<E> node, int depth, StringBuilder sb){
        for (int i = 1; i < depth; i++) {
            sb.append("   ");
        }
        if(node == null){
            sb.append("null\n");
        }else{
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }
    
    //http://www.openbookproject.net/thinkcs/archive/java/english/chap17.htm
    public static void printPreOrder(CHBinaryTree tree){
        if(tree == null){
            return;
        }
        System.out.println(tree + " ");
        printPreOrder(tree.getLeftSubtree());
        printPreOrder(tree.getRightSubtree());
    }
    
    public static void printPostOrder(CHBinaryTree tree){
        if(tree == null){
            return;
        }
        printPostOrder(tree.getLeftSubtree());
        printPostOrder(tree.getRightSubtree());
        System.out.println(tree + " ");
    }
    
    public static void printInOrder(CHBinaryTree tree){
        if(tree == null){
            return;
        }
        printInOrder(tree.getLeftSubtree());
        System.out.println(tree + " " );
        printInOrder(tree.getRightSubtree());
    }
   
    
    
    
    
    
    public static class Node<E> {
        //Data fields
        public E data;
        //Reference to left child
        public Node<E> left;
        //Reference to the right child
        public Node<E> right;
        
        //Constructors
        //Construct a node with given data and no children
        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
        
       
    }
        
        //Methods
        
    
}
