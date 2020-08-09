package cn.zjm404.stu.netty.io.bio;


import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",8080);
        Logger.getGlobal().info("已经连接到服务器");

        String req = "hello world";
        OutputStream out = s.getOutputStream();
        out.write(req.getBytes());
        out.flush();
        InputStream in = s.getInputStream();
        byte[] res  = new byte[128];
        int len = in.read(res);
        System.out.println(new String(res,0,len));
    }
}
