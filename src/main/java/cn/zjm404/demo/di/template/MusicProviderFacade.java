package cn.zjm404.demo.di.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MusicProviderFacade {
    List<IMusicProvider> musicProvidersList;

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
