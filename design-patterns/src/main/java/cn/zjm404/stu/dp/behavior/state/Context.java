package cn.zjm404.stu.dp.behavior.state;

/**
 * 进行状态切换
 */
public class Context {
    public final static AbstractState STATE1 = new ConcreteState1();
    public final static AbstractState STATE2 = new ConcreteState2();

    private AbstractState state;

    public void setState(AbstractState _state){
        this.state = _state;
    }

    public AbstractState getState(){
        return this.state;
    }

    public void handle(){
        this.state.handle();
    }
}
