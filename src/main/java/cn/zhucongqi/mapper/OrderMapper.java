package cn.zhucongqi.mapper;

import cn.zhucongqi.beans.MallOrder;
import cn.zhucongqi.beans.UserOrder;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author ：Jobsz
 * @project ：gupaoedu-vip-mybatis-standalone
 * @date ：Created in 2019/12/9 11:35
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderMapper {

    List<UserOrder> getOrderByUserId(Long id);

    boolean addOrder(MallOrder order);

    List<UserOrder> getOrderByUserId2(Long id, RowBounds rowBounds);

    List<MallOrder> mallOrders(Long uid, RowBounds rowBounds);
}
