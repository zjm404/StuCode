package cn.zjm404.demo.di;

import java.io.InputStream;
import java.util.List;

public interface MyBeanConfigParser {
    List<MyBeanDefinition> parse(InputStream inputStream);
}
