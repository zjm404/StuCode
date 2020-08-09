package cn.zjm404.stu.design.organization.bridge;
public class Client {
    public static void main(String[] args) {
        IExtendsClass iExtendsClass = new ConcreteExtendsClass();
        AbstractAClass abstractAClass = new ConcreteAClass(iExtendsClass);
        abstractAClass.method();
    }
}
