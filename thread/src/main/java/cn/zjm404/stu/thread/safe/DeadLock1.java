package cn.zjm404.stu.thread.safe;

public class DeadLock1 {
    static class O {
        private Object o1;
        private Object o2;

        public O(Object _o1, Object _o2) {
            o1 = _o1;
            o2 = _o2;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String s = new String();
        Object o1 = new Object();
        Object o2 = new Object();
        O o = new O(o1, o2);
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println("t2");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}

