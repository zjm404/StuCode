package cn.zjm404.stu.thread.divide.tpm;

public class Client {
    public static void main(String[] args) {
        ThreadPerMessageTest tpm = new ThreadPerMessageTest();
        Runnable w1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        tpm.run(w1);
    }
}
