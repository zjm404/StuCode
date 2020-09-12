package cn.zjm404.stu.dp.behavior.interpreter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class ExpressionInterpreter {
    private Deque<Expression> expressions = new LinkedList<>();

    public long interpret(String expression){
        String[] elements = expression.split(" ");
        String checkNumber = "^-?[1-9]d*$";
        for (String element : elements) {

        }
    }
}
