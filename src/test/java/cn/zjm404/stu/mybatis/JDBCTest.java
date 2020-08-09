package cn.zjm404.stu.mybatis;

import com.mysql.cj.jdbc.DatabaseMetaData;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class JDBCTest {
    //useServerPrepStmts=true&
//    private static final String url = "jdbc:mysql://123.207.5.170:3306/mybatis_test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String url = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=true&useServerPrepStmts=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String user = "zjm";
    private static final String password = "1715925292%@it";
    private String param = "10086";
    private Connection conn;

//    @Before
//    public void init() throws ClassNotFoundException, SQLException {
//        //1.加载注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //2.获取连接对象
//        conn = DriverManager.getConnection(url,user,password);
//    }
//    @After
//    public void destroy() throws SQLException {
//        //5.释放
//        if(conn != null){
//            conn.close();
//        }
//    }
    @Test
    public void statementTest() throws ClassNotFoundException, SQLException {

        //1.加载注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接对象
        conn = DriverManager.getConnection(url,user,password);
        //3.编写sql语句
        String str = "1 OR TRUE";
        String sql = "SELECT * FROM demo WHERE id = " + str;

        //4.执行sql语句
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("ID"+"    "+"信息");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("msg"));
        }
        //5、释放资源
        statement.close();
        conn.close();


    }
    @Test
    public void preparedStatementDemo() throws ClassNotFoundException, SQLException {
        //1.加载注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接对象
        conn = DriverManager.getConnection(url,user,password);

        //3.编写sql语句
        String sql = "SELECT * FROM demo WHERE id = ?";

        //4.执行sql语句
        PreparedStatement statement = conn.prepareStatement(sql);
        for(int i = 0; i < 10 ; i++){
            statement.setString(1,"1 OR TRUE");
            statement.execute();
        }
//        System.out.println(statement);
//        statement.execute();
//        ResultSet rs = statement.getResultSet();
//
//        System.out.println("ID"+"    "+"信息");
//        while(rs.next()){
//            System.out.println(rs.getInt("id")+" "+rs.getString("msg"));
//        }
        //5、释放资源
        statement.close();
        conn.close();
    }
    @Test
    public void SQLCacheTest() throws SQLException {
        String url1 = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=false&useServerPrepStmts=false&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn1 = DriverManager.getConnection(url1,user,password);
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,"1 OR TRUE");
        ps.execute();
        ps.close();
        conn1.close();

        Connection conn2 = DriverManager.getConnection(url,user,password);
        PreparedStatement ps1 = conn2.prepareStatement(sql);
        ps1.setString(1,"1 OR TRUE");
        ps1.execute();
        ps1.close();
        conn2.close();

    }
    @Test
    public void prepareBatchTest() throws ClassNotFoundException, SQLException {
        //1.加载注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接对象
        conn = DriverManager.getConnection(url,user,password);

        //3.编写并预编译sql语句
        String sql = "INSERT INTO demo (msg) VALUE (?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            statement.setString(1,"hello"+i);
            statement.addBatch();
        }

        //4.执行sql语句
        statement.executeBatch();
        System.out.println(System.currentTimeMillis() - l);
        //5、释放资源
        statement.close();
        conn.close();
    }
    @Test
    public void inject() throws SQLException, ClassNotFoundException {
        String str = "'1' OR 'TRUE'";
//        System.out.println("statement:");
//        selectType1(str);
        System.out.println("preparedStatement");
        selectType2(str);
    }

    public void selectType1(String str) throws SQLException {
        String sql = "SELECT * FROM demo WHERE id = 1 OR TRUE ";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.printf("%d\t%s\n",resultSet.getInt("id"),resultSet.getString("msg"));
        }
        statement.close();
    }
    public void selectType2(String str) throws SQLException {
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,str);
//        preparedStatement.setString(1,str);
        System.out.println(preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.printf("%d\t%s\n",resultSet.getInt("id"),resultSet.getString("msg"));
        }
        preparedStatement.close();
    }



    @Test
    public void ConnectTest() throws SQLException {
        Connection conn1 = DriverManager.getConnection(url,user,password);
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,"1 OR TRUE");
        ps.execute();
        PreparedStatement ps1 = conn1.prepareStatement(sql);
        ps1.setString(1,"1 OR TRUE");
        ps1.execute();

        Connection conn2 = DriverManager.getConnection(url,user,password);
        PreparedStatement ps2 = conn2.prepareStatement(sql);
        ps2.setString(1,"1 OR TRUE");
        ps2.execute();
        PreparedStatement ps22 = conn2.prepareStatement(sql);
        ps22.setString(1,"1 OR TRUE");
        ps22.execute();
    }
    @Test
    public void ClientPreparedNoCache() throws SQLException {
        String url1 = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=false&useServerPrepStmts=false&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn1 = DriverManager.getConnection(url1,user,password);
        long startTime = System.currentTimeMillis();
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        conn1.close();
        System.out.println("客户端处理&&不使用缓存，用时：" + (System.currentTimeMillis()-startTime));
    }
    @Test
    public void ClientPreparedWithCache() throws SQLException {
        String url1 = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=true&useServerPrepStmts=false&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn1 = DriverManager.getConnection(url1,user,password);
        long startTime = System.currentTimeMillis();
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        conn1.close();
        System.out.println("客户端处理&&使用缓存，用时：" + (System.currentTimeMillis()-startTime));
    }
    @Test
    public void ServerPreparedNoCache() throws SQLException {
        String url1 = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=false&useServerPrepStmts=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn1 = DriverManager.getConnection(url1,user,password);
        long startTime = System.currentTimeMillis();
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        conn1.close();
        System.out.println("服务端处理&&不使用缓存，用时：" + (System.currentTimeMillis()-startTime));
    }
    @Test
    public void ServerPreparedWithCache() throws SQLException {
        String url1 = "jdbc:mysql://123.207.5.170:3306/mybatis_test?cachePrepStmts=true&useServerPrepStmts=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
        Connection conn1 = DriverManager.getConnection(url1,user,password);
        long startTime = System.currentTimeMillis();
        String sql = "SELECT * FROM demo WHERE id = ?";
        PreparedStatement ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        ps = conn1.prepareStatement(sql);
        ps.setString(1,param);
        ps.execute();
        ps.close();
        conn1.close();
        System.out.println("服务端处理&&使用缓存，用时：" + (System.currentTimeMillis()-startTime));
    }
    @Test
    public void ResultTypeTest() throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM demo");
        int i = 1;
        Math.sqrt(i);
    }
    @Test
    public void CallableStatementTest() throws SQLException {
        conn = DriverManager.getConnection(url,user,password);
        String sql = "{CALL GetMsgById(?)}";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setInt(1,1);
        cs.execute();
        ResultSet rs = cs.getResultSet();
        rs.next();
        System.out.println(rs.getInt("id")+" "+rs.getString("msg"));
        System.out.println(cs.getInt(1));
        cs.close();
        conn.close();
    }

}
