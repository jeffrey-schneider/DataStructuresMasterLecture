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
public class CHBinaryTreeTest {
    public static void main(String[] args) {
        CHBinaryTree left = new CHBinaryTree(new Integer(2), null, null);
        CHBinaryTree right = new CHBinaryTree(new Integer(3), null, null);
        CHBinaryTree tree = new CHBinaryTree(new Integer(1),left, right);
        
        System.out.println(tree.getLeftSubtree());
        
        
        
        
        
    }
}
