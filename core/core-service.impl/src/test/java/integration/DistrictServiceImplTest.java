package integration;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.model.bean.District;
import top.danny.spider.service.DistrictService;

import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DistrictServiceImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-15 23:06:15
 */
public class DistrictServiceImplTest extends BaseServiceSpringTest {
    @Autowired
    private DistrictService districtService;

    @Test
    public void findDistrictByNameTest(){
        List<District> districtList= districtService.findDistrictByName("石景山区");
        Assert.assertNotNull(districtList);
        System.out.println("result:"+JSON.toJSONString(districtList));
    }

}
