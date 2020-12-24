package github.zjm404.stu.dp.creat.prototype;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MsgObject implements Cloneable, Serializable {
    private int id;
    private String msg;

    @Override
    public MsgObject clone() throws CloneNotSupportedException {
        return (MsgObject) super.clone();
    }
}
