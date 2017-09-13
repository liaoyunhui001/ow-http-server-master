package com.rst.ow.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hujia on 2016/11/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertUser() throws Exception {
        String name = "hujia";
        String phone = "13554716413";

        if (userDao.insertUser(name, "未填写", phone, "未填写", "ow")) {
            System.out.println("添加用户成功");
        } else {
            System.out.println("添加用户失败");
        }
    }
}
