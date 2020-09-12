package cn.zjm404.stu.dp.behavior.mediator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractMediator {
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    public abstract void doSomething();
}
