package integration;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.danny.spider.model.bean.District;
import top.danny.spider.model.bean.User;
import top.danny.spider.service.DistrictService;
import top.danny.spider.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 16:54:44
 */
public class UserServiceImplTest extends BaseServiceSpringTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DistrictService districtService;

    @Test
    public void saveUserTest() {
        User user = getUser();
        User userSaved = userService.saveUser(user);
        Assert.assertNotNull(userSaved);
    }

    @Test
    public void updateUserTest1() {
        try {
            User user = userService.findUserById(1051L);
            String distirctName = user.getAddress().split(" ")[user.getAddress().split(" ").length - 1];
            List<District> districtList = districtService.findDistrictByName(distirctName);
            int result = userService.updateUser(user.setAreaId(districtList.get(0).getId()));
            Assert.assertTrue(result > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUserDistrictTest() {
        long userid = 0L;
        try {
            long startTime = System.currentTimeMillis();
            List<User> userList = userService.findAllUser();

            for (User user : userList) {
                userid = user.getId();
                String distirctName = user.getAddress().split(" ")[user.getAddress().split(" ").length - 1];
                List<District> districtList = districtService.findDistrictByName(distirctName);
                if (districtList.isEmpty()){
                    userService.deleteUserById(user.getId());
                    continue;
                }
                int result = userService.updateUser(user.setAreaId(districtList.get(0).getId()));
                System.out.println("用户"+user.getId()+"的地址更新完毕");
            }
            System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(userid);
        }
    }

    /**
     * http://idcard.911cha.com/
     */
    @Test
    public void updateUserAddressTest() {
        try {
            User user = userService.findUserById(283247L);
            String distirctName = user.getAddress().split(" ")[user.getAddress().split(" ").length - 1];
            List<District> districtList = districtService.findDistrictByName(distirctName);
            int result = userService.updateUser(user.setAreaId(districtList.get(0).getId()));
            Assert.assertTrue(result > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User getUser() {
        User user = new User();
        user.setUserName("danny")
                .setPassword("123456")
                .setRealName("胡玉洋")
                .setIdCardNo("187302199009098918")
                .setMobileNo("18730984987")
                .setAge(26)
                .setBirthday(new Date())
        ;
        return user;
    }

    @Test
    public void findUserPageTest() {

    }
}
