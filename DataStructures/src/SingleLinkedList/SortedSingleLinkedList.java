/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

/**
 *
 * @author JCSchneider
 */
public class SortedSingleLinkedList<E> extends SingleLinkedList {
    
    //A reference to the first node in the list
    public Node<E> head;
    //A reference to the node to return when next() is called.
    public Node<E> iterator;
    
    /** Constructor
     * 
     * 
     */
    public SortedSingleLinkedList(){
        head = null;
        iterator = null;
    }
    
    /**
     * isEmpty
     * @returns     true if there are no items in linked list
     */
    public boolean isEmpty(){
        return(head==null);
    }
    
    /**Add
     * @param <E> 
     * @returns none
     * adds an item into the list in sorted order
     */
    public void add(Comparable item){
        //make the new node to insert into the list
        Node newNode = new Node(item);
        // first see if the list is empty
        
		if (head == null)
		{
			System.out.println("add "+item +" to front");
			head = newNode;
			return;
		}
		// there is something in the list
		// now check to see if it belongs in front
		else if (item.compareTo(head.data) < 0)
		{
			System.out.println("add "+item +" before "+head.data);
			newNode.next = head;
			head = newNode;
		}
		// otherwise, step down the list.  n will stop 
		// at the node after the new node, and trailer will
		// stop at the node before the new node
		else
		{
			Node after = head.next;
			Node before = head;
			while (after != null)
			{
				if (item.compareTo(after.data) < 0)
					break;
				before = after;
				after = after.next;
			}
			// insert between before & after
			newNode.next = before.next;
			before.next = newNode;
			System.out.println("add "+item +" after "+before.data);
		}
                size++;

	}
    public void printMe() {
        Node current = head;
        if (current == null) {
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
    private Comparable data;
    private Node<E> next;
    
    private Node(Comparable item){
        data = item;
        next = null;
    }
    
    private Node(Comparable item, Node<E> nodeRef){
        data = item;
        next = nodeRef;
    }
}    
}
