package cn.zjm404.demo.di.template;

import java.util.List;

public class WYYMusicProvider implements IMusicProvider{
    @Override
    public List<Object> search(String msg) {
        System.out.println("网易云音乐...关键词："+msg);
        return null;
    }
}
