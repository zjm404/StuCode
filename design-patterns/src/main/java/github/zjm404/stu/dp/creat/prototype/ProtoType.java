package github.zjm404.stu.dp.creat.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;


@Setter
@Getter
@ToString
public class ProtoType implements Cloneable,Serializable{
    private MsgObject msg1;

    @Override
    public ProtoType clone() throws CloneNotSupportedException {
        ProtoType res = (ProtoType) super.clone();
        res.msg1 = res.msg1.clone();
        return res;
    }

    public ProtoType deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return (ProtoType) oi.readObject();
    }
}
