package cn.zjm404.stu.dp.behavior.interpreter;

import lombok.AllArgsConstructor;
import org.springframework.expression.ExpressionParser;
@AllArgsConstructor
public class AddExpression implements Expression{
    private Expression ep1;
    private Expression ep2;
    @Override
    public long interpret() {
        return ep1.interpret() + ep2.interpret();
    }
}
