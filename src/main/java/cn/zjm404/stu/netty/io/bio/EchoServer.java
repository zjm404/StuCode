package cn.zjm404.stu.netty.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(6);
        executor.execute(
                () -> {
                    try (Socket s = ss.accept()) {
                        InputStream in = s.getInputStream();
                        byte[] req = new byte[128];
                        InputStreamReader reader = new InputStreamReader(in);
                        int len = in.read(req);
                        OutputStream out = s.getOutputStream();
                        out.write(req);
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
        );
    }
}
