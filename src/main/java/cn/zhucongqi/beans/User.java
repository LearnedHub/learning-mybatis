package cn.zhucongqi.beans;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:39
 * @description：
 * @modified By：
 * @version:
 */
public class User {

    private Long id;
    private String name;
    private String addr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
