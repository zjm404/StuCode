package github.zjm404.stu.core.bean;

import java.util.List;

public class KGMusic implements IMusicProvider{
    @Override
    public List<Music> search(String keywords) {
        System.out.println("酷狗音乐搜索中~");
        return null;
    }
}
