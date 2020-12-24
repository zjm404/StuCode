package github.zjm404.stu.dp.behavior.mediator;

public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public void setMediator(AbstractMediator _mediator){
        this.mediator = _mediator;
    }
}
