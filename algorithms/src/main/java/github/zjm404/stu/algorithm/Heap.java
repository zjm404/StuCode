package github.zjm404.stu.algorithm;

public class Heap {
    private int[] a;
    /**
     * 堆的容量
     */
    private int n;
    /**
     * 堆中已存储数据个数
     */
    private int count;

    public Heap(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data){
        if(count >= n){
            return;
        }
        count++;
        //加入堆尾
        a[count] = data;
        int i = count;
        //进行堆化
        while(i/2 > 0 && a[i] > a[i/2]){
            swap(a,i,i/2);
            i = i/2;
        }
    }
    public void removeTop(){
        if(count == 0){
            return;
        }
        a[1] = a[count];
        count--;
        heapify(a,count,1);
    }
    private void heapify(int[] a,int n,int i){
        while(true){
            int maxPos = i;
            if(i*2 <= n && a[i] < a[i*2]){
                maxPos = i*2;
            }
            if(i*2+1 <= n && a[maxPos] < a[i*2+1]){
                maxPos = i*2+1;
            }
            if(maxPos == i){
                break;
            }
            swap(a,i,maxPos);
            i = maxPos;
        }
    }
    private void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
