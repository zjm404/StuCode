package github.zjm404.stu.demo.index;

public class BTreeNode {
    //叉数
    public static final int m;
    static {
        //计算 m 数量，保证让所有信息的大小正好等于页的大小
        m = 5;
    }
    //用于划分数据区间
    public int[] keywords = new int[m-1];
    //数据地址
    public long[] dataAddress = new long[m];
    //子节点
    public BTreeNode[] children  = new BTreeNode[m];
}

