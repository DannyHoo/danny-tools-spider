package top.danny.spider.dao.data;

import org.hibernate.annotations.DynamicUpdate;
import top.danny.spider.dao.data.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SpiderTask
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 10:09:33
 */
@Entity
@Table(name="t_spider_task")
@DynamicUpdate(true)
public class SpiderTaskDO extends BaseEntity {

    @Column(name = "taskName")
    private String taskName;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    public String getTaskName() {
        return taskName;
    }

    public SpiderTaskDO setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SpiderTaskDO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SpiderTaskDO setUrl(String url) {
        this.url = url;
        return this;
    }
}
