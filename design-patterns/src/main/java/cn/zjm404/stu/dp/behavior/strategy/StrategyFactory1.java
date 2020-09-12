package cn.zjm404.stu.dp.behavior.strategy;

public class StrategyFactory1 {
    public static IStrategy getStrategy(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return switch (type) {
            case "A" -> new ConcreteStrategy1();
            case "B" -> new ConcreteStrategy2();
            default -> null;
        };
    }
}
