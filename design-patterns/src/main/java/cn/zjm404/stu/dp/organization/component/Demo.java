package cn.zjm404.stu.dp.organization.component;

import java.util.ArrayList;

public class Demo {
    private String msg1;
    private String msg2;
    private ArrayList<Demo> demos = new ArrayList<>();

    public boolean isLeaf(){
        return this.demos.isEmpty();
    }
}
