package top.danny.spider.dao.jpa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import top.danny.spider.dao.data.SpiderTaskDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SpiderTaskDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-08-19 12:54:35
 */
public class SpiderTaskDAOTest extends BaseDaoSpringTest {
    @Autowired
    private SpiderTaskDAO spiderTaskDAO;

    @Test
    @Rollback(false)
    public void batchInsertTest() {
        List<SpiderTaskDO> spiderTaskDOList = getSpiderTaskList();
        spiderTaskDAO.batchInsert(spiderTaskDOList);
    }

    private List<SpiderTaskDO> getSpiderTaskList() {
        List<SpiderTaskDO> spiderTaskList = new ArrayList<>();
        SpiderTaskDO spiderTask1= new SpiderTaskDO()
                .setTaskName("拉勾网")
                .setTitle("颗豆互动_资深Java工程师")
                .setUrl("https://www.lagou.com/jobs/3202442.html");
        spiderTaskList.add(spiderTask1);
        SpiderTaskDO spiderTask2 = new SpiderTaskDO()
                .setTaskName("拉勾网")
                .setTitle("比特大陆_高级java工程师")
                .setUrl("https://www.lagou.com/jobs/3498321.html");
        spiderTaskList.add(spiderTask2);
        return spiderTaskList;
    }
}
