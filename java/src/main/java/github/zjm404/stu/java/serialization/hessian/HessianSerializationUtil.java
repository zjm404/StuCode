package github.zjm404.stu.java.serialization.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author zjm
 * @Date 2020/11/20
 * @Description
 * @Version 1.0
 */
public class HessianSerializationUtil {
    public static <T> T deSerialize(byte[] bytes) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bis);
        T res = (T) input.readObject();
        input.close();
        return res;
    }

    /**
     * 进行反序列化，如果出现异常就直接抛出，不进行处理
     * （出现异常也没必要继续了，序列化都错了，直接返回错误好了）
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> byte[] enSerialize(T obj) throws IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(os);
        out.writeObject(obj);
        out.close();
        return os.toByteArray();
    }
}
