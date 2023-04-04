package main.lld.cache.algorithms;

import main.lld.cache.algorithms.exceptions.InvalidElementException;
import main.lld.cache.algorithms.exceptions.InvalidNodeException;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> first;
    DoublyLinkedListNode<E> last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public void detachNode(DoublyLinkedListNode<E> node){
        if(null == node){
            return;
        }
        if(node.equals(first)){
            first = first.next;

            if(first != null){
                first.prev= null;
            }
        }else if(node.equals(last)){
            last = last.prev;
            if(last.next != null){
                last.next = null;
            }
        }else {
            node.prev.next= node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node){
        if(null == node){
            throw new InvalidNodeException();
        }
        if(last == null){
            last = node;
            first = node;
        }else {
            last.next = node;
            node.prev = last;
            node.next = null;
            last = node;
        }
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element){
        if(null == element){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public DoublyLinkedListNode<E> getFirst(){
        return first;
    }
}
