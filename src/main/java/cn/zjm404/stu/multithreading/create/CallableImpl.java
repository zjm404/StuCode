package cn.zjm404.stu.multithreading.create;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World";
    }
}
