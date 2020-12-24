package github.zjm404.stu.java.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @Author zjm
 * @Date 2020/11/23
 * @Description
 * @Version 1.0
 */
@Target({FIELD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {HasNotNullValidator.class})
public @interface HasNotNull {
    /**
     * 属性名字
     * @return
     */
    String[] fields();

    /**
     * 至少有 num 个属性不能为 null
     * @return
     */
    int num();

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
