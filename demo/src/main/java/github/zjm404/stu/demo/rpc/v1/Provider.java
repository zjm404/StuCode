package github.zjm404.stu.demo.rpc.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author
 * @Date 2020/11/4
 * @Description
 * @Version 1.0
 */
public class Provider {
    private int port;
    private ThreadPoolExecutor threads;
    private MyServerHandler handler;
    private JdkSerialization serialization = new JdkSerialization();

    class MyServerHandler implements Runnable {
        private JdkSerialization serialization;
        private Socket s;

        public MyServerHandler(Socket s) {
            this.s = s;
        }

        public void send(Socket s, byte[] bytes) {
            try (OutputStream out = s.getOutputStream(); BufferedOutputStream bout = new BufferedOutputStream(out)) {
                bout.write(bytes);
                bout.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            byte[] bytes = serialization.serialize(new DemoImpl());
            send(s, bytes);
        }
    }

    public Provider(int port, ThreadPoolExecutor threads) {
        this.port = port;
        this.threads = threads;
        this.serialization = new JdkSerialization();
    }

    public void start() {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s = ss.accept();
                threads.execute(new MyServerHandler(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

