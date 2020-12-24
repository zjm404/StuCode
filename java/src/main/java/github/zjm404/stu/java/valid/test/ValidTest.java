package github.zjm404.stu.java.valid.test;


import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Author
 * @Date 2020/11/23
 * @Description
 * @Version 1.0
 */
public class ValidTest {
    @Test
    public void validTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        RequestDTO req = new RequestDTO();
        req.setMsg("hello world");
//        RpcDTO rpcDTO = new RpcDTO();
//        rpcDTO.setFoods(new Food[1]);
//        req.setRpcDTO(rpcDTO);
        Set<ConstraintViolation<RequestDTO>> errors = validator.validate(req);
        for (ConstraintViolation<RequestDTO> error : errors) {
            System.out.println(error.getMessage());
        }
    }
}
