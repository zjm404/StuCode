package github.zjm404.stu.algorithm.list;

import java.util.Iterator;

/**
 * @author ZJM
 */
public abstract class MyLinkedList<T> implements Iterable<T> {

    protected Node<T> head;
    protected Node<T> tail;

    @Override
    public Iterator<T> iterator() {

        return new MyLinkedIterator();
    }


    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T t) {
            value = t;
        }
    }

    private class MyLinkedIterator implements Iterator<T> {


        private Node<T> curNode;

        private Node<T> lastReturn;

        public MyLinkedIterator() {
            curNode = head;
        }

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public T next() {
            lastReturn = curNode;
            curNode = curNode.next;
            return lastReturn.value;
        }

        public T currentItem(){
            return curNode.value;
        }

        @Override
        public void remove() {
            if(lastReturn == null){
                throw new IllegalStateException();
            }
            //孤立被删除节点
            Node<T> del = lastReturn;
            Node<T> delPrev = lastReturn.prev;

            //如果删除的节点为首节点
            if(delPrev == null){
                head = curNode;
                curNode.prev = null;

            }else{
                delPrev.next = del.next;
                del.next.prev = delPrev;
            }
            del.next = null;
            del.prev = null;
            lastReturn = null;
        }
    }

    public abstract void add(T t);

    public abstract void addFirst(T t);

    public abstract boolean removeFirst();

    public abstract boolean remove(T target);

    public abstract boolean contain(T target);
}
