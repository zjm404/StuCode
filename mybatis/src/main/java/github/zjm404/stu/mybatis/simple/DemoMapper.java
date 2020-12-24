package github.zjm404.stu.mybatis.simple;

import org.apache.ibatis.annotations.Param;

public interface DemoMapper {

    public DemoDO selectById(@Param("id") int id);
}
