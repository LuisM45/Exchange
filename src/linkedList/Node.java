/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

/**
 *
 * @author LuisM45
 * @param <E>
 */
public class Node<E extends Object>{
    Node<E> link;//Ganas de poner ese private no me faltan
    E object;
    
    public Node(Node<E> link, E object) {
        this.link = link;
        this.object = object;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }
    
    
}
