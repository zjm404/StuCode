package cn.zjm404.stu.design.creat.factory;

import cn.zjm404.stu.design.creat.factory.factory.ConcreteFactory2;

public class Client {
    public static void main(String[] args) {
//        String str;
//        Scanner sc = new Scanner(System.in);
//        str = sc.nextLine();
//        AbstractProduct abstractProduct = Factory.create(str);
//        if (abstractProduct != null) {
//            abstractProduct.method2();
//        }
//        AbstractProduct ap = Factory.createPlus(ConcreteProduct1.class);
//        ap.method2();

        AbstractProduct ap2 = new ConcreteFactory2().create();
        ap2.method2();

    }
}
