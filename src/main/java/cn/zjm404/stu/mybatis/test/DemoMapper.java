package cn.zjm404.stu.mybatis.test;

import org.apache.ibatis.annotations.Param;

public interface DemoMapper {

    public DemoDO selectById(@Param("id") int id);
}
