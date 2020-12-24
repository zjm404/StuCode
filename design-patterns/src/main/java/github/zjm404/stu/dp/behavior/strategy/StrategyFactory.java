package github.zjm404.stu.dp.behavior.strategy;

import java.util.HashMap;

public class StrategyFactory {
    private static HashMap<String,IStrategy> map = new HashMap<>();
    static{
        map.put("A",new ConcreteStrategy1());
        map.put("B",new ConcreteStrategy2());
    }
    public static IStrategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return map.get(type);
    }
}
