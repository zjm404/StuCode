package cn.zjm404.stu.dp.behavior.strategy;

import java.lang.reflect.InvocationTargetException;

public class StrategyFactory2 {
    public static <T extends IStrategy> IStrategy getStrategy(Class<T> tClass){
        IStrategy strategy = null;
        try{
            strategy = (IStrategy) Class.forName(tClass.getName()).getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return strategy;
    }
}
