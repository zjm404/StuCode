package cn.zjm404.stu.thread.cooperation.wn.inner;

import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private Queue<Object> goodsQueue = new LinkedList<>();
    private final int MAX_GOODS_NUM = 8;

    public synchronized void produce(Object goods) throws InterruptedException {
        while(goodsQueue.size() > MAX_GOODS_NUM){
            wait();
        }
        if(goodsQueue.size() == 0){
            goodsQueue.add(goods);
            notifyAll();
        }else{
            goodsQueue.add(goods);
        }

    }
    public synchronized Object consume() throws InterruptedException {
        while(goodsQueue.size() == 0){
            wait();
        }
        if(goodsQueue.size() == MAX_GOODS_NUM){
            Object res = goodsQueue.poll();
            notifyAll();
            return res;
        }else {
            return goodsQueue.poll();
        }
    }
}
