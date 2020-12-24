package github.zjm404.stu.java.valid.test;

import lombok.Data;


/**
 * @Author
 * @Date 2020/11/23
 * @Description
 * @Version 1.0
 */
@Data
public class RpcDTO {
    private String msg;
    private Food[] foods;
    private Room[] rooms;
    private Ticket[] tickets;
}
