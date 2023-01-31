package com.shiro.ds;

import com.shiro.ds.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@MapperScan(basePackages = "com.shiro.ds.mapper.UserMapper")
class ShiroLoginApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println(userService.getUserInfoByName("zhangsan"));

    }

}
