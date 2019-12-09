package cn.zhucongqi.interceptor;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 17:00
 * @description：
 * @modified By：
 * @version:
 */

@Intercepts({@Signature(type = Executor.class,method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0]; // MappedStatement
        BoundSql boundSql = ms.getBoundSql(args[1]); // Object parameter
        RowBounds rb = (RowBounds) args[2]; // RowBounds
        if (null == rb || rb == RowBounds.DEFAULT) {
            return invocation.proceed();
        }

        // append limit statement
        StringBuilder sqlBuidler = new StringBuilder(boundSql.getSql());
        String limit = String.format(" limit %d,%d", rb.getOffset(), rb.getLimit());
        sqlBuidler.append(limit);

        // replace sqlSource by reflection
        SqlSource sqlSource = new StaticSqlSource(ms.getConfiguration(), sqlBuidler.toString(), boundSql.getParameterMappings());
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        field.set(ms, sqlSource);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
