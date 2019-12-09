package cn.zhucongqi.mapper;


import cn.zhucongqi.beans.User;

import java.util.List;

/**
 * @author ：Jobsz
 * @project ：gupaoedu-vip-mybatis-standalone
 * @date ：Created in 2019/12/9 10:42
 * @description：User Mapper
 * @modified By：
 * @version: 0.1
 */
public interface UserMapper {

    boolean addUser(User user);

    List<User> users();

    boolean updateUser(User user);

    boolean updateUser2(User user);

}
