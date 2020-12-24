package github.zjm404.stu.demo.rpc.v1;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author
 * @Date 2020/11/4
 * @Description
 * @Version 1.0
 */
public class Consumer {
    private int port;
    private String host;
    private JdkSerialization serialization;

    public Consumer(int port, String host){
        this.port = port;
        this.host = host;
        this.serialization = new JdkSerialization();
    }
    public<T> T recv() {
        try(Socket s = new Socket(host,port);InputStream in = s.getInputStream(); BufferedInputStream bin = new BufferedInputStream(in)){
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            int result = bin.read();
            while(result != -1){
                bao.write(result);
                result = bin.read();
            }
            bin.close();
            return this.serialization.deSerialize(bao.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
