package cn.zhucongqi.beans;

import java.util.List;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:39
 * @description：
 * @modified By：
 * @version:
 */
public class UserOrder {

    private Long uid;
    private List<MallOrder> orders;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<MallOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<MallOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "uid=" + uid +
                ", orders=" + orders +
                '}';
    }
}
