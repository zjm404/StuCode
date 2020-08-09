package cn.zjm404.demo.di.template;

import java.util.List;

public class TTPODMusicProvider implements IMusicProvider{
    @Override
    public List<Object> search(String msg) {
        System.out.println("天天动听...关键词："+msg);
        return null;
    }
}
