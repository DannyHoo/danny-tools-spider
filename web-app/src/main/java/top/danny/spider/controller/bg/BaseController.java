package top.danny.spider.controller.bg;

import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-25 23:56:51
 */
public class BaseController {
    private static final String pageNumberFlag="pageNumber";
    private static final String pageSizeFlag="pageSize";

    /**
     * 根据前台传输的map获取当前页数
     * @param map
     * @return
     */
    public int getPageNumber(Map map){
        Object object=map.get(pageNumberFlag);
        int pageNumber=object==null?1:Integer.parseInt(object.toString());
        return pageNumber;
    }

    /**
     * 根据前台传输的map获取页数大小
     * @param map
     * @return
     */
    public int getPageSize(Map map){
        Object object=map.get(pageSizeFlag);
        int pageNumber=object==null?10:Integer.parseInt(object.toString());
        return pageNumber;
    }
}
