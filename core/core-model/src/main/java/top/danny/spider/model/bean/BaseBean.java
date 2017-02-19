package top.danny.spider.model.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseBean
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:32:45
 */
public class BaseBean implements Serializable {
    private static final long serialVersionUID = -4361621531500045980L;

    /** 主键 **/
    protected Long id;
    protected String comment;
    /** 创建时间 **/
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    protected Date createTime;
    /** 最后修改时间 **/
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    protected Date updateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public BaseBean setId(Long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public BaseBean setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BaseBean setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public BaseBean setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
