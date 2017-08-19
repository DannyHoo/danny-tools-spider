package top.danny.spider.model.bean;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SpiderTask
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 10:09:33
 */
public class SpiderTask extends BaseBean {
    private String taskName;
    private String title;
    private String url;

    public String getTaskName() {
        return taskName;
    }

    public SpiderTask setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SpiderTask setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SpiderTask setUrl(String url) {
        this.url = url;
        return this;
    }
}
