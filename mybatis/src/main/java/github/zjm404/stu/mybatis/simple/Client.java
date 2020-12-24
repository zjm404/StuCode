package github.zjm404.stu.mybatis.simple;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Client {
    public static void main(String[] args){
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
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
