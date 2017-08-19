package top.danny.spider.model.dto;

import top.danny.spider.model.bean.SpiderTask;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UrlCache
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 09:33:47
 * 待优化，可以换成队列
 */
public class UrlCache {

    private Map<String, String> urlCacheMap;
    private Map<String, String> urlCacheMapHistory;

    private UrlCache() {
        urlCacheMap = new LinkedHashMap<>(256);
        urlCacheMapHistory = new LinkedHashMap<>(256);
    }

    public static UrlCache getInstance() {
        return new UrlCache();
    }

    /*任务入队*/
    public void push(String title, String url) {
        if (!urlCacheMapHistory.containsKey(title)){
            urlCacheMap.put(title, url);
            System.out.println("任务入队，现待处理任务数为："+getSize());
        }
    }

    /*任务出队*/
    public String pop() {
        String url = "";
        /*只遍历一次*/
        for (String key : urlCacheMap.keySet()) {
            url = urlCacheMap.get(key).toString();
            urlCacheMapHistory.put(key,url);//把该地址放入历史任务记录中
            System.out.println("添加任务历史记录："+key+"，现历史记录条数为："+getrlCacheHistoryMapSize());
            urlCacheMap.remove(key);//把该地址从待处理任务中去除
            System.out.println("任务出队："+key+"，现待处理任务数为："+getSize());
            break;
        }
        return url;
    }

    public void initUrlCatch(List<SpiderTask> spiderTaskList){
        if (spiderTaskList!=null && spiderTaskList.size()>0){
            for (int i=0;i<spiderTaskList.size();i++){
                urlCacheMap.put(spiderTaskList.get(i).getTitle(),spiderTaskList.get(i).getUrl());
            }
        }
    }

    public void clear() {
        urlCacheMap.clear();
    }

    public int getSize() {
        return urlCacheMap.entrySet().size();
    }

    public int getrlCacheHistoryMapSize() {
        return urlCacheMapHistory.entrySet().size();
    }

    public Map<String, String> getUrlCacheMap() {
        return urlCacheMap;
    }

    public UrlCache setUrlCacheMap(Map<String, String> urlCacheMap) {
        this.urlCacheMap = urlCacheMap;
        return this;
    }

    public Map<String, String> getUrlCacheMapHistory() {
        return urlCacheMapHistory;
    }

    public UrlCache setUrlCacheMapHistory(Map<String, String> urlCacheMapHistory) {
        this.urlCacheMapHistory = urlCacheMapHistory;
        return this;
    }
}
