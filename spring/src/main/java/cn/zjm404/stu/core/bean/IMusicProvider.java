package cn.zjm404.stu.core.bean;

import java.util.List;

public interface IMusicProvider {
    public List<Music> search(String keywords);
}
