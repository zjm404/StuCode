package github.zjm404.stu.java.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

/**
 * @Author
 * @Date 2020/11/23
 * @Description
 * @Version 1.0
 */
public class HasNotNullValidator implements ConstraintValidator<HasNotNull,Object> {
    private String[] fields;
    private int num;
    private static boolean filedValueIsNull(String filedName,Object obj){
        try{
            Field field = obj.getClass().getDeclaredField(filedName);
            //使得可以访问 private 属性
            field.setAccessible(true);
            return field.get(obj) == null;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public void initialize(HasNotNull hasNotNull) {
        if(hasNotNull == null){
            return ;
        }
        fields = hasNotNull.fields();
        num = hasNotNull.num();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null){
            return false;
        }
        for (String field : fields) {
            if (!filedValueIsNull(field, o)) {
                num--;
            }
            if(num <= 0){
                return true;
            }
        }
        return false;
    }
}
