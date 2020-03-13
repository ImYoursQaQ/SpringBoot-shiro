package com.itheima;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hubo
 * @date 2020-03-13
 * @description: 测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBoot {

    Logger logger = LoggerFactory.getLogger(SpringBoot.class);

    @Autowired
    private UserService userService;
    @Test
    public void testDataBase(){
        User byId = userService.findById(1);
        logger.info("{}",byId);
    }
}
