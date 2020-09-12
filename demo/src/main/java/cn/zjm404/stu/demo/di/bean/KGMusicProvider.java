package cn.zjm404.stu.demo.di.bean;

import java.util.List;

public class KGMusicProvider implements IMusicProvider{
    @Override
    public List<Object> search(String msg) {
        //做测试用
        System.out.println("酷狗...关键词："+msg);
        return null;
    }
}
