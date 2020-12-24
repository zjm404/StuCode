package github.zjm404.stu.demo.diff;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GetDiffNodeDemo<T> {
    public  List getDiffNodes(List<T> l1,List<T> l2){
        Set<T> set = new HashSet(l1);
        List<T> res = new LinkedList();
        for (T o : l2) {
            if (!set.contains(o)){
                res.add(o);
            }
        }
        return res;
    }
}
