package github.zjm404.stu.mybatis.simple;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.IOException;
import java.io.Reader;

public class SpringMybatisClient {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactoryBean sqlSessionFactoryBean;
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sessionFactory.openSession();
            DemoMapper demoMapper = session.getMapper(DemoMapper.class);
            DemoDO demoDO = demoMapper.selectById(1);
            System.out.println(demoDO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
