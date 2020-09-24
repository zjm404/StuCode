package cn.zjm404.stu.algorithm.list;

import java.util.Iterator;

public class SentryLinkedList<E> implements Iterable<E>, Iterator<E> {

    private Node<E> head = new Node<>();
    private Node<E> tail = head;

    public void add(E e){
        Node<E> n = new Node<>(e);
        //建立联系
        n.prev = tail;
        tail.next = n;
        //挪动位置
        tail = tail.next;
    }
    public void addFirst(E e){
        Node<E> n = new Node<>(e);
        //建立联系
        head.prev = n;
        n.next = head.next;
        //挪动位置
        head = n;
    }
    public boolean remove(E target){
        for(Node<E> n = head.next;n != null;n = n.next){
            if(n.value.equals(target)){
                Node<E> delNext = n.next;
                Node<E> delPrev = n.prev;
                //孤立被删除节点
                delNext.prev = delPrev;
                delPrev.next = delNext;
                //删除节点
                n.next = null;
                n.prev = null;
            }
        }
        return false;
    }
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
