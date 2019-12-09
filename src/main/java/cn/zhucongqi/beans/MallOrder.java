package cn.zhucongqi.beans;

import java.util.Date;

/**
 * @author ：Jobsz
 * @project ：mybatis-learning-project
 * @date ：Created in 2019/12/9 16:39
 * @description：
 * @modified By：
 * @version:
 */
public class MallOrder {

    private Long id;
    private String descr;
    private Date date;
    private Long uid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "MallOrder{" +
                "id=" + id +
                ", descr='" + descr + '\'' +
                ", date=" + date +
                ", uid=" + uid +
                '}';
    }
}
