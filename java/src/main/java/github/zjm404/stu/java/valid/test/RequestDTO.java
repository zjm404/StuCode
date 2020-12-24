package github.zjm404.stu.java.valid.test;

import github.zjm404.stu.java.valid.HasNotNull;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author
 * @Date 2020/11/23
 * @Description
 * @Version 1.0
 */
@Data
public class RequestDTO {
    @NotNull(message = "不可为null")
    private String msg;
    @HasNotNull(fields = {"foods","rooms","tickets"},num = 1,message = "食/住/门票至少有一个不为null")
    RpcDTO rpcDTO;
}
