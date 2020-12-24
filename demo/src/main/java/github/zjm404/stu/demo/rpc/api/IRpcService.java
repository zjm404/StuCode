package github.zjm404.stu.demo.rpc.api;

import java.io.Closeable;
import java.net.URI;

/**
 * @Author
 * @Date 2020/11/18
 * @Description
 * @Version 1.0
 */
public interface IRpcService extends Closeable {
    public IRegisterService getRegisterService();
    public <T>T getRemoteService(URI uri,Class<T> serviceClass);
    public <T>URI addServiceProvider(T obj,Class<T> serviceClass);
    public void start() throws Exception;
}
