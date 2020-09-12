package cn.zjm404.stu.algorithm.bitmap;

public abstract class BitMapDemo {
    private char[] bits;
    private int len;
    public BitMapDemo(int _len){
        len = _len;
        bits = new char[_len / 16 +1];
    }
    public void put(int k){
        k = hash(k);
        if(k > len){
            return ;
        }
        // 确定 bits 数组中的下标
        int flagBits = k/16;
        // 确定在 bit 中的位置
        int flagBit = k%16;
        // 将指定位置设置为 1
        bits[flagBits] |= (1 << flagBit);
    }
    public boolean get(int k){
        k = hash(k);
        if(k > len){
            return false;
        }
        // 确定 bits 数组中的下标
        int flagBits = k/16;
        // 确定在 bit 中的位置
        int flagBit = k%16;
        return (bits[flagBits] & (1 << flagBit)) != 0;
    }

    /**
     * 设置 key 与 bitmap 的映射关系
     * @param k
     * @return
     */
    protected abstract int hash(int k);
}
