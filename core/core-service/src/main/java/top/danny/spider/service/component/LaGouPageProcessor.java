package top.danny.spider.service.component;

import top.danny.spider.model.dto.UrlCache;

/**
 * @author huyuyang@lxfintech.com
 * @Title: LaGouPageProcessor
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 00:29:41
 */
public interface LaGouPageProcessor {

    UrlCache getUrlCache();

    boolean spider() throws InterruptedException;

    void cleanData();

}
