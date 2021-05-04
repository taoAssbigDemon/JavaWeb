package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC的工具类，使用Druid数据库连接池
 */
public class JDBCUtils {

    private static DataSource ds;

    /*
    根据配置文件创建Druid DataSource 连接池
     */
    static{
        //1.加载配置文件
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.初始化连接池对象
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 1. 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /*
     * 2.获取连接对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
