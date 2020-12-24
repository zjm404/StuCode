package github.zjm404.stu.demo.di.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
@Setter
@Getter
public class MusicProviderFacade {
    private List<IMusicProvider> musicProvidersList;
    public List<Object> search(String msg){
        List<Object> res = new LinkedList<>();
        for (IMusicProvider iMusicProvider : musicProvidersList) {
            List<Object> list = iMusicProvider.search(msg);
            if(list != null){
                res.addAll(list);
            }

        }
        return res;
    }
}
