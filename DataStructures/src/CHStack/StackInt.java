/**
 * A stack is a data structure in which objects are inserted into
/* and removed from the same end (LIFO)
 */
package CHStack;

/**
 *
 * @author jeffrey.schneider
 */
public interface StackInt<E> {
    
    /**
     * Pushes an item onto the top of the stack and returns
     * the item pushed
     * @param obj       The object to be inserted
     * @return          The object inserted.
     */
    E push(E obj);


    
    /**
     * Returns the object at the top of the stack without removing it.
     * post: The stack remains unchanged.
     * @return          The object at the top of the stack
     * @throws          EmptyStackException if stack is empty.
     */
    E peek();
    
    
    
    E pop();
    
    boolean isEmpty();
}
