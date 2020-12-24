package github.zjm404.stu.demo.rpc.v2.protocol.application;

import lombok.Data;

/**
 * @Author
 * @Date 2020/11/19
 * @Description
 * @Version 1.0
 */
@Data
public class Message {
    Header header;
    byte[] body;
}
