package cn.zjm404.stu.dp.organization.flyweight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class SharedObject {
    //共享的属性
    private String a1;
    private String a2;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SharedObject that = (SharedObject) o;
        return Objects.equals(a1, that.a1) &&
                Objects.equals(a2, that.a2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1, a2);
    }
}
