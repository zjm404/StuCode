package github.zjm404.stu.java.spi.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author zjm
 * @date 2020/12/10
 */
public class Client {
    public static void main(String[] args) {
        IDemo demo = ExtensionLoader.getExtensionLoader(IDemo.class).getExtension("A");
        demo.say();
    }
}
