package github.zjm404.stu.java.spi.dubbo;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author zjm
 * @date 2020/12/10
 */
@SPI
public interface IDemo {
    public void say();
}
