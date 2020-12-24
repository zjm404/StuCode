package github.zjm404.stu.demo.index;

public class BPlusTreeLeafNode {
    //数据节点数量
    public static final int k;
    static {
        //计算 k 数量，保证让所有信息的大小正好等于页的大小
        k = 5;
    }
    //用于划分数据区间
    public int[] keywords = new int[k];
    //数据地址
    public long[] dataAddress = new long[k];
    //链表中的前驱节点
    public BPlusTreeLeafNode prev;
    //链表中的后驱节点
    public BPlusTreeLeafNode next;
}
