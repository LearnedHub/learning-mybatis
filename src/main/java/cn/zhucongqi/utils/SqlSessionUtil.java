package cn.zhucongqi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:40
 * @description：
 * @modified By：
 * @version:
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession openSession(ExecutorType executorType) {
        return sqlSessionFactory.openSession(executorType);
    }
}
