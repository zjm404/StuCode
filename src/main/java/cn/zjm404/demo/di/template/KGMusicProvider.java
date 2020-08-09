package cn.zjm404.demo.di.template;

import java.util.List;

public class KGMusicProvider implements IMusicProvider{
    @Override
    public List<Object> search(String msg) {
        System.out.println("酷狗...关键词："+msg);
        return null;
    }
}
