package github.zjm404.stu.thread.create;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World";
    }
}
