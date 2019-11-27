/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CHBST;

/**
 *
 * @author jeffrey.schneider
 */
public interface ISearchTree<E> {
    
    boolean add(E item);
    
    boolean contains(E item);
    
    E find(E target);
    
    E delete(E target);
}
