package cn.zjm404.stu.dp.organization.bridge;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZJM
 */
@AllArgsConstructor
@Getter
public abstract class AbstractAClass {
    private IExtendsClass iExtendsClass;
    public  void method(){
        iExtendsClass.method();
    }

}
