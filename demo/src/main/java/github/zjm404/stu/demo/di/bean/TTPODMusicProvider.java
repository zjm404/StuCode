package github.zjm404.stu.demo.di.bean;

import java.util.List;

public class TTPODMusicProvider implements IMusicProvider{
    @Override
    public List<Object> search(String msg) {
        System.out.println("天天动听...关键词："+msg);
        return null;
    }
}
