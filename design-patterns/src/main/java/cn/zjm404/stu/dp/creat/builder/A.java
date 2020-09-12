package cn.zjm404.stu.dp.creat.builder;

import lombok.ToString;

@ToString
public class A {

    private String v1;
    private String v2;

    public A (Builder builder){
        this.v1 = builder.v1;
        this.v2 = builder.v2;
    }

    public static class Builder{
        private String v1;
        private String v2;

        public A build(){
            //对属性进行一些判断，这里就不写了
            return new A(this);
        }
        public  Builder setV1(String v1){
            this.v1 = v1;
            return this;
        }
        public Builder setV2(String v2){
            this.v2 = v2;
            return this;
        }


    }
}

class Run{
    public static void main(String[] args){
        A a = new A.Builder()
                .setV1("hello")
                .setV2("world")
                .build();
        System.out.println(a);

    }
}

