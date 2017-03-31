package top.danny.spider.dao.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.dao.data.DistrictDO;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-03-12 23:50:28
 */
public class DistrictDAOTest extends BaseDaoSpringTest {

    @Autowired
    private DistrictDAO districtDAO;

    @Test
    public void findDistrictTest(){
        List<DistrictDO> districtDO=districtDAO.findByDistrictName("东城区");
        Assert.assertNotNull(districtDO);
        if (districtDO!=null){
            System.out.println(districtDO.get(0).getCityID());
        }
    }
}
