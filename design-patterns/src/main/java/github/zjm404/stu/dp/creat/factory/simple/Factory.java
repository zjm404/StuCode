package github.zjm404.stu.dp.creat.factory.simple;

import github.zjm404.stu.dp.creat.factory.AbstractProduct;
import github.zjm404.stu.dp.creat.factory.ConcreteProduct1;
import github.zjm404.stu.dp.creat.factory.ConcreteProduct2;

import java.lang.reflect.InvocationTargetException;

public class Factory {
    public static AbstractProduct create(String type){
        if(type.equalsIgnoreCase("1")){
            return new ConcreteProduct1();
        }else if(type.equalsIgnoreCase("2")){
            return new ConcreteProduct2();
        }else{
            return null;
        }
    }
    public static <T extends AbstractProduct> AbstractProduct createPlus(Class<T> clazz){
        AbstractProduct ap = null;
        try{
            ap = (AbstractProduct) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ap;
    }
}
