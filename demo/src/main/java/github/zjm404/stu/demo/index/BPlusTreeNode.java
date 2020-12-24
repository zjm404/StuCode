package github.zjm404.stu.demo.index;

public class BPlusTreeNode {
    //叉数
    public static final int m;
    static {
        //计算 m 数量，保证让所有信息的大小正好等于页的大小
        m = 5;
    }
    //用于划分数据区间
    public int[] keywords = new int[m-1];

    //子节点
    public BPlusTreeNode[] children  = new BPlusTreeNode[m];
}
