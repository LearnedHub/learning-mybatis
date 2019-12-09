import cn.zhucongqi.beans.MallOrder;
import cn.zhucongqi.beans.User;
import cn.zhucongqi.beans.UserOrder;
import cn.zhucongqi.mapper.OrderMapper;
import cn.zhucongqi.mapper.UserMapper;
import cn.zhucongqi.utils.SqlSessionUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:48
 * @description：
 * @modified By：
 * @version:
 */
public class Tester {

    @Test
    public  void testAddUser() {
        System.out.println("testing running");

        SqlSession session = SqlSessionUtil.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setAddr("Addr");
        user.setId(0L);
        user.setName("username");

        boolean ret = userMapper.addUser(user);
        System.out.println("ret=" +ret);
        session.commit();
        session.close();
    }

    @Test
    public void testUsers() {
        SqlSession session = SqlSessionUtil.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<User> users =  userMapper.users();
        System.out.println("Users" + users);

        session.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = SqlSessionUtil.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1L);
        user.setName("中国🇨🇳 ");
        boolean ret =  userMapper.updateUser(user);
        System.out.println("ret=" +ret);
        session.commit();
        session.close();
    }

    @Test
    public void testUpdateUser2() {
        SqlSession session = SqlSessionUtil.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setId(1L);
        user.setName("中国🇨🇳 ");
        user.setAddr("中国大中国");
        boolean ret =  userMapper.updateUser2(user);
        System.out.println("ret=" +ret);
        session.commit();
        session.close();
    }

    @Test
    public void testUserOrders() {

        SqlSession session = SqlSessionUtil.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<UserOrder> userOrders = orderMapper.getOrderByUserId(1L);

        System.out.println("List<UserOrder>="+userOrders);

        session.close();
    }

    @Test
    public void testAddUserOrder() {

        SqlSession session = SqlSessionUtil.openSession(ExecutorType.BATCH);
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        for (int i = 0; i < 10; i++) {
            MallOrder order = new MallOrder();
            order.setId(0L);
            order.setUid(11L);
            order.setDate(new Date());
            order.setDescr(System.currentTimeMillis() + "");
            orderMapper.addOrder(order);
        }

        session.commit();
        session.close();
    }

    @Test
    public void testPageOrder() {

        SqlSession session = SqlSessionUtil.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        RowBounds rb = new RowBounds(0,5);
        List<UserOrder> userOrders = orderMapper.getOrderByUserId2(11L, rb);
        System.out.println("userorders == "+ userOrders);
        session.close();
    }

    @Test
    public void testOrderPage() {
        SqlSession session = SqlSessionUtil.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        RowBounds rb = new RowBounds(0,8);
        List<MallOrder> mallOrders = orderMapper.mallOrders(1L, rb);
        System.out.println("mallOrders == "+ mallOrders);
        session.close();
    }

}
