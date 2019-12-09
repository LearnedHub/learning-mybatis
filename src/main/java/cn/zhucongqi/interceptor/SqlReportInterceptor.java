package cn.zhucongqi.interceptor;

import com.oracle.tools.packager.Log;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:57
 * @description：
 * @modified By：
 * @version:
 */

@Intercepts({ @Signature(type = StatementHandler.class, method = "query", args = { Statement.class, ResultHandler.class}) })
public class SqlReportInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        if (Log.isDebug()) {
            Log.debug("running sql: " + boundSql.getSql());
        }
        try {
            return invocation.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            if (Log.isDebug()) {
                Log.debug("Time consuming：" + (endTime-startTime) +"ms");
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
