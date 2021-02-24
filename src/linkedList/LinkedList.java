/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;


import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;


/**
 *
 * @author LuisM45
 */
public class LinkedList<E extends Object> implements List<E>{
    private Node<E> start;

    public LinkedList() {
        this.start = null;
    }

    private Node<E> getNode(int index){
        Node n = start;
        while(index>0) {
            n=n.link;
            index--;
        }
        return n;
    }
    
    // Metodos ocupados
    @Override
    public boolean isEmpty() {
        return this.start==null;
    }
    
    @Override
    public boolean add(E e) {
        int oldSize = size();
        add(0, e);
        return oldSize!=size();
    }
    
    public boolean addOrder(E e,Comparator<E> c) {
        boolean f = false;
        int oldSize = size();
        int pointer = 0;
        //Para lista vacia
        if(start==null) {add(e);return true;}
        Node n = start;
        
        Iterator<E> i = this.iterator();
        while(i.hasNext()){
            if(c.compare(e, i.next())<0) break;
            pointer++;
        }
        add(pointer, e);
        
        return oldSize!=size();
    }
    
    @Override
    public E get(int i){
        return getNode(i).object;
    }
    
    @Override
    public int size(){
        int i = 0;
        Node p = start;
        while(p!=null){
            i++;
            p=p.link;
        }
        return i;
    }

//    
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        //Pienso eliminar este toString para hacerlo purista y lo mas general posible
//        sb.append(start!=null?"Lista de empleados\n":"Lista vacia");
//        Node p = start;
//        while(p!=null){
//            sb.append(p.object).append('\n');
//            p=p.link;
//        }
//        
//        return sb.toString();
//    }

    //Metodos implementados aunque no se ocuparon en la corrida
    
    @Override
    public boolean contains(Object o) {
        Node p = start;
        while(p!=null){
            if(p.object.equals(o)) return true;
            p=p.link;
        }
        return false;
    }

    @Override
    //Este tecnicamentes sí se ocupó de manera implicita en el foreach
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node n = start;
            Node nLess1 = start;
            Node nLess2 = start;
            
            @Override
            public boolean hasNext() {
                return n!=null;
            }

            @Override
            public E next() {
                Node n1 =n;
                nLess2=nLess1;
                nLess1=n;
                n=n.link;
                return (E)n1.object;
            }

            @Override
            public void remove() {
                if(nLess1==start)start=n;
                else nLess2.link=n!=null?n:null;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> cnsmr) {
                while(hasNext()) cnsmr.accept(next());
            }
            
        };
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] o = new Object[size];
        Node p = start;
        for(;size>=0;size--){
            o[size]=p.object;
            p=p.link;
        }
        return o;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        //Ni idea que esto, ni lo que debería hacer
//        int size = size();
//        if (a.length < size){
//            // Make a new array of a's runtime type, but my contents:
//            T[] a1 = ;
//            a1.;
//            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
//        }
//        System.arraycopy(elementData, 0, a, 0, size);
//        if (a.length > size)
//            a[size] = null;
//        return a;
    }

    @Override
    public boolean remove(Object o){
        if(start!=null&&start.object.equals(o)){
            start=start.link;
            return true;
        }
        
        Node n = start;
        while(n.link!=null){
            if(n.link.object.equals(o)){
                n.link=n.link.link;
                return true;
            }
            n=n.link;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean f = true;
        for(Object o:c){
            f&=contains(o);
            if(!f) break;
        }
        return f;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size(),c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Node tail = start;
        Node head = null;
        for(int idx =0;idx<index;idx++){
            head=tail;
            tail=tail.link;
        }
        for(Object o:c){
            tail=new Node(tail, o);
        }
        head.link=tail;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int size = size();
        boolean f = false;
        boolean t;
        for(int i = 0;i<size;i++){
            t=false;
            for(Object o:c){
                t = contains((E)o);
                if(t) break;
            }
            if(t){
                remove(i);
                i--;
                size--;
            }
            if(t&&!f) f=true;
        }
        return f;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int size = size();
        boolean f = false;
        boolean t;
        for(int i = 0;i<size;i++){
            t=false;
            for(Object o:c){
                t = contains((E)o);
                if(t) break;
            }
            if(!t){
                remove(i);
                i--;
                size--;
            }
            if(t&&!f) f=true;
        }
        return f;
    }

    @Override
    public void clear() {
        start = null;
    }

    @Override
    public E set(int index, E element) {
        Node n = getNode(index);
        E e = (E) n.object;
        n.object = element;
        return e;
    }

    @Override
    public void add(int index, E element) {
        if(index==0)start = new Node<>(start,element);
        else{
            Node n = new Node(getNode(index), element);
            getNode(index-1).link=n;
        }
    }

    @Override
    public E remove(int index) {
        E e;
        if(index==0) {
            e=(E)start;
            start = start.link;
            return e;
        }
        Node n = getNode(index-1);
        e = (E)n.link.object;
        n.link=n.link.link;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        Node p = start;
        int idx = 0;
        while(p!=null){
            if(p.object.equals(o)) return idx;
            p=p.link;
            idx++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node p = start;
        int idx = -1;
        int i = 0;
        while(p!=null){
            if(p.object.equals(o)) idx=i;
            p=p.link;
            i++;
        }
        return idx;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        Node n =start;
        LinkedList<E> m = new LinkedList<>();
        for(int i = 0; i<=fromIndex;i++){
            for(;fromIndex<=i&&i<toIndex;i++){
                    m.add((E) n.object);
                    n=n.link;
                }
            n=n.link;
            }
        return m;
    }
    
    
    
}
