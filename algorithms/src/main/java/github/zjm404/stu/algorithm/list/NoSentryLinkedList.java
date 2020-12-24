package github.zjm404.stu.algorithm.list;


public class NoSentryLinkedList<T> extends MyLinkedList<T>{

    @Override
    public void add(T t){
        if(head == null){
            tail = head = new Node<T>(t);
            return;
        }
        Node<T> newNode = new Node<T>(t);
        //建立联系
        newNode.prev = tail;
        tail.next = newNode;
        //挪动尾结点
        tail = newNode;

    }
    @Override
    public void addFirst(T t){
        if(head == null){
            tail = head = new Node<T>(t);
            return;
        }
        Node n = new Node(t);
        n.next = head;
        head.prev = n;
        head = n;
    }
    @Override
    public boolean removeFirst(){
        if(head == null){
            throw new NullPointerException("空链表异常！");
        }
        //如果链表中只有一个节点
        if(head == tail){
            head = tail = null;
            return true;
        }
        Node<T> del = head;
        //孤立节点
        if(del.next != null){
            del.next.prev = null;
        }
        head = del.next;
        //删除节点
        del.prev = null;
        del.next = null;

        return true;

    }
    @Override
    public boolean remove(T target){
        //如果为空链表，则直接返回
        if(head == null){
            return false;
        }
        //如果删除节点为头节点
        if(head.value.equals(target)){
            return removeFirst();
        }
        //遍历链表，找到后继节点为target的节点
        for(Node<T> n = head;n.next != null;n = n.next){
            if(n.next.value.equals(target)){

                //删除目标节点
                Node<T> del = n.next;
                //孤立节点
                n.next = del.next;
                if(del.next != null){
                    del.next.prev = n;
                }
                //删除节点
                del.next = null;
                del.prev = null;

                //如果删除的节点为尾节点
                if(tail == del){
                    tail = n.next;
                }
                return true;
            }
        }

        return false;
    }
    @Override
    public boolean contain(T target){
        for (Node<T> n = head; n != null; n = n.next){
            if(n.value.equals(target)){
                return true;
            }
        }
        return false;
    }
}
