package top.danny.spider.dao.jpa;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.dao.data.AreaDO;
import top.danny.spider.utils.IterableUtils;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: AreaDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-17 21:45:23
 */
public class AreaDAOTest extends BaseDaoSpringTest {

    @Autowired
    private AreaDAO areaDAO;

    @Test
    public void findOneTest() {
        List<AreaDO> areaDOList= IterableUtils.convertToList(areaDAO.findAll());
        System.out.println(JSON.toJSONString(areaDOList));
    }
}
