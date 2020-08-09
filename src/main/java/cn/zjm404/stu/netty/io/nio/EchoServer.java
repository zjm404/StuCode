package cn.zjm404.stu.netty.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class EchoServer {
    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{
            selector = Selector.open();
            ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(8080),1024);
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            Logger.getGlobal().info("等待连接中...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try{
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
