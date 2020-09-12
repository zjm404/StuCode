package cn.zjm404.stu.dp.behavior.state;

public abstract class AbstractState {
    protected Context context;

    public void setContext(Context _context){
        this.context = _context;
    }

    public abstract void handle();
}
