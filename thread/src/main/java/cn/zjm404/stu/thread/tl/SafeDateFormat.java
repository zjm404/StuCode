package cn.zjm404.stu.thread.tl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SafeDateFormat {
    private static final ThreadLocal<DateFormat> tl;
    static {
        tl = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    public static DateFormat get(){
        return tl.get();
    }
}
